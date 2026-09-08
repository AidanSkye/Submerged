package me.aidanskye.submerged.client.render.model;

import me.aidanskye.submerged.client.render.model.animation.FreddyAnimations;
import me.aidanskye.submerged.entity.FreddyEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class FreddyEntityModel extends SinglePartEntityModel<FreddyEntity> {
	private final ModelPart Root;

	public FreddyEntityModel(ModelPart root) {
		this.Root = root.getChild("Root");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Root = modelPartData.addChild("Root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Waist = Root.addChild("Waist", ModelPartBuilder.create().uv(20, 15).cuboid(-2.0F, -2.0F, -3.0F, 4.0F, 2.0F, 7.0F, new Dilation(0.02F)), ModelTransform.pivot(0.0F, -16.75F, 0.0F));

		ModelPartData cube_r1 = Waist.addChild("cube_r1", ModelPartBuilder.create().uv(20, 24).mirrored().cuboid(-1.0F, -2.0F, -3.0F, 3.0F, 2.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.9696F, -0.3473F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData cube_r2 = Waist.addChild("cube_r2", ModelPartBuilder.create().uv(20, 24).cuboid(-2.0F, -2.0F, -3.0F, 3.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(3.9696F, -0.3473F, 0.0F, 0.0F, 0.0F, -0.1745F));

		ModelPartData Body = Waist.addChild("Body", ModelPartBuilder.create().uv(0, 45).cuboid(-1.0F, -11.0F, 0.0F, 2.0F, 11.0F, 2.0F, new Dilation(0.0F))
		.uv(34, 67).cuboid(-4.5F, -9.0F, -2.5F, 9.0F, 8.0F, 6.0F, new Dilation(0.35F))
		.uv(16, 41).cuboid(4.25F, -9.0F, -1.75F, 1.0F, 8.0F, 5.0F, new Dilation(0.0F))
		.uv(16, 41).mirrored().cuboid(-5.25F, -9.0F, -1.75F, 1.0F, 8.0F, 5.0F, new Dilation(0.0F)).mirrored(false)
		.uv(38, 33).cuboid(-3.5F, -9.0F, -3.75F, 7.0F, 8.0F, 1.0F, new Dilation(0.0F))
		.uv(40, 58).cuboid(-0.5F, -7.0F, -4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(44, 58).cuboid(-0.5F, -5.5F, -4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData Head = Body.addChild("Head", ModelPartBuilder.create().uv(54, 31).cuboid(-2.0F, -1.0F, 0.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(48, 5).cuboid(1.2F, -1.7F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(50, 31).cuboid(1.2F, -1.7F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(16, 39).cuboid(0.1F, -1.7F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(48, 5).mirrored().cuboid(-2.2F, -1.7F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(16, 39).mirrored().cuboid(-1.1F, -1.7F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(52, 5).cuboid(1.2F, -3.275F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(54, 24).cuboid(1.2F, -3.275F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(54, 24).mirrored().cuboid(-2.2F, -3.275F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(46, 31).cuboid(0.1F, -3.275F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(46, 31).mirrored().cuboid(-1.1F, -3.275F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(52, 5).mirrored().cuboid(-2.2F, -3.275F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(50, 31).mirrored().cuboid(-2.2F, -1.7F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(54, 34).cuboid(-2.0F, -1.0F, -1.5F, 4.0F, 1.0F, 2.0F, new Dilation(-0.02F))
		.uv(28, 53).cuboid(-2.0F, -6.0F, 0.0F, 4.0F, 5.0F, 2.0F, new Dilation(0.0F))
		.uv(46, 7).cuboid(-3.0F, -6.0F, -1.5F, 6.0F, 3.0F, 2.0F, new Dilation(-0.02F))
		.uv(16, 35).cuboid(-0.5F, -6.0F, -2.0F, 1.0F, 3.0F, 1.0F, new Dilation(-0.04F)), ModelTransform.pivot(0.0F, -10.5F, 1.0F));

//		ModelPartData Left_Eye = Head.addChild("Left.Eye", ModelPartBuilder.create().uv(67, 17).cuboid(-1.0F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.34F))
//		.uv(46, 12).cuboid(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(-0.4F)), ModelTransform.pivot(1.25F, -4.35F, -1.75F));
//
//		ModelPartData Right_Eye = Head.addChild("Right.Eye", ModelPartBuilder.create().uv(67, 17).mirrored().cuboid(-1.0F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.34F)).mirrored(false)
//		.uv(46, 12).cuboid(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(-0.4F)), ModelTransform.pivot(-1.25F, -4.35F, -1.75F));

		ModelPartData Mask = Head.addChild("Mask", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Jaw = Mask.addChild("Jaw", ModelPartBuilder.create().uv(28, 0).cuboid(-2.0F, -0.5F, -3.5F, 4.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(16, 54).cuboid(2.0F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F))
		.uv(56, 5).cuboid(1.0F, -1.25F, -3.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(58, 24).cuboid(0.0F, -1.25F, -3.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(58, 24).mirrored().cuboid(-1.0F, -1.25F, -3.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(56, 5).mirrored().cuboid(-2.0F, -1.25F, -3.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(16, 54).mirrored().cuboid(-3.0F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Face = Mask.addChild("Face", ModelPartBuilder.create().uv(54, 12).cuboid(-2.0F, -5.05F, 1.75F, 4.0F, 7.0F, 1.0F, new Dilation(0.0F))
		.uv(48, 0).cuboid(-2.0F, -5.05F, -2.25F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(40, 26).cuboid(-2.5F, -4.55F, -2.25F, 5.0F, 1.0F, 4.0F, new Dilation(-0.02F))
		.uv(42, 15).cuboid(2.0F, -5.0F, -2.25F, 1.0F, 6.0F, 5.0F, new Dilation(0.0F))
		.uv(28, 42).cuboid(3.0F, -4.75F, -2.25F, 1.0F, 6.0F, 5.0F, new Dilation(0.0F))
		.uv(56, 53).cuboid(1.875F, -2.0F, -3.0F, 2.0F, 2.0F, 1.0F, new Dilation(-0.05F))
		.uv(42, 15).mirrored().cuboid(-3.0F, -5.0F, -2.25F, 1.0F, 6.0F, 5.0F, new Dilation(0.0F)).mirrored(false)
		.uv(28, 42).mirrored().cuboid(-4.0F, -4.75F, -2.25F, 1.0F, 6.0F, 5.0F, new Dilation(0.0F)).mirrored(false)
		.uv(56, 53).mirrored().cuboid(-3.875F, -2.0F, -3.0F, 2.0F, 2.0F, 1.0F, new Dilation(-0.05F)).mirrored(false)
		.uv(56, 53).cuboid(1.875F, -2.0F, -3.0F, 2.0F, 2.0F, 1.0F, new Dilation(-0.05F))
		.uv(40, 31).cuboid(-1.0F, -2.5F, -4.0F, 2.0F, 1.0F, 1.0F, new Dilation(-0.15F))
		.uv(54, 20).cuboid(-2.0F, -2.25F, -3.5F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 58).cuboid(-0.5F, -4.25F, -2.25F, 1.0F, 2.0F, 1.0F, new Dilation(-0.01F))
		.uv(58, 26).cuboid(1.0F, -0.5F, -3.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(58, 28).cuboid(0.0F, -0.5F, -3.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(58, 28).mirrored().cuboid(-1.0F, -0.5F, -3.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(58, 26).mirrored().cuboid(-2.0F, -0.5F, -3.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false), ModelTransform.pivot(0.0F, -1.5F, 0.0F));

		ModelPartData Hat = Face.addChild("Hat", ModelPartBuilder.create().uv(40, 49).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(40, 54).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, 0.0F));

		ModelPartData Ear_L = Face.addChild("Ear.L", ModelPartBuilder.create().uv(4, 58).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(56, 56).cuboid(-1.0F, -3.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.02F)), ModelTransform.of(3.0F, -4.5F, 0.25F, 0.0F, 0.0F, 0.4363F));

		ModelPartData Ear_R = Face.addChild("Ear.R", ModelPartBuilder.create().uv(4, 58).mirrored().cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(56, 56).mirrored().cuboid(-1.0F, -3.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.02F)).mirrored(false), ModelTransform.of(-3.0F, -4.5F, 0.25F, 0.0F, 0.0F, -0.4363F));

		ModelPartData BowTie = Body.addChild("BowTie", ModelPartBuilder.create().uv(54, 37).cuboid(-1.0F, -1.05F, -1.05F, 2.0F, 2.0F, 2.0F, new Dilation(-0.55F)), ModelTransform.pivot(0.0F, -8.0F, -3.75F));

		ModelPartData cube_r3 = BowTie.addChild("cube_r3", ModelPartBuilder.create().uv(8, 56).mirrored().cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.53F)).mirrored(false), ModelTransform.of(-0.75F, -0.2973F, 0.0F, 0.0F, 0.0F, 0.384F));

		ModelPartData cube_r4 = BowTie.addChild("cube_r4", ModelPartBuilder.create().uv(48, 54).mirrored().cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.55F)).mirrored(false), ModelTransform.of(-0.75F, 0.2F, 0.0F, 0.0F, 0.0F, -0.384F));

		ModelPartData cube_r5 = BowTie.addChild("cube_r5", ModelPartBuilder.create().uv(8, 56).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.53F)), ModelTransform.of(0.75F, -0.2973F, 0.0F, 0.0F, 0.0F, -0.384F));

		ModelPartData cube_r6 = BowTie.addChild("cube_r6", ModelPartBuilder.create().uv(48, 54).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.55F)), ModelTransform.of(0.75F, 0.2F, 0.0F, 0.0F, 0.0F, 0.384F));

		ModelPartData LeftUpperArm = Body.addChild("LeftUpperArm", ModelPartBuilder.create().uv(28, 7).cuboid(-1.0F, -2.5F, -2.0F, 5.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(56, 45).cuboid(-1.75F, -1.5F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(-0.02F))
		.uv(56, 45).cuboid(4.0F, -1.5F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(6.25F, -7.5F, 0.75F));

		ModelPartData LeftLowerArm = LeftUpperArm.addChild("LeftLowerArm", ModelPartBuilder.create().uv(20, 33).cuboid(0.0F, -2.0F, -2.0F, 5.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(56, 49).cuboid(5.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(4.75F, -0.5F, 0.0F));

		ModelPartData Hand = LeftLowerArm.addChild("Hand", ModelPartBuilder.create().uv(40, 42).cuboid(-0.5F, -2.0F, -1.5F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, 0.0F, 0.0F));

		ModelPartData EmptyHand = Hand.addChild("EmptyHand", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 0.0F, 0.0F));

		ModelPartData LowerFinger_L_0 = Hand.addChild("LowerFinger.L.0", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.45F)), ModelTransform.pivot(1.5F, 1.35F, 0.875F));

		ModelPartData UpperFinger_L_1 = LowerFinger_L_0.addChild("UpperFinger.L.1", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.4F)), ModelTransform.pivot(2.0F, 0.0F, 0.0F));

		ModelPartData LowerFinger_L_1 = Hand.addChild("LowerFinger.L.1", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.45F)), ModelTransform.pivot(1.5F, 0.1F, 0.875F));

		ModelPartData UpperFinger_L_2 = LowerFinger_L_1.addChild("UpperFinger.L.2", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.4F)), ModelTransform.pivot(2.0F, 0.0F, 0.0F));

		ModelPartData LowerFinger_L_2 = Hand.addChild("LowerFinger.L.2", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.45F)), ModelTransform.pivot(1.5F, -1.15F, 0.875F));

		ModelPartData UpperFinger_L_3 = LowerFinger_L_2.addChild("UpperFinger.L.3", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.4F)), ModelTransform.pivot(2.0F, 0.0F, 0.0F));

		ModelPartData LowerFinger_L_3 = Hand.addChild("LowerFinger.L.3", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.45F)), ModelTransform.pivot(0.25F, -2.4F, -0.875F));

		ModelPartData UpperFinger_L_4 = LowerFinger_L_3.addChild("UpperFinger.L.4", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.4F)), ModelTransform.pivot(1.0F, 0.0F, 0.0F));

		ModelPartData RightUpperArm = Body.addChild("RightUpperArm", ModelPartBuilder.create().uv(28, 7).mirrored().cuboid(-4.0F, -2.5F, -2.0F, 5.0F, 4.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
		.uv(56, 45).mirrored().cuboid(-5.0F, -1.5F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
		.uv(56, 45).mirrored().cuboid(0.75F, -1.5F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(-0.02F)).mirrored(false), ModelTransform.pivot(-6.25F, -7.5F, 0.75F));

		ModelPartData RightLowerArm2 = RightUpperArm.addChild("RightLowerArm2", ModelPartBuilder.create().uv(20, 33).mirrored().cuboid(-5.0F, -2.0F, -2.0F, 5.0F, 4.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
		.uv(56, 49).mirrored().cuboid(-6.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-4.75F, -0.5F, 0.0F));

		ModelPartData Hand3 = RightLowerArm2.addChild("Hand3", ModelPartBuilder.create().uv(40, 42).mirrored().cuboid(-1.5F, -2.0F, -1.5F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-6.0F, 0.0F, 0.0F));

		ModelPartData EmptyHand3 = Hand3.addChild("EmptyHand3", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 0.0F, 0.0F));

		ModelPartData LowerFinger_R_4 = Hand3.addChild("LowerFinger.R.4", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.45F)).mirrored(false), ModelTransform.pivot(-1.5F, 1.35F, 0.875F));

		ModelPartData UpperFinger_R_5 = LowerFinger_R_4.addChild("UpperFinger.R.5", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.4F)).mirrored(false), ModelTransform.pivot(-2.0F, 0.0F, 0.0F));

		ModelPartData LowerFinger_R_5 = Hand3.addChild("LowerFinger.R.5", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.45F)).mirrored(false), ModelTransform.pivot(-1.5F, 0.1F, 0.875F));

		ModelPartData UpperFinger_R_6 = LowerFinger_R_5.addChild("UpperFinger.R.6", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.4F)).mirrored(false), ModelTransform.pivot(-2.0F, 0.0F, 0.0F));

		ModelPartData LowerFinger_R_6 = Hand3.addChild("LowerFinger.R.6", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.45F)).mirrored(false), ModelTransform.pivot(-1.5F, -1.15F, 0.875F));

		ModelPartData UpperFinger_R_7 = LowerFinger_R_6.addChild("UpperFinger.R.7", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.4F)).mirrored(false), ModelTransform.pivot(-2.0F, 0.0F, 0.0F));

		ModelPartData LowerFinger_R_7 = Hand3.addChild("LowerFinger.R.7", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.5F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.45F)).mirrored(false), ModelTransform.pivot(-0.25F, -2.4F, -0.875F));

		ModelPartData UpperFinger_R_8 = LowerFinger_R_7.addChild("UpperFinger.R.8", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.4F)).mirrored(false), ModelTransform.pivot(-1.0F, 0.0F, 0.0F));

		ModelPartData LeftThigh = Waist.addChild("LeftThigh", ModelPartBuilder.create().uv(8, 45).cuboid(-1.0F, -1.25F, -1.0F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 15).cuboid(-2.5F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, new Dilation(-0.25F)), ModelTransform.pivot(2.5F, 0.0F, 0.5F));

		ModelPartData LeftLeg = LeftThigh.addChild("LeftLeg", ModelPartBuilder.create().uv(56, 41).cuboid(-1.0F, 5.75F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 35).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.75F, 0.0F));

		ModelPartData LeftFoot = LeftLeg.addChild("LeftFoot", ModelPartBuilder.create().uv(0, 27).cuboid(-2.0F, 0.0F, -5.0F, 4.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.0F, 1.0F));

		ModelPartData RightThigh = Waist.addChild("RightThigh", ModelPartBuilder.create().uv(8, 45).mirrored().cuboid(-1.0F, -1.25F, -1.0F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
		.uv(0, 15).mirrored().cuboid(-2.5F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, new Dilation(-0.25F)).mirrored(false), ModelTransform.pivot(-2.5F, 0.0F, 0.5F));

		ModelPartData RightLeg = RightThigh.addChild("RightLeg", ModelPartBuilder.create().uv(56, 41).mirrored().cuboid(-1.0F, 5.75F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
		.uv(0, 35).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 7.75F, 0.0F));

		ModelPartData RightFoot = RightLeg.addChild("RightFoot", ModelPartBuilder.create().uv(0, 27).mirrored().cuboid(-2.0F, 0.0F, -5.0F, 4.0F, 2.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 7.0F, 1.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}

	public static TexturedModelData getEyesTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData Root = modelPartData.addChild("Root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Waist = Root.addChild("Waist", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -16.75F, 0.0F));

		ModelPartData Body = Waist.addChild("Body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData Head = Body.addChild("Head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -10.5F, 1.0F));

		ModelPartData Left_Eye = Head.addChild("Left.Eye", ModelPartBuilder.create().uv(67, 17).cuboid(-1.0F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.34F))
				.uv(46, 12).cuboid(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(-0.4F)), ModelTransform.pivot(1.25F, -4.35F, -1.75F));

		ModelPartData Right_Eye = Head.addChild("Right.Eye", ModelPartBuilder.create().uv(67, 17).mirrored().cuboid(-1.0F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.34F)).mirrored(false)
				.uv(46, 12).cuboid(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(-0.4F)), ModelTransform.pivot(-1.25F, -4.35F, -1.75F));

		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(FreddyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.updateAnimation(entity.mainPoseAnimationState, FreddyAnimations.MAINPOSE, ageInTicks, 1f);
		this.updateAnimation(entity.stuffedAnimationState, FreddyAnimations.STUFFED, ageInTicks, 1f);
		this.updateAnimation(entity.blackEyesAnimationState, FreddyAnimations.BLACKEYES, ageInTicks, 1f);
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