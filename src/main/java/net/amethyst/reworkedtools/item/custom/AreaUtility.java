package net.amethyst.reworkedtools.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Direction;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.TagKey;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;

import java.util.Map;

//Original Author:kwpugh
public class AreaUtility {
    public static byte attemptBreakNeighbors( BlockPos pos,World world, PlayerEntity player, int item, int radius, boolean obsidian) {
        byte b = 0;
        if (!world.isClient) {
            /**final Hand hand = player.getActiveHand();
            final ItemStack stack = player.getStackInHand(hand);*/
            final Map<Enchantment, Integer> enchantments = EnchantmentHelper.get(player.getMainHandStack());
            final boolean silkTouch = enchantments.containsKey(Enchantments.SILK_TOUCH);
            final Vec3d cameraPos = player.getCameraPosVec(1);
            final Vec3d rotation = player.getRotationVec(1);
            final Vec3d cameraPosWithRotation = cameraPos.add(rotation.x * 5, rotation.y * 5, rotation.z * 5);
            final BlockHitResult blockHitResult = world.raycast(new RaycastContext(cameraPos, cameraPosWithRotation, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, player));


            BlockPos pos1;
            BlockPos pos2;
            BlockPos pos3;
            BlockPos pos4;
            BlockPos pos5;
            BlockPos pos6;
            BlockPos pos7;
            BlockPos pos8;
            BlockPos pos9;

            int x1 = (int) pos.getX();
            int y1 = (int) pos.getY();
            int z1 = (int) pos.getZ();

            final Direction.Axis axis = blockHitResult.getSide().getAxis();
            //Depending on the side and axis, add blockPos on same plane
            final BlockPos origin = blockHitResult.getBlockPos();



                if (axis == Direction.Axis.Z) {
                pos1 = new BlockPos(x1 - 1, y1 + 1, z1);
                pos2 = new BlockPos(x1, y1 + 1, z1);
                pos3 = new BlockPos(x1 + 1, y1 + 1, z1);
                pos4 = new BlockPos(x1 - 1, y1, z1);
                pos5 = new BlockPos(x1, y1, z1);
                pos6 = new BlockPos(x1 + 1, y1, z1);
                pos7 = new BlockPos(x1 - 1, y1 - 1, z1);
                pos8 = new BlockPos(x1, y1 - 1, z1);
                pos9 = new BlockPos(x1 + 1, y1 - 1, z1);

                } else if (axis == Direction.Axis.X) {
                    pos1 = new BlockPos(x1, y1 + 1, z1 - 1);
                pos2 = new BlockPos(x1, y1 + 1, z1);
                pos3 = new BlockPos(x1, y1 + 1, z1 + 1);
                pos4 = new BlockPos(x1, y1, z1 - 1);
                pos5 = new BlockPos(x1, y1, z1);
                pos6 = new BlockPos(x1, y1, z1 + 1);
                pos7 = new BlockPos(x1, y1 - 1, z1 - 1);
                pos8 = new BlockPos(x1, y1 - 1, z1);
                pos9 = new BlockPos(x1, y1 - 1, z1 + 1);

                } else if (axis == Direction.Axis.Y) {
                    pos1 = new BlockPos(x1 + 1, y1, z1 + 1);
                pos2 = new BlockPos(x1 + 1, y1, z1);
                pos3 = new BlockPos(x1 + 1, y1, z1 - 1);
                pos4 = new BlockPos(x1, y1, z1 + 1);
                pos5 = new BlockPos(x1, y1, z1);
                pos6 = new BlockPos(x1, y1, z1 - 1);
                pos7 = new BlockPos(x1 - 1, y1, z1 + 1);
                pos8 = new BlockPos(x1 - 1, y1, z1);
                pos9 = new BlockPos(x1 - 1, y1, z1 - 1);


            } else {
                pos1 = null;
                pos2 = null;
                pos3 = null;
                pos4 = null;
                pos5 = null;
                pos6 = null;
                pos7 = null;
                pos8 = null;
                pos9 = null;
            }
            BlockState state1 = world.getBlockState(pos1);
            BlockState state2 = world.getBlockState(pos2);
            BlockState state3 = world.getBlockState(pos3);
            BlockState state4 = world.getBlockState(pos4);
            BlockState state5 = world.getBlockState(pos5);
            BlockState state6 = world.getBlockState(pos6);
            BlockState state7 = world.getBlockState(pos7);
            BlockState state8 = world.getBlockState(pos8);
            BlockState state9 = world.getBlockState(pos9);

            final Block block1 = state1.getBlock();
            final Block block2 = state2.getBlock();
            final Block block3 = state3.getBlock();
            final Block block4 = state4.getBlock();
            final Block block5 = state5.getBlock();
            final Block block6 = state6.getBlock();
            final Block block7 = state7.getBlock();
            final Block block8 = state8.getBlock();
            final Block block9 = state9.getBlock();

            final float hardness1 = state1.getHardness(world, pos1);
            final float hardness2 = state1.getHardness(world, pos2);
            final float hardness3 = state1.getHardness(world, pos3);
            final float hardness4 = state1.getHardness(world, pos4);
            final float hardness5 = state1.getHardness(world, pos5);
            final float hardness6 = state1.getHardness(world, pos6);
            final float hardness7 = state1.getHardness(world, pos7);
            final float hardness8 = state1.getHardness(world, pos8);
            final float hardness9 = state1.getHardness(world, pos9);

            /**if (player.getMainHandStack().isSuitableFor(world.getBlockState(pos1))) {*/
                final boolean readyForBreaking1 = obsidian || (hardness1 < 50.0F && hardness1 >= 0F);
                if (readyForBreaking1) {
                    if (item ==1) {
                        if (state1.isIn(BlockTags.PICKAXE_MINEABLE)) {
                            world.breakBlock(pos1, false);
                            if (silkTouch) {
                                // drop blocks
                                world.spawnEntity(new ItemEntity(world, pos1.getX(), pos1.getY(), pos1.getZ(), new ItemStack(block1.asItem(), 1)));
                            } else {
                                // drops stacks
                                Block.dropStacks(state1, world, pos1, null, player, new ItemStack(block1.asItem()));   // USe this version to account for enchantments on stack
                            }
                        } 
                    else if (item == 2) {
                            if (state1.isIn(BlockTags.SHOVEL_MINEABLE)) {
                                world.breakBlock(pos1, false);
                                if (silkTouch) {
                                    // drop blocks
                                    world.spawnEntity(new ItemEntity(world, pos1.getX(), pos1.getY(), pos1.getZ(), new ItemStack(block1.asItem(), 1)));
                                } else {
                                    // drops stacks
                                    Block.dropStacks(state1, world, pos1, null, player, new ItemStack(block1.asItem()));   // USe this version to account for enchantments on stack
                                }
                            }
                        }

                    }
                }
            final boolean readyForBreaking2 = obsidian || (hardness2 < 50.0F && hardness2 >= 0F);
            if (readyForBreaking2) {
                if (item == 1) {
                    if (state2.isIn(BlockTags.PICKAXE_MINEABLE)) {
                        world.breakBlock(pos2, false);
                        if (silkTouch) {
                            // drop blocks
                            world.spawnEntity(new ItemEntity(world, pos2.getX(), pos2.getY(), pos2.getZ(), new ItemStack(block2.asItem(), 1)));
                        } else {
                            // drops stacks
                            Block.dropStacks(state2, world, pos2, null, player, new ItemStack(block2.asItem()));   // USe this version to account for enchantments on stack
                        }
                    }
                if (item == 2) {
                        if (state2.isIn(BlockTags.SHOVEL_MINEABLE)) {
                            world.breakBlock(pos2, false);
                            if (silkTouch) {
                                // drop blocks
                                world.spawnEntity(new ItemEntity(world, pos2.getX(), pos2.getY(), pos2.getZ(), new ItemStack(block2.asItem(), 1)));
                            } else {
                                // drops stacks
                                Block.dropStacks(state2, world, pos2, null, player, new ItemStack(block2.asItem()));   // USe this version to account for enchantments on stack
                            }
                        }
                    }

                }
            }
            final boolean readyForBreaking3 = obsidian || (hardness3 < 50.0F && hardness3 >= 0F);
            if (readyForBreaking3) {
                if (item == 1) {
                    if (state3.isIn(BlockTags.PICKAXE_MINEABLE)) {
                        world.breakBlock(pos3, false);
                        if (silkTouch) {
                            // drop blocks
                            world.spawnEntity(new ItemEntity(world, pos3.getX(), pos3.getY(), pos3.getZ(), new ItemStack(block3.asItem(), 1)));
                        } else {
                            // drops stacks
                            Block.dropStacks(state3, world, pos3, null, player, new ItemStack(block3.asItem()));   // USe this version to account for enchantments on stack
                        }
                    } else if (item == 2) {
                        if (state3.isIn(BlockTags.SHOVEL_MINEABLE)) {
                            world.breakBlock(pos3, false);
                            if (silkTouch) {
                                // drop blocks
                                world.spawnEntity(new ItemEntity(world, pos3.getX(), pos3.getY(), pos3.getZ(), new ItemStack(block3.asItem(), 1)));
                            } else {
                                // drops stacks
                                Block.dropStacks(state3, world, pos3, null, player, new ItemStack(block3.asItem()));   // USe this version to account for enchantments on stack
                            }
                        }
                    }

                }
            }
            final boolean readyForBreaking4 = obsidian || (hardness4 < 50.0F && hardness4 >= 0F);
            if (readyForBreaking4) {
                if (item == 1) {
                    if (state4.isIn(BlockTags.PICKAXE_MINEABLE)) {
                        world.breakBlock(pos4, false);
                        if (silkTouch) {
                            // drop blocks
                            world.spawnEntity(new ItemEntity(world, pos4.getX(), pos4.getY(), pos4.getZ(), new ItemStack(block4.asItem(), 1)));
                        } else {
                            // drops stacks
                            Block.dropStacks(state4, world, pos4, null, player, new ItemStack(block4.asItem()));   // USe this version to account for enchantments on stack
                        }
                    } else if (item == 2) {
                        if (state4.isIn(BlockTags.SHOVEL_MINEABLE)) {
                            world.breakBlock(pos4, false);
                            if (silkTouch) {
                                // drop blocks
                                world.spawnEntity(new ItemEntity(world, pos4.getX(), pos4.getY(), pos4.getZ(), new ItemStack(block4.asItem(), 1)));
                            } else {
                                // drops stacks
                                Block.dropStacks(state4, world, pos4, null, player, new ItemStack(block4.asItem()));   // USe this version to account for enchantments on stack
                            }
                        }
                    }

                }
            }
            final boolean readyForBreaking5 = obsidian || (hardness5 < 50.0F && hardness5 >= 0F);
            if (readyForBreaking5) {
                if (item == 1) {
                    if (state5.isIn(BlockTags.PICKAXE_MINEABLE)) {
                        world.breakBlock(pos5, false);
                        if (silkTouch) {
                            // drop blocks
                            world.spawnEntity(new ItemEntity(world, pos5.getX(), pos5.getY(), pos5.getZ(), new ItemStack(block5.asItem(), 1)));
                        } else {
                            // drops stacks
                            Block.dropStacks(state5, world, pos5, null, player, new ItemStack(block5.asItem()));   // USe this version to account for enchantments on stack
                        }
                    } else if (item == 2) {
                        if (state5.isIn(BlockTags.SHOVEL_MINEABLE)) {
                            world.breakBlock(pos5, false);
                            if (silkTouch) {
                                // drop blocks
                                world.spawnEntity(new ItemEntity(world, pos5.getX(), pos5.getY(), pos5.getZ(), new ItemStack(block5.asItem(), 1)));
                            } else {
                                // drops stacks
                                Block.dropStacks(state5, world, pos5, null, player, new ItemStack(block5.asItem()));   // USe this version to account for enchantments on stack
                            }
                        }
                    }

                }
            }
            final boolean readyForBreaking6 = obsidian || (hardness6 < 50.0F && hardness6 >= 0F);
            if (readyForBreaking6) {
                if (item == 1) {
                    if (state6.isIn(BlockTags.PICKAXE_MINEABLE)) {
                        world.breakBlock(pos6, false);
                        if (silkTouch) {
                            // drop blocks
                            world.spawnEntity(new ItemEntity(world, pos6.getX(), pos6.getY(), pos6.getZ(), new ItemStack(block6.asItem(), 1)));
                        } else {
                            // drops stacks
                            Block.dropStacks(state6, world, pos6, null, player, new ItemStack(block6.asItem()));   // USe this version to account for enchantments on stack
                        }
                    } else if (item == 2) {
                        if (state6.isIn(BlockTags.SHOVEL_MINEABLE)) {
                            world.breakBlock(pos6, false);
                            if (silkTouch) {
                                // drop blocks
                                world.spawnEntity(new ItemEntity(world, pos6.getX(), pos6.getY(), pos6.getZ(), new ItemStack(block6.asItem(), 1)));
                            } else {
                                // drops stacks
                                Block.dropStacks(state6, world, pos6, null, player, new ItemStack(block6.asItem()));   // USe this version to account for enchantments on stack
                            }
                        }
                    }

                }
            }
            final boolean readyForBreaking7 = obsidian || (hardness7 < 50.0F && hardness7 >= 0F);
            if (readyForBreaking7) {
                if (item == 1) {
                    if (state7.isIn(BlockTags.PICKAXE_MINEABLE)) {
                        world.breakBlock(pos7, false);
                        if (silkTouch) {
                            // drop blocks
                            world.spawnEntity(new ItemEntity(world, pos7.getX(), pos7.getY(), pos7.getZ(), new ItemStack(block7.asItem(), 1)));
                        } else {
                            // drops stacks
                            Block.dropStacks(state7, world, pos7, null, player, new ItemStack(block7.asItem()));   // USe this version to account for enchantments on stack
                        }
                    } else if (item == 2) {
                        if (state7.isIn(BlockTags.SHOVEL_MINEABLE)) {
                            world.breakBlock(pos7, false);
                            if (silkTouch) {
                                // drop blocks
                                world.spawnEntity(new ItemEntity(world, pos7.getX(), pos7.getY(), pos7.getZ(), new ItemStack(block7.asItem(), 1)));
                            } else {
                                // drops stacks
                                Block.dropStacks(state7, world, pos7, null, player, new ItemStack(block7.asItem()));   // USe this version to account for enchantments on stack
                            }
                        }
                    }

                }
            }
            final boolean readyForBreaking8 = obsidian || (hardness8 < 50.0F && hardness8 >= 0F);
            if (readyForBreaking8) {
                if (item == 1) {
                    if (state8.isIn(BlockTags.PICKAXE_MINEABLE)) {
                        world.breakBlock(pos8, false);
                        if (silkTouch) {
                            // drop blocks
                            world.spawnEntity(new ItemEntity(world, pos8.getX(), pos8.getY(), pos8.getZ(), new ItemStack(block8.asItem(), 1)));
                        } else {
                            // drops stacks
                            Block.dropStacks(state8, world, pos8, null, player, new ItemStack(block8.asItem()));   // USe this version to account for enchantments on stack
                        }
                    } else if (item == 2) {
                        if (state8.isIn(BlockTags.SHOVEL_MINEABLE)) {
                            world.breakBlock(pos8, false);
                            if (silkTouch) {
                                // drop blocks
                                world.spawnEntity(new ItemEntity(world, pos8.getX(), pos8.getY(), pos8.getZ(), new ItemStack(block8.asItem(), 1)));
                            } else {
                                // drops stacks
                                Block.dropStacks(state8, world, pos8, null, player, new ItemStack(block8.asItem()));   // USe this version to account for enchantments on stack
                            }
                        }
                    }

                }
            }
            final boolean readyForBreaking9 = obsidian || (hardness9 < 50.0F && hardness9 >= 0F);
            if (readyForBreaking9) {
                if (item == 1) {
                    if (state9.isIn(BlockTags.PICKAXE_MINEABLE)) {
                        world.breakBlock(pos9, false);
                        if (silkTouch) {
                            // drop blocks
                            world.spawnEntity(new ItemEntity(world, pos9.getX(), pos9.getY(), pos9.getZ(), new ItemStack(block9.asItem(), 1)));
                        } else {
                            // drops stacks
                            Block.dropStacks(state9, world, pos9, null, player, new ItemStack(block9.asItem()));   // USe this version to account for enchantments on stack
                        }
                    } else if (item == 2) {
                        if (state9.isIn(BlockTags.SHOVEL_MINEABLE)) {
                            world.breakBlock(pos9, false);
                            if (silkTouch) {
                                // drop blocks
                                world.spawnEntity(new ItemEntity(world, pos9.getX(), pos9.getY(), pos9.getZ(), new ItemStack(block9.asItem(), 1)));
                            } else {
                                // drops stacks
                                Block.dropStacks(state9, world, pos9, null, player, new ItemStack(block9.asItem()));   // USe this version to account for enchantments on stack
                            }
                        }
                    }

                }
            }
            /**}*/
        }
        return b;
    }
}