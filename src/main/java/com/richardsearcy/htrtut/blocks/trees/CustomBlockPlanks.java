package com.richardsearcy.htrtut.blocks.trees;

import com.richardsearcy.htrtut.util.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class CustomBlockPlanks extends Block implements IMetaName {

    public static final PropertyEnum<CustomBlockPlanks.EnumType> VARIANT = PropertyEnum.<CustomBlockPlanks.EnumType>create("variant", CustomBlockPlanks.EnumType.class);

    public CustomBlockPlanks(String name) {

        super(Material.WOOD);
        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(SoundType.WOOD);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumType.TUTORIAL));
    }

    @Override
    public int damageDropped(IBlockState state) {

        return ((CustomBlockPlanks.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {

        for(CustomBlockPlanks.EnumType customblockplanks$enumtype : CustomBlockPlanks.EnumType.values()) {
            items.add(new ItemStack(this, 1, customblockplanks$enumtype.getMeta()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {

        return this.getDefaultState().withProperty(VARIANT, CustomBlockPlanks.EnumType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {

        return((CustomBlockPlanks.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {

        return new ItemStack(Item.getItemFromBlock(this), 1, (int)(getMetaFromState(world.getBlockState(pos))));
    }

    @Override
    protected BlockStateContainer createBlockState() {

        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }

    @Override
    public String getSpecialName(ItemStack stack) {

        return CustomBlockPlanks.EnumType.values()[stack.getItemDamage()].getName();
    }

    // CustomBlockPlanks.EnumType. It implements IStringSerializable for the getName() method.
    public enum EnumType implements IStringSerializable {

        // Place the block variants here
        TUTORIAL(0, "tutorial"),
        ALUMINUM(1, "aluminum");

        // Set up the enum
        private static final CustomBlockPlanks.EnumType[] META_LOOKUP = new CustomBlockPlanks.EnumType[values().length];
        private final int meta;
        private final String name, unlocalizedName;

        EnumType(int meta, String name) {

            this(meta, name, name);
        }

        EnumType(int meta, String name, String unlocalizedName) {

            this.meta = meta;
            this.name = name;
            this.unlocalizedName = unlocalizedName;
        }

        // Method from IStringSeriazable interface
        @Override
        public String getName() {

            return this.name;
        }

        public int getMeta() {

            return this.meta;
        }

        public String getUnlocalizedName() {

            return this.unlocalizedName;
        }

        @Override
        public String toString() {

            return this.name;
        }

        public static CustomBlockPlanks.EnumType byMetadata(int meta) {

            return META_LOOKUP[meta];
        }

        static {

            for(CustomBlockPlanks.EnumType customblockplanks$enumtype : values()) {
                META_LOOKUP[customblockplanks$enumtype.getMeta()] = customblockplanks$enumtype;
            }
        }
    }
}
