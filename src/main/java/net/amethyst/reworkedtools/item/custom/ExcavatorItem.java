package net.amethyst.reworkedtools.item.custom;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.data.server.BlockTagProvider;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class ExcavatorItem extends ShovelItem {
    private final int miningLevel;

    public ExcavatorItem(int durability, ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, new Item.Settings().maxDamage(durability).group(ItemGroup.TOOLS));
        miningLevel = material.getMiningLevel();
    }

    @Override
    public boolean isSuitableFor(BlockState state)
    {
        return state.isIn(BlockTags.SHOVEL_MINEABLE);
    }


    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity playerIn)
    {
        if(!playerIn.isSneaking() && playerIn.getMainHandStack().isSuitableFor(world.getBlockState(pos)))
        {
            final boolean obsidianFlag = state.getBlock() == Blocks.OBSIDIAN || state.getBlock() == Blocks.CRYING_OBSIDIAN;
            AreaUtility.attemptBreakNeighbors(pos, world, playerIn, 2,1, obsidianFlag);

        }

        return true;
    }

    //Add this to prevent player breaking block by left-clicking when not sneaking
    /*
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return miner.isSneaking();
    }
     */

    /*
    public ActionResult useOnBlock(ItemUsageContext context) {
        final PlayerEntity player = context.getPlayer();
        if (player == null) {
            return ActionResult.PASS;
        }
        final Hand hand = context.getHand();
        final World world = player.world;
        if (world == null) {
            return ActionResult.PASS;
        }
        final ItemStack hammerStack = context.getStack();
        final Direction direction = context.getSide();
        final BlockPos pos = context.getBlockPos();
        if (player instanceof ServerPlayerEntity serverPlayer) {
            tryBreakNineBlocks(world, serverPlayer, directionToInt(direction), pos, hammerStack, hand);
        }
        player.getItemCooldownManager().set(hammerStack.getItem(),
                //below is the cool-down tick
                Math.max(5, 50 - 10 * miningLevel));
        return ActionResult.success(world.isClient);
    }
    public int directionToInt(Direction direction) {
        return switch (direction) {
            case UP, DOWN -> 2;
            case EAST, WEST -> 1;
            case NORTH, SOUTH -> 3;
        };
    }
    public void tryBreakNineBlocks(World world, ServerPlayerEntity player, int direction, BlockPos center, ItemStack hammerStack, Hand hand) {
        final boolean calX = !(direction == 1);
        final boolean calY = !(direction == 2);
        final boolean calZ = !(direction == 3);
        final int xStart = center.getX() - (calX ? 1 : 0);
        final int yStart = center.getY() - (calY ? 1 : 0);
        final int zStart = center.getZ() - (calZ ? 1 : 0);
        boolean willContinue = true;
        for (int x = 0; x <= (calX ? 2 : 0) && willContinue; x++) {
            for (int y = 0; y <= (calY ? 2 : 0) && willContinue; y++) {
                for (int z = 0; z <= (calZ ? 2 : 0) && willContinue; z++) {
                    willContinue = checkAndTryBreakBlock(world, player, new BlockPos(xStart + x, yStart + y, zStart + z), hammerStack, hand);
                }
            }
        }
    }
    public boolean checkAndTryBreakBlock(World world, ServerPlayerEntity player, BlockPos pos, ItemStack hammer, Hand hand) {
        final Block blockToCheck = world.getBlockState(pos).getBlock();
        if (blockToCheck instanceof BlockWithEntity) {
            return true;
        }
        if (blockToCheck.getHardness() < 0F) {
            //Skip bedrock
            return true;
        }
        world.breakBlock(pos, true, player);
        if (hammer.damage(1, player.world.random, player)) {
            player.setStackInHand(hand, ItemStack.EMPTY);
            return false;
        }
        return true;
    }
     */
}