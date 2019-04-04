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
        Finger pointerFinger = fingers.get(1);
        /**
         *  This for loop wsa mostly taken from the Leap Motion website.
         *  It ACTUALLY tracks the tip of your pointer finger.
         *  The last version got the tips of all your fingers, I think.
         *  This one is for sure correct.
         */
        for(Bone.Type boneType : Bone.Type.values()) {
            Bone bone = pointerFinger.bone(boneType);
            System.out.println(bone.nextJoint());
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
