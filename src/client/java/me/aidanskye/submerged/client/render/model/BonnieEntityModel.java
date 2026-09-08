package me.aidanskye.submerged.client.render.model;

import me.aidanskye.submerged.client.render.model.animation.BonnieAnimations;
import me.aidanskye.submerged.entity.BonnieEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class BonnieEntityModel extends SinglePartEntityModel<BonnieEntity> {
	private final ModelPart Root;

	public BonnieEntityModel(ModelPart root) {
		this.Root = root.getChild("Root");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Root = modelPartData.addChild("Root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Waist = Root.addChild("Waist", ModelPartBuilder.create().uv(20, 13).cuboid(-2.0F, -2.0F, -3.0F, 4.0F, 2.0F, 7.0F, new Dilation(0.02F)), ModelTransform.pivot(0.0F, -16.75F, 0.0F));

		ModelPartData cube_r1 = Waist.addChild("cube_r1", ModelPartBuilder.create().uv(20, 22).mirrored().cuboid(-1.0F, -2.0F, -3.0F, 3.0F, 2.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.9696F, -0.3473F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData cube_r2 = Waist.addChild("cube_r2", ModelPartBuilder.create().uv(20, 22).cuboid(-2.0F, -2.0F, -3.0F, 3.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(3.9696F, -0.3473F, 0.0F, 0.0F, 0.0F, -0.1745F));

		ModelPartData Body = Waist.addChild("Body", ModelPartBuilder.create().uv(28, 41).cuboid(-1.0F, -11.0F, 0.0F, 2.0F, 11.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-3.5F, -9.0F, -1.5F, 7.0F, 8.0F, 5.0F, new Dilation(0.35F))
		.uv(0, 41).cuboid(3.5F, -6.0F, -1.75F, 1.0F, 5.0F, 5.0F, new Dilation(0.0F))
		.uv(0, 41).mirrored().cuboid(-4.5F, -6.0F, -1.75F, 1.0F, 5.0F, 5.0F, new Dilation(0.0F)).mirrored(false)
		.uv(0, 32).cuboid(-3.5F, -9.0F, -2.5F, 7.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, -0.25F));

		ModelPartData Head = Body.addChild("Head", ModelPartBuilder.create().uv(48, 42).cuboid(-2.0F, -1.0F, 0.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(16, 39).cuboid(1.2F, -1.7F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(58, 16).cuboid(1.2F, -1.7F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(56, 26).cuboid(0.1F, -1.7F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(58, 40).cuboid(1.2F, -3.275F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(0, 59).cuboid(1.2F, -3.275F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(4, 59).cuboid(0.1F, -3.275F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(0, 59).mirrored().cuboid(-2.2F, -3.275F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(58, 40).mirrored().cuboid(-2.2F, -3.275F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(4, 59).mirrored().cuboid(-1.1F, -3.275F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(56, 26).mirrored().cuboid(-1.1F, -1.7F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(58, 16).mirrored().cuboid(-2.2F, -1.7F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(16, 39).mirrored().cuboid(-2.2F, -1.7F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(48, 45).cuboid(-2.0F, -1.0F, -1.5F, 4.0F, 1.0F, 2.0F, new Dilation(-0.02F))
		.uv(44, 0).cuboid(-2.0F, -6.0F, 0.0F, 4.0F, 5.0F, 2.0F, new Dilation(0.0F))
		.uv(42, 8).cuboid(-3.0F, -6.0F, -1.5F, 6.0F, 3.0F, 2.0F, new Dilation(-0.02F))
		.uv(16, 32).cuboid(-0.5F, -6.0F, -2.0F, 1.0F, 3.0F, 1.0F, new Dilation(-0.04F)), ModelTransform.pivot(0.0F, -10.5F, 1.0F));

		ModelPartData Left_Eye = Head.addChild("Left.Eye", ModelPartBuilder.create().uv(20, 52).cuboid(-1.0F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.34F))
		.uv(58, 34).cuboid(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(-0.4F)), ModelTransform.pivot(1.25F, -4.35F, -1.75F));

		ModelPartData Right_Eye = Head.addChild("Right.Eye", ModelPartBuilder.create().uv(20, 52).cuboid(-1.0F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.34F))
		.uv(58, 34).cuboid(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(-0.4F)), ModelTransform.pivot(-1.25F, -4.35F, -1.75F));

		ModelPartData Mask = Head.addChild("Mask", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Jaw = Mask.addChild("Jaw", ModelPartBuilder.create().uv(0, 25).cuboid(-2.0F, -0.5F, -3.5F, 4.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(48, 28).cuboid(2.0F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F))
		.uv(28, 59).cuboid(1.0F, -1.25F, -3.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(32, 59).cuboid(0.0F, -1.25F, -3.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(32, 59).mirrored().cuboid(-1.0F, -1.25F, -3.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(28, 59).mirrored().cuboid(-2.0F, -1.25F, -3.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(48, 28).mirrored().cuboid(-3.0F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Face = Mask.addChild("Face", ModelPartBuilder.create().uv(48, 34).cuboid(-2.0F, -5.05F, 1.75F, 4.0F, 7.0F, 1.0F, new Dilation(0.0F))
		.uv(42, 13).cuboid(-2.0F, -5.05F, -2.25F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(24, 8).cuboid(-2.5F, -4.55F, -2.25F, 5.0F, 1.0F, 4.0F, new Dilation(-0.02F))
		.uv(36, 31).cuboid(2.0F, -5.0F, -2.25F, 1.0F, 6.0F, 5.0F, new Dilation(0.0F))
		.uv(36, 42).cuboid(3.0F, -2.75F, -2.25F, 1.0F, 4.0F, 5.0F, new Dilation(0.0F))
		.uv(40, 28).cuboid(1.875F, -1.75F, -3.0F, 2.0F, 2.0F, 1.0F, new Dilation(-0.25F))
		.uv(36, 59).cuboid(-0.5F, -2.5F, -4.0F, 1.0F, 1.0F, 1.0F, new Dilation(-0.15F))
		.uv(42, 18).cuboid(-2.0F, -2.25F, -3.5F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(16, 36).cuboid(-0.5F, -4.25F, -2.25F, 1.0F, 2.0F, 1.0F, new Dilation(-0.01F))
		.uv(60, 26).cuboid(-0.25F, -0.5F, -3.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(60, 26).mirrored().cuboid(-0.75F, -0.5F, -3.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(36, 31).mirrored().cuboid(-3.0F, -5.0F, -2.25F, 1.0F, 6.0F, 5.0F, new Dilation(0.0F)).mirrored(false)
		.uv(36, 42).mirrored().cuboid(-4.0F, -2.75F, -2.25F, 1.0F, 4.0F, 5.0F, new Dilation(0.0F)).mirrored(false)
		.uv(40, 28).mirrored().cuboid(-3.875F, -1.75F, -3.0F, 2.0F, 2.0F, 1.0F, new Dilation(-0.25F)).mirrored(false), ModelTransform.pivot(0.0F, -1.5F, 0.0F));

		ModelPartData Ear_L = Face.addChild("Ear.L", ModelPartBuilder.create().uv(58, 37).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(56, 52).cuboid(-1.0F, -5.0F, -0.75F, 2.0F, 4.0F, 1.0F, new Dilation(-0.08F))
		.uv(56, 57).cuboid(-1.0F, -5.0F, -0.5F, 2.0F, 4.0F, 1.0F, new Dilation(0.1F)), ModelTransform.of(1.5F, -4.5F, 0.25F, 0.0F, 0.0F, 0.4363F));

		ModelPartData Ear_L2 = Ear_L.addChild("Ear.L2", ModelPartBuilder.create().uv(58, 48).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 58).cuboid(-1.0F, -4.0F, -0.5F, 2.0F, 3.0F, 1.0F, new Dilation(0.06F))
		.uv(22, 58).cuboid(-1.0F, -4.0F, -0.75F, 2.0F, 3.0F, 1.0F, new Dilation(-0.14F)), ModelTransform.pivot(0.0F, -4.75F, 0.0F));

		ModelPartData Ear_R = Face.addChild("Ear.R", ModelPartBuilder.create().uv(58, 37).mirrored().cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(56, 52).mirrored().cuboid(-1.0F, -5.0F, -0.75F, 2.0F, 4.0F, 1.0F, new Dilation(-0.08F)).mirrored(false)
		.uv(56, 57).mirrored().cuboid(-1.0F, -5.0F, -0.5F, 2.0F, 4.0F, 1.0F, new Dilation(0.1F)).mirrored(false), ModelTransform.of(-1.5F, -4.5F, 0.25F, 0.0F, 0.0F, -0.4363F));

		ModelPartData Ear_L4 = Ear_R.addChild("Ear.L4", ModelPartBuilder.create().uv(58, 48).mirrored().cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(16, 58).mirrored().cuboid(-1.0F, -4.0F, -0.5F, 2.0F, 3.0F, 1.0F, new Dilation(0.06F)).mirrored(false)
		.uv(22, 58).mirrored().cuboid(-1.0F, -4.0F, -0.75F, 2.0F, 3.0F, 1.0F, new Dilation(-0.14F)).mirrored(false), ModelTransform.pivot(0.0F, -4.75F, 0.0F));

		ModelPartData BowTie = Body.addChild("BowTie", ModelPartBuilder.create().uv(40, 56).cuboid(-1.0F, -1.05F, -1.05F, 2.0F, 2.0F, 2.0F, new Dilation(-0.55F)), ModelTransform.pivot(0.0F, -8.0F, -2.75F));

		ModelPartData cube_r3 = BowTie.addChild("cube_r3", ModelPartBuilder.create().uv(0, 51).mirrored().cuboid(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.53F)).mirrored(false), ModelTransform.of(-0.75F, -0.2973F, 0.0F, 0.0F, 0.0F, 0.384F));

		ModelPartData cube_r4 = BowTie.addChild("cube_r4", ModelPartBuilder.create().uv(56, 4).mirrored().cuboid(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.6F)).mirrored(false), ModelTransform.of(-0.8091F, -0.0614F, 0.0F, 0.0F, 0.0F, 0.0087F));

		ModelPartData cube_r5 = BowTie.addChild("cube_r5", ModelPartBuilder.create().uv(48, 48).mirrored().cuboid(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.55F)).mirrored(false), ModelTransform.of(-0.75F, 0.2F, 0.0F, 0.0F, 0.0F, -0.384F));

		ModelPartData cube_r6 = BowTie.addChild("cube_r6", ModelPartBuilder.create().uv(56, 4).cuboid(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.6F)), ModelTransform.of(0.8091F, -0.0614F, 0.0F, 0.0F, 0.0F, -0.0087F));

		ModelPartData cube_r7 = BowTie.addChild("cube_r7", ModelPartBuilder.create().uv(0, 51).cuboid(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.53F)), ModelTransform.of(0.75F, -0.2973F, 0.0F, 0.0F, 0.0F, -0.384F));

		ModelPartData cube_r8 = BowTie.addChild("cube_r8", ModelPartBuilder.create().uv(48, 48).cuboid(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.55F)), ModelTransform.of(0.75F, 0.2F, 0.0F, 0.0F, 0.0F, 0.384F));

		ModelPartData LeftUpperArm = Body.addChild("LeftUpperArm", ModelPartBuilder.create().uv(40, 22).cuboid(-1.0F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, new Dilation(0.1F))
		.uv(58, 12).cuboid(-1.75F, -1.5F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(-0.02F))
		.uv(58, 8).cuboid(4.0F, -1.5F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(5.25F, -7.5F, 0.75F));

		ModelPartData LeftLowerArm = LeftUpperArm.addChild("LeftLowerArm", ModelPartBuilder.create().uv(12, 41).cuboid(0.0F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new Dilation(0.1F))
		.uv(71, 38).cuboid(0.0F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new Dilation(0.51F))
		.uv(10, 58).cuboid(5.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(4.75F, -0.5F, 0.0F));

		ModelPartData Hand = LeftLowerArm.addChild("Hand", ModelPartBuilder.create().uv(20, 47).cuboid(-0.5F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.1F)), ModelTransform.pivot(6.0F, 0.0F, 0.0F));

		ModelPartData EmptyHand = Hand.addChild("EmptyHand", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 0.0F, 0.0F));

		ModelPartData LowerFinger_L_0 = Hand.addChild("LowerFinger.L.0", ModelPartBuilder.create().uv(48, 56).cuboid(-0.75F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.6F)), ModelTransform.pivot(0.5F, -1.9F, -0.375F));

		ModelPartData UpperFinger_L_0 = LowerFinger_L_0.addChild("UpperFinger.L.0", ModelPartBuilder.create().uv(36, 51).cuboid(-0.75F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.55F)), ModelTransform.pivot(0.75F, 0.0F, 0.0F));

		ModelPartData LowerFinger_L_1 = Hand.addChild("LowerFinger.L.1", ModelPartBuilder.create().uv(46, 52).cuboid(-0.75F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.6F)), ModelTransform.pivot(1.5F, -1.0F, 0.875F));

		ModelPartData UpperFinger_L_1 = LowerFinger_L_1.addChild("UpperFinger.L.1", ModelPartBuilder.create().uv(54, 18).cuboid(-0.75F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.55F)), ModelTransform.pivot(1.75F, 0.0F, 0.0F));

		ModelPartData LowerFinger_L_2 = Hand.addChild("LowerFinger.L.2", ModelPartBuilder.create().uv(20, 54).cuboid(-0.75F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.6F)), ModelTransform.pivot(1.5F, 0.0F, 0.875F));

		ModelPartData UpperFinger_L_2 = LowerFinger_L_2.addChild("UpperFinger.L.2", ModelPartBuilder.create().uv(0, 55).cuboid(-0.75F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.55F)), ModelTransform.pivot(1.75F, 0.0F, 0.0F));

		ModelPartData LowerFinger_L_3 = Hand.addChild("LowerFinger.L.3", ModelPartBuilder.create().uv(30, 55).cuboid(-0.75F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.6F)), ModelTransform.pivot(1.5F, 1.0F, 0.875F));

		ModelPartData UpperFinger_L_3 = LowerFinger_L_3.addChild("UpperFinger.L.3", ModelPartBuilder.create().uv(56, 0).cuboid(-0.75F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.55F)), ModelTransform.pivot(1.75F, 0.0F, 0.0F));

		ModelPartData RightUpperArm = Body.addChild("RightUpperArm", ModelPartBuilder.create().uv(40, 22).mirrored().cuboid(-4.0F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, new Dilation(0.1F)).mirrored(false)
		.uv(58, 12).mirrored().cuboid(0.75F, -1.5F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(-0.02F)).mirrored(false)
		.uv(58, 8).mirrored().cuboid(-5.0F, -1.5F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-5.25F, -7.5F, 0.75F));

		ModelPartData RightLowerArm = RightUpperArm.addChild("RightLowerArm", ModelPartBuilder.create().uv(12, 41).mirrored().cuboid(-5.0F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new Dilation(0.1F)).mirrored(false)
		.uv(10, 58).mirrored().cuboid(-6.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-4.75F, -0.5F, 0.0F));

		ModelPartData Hand2 = RightLowerArm.addChild("Hand2", ModelPartBuilder.create().uv(20, 47).mirrored().cuboid(-1.5F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.1F)).mirrored(false), ModelTransform.pivot(-6.0F, 0.0F, 0.0F));

		ModelPartData EmptyHand2 = Hand2.addChild("EmptyHand2", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 0.0F, 0.0F));

		ModelPartData LowerFinger_R_0 = Hand2.addChild("LowerFinger.R.0", ModelPartBuilder.create().uv(48, 56).mirrored().cuboid(-1.25F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.6F)).mirrored(false), ModelTransform.pivot(-0.5F, -1.9F, -0.375F));

		ModelPartData UpperFinger_R_0 = LowerFinger_R_0.addChild("UpperFinger.R.0", ModelPartBuilder.create().uv(36, 51).mirrored().cuboid(-2.25F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.55F)).mirrored(false), ModelTransform.pivot(-0.75F, 0.0F, 0.0F));

		ModelPartData LowerFinger_R_1 = Hand2.addChild("LowerFinger.R.1", ModelPartBuilder.create().uv(46, 52).mirrored().cuboid(-2.25F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.6F)).mirrored(false), ModelTransform.pivot(-1.5F, -1.0F, 0.875F));

		ModelPartData UpperFinger_R_1 = LowerFinger_R_1.addChild("UpperFinger.R.1", ModelPartBuilder.create().uv(54, 18).mirrored().cuboid(-2.25F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.55F)).mirrored(false), ModelTransform.pivot(-1.75F, 0.0F, 0.0F));

		ModelPartData LowerFinger_R_2 = Hand2.addChild("LowerFinger.R.2", ModelPartBuilder.create().uv(20, 54).mirrored().cuboid(-2.25F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.6F)).mirrored(false), ModelTransform.pivot(-1.5F, 0.0F, 0.875F));

		ModelPartData UpperFinger_R_2 = LowerFinger_R_2.addChild("UpperFinger.R.2", ModelPartBuilder.create().uv(0, 55).mirrored().cuboid(-2.25F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.55F)).mirrored(false), ModelTransform.pivot(-1.75F, 0.0F, 0.0F));

		ModelPartData LowerFinger_R_3 = Hand2.addChild("LowerFinger.R.3", ModelPartBuilder.create().uv(30, 55).mirrored().cuboid(-2.25F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.6F)).mirrored(false), ModelTransform.pivot(-1.5F, 1.0F, 0.875F));

		ModelPartData UpperFinger_R_3 = LowerFinger_R_3.addChild("UpperFinger.R.3", ModelPartBuilder.create().uv(56, 0).mirrored().cuboid(-2.25F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.55F)).mirrored(false), ModelTransform.pivot(-1.75F, 0.0F, 0.0F));

		ModelPartData LeftThigh = Waist.addChild("LeftThigh", ModelPartBuilder.create().uv(12, 47).cuboid(-1.0F, -1.25F, -1.0F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 13).cuboid(-2.5F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, new Dilation(-0.25F)), ModelTransform.pivot(2.5F, 0.0F, 0.5F));

		ModelPartData LeftLeg = LeftThigh.addChild("LeftLeg", ModelPartBuilder.create().uv(56, 22).cuboid(-1.0F, 5.75F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(20, 31).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.75F, 0.0F));

		ModelPartData LeftFoot = LeftLeg.addChild("LeftFoot", ModelPartBuilder.create().uv(24, 0).cuboid(-2.0F, 0.0F, -5.0F, 4.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.0F, 1.0F));

		ModelPartData RightThigh = Waist.addChild("RightThigh", ModelPartBuilder.create().uv(12, 47).mirrored().cuboid(-1.0F, -1.25F, -1.0F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
		.uv(0, 13).mirrored().cuboid(-2.5F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, new Dilation(-0.25F)).mirrored(false), ModelTransform.pivot(-2.5F, 0.0F, 0.5F));

		ModelPartData RightLeg = RightThigh.addChild("RightLeg", ModelPartBuilder.create().uv(56, 22).mirrored().cuboid(-1.0F, 5.75F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
		.uv(20, 31).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 7.75F, 0.0F));

		ModelPartData RightFoot = RightLeg.addChild("RightFoot", ModelPartBuilder.create().uv(24, 0).mirrored().cuboid(-2.0F, 0.0F, -5.0F, 4.0F, 2.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 7.0F, 1.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(BonnieEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.updateAnimation(entity.mainPoseAnimationState, BonnieAnimations.MAINPOSE, ageInTicks, 1f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
		Root.render(matrices, vertexConsumer, light, overlay, color);
	}

	@Override
	public ModelPart getPart() {
		return Root;
	}
}