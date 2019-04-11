import com.leapmotion.leap.*;
import java.io.IOException;

class SampleListener extends Listener {
    public void onConnect(Controller leapController) {
        System.out.println("Connected");
    }

    public void onFrame(Controller leapController) {
        Frame frame = leapController.frame();

        //creates a list of hands seen in the current frame
        HandList hands = frame.hands();
        //creates a hand object using the first hand seen in the list of hands
        Hand firstHand = hands.get(0);
        FingerList fingers = frame.fingers();
        //create finger bone objects
        Bone thumbFingerBone = Bone.invalid();
        Bone pointerFingerBone = Bone.invalid();
        Bone middleFingerBone = Bone.invalid();
        Bone ringFingerBone = Bone.invalid();
        Bone pinkieFingerBone = Bone.invalid();

        Finger thumbFinger = fingers.get(0);
        Finger pointerFinger = fingers.get(1);
        Finger middleFinger = fingers.get(2);
        Finger ringFinger = fingers.get(3);
        Finger pinkieFinger = fingers.get(4);

        /**
         *  This for loop wsa mostly taken from the Leap Motion website.
         *  It ACTUALLY tracks the tip of your pointer finger.
         *  The last version got the tips of all your fingers, I think.
         *  This one is for sure correct.
         */
        for(Bone.Type boneType : Bone.Type.values()) {
            thumbFingerBone = thumbFinger.bone(boneType);
        }

        for(Bone.Type boneType : Bone.Type.values()) {
            pointerFingerBone = pointerFinger.bone(boneType);
        }

        for(Bone.Type boneType : Bone.Type.values()) {
            middleFingerBone = middleFinger.bone(boneType);
        }

        for(Bone.Type boneType : Bone.Type.values()) {
            ringFingerBone = ringFinger.bone(boneType);
        }

        for(Bone.Type boneType : Bone.Type.values()) {
            pinkieFingerBone = pinkieFinger.bone(boneType);
        }

        //System.out.println(middleFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint()));
        if (middleFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint()) > 100) {
            System.out.println("peace sign");
        }

    }
}

/**
 * This was taken entirely from their Hello World example
 */
public class Sample {
    public static void main(String[] args) {

        Controller leapController = new Controller();
        SampleListener leapListener = new SampleListener();

        leapController.addListener(leapListener);

        //run until enter is pressed
        System.out.println("Press Enter to quit");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
