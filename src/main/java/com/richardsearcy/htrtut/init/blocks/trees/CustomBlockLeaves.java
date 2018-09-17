package com.richardsearcy.htrtut.init.blocks.trees;

import com.google.common.base.Predicate;
import com.richardsearcy.htrtut.util.IMetaName;
import com.sun.istack.internal.Nullable;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.List;

public class CustomBlockLeaves extends BlockLeaves implements IMetaName {

    public static final PropertyEnum<CustomBlockPlanks.EnumType> VARIANT = PropertyEnum.<CustomBlockPlanks.EnumType>create("variant", CustomBlockPlanks.EnumType.class, new Predicate<CustomBlockPlanks.EnumType>() {
        public boolean apply(@Nullable CustomBlockPlanks.EnumType apply) {
            // Can't be more than 4!
            return apply.getMeta() < 2;
        }
    });


    public CustomBlockLeaves(String name) {

        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(SoundType.PLANT);
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, CustomBlockPlanks.EnumType.TUTORIAL).withProperty(CHECK_DECAY, Boolean.TRUE).withProperty(DECAYABLE, Boolean.TRUE));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {

        return this.getDefaultState().withProperty(VARIANT, CustomBlockPlanks.EnumType.byMetadata(meta % 2));
    }

    @Override
    public int getMetaFromState(IBlockState state) {

        int i = ((CustomBlockPlanks.EnumType)state.getValue(VARIANT)).getMeta();

        if(!((Boolean)state.getValue(DECAYABLE)).booleanValue()) {
            i |= 2;
        }

        if(!((Boolean)state.getValue(CHECK_DECAY)).booleanValue()) {
            i |=4;
        }

        return i;
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {

        for(CustomBlockPlanks.EnumType customblockplanks$enumtype : CustomBlockPlanks.EnumType.values()) {
            items.add(new ItemStack(this, 1, customblockplanks$enumtype.getMeta()));
        }
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state) {

        return new ItemStack(Item.getItemFromBlock(this), 1, ((CustomBlockPlanks.EnumType)state.getValue(VARIANT)).getMeta());
    }

    @Override
    public int damageDropped(IBlockState state) {

        return ((CustomBlockPlanks.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public String getSpecialName(ItemStack stack) {

        return CustomBlockPlanks.EnumType.values()[stack.getItemDamage()].getName();
    }

    @Override
    protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) {

        return;
    }

    @Override
    protected int getSaplingDropChance(IBlockState state) {

        return 30;
    }

    @Override
    public BlockPlanks.EnumType getWoodType(int meta) {

        return null;
    }

    @Nonnull
    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {

        return NonNullList.withSize(1, new ItemStack(this, 1, world.getBlockState(pos).getValue(VARIANT).getMeta()));
    }

    @Override
    protected BlockStateContainer createBlockState() {

        return new BlockStateContainer(this, new IProperty[] {VARIANT, DECAYABLE, CHECK_DECAY});
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {

        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {

        return BlockRenderLayer.TRANSLUCENT;
    }
}