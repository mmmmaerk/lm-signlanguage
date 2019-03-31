import com.leapmotion.leap.*;
import java.io.IOException;

class SampleListener extends Listener {
    public void onConnect(Controller leapController) {
        System.out.println("Connected");
    }

    public void onFrame(Controller leapController) {
        Frame frame = leapController.frame();

        HandList hands = frame.hands();
        Hand firstHand = hands.get(0);

        FingerList fingers = frame.fingers();
        Finger firstFinger = fingers.get(1);

        for (Finger finger : firstHand.fingers()) {
            for(Bone.Type boneType : Bone.Type.values()) {
                Bone bone = finger.bone(boneType);

                System.out.println(bone.nextJoint());
            }
        }

    }
}

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
