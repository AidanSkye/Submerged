package me.aidanskye.submerged.client.render.model.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class FreddyAnimations {
	public static final Animation MAINPOSE = Animation.Builder.create(0.0F)
		.addBoneAnimation("Waist", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -2.5F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("Waist", new Transformation(Transformation.Targets.SCALE, 
			new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("Body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-1.2505F, 0.0654F, 3.0021F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("Head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(7.5641F, -7.4355F, -0.9844F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("Head", new Transformation(Transformation.Targets.SCALE,
			new Keyframe(0.0F, AnimationHelper.createScalingVector(1.2F, 1.2F, 1.2F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("Jaw", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("Hat", new Transformation(Transformation.Targets.SCALE, 
			new Keyframe(0.0F, AnimationHelper.createScalingVector(1.1F, 1.1F, 1.1F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("BowTie", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -0.25F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("BowTie", new Transformation(Transformation.Targets.SCALE, 
			new Keyframe(0.0F, AnimationHelper.createScalingVector(1.4F, 1.4F, 0.7F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("LeftUpperArm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-2.3266F, 26.4883F, -28.1913F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("LeftLowerArm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(27.2564F, -12.4717F, -49.1958F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("Hand", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-7.5641F, -7.4355F, 0.9844F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("LeftThigh", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -20.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("LeftFoot", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.9977F, -0.1177F, 2.2471F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("RightThigh", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("RightLeg", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-0.6696F, 14.9854F, -2.5881F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("UpperFinger.L.4", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 32.5F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("LowerFinger.L.3", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, -35.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("LowerFinger.L.0", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-5.0F, 5.0F, 10.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("UpperFinger.L.1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 17.5F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("UpperFinger.L.2", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 22.5F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("LowerFinger.L.2", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(4.9953F, 0.2178F, -12.4905F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("UpperFinger.L.3", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 17.5F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("RightUpperArm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -35.0F, -70.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("RightLowerArm2", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(102.7598F, -59.9449F, -45.8913F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("Hand3", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(12.7514F, -51.3798F, -16.1536F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("UpperFinger.R.5", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -75.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("UpperFinger.R.6", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -57.5F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("LowerFinger.R.6", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("UpperFinger.R.7", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -77.5F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("LowerFinger.R.7", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -22.5F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("UpperFinger.R.8", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.build();

	//I only realized after I made this animation that this model is Toy Freddy from Fnaf 2 and this pose is of stuffed Freddy from Fnaf 1... but like it looks cool
	public static final Animation STUFFED = Animation.Builder.create(0.0F)
			.addBoneAnimation("Waist", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -14.5F, -4.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("Body", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-4.9953F, -0.2178F, -2.4905F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("Head", new Transformation(Transformation.Targets.SCALE,
					new Keyframe(0.0F, AnimationHelper.createScalingVector(1.2F, 1.2F, 1.2F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("Jaw", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(9.9929F, 0.3262F, -2.4786F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("Jaw", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("Mask", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -7.5F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("Hat", new Transformation(Transformation.Targets.SCALE,
					new Keyframe(0.0F, AnimationHelper.createScalingVector(1.1F, 1.1F, 1.1F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("BowTie", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -0.25F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("BowTie", new Transformation(Transformation.Targets.SCALE,
					new Keyframe(0.0F, AnimationHelper.createScalingVector(1.2F, 1.2F, 0.7F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("LeftUpperArm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 17.5F, 62.5F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("LeftLowerArm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(3.5999F, 5.7718F, 26.8435F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("Hand", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(152.5223F, 1.1541F, 2.2178F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("LeftThigh", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-90.3947F, -7.4898F, 3.0258F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("LeftLeg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(90.2188F, 4.9952F, 0.0095F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("LeftFoot", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(15.0571F, -7.457F, -0.6573F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("Left.Eye", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 1.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("RightThigh", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-90.1744F, 2.4939F, -4.0041F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("RightLeg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("RightFoot", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(15.2811F, 11.7777F, 5.0953F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("Right.Eye", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 1.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("UpperFinger.L.1", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 47.5F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("UpperFinger.L.2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 42.5F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("UpperFinger.L.3", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 25.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("RightUpperArm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.8831F, -9.9895F, -80.1342F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("RightUpperArm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("RightLowerArm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.2937F, -22.352F, -5.4537F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("Hand3", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-2.72F, -19.8217F, 7.9753F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("UpperFinger.R.5", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -35.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("UpperFinger.R.6", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -35.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("UpperFinger.R.7", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -35.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("UpperFinger.R.8", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.LINEAR)
			))
			.build();

	public static final Animation BLACKEYES = Animation.Builder.create(0.0F)
			.addBoneAnimation("Left.Eye", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -180.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("Right.Eye", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -180.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.build();
}