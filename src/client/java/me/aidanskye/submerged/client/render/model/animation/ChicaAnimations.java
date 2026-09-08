package me.aidanskye.submerged.client.render.model.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class ChicaAnimations {
	public static final Animation MAINPOSE = Animation.Builder.create(0.0F)
		.addBoneAnimation("Waist", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -2.5F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("Body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-1.2515F, -0.0438F, -1.9967F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("Head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 2.5F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("Head", new Transformation(Transformation.Targets.SCALE, 
			new Keyframe(0.0F, AnimationHelper.createScalingVector(1.1F, 1.1F, 1.1F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("Jaw", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("LeftUpperArm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(53.1867F, 19.6226F, 55.278F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("LeftLowerArm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-11.5861F, 4.3856F, -67.5182F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("Hand", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-90.6436F, -8.9652F, -29.2945F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("LeftThigh", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -20.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("LeftFoot", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.9977F, -0.1177F, 2.2471F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("Left.Eye", new Transformation(Transformation.Targets.SCALE, 
			new Keyframe(0.0F, AnimationHelper.createScalingVector(1.3F, 1.3F, 1.3F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("LowerFinger.L.0", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -15.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("UpperFinger.L.0", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -60.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("LowerFinger.L.1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(1.7494F, -34.9618F, -3.051F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("UpperFinger.L.1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -10.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("LowerFinger.L.2", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -32.5F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("UpperFinger.L.2", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -10.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("LowerFinger.L.3", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-8.9998F, -31.749F, 11.2304F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("UpperFinger.L.3", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -15.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("RightThigh", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 2.5F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("RightUpperArm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -42.5F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("RightLowerArm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -97.5F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("RightLowerArm", new Transformation(Transformation.Targets.SCALE, 
			new Keyframe(0.0F, AnimationHelper.createScalingVector(1.002F, 1.002F, 1.002F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("Hand2", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(88.3131F, -4.4987F, 42.1153F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("Right.Eye", new Transformation(Transformation.Targets.SCALE, 
			new Keyframe(0.0F, AnimationHelper.createScalingVector(1.3F, 1.3F, 1.3F), Transformation.Interpolations.LINEAR)
		))
		.build();
}