package com.richardsearcy.htrtut.init.blocks.trees;

import com.google.common.base.Predicate;
import com.richardsearcy.htrtut.util.IMetaName;
import com.sun.istack.internal.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

public class CustomBlockSapling extends BlockBush implements IGrowable, IMetaName {

    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);

    public static final PropertyEnum<CustomBlockPlanks.EnumType> VARIANT = PropertyEnum.<CustomBlockPlanks.EnumType>create("variant", CustomBlockPlanks.EnumType.class, new Predicate<CustomBlockPlanks.EnumType>()
    {
        public boolean apply(@Nullable CustomBlockPlanks.EnumType apply)
        {
            // Cannot be more than 4!
            return apply.getMeta() < 2;
        }
    });

    public CustomBlockSapling(String name) {

        setUnlocalizedName(name);
        setRegistryName(name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, CustomBlockPlanks.EnumType.TUTORIAL).withProperty(STAGE, Integer.valueOf(0)));
    }

    // Sapling Shape
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

        return SAPLING_AABB;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {

        return NULL_AABB;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {

        // Not a cube.
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {

        // Not a cube.
        return false;
    }

    // Variants
    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {

        for(CustomBlockPlanks.EnumType customblockplanks$enumtype : CustomBlockPlanks.EnumType.values()) {
            items.add(new ItemStack(this, 1, customblockplanks$enumtype.getMeta()));
        }
    }

    @Override
    public String getSpecialName(ItemStack stack) {

        return CustomBlockPlanks.EnumType.values()[stack.getItemDamage()].getName();
    }

    @Override
    public int damageDropped(IBlockState state) {

        return ((CustomBlockPlanks.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {

        return this.getDefaultState().withProperty(VARIANT, CustomBlockPlanks.EnumType.byMetadata(meta & 1)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((CustomBlockPlanks.EnumType)state.getValue(VARIANT)).getMeta();
        i = i | ((Integer)state.getValue(STAGE)).intValue() << 3;
        return i;
    }

    @Override
    protected BlockStateContainer createBlockState() {

        return new BlockStateContainer(this, new IProperty[] {VARIANT, STAGE});
    }

    // Tree Code
    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {

        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {

        return (double)worldIn.rand.nextFloat() < 0.45D;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {

        if(((Integer)state.getValue(STAGE)).intValue() == 0)
        {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
        else
        {
            this.generateTree(worldIn, rand, pos, state);
        }
    }

    @Override
    protected boolean canSustainBush(IBlockState state) {

        return state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.FARMLAND;
    }

    public void generateTree(World world, Random rand, BlockPos pos, IBlockState state) {

        if(!TerrainGen.saplingGrowTree(world, rand, pos)) return;
        WorldGenerator gen = (WorldGenerator)(rand.nextInt(10) == 0 ? new WorldGenBigTree(false) : new WorldGenTrees(false));
        boolean flag = false;
        int i = 0, j = 0;

        switch((CustomBlockPlanks.EnumType)state.getValue(VARIANT))
        {
            case TUTORIAL:
                //gen = new WorldGenTutorialTree();
                break;
            case ALUMINUM:

                break;
        }

        IBlockState iblockstate = Blocks.AIR.getDefaultState();
        if(flag)
        {
            world.setBlockState(pos.add(0, 0, 0), iblockstate, 4);
            world.setBlockState(pos.add(1, 0, 0), iblockstate, 4);
            world.setBlockState(pos.add(0, 0, 1), iblockstate, 4);
            world.setBlockState(pos.add(1, 0, 1), iblockstate, 4);
        }
        else
        {
            world.setBlockState(pos, iblockstate, 4);
        }

        if(!gen.generate(world, rand, pos.add(i, 0, j)))
        {
            if(flag)
            {
                world.setBlockState(pos.add(0, 0, 0), iblockstate, 4);
                world.setBlockState(pos.add(1, 0, 0), iblockstate, 4);
                world.setBlockState(pos.add(0, 0, 1), iblockstate, 4);
                world.setBlockState(pos.add(1, 0, 1), iblockstate, 4);
            }
            else
            {
                world.setBlockState(pos, iblockstate, 4);
            }
        }
    }
}
