package me.aidanskye.submerged.client.render.model;

import me.aidanskye.submerged.client.render.model.animation.ChicaAnimations;
import me.aidanskye.submerged.entity.ChicaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ChicaEntityModel extends SinglePartEntityModel<ChicaEntity> {
	private final ModelPart Root;

	public ChicaEntityModel(ModelPart root) {
		this.Root = root.getChild("Root");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Root = modelPartData.addChild("Root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Waist = Root.addChild("Waist", ModelPartBuilder.create().uv(0, 13).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 2.0F, 6.0F, new Dilation(0.02F)), ModelTransform.pivot(0.0F, -16.75F, 0.0F));

		ModelPartData cube_r1 = Waist.addChild("cube_r1", ModelPartBuilder.create().uv(22, 0).mirrored().cuboid(0.0F, -2.0F, -2.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.9696F, -0.3473F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData cube_r2 = Waist.addChild("cube_r2", ModelPartBuilder.create().uv(22, 0).cuboid(-2.0F, -2.0F, -2.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(3.9696F, -0.3473F, 0.0F, 0.0F, 0.0F, -0.1745F));

		ModelPartData Body = Waist.addChild("Body", ModelPartBuilder.create().uv(28, 38).cuboid(-1.0F, -11.0F, 0.0F, 2.0F, 11.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-3.0F, -9.0F, -1.5F, 6.0F, 8.0F, 5.0F, new Dilation(0.35F))
		.uv(40, 5).cuboid(-3.25F, -8.75F, -2.0F, 1.0F, 4.0F, 5.0F, new Dilation(0.35F))
		.uv(0, 43).cuboid(2.25F, -8.75F, -2.0F, 1.0F, 4.0F, 5.0F, new Dilation(0.35F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData Head = Body.addChild("Head", ModelPartBuilder.create().uv(50, 31).cuboid(-2.0F, -1.0F, 0.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(8, 59).cuboid(1.2F, -1.7F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(12, 59).cuboid(1.2F, -1.7F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(24, 49).cuboid(0.1F, -1.7F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(16, 59).cuboid(1.2F, -3.275F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(20, 59).cuboid(1.2F, -3.275F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(4, 59).cuboid(0.1F, -3.275F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(4, 59).mirrored().cuboid(-1.1F, -3.275F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(20, 59).mirrored().cuboid(-2.2F, -3.275F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(16, 59).mirrored().cuboid(-2.2F, -3.275F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(12, 59).mirrored().cuboid(-2.2F, -1.7F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(8, 59).mirrored().cuboid(-2.2F, -1.7F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(24, 49).mirrored().cuboid(-1.1F, -1.7F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(50, 34).cuboid(-2.0F, -1.0F, -1.5F, 4.0F, 1.0F, 2.0F, new Dilation(-0.02F))
		.uv(36, 43).cuboid(-2.0F, -6.0F, 0.0F, 4.0F, 5.0F, 2.0F, new Dilation(0.0F))
		.uv(38, 0).cuboid(-3.0F, -6.0F, -1.5F, 6.0F, 3.0F, 2.0F, new Dilation(-0.02F))
		.uv(12, 32).cuboid(-0.5F, -6.0F, -2.0F, 1.0F, 3.0F, 1.0F, new Dilation(-0.04F)), ModelTransform.pivot(0.0F, -11.0F, 1.0F));

		ModelPartData Left_Eye = Head.addChild("Left.Eye", ModelPartBuilder.create().uv(52, 41).cuboid(-1.0F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.34F))
		.uv(58, 45).cuboid(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(-0.4F)), ModelTransform.pivot(1.25F, -4.35F, -1.75F));

		ModelPartData Right_Eye = Head.addChild("Right.Eye", ModelPartBuilder.create().uv(52, 41).cuboid(-1.0F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.34F))
		.uv(58, 45).cuboid(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(-0.4F)), ModelTransform.pivot(-1.25F, -4.35F, -1.75F));

		ModelPartData Mask = Head.addChild("Mask", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Jaw = Mask.addChild("Jaw", ModelPartBuilder.create().uv(16, 31).cuboid(-2.0F, -0.5F, -2.5F, 4.0F, 1.0F, 5.0F, new Dilation(0.0F))
		.uv(12, 49).cuboid(2.0F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F))
		.uv(24, 59).cuboid(1.0F, -1.25F, -2.75F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(28, 59).cuboid(0.0F, -1.25F, -2.75F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(28, 59).mirrored().cuboid(-1.0F, -1.25F, -2.75F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(24, 59).mirrored().cuboid(-2.0F, -1.25F, -2.75F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(12, 49).mirrored().cuboid(-3.0F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData LowerBeak = Jaw.addChild("LowerBeak", ModelPartBuilder.create().uv(54, 29).cuboid(-1.0F, -0.225F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.02F))
		.uv(58, 55).cuboid(-0.5F, -0.225F, -2.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.25F, -2.35F));

		ModelPartData cube_r3 = LowerBeak.addChild("cube_r3", ModelPartBuilder.create().uv(42, 55).mirrored().cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, new Dilation(-0.02F)).mirrored(false), ModelTransform.of(-0.212F, 0.75F, -0.6154F, 0.0F, -0.5803F, 0.0F));

		ModelPartData cube_r4 = LowerBeak.addChild("cube_r4", ModelPartBuilder.create().uv(42, 55).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, new Dilation(-0.02F)), ModelTransform.of(0.212F, 0.75F, -0.6154F, 0.0F, 0.5803F, 0.0F));

		ModelPartData Face = Mask.addChild("Face", ModelPartBuilder.create().uv(40, 59).cuboid(1.0F, -0.5F, -2.75F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(44, 59).cuboid(0.0F, -0.5F, -2.75F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
		.uv(48, 43).cuboid(-2.0F, -5.05F, 1.75F, 4.0F, 7.0F, 1.0F, new Dilation(0.0F))
		.uv(36, 38).cuboid(-2.0F, -5.05F, -2.25F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(22, 8).cuboid(-2.5F, -4.55F, -2.25F, 5.0F, 1.0F, 4.0F, new Dilation(-0.02F))
		.uv(0, 32).cuboid(2.0F, -5.0F, -2.25F, 1.0F, 6.0F, 5.0F, new Dilation(0.0F))
		.uv(54, 25).cuboid(1.75F, -1.75F, -3.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.3F))
		.uv(34, 21).cuboid(2.5F, -4.75F, -2.25F, 1.0F, 6.0F, 5.0F, new Dilation(-0.02F))
		.uv(44, 59).mirrored().cuboid(-1.0F, -0.5F, -2.75F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(40, 59).mirrored().cuboid(-2.0F, -0.5F, -2.75F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(34, 21).mirrored().cuboid(-3.5F, -4.75F, -2.25F, 1.0F, 6.0F, 5.0F, new Dilation(-0.02F)).mirrored(false)
		.uv(0, 32).mirrored().cuboid(-3.0F, -5.0F, -2.25F, 1.0F, 6.0F, 5.0F, new Dilation(0.0F)).mirrored(false)
		.uv(54, 25).cuboid(-3.75F, -1.75F, -3.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.3F))
		.uv(54, 13).cuboid(-2.0F, -1.25F, -2.5F, 4.0F, 1.0F, 1.0F, new Dilation(0.1F))
		.uv(49, 62).cuboid(-2.5F, -1.95F, -2.25F, 5.0F, 1.0F, 1.0F, new Dilation(-0.02F))
		.uv(0, 59).cuboid(-0.5F, -4.25F, -2.25F, 1.0F, 3.0F, 1.0F, new Dilation(-0.01F)), ModelTransform.pivot(0.0F, -1.5F, 0.0F));

		ModelPartData cube_r5 = Face.addChild("cube_r5", ModelPartBuilder.create().uv(54, 22).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 1.0F, 2.0F, new Dilation(-0.4F)), ModelTransform.of(-1.0864F, -5.8403F, -0.0847F, 2.672F, -0.3811F, -2.4997F));

		ModelPartData cube_r6 = Face.addChild("cube_r6", ModelPartBuilder.create().uv(54, 19).cuboid(-1.5F, -0.5F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(-0.3F)), ModelTransform.of(0.4424F, -5.1812F, -1.2226F, -0.3156F, 0.8615F, -0.4908F));

		ModelPartData cube_r7 = Face.addChild("cube_r7", ModelPartBuilder.create().uv(0, 56).cuboid(-0.2781F, -0.8064F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(-0.41F)), ModelTransform.of(1.7793F, -5.7593F, 0.2059F, -0.0154F, -0.1739F, 0.0886F));

		ModelPartData cube_r8 = Face.addChild("cube_r8", ModelPartBuilder.create().uv(54, 16).cuboid(-2.2671F, -0.663F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(-0.4F)), ModelTransform.of(1.7793F, -5.7593F, 0.2059F, 0.0879F, -0.151F, -0.5303F));

		ModelPartData UpperBeak = Face.addChild("UpperBeak", ModelPartBuilder.create().uv(58, 58).cuboid(-1.0F, -0.4352F, -0.3322F, 2.0F, 1.0F, 1.0F, new Dilation(0.02F))
		.uv(58, 48).cuboid(-0.5F, -0.4352F, -1.3322F, 1.0F, 1.0F, 2.0F, new Dilation(0.001F)), ModelTransform.of(0.0F, -0.6648F, -3.1678F, 0.1745F, 0.0F, 0.0F));

		ModelPartData cube_r9 = UpperBeak.addChild("cube_r9", ModelPartBuilder.create().uv(26, 55).mirrored().cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.212F, 0.5648F, 0.0523F, 0.0F, -0.5803F, 0.0F));

		ModelPartData cube_r10 = UpperBeak.addChild("cube_r10", ModelPartBuilder.create().uv(26, 55).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.212F, 0.5648F, 0.0523F, 0.0F, 0.5803F, 0.0F));

		ModelPartData cube_r11 = UpperBeak.addChild("cube_r11", ModelPartBuilder.create().uv(51, 56).cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.02F)), ModelTransform.of(0.5F, 0.0853F, 1.4361F, -0.1309F, 0.0F, 0.0F));

		ModelPartData cube_r12 = UpperBeak.addChild("cube_r12", ModelPartBuilder.create().uv(51, 56).cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.2178F, -0.0778F, 0.3054F, 0.0F, 0.0F));

		ModelPartData Bib = Body.addChild("Bib", ModelPartBuilder.create().uv(12, 43).cuboid(-3.0F, -1.25F, 1.0F, 6.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -8.0F, -3.75F));

		ModelPartData cube_r13 = Bib.addChild("cube_r13", ModelPartBuilder.create().uv(40, 14).cuboid(-3.0F, -3.0F, -1.0F, 6.0F, 5.0F, 1.0F, new Dilation(0.015F)), ModelTransform.of(0.0F, -0.5F, 3.25F, -1.5708F, 0.0F, 0.0F));

		ModelPartData LeftUpperArm = Body.addChild("LeftUpperArm", ModelPartBuilder.create().uv(34, 32).cuboid(2.0F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(58, 41).cuboid(1.25F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(-0.02F))
		.uv(18, 55).cuboid(-0.75F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.22F))
		.uv(56, 51).cuboid(7.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(4.25F, -9.0F, 0.75F));

		ModelPartData LeftLowerArm = LeftUpperArm.addChild("LeftLowerArm", ModelPartBuilder.create().uv(12, 37).cuboid(0.0F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(34, 58).cuboid(5.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(7.75F, 0.0F, 0.0F));

		ModelPartData Hand = LeftLowerArm.addChild("Hand", ModelPartBuilder.create().uv(54, 0).cuboid(-0.5F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.1F)), ModelTransform.pivot(6.0F, 0.0F, 0.0F));

		ModelPartData EmptyHand = Hand.addChild("EmptyHand", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 0.0F, 0.0F));

		ModelPartData LowerFinger_L_0 = Hand.addChild("LowerFinger.L.0", ModelPartBuilder.create().uv(10, 55).cuboid(-0.75F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.6F)), ModelTransform.pivot(0.5F, -1.9F, -0.375F));

		ModelPartData UpperFinger_L_0 = LowerFinger_L_0.addChild("UpperFinger.L.0", ModelPartBuilder.create().uv(36, 50).cuboid(-0.75F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.55F)), ModelTransform.pivot(0.75F, 0.0F, 0.0F));

		ModelPartData LowerFinger_L_1 = Hand.addChild("LowerFinger.L.1", ModelPartBuilder.create().uv(24, 51).cuboid(-0.75F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.6F)), ModelTransform.pivot(1.5F, -1.0F, 0.875F));

		ModelPartData UpperFinger_L_1 = LowerFinger_L_1.addChild("UpperFinger.L.1", ModelPartBuilder.create().uv(46, 51).cuboid(-0.75F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.55F)), ModelTransform.pivot(1.75F, 0.0F, 0.0F));

		ModelPartData LowerFinger_L_2 = Hand.addChild("LowerFinger.L.2", ModelPartBuilder.create().uv(0, 52).cuboid(-0.75F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.6F)), ModelTransform.pivot(1.5F, 0.0F, 0.875F));

		ModelPartData UpperFinger_L_2 = LowerFinger_L_2.addChild("UpperFinger.L.2", ModelPartBuilder.create().uv(52, 5).cuboid(-0.75F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.55F)), ModelTransform.pivot(1.75F, 0.0F, 0.0F));

		ModelPartData LowerFinger_L_3 = Hand.addChild("LowerFinger.L.3", ModelPartBuilder.create().uv(52, 9).cuboid(-0.75F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.6F)), ModelTransform.pivot(1.5F, 1.0F, 0.875F));

		ModelPartData UpperFinger_L_3 = LowerFinger_L_3.addChild("UpperFinger.L.3", ModelPartBuilder.create().uv(52, 37).cuboid(-0.75F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.55F)), ModelTransform.pivot(1.75F, 0.0F, 0.0F));

		ModelPartData RightUpperArm = Body.addChild("RightUpperArm", ModelPartBuilder.create().uv(34, 32).mirrored().cuboid(-7.0F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
		.uv(58, 41).mirrored().cuboid(-2.25F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(-0.02F)).mirrored(false)
		.uv(18, 55).mirrored().cuboid(-1.25F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.22F)).mirrored(false)
		.uv(56, 51).mirrored().cuboid(-8.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-4.25F, -9.0F, 0.75F));

		ModelPartData RightLowerArm = RightUpperArm.addChild("RightLowerArm", ModelPartBuilder.create().uv(12, 37).mirrored().cuboid(-5.0F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
		.uv(34, 58).mirrored().cuboid(-6.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-7.75F, 0.0F, 0.0F));

		ModelPartData Hand2 = RightLowerArm.addChild("Hand2", ModelPartBuilder.create().uv(54, 0).mirrored().cuboid(-1.5F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.1F)).mirrored(false), ModelTransform.pivot(-6.0F, 0.0F, 0.0F));

		ModelPartData EmptyHand2 = Hand2.addChild("EmptyHand2", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 0.0F, 0.0F));

		ModelPartData LowerFinger_R_0 = Hand2.addChild("LowerFinger.R.0", ModelPartBuilder.create().uv(10, 55).mirrored().cuboid(-1.25F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.6F)).mirrored(false), ModelTransform.pivot(-0.5F, -1.9F, -0.375F));

		ModelPartData UpperFinger_R_0 = LowerFinger_R_0.addChild("UpperFinger.R.0", ModelPartBuilder.create().uv(36, 50).mirrored().cuboid(-2.25F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.55F)).mirrored(false), ModelTransform.pivot(-0.75F, 0.0F, 0.0F));

		ModelPartData LowerFinger_R_1 = Hand2.addChild("LowerFinger.R.1", ModelPartBuilder.create().uv(24, 51).mirrored().cuboid(-2.25F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.6F)).mirrored(false), ModelTransform.pivot(-1.5F, -1.0F, 0.875F));

		ModelPartData UpperFinger_R_1 = LowerFinger_R_1.addChild("UpperFinger.R.1", ModelPartBuilder.create().uv(46, 51).mirrored().cuboid(-2.25F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.55F)).mirrored(false), ModelTransform.pivot(-1.75F, 0.0F, 0.0F));

		ModelPartData LowerFinger_R_2 = Hand2.addChild("LowerFinger.R.2", ModelPartBuilder.create().uv(0, 52).mirrored().cuboid(-2.25F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.6F)).mirrored(false), ModelTransform.pivot(-1.5F, 0.0F, 0.875F));

		ModelPartData UpperFinger_R_2 = LowerFinger_R_2.addChild("UpperFinger.R.2", ModelPartBuilder.create().uv(52, 5).mirrored().cuboid(-2.25F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.55F)).mirrored(false), ModelTransform.pivot(-1.75F, 0.0F, 0.0F));

		ModelPartData LowerFinger_R_3 = Hand2.addChild("LowerFinger.R.3", ModelPartBuilder.create().uv(52, 9).mirrored().cuboid(-2.25F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.6F)).mirrored(false), ModelTransform.pivot(-1.5F, 1.0F, 0.875F));

		ModelPartData UpperFinger_R_3 = LowerFinger_R_3.addChild("UpperFinger.R.3", ModelPartBuilder.create().uv(52, 37).mirrored().cuboid(-2.25F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.55F)).mirrored(false), ModelTransform.pivot(-1.75F, 0.0F, 0.0F));

		ModelPartData LeftThigh = Waist.addChild("LeftThigh", ModelPartBuilder.create().uv(46, 20).cuboid(-1.0F, -1.25F, -1.0F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 21).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.5F, 0.0F, 0.95F));

		ModelPartData LeftLeg = LeftThigh.addChild("LeftLeg", ModelPartBuilder.create().uv(34, 54).cuboid(-1.0F, 5.75F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(16, 21).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.75F, 0.0F));

		ModelPartData LeftFoot = LeftLeg.addChild("LeftFoot", ModelPartBuilder.create().uv(20, 13).cuboid(-2.0F, 0.0F, -5.0F, 4.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.0F, 1.0F));

		ModelPartData RightThigh = Waist.addChild("RightThigh", ModelPartBuilder.create().uv(46, 20).mirrored().cuboid(-1.0F, -1.25F, -1.0F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
		.uv(0, 21).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-2.5F, 0.0F, 0.95F));

		ModelPartData RightLeg = RightThigh.addChild("RightLeg", ModelPartBuilder.create().uv(34, 54).mirrored().cuboid(-1.0F, 5.75F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
		.uv(16, 21).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 7.75F, 0.0F));

		ModelPartData RightFoot = RightLeg.addChild("RightFoot", ModelPartBuilder.create().uv(20, 13).mirrored().cuboid(-2.0F, 0.0F, -5.0F, 4.0F, 2.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 7.0F, 1.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(ChicaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.updateAnimation(entity.mainPoseAnimationState, ChicaAnimations.MAINPOSE, ageInTicks, 1f);
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