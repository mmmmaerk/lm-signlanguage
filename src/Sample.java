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

        /**
         *  this is taken straight from the leap motion example.
         *  i believe that it's going through the list of fingers
         *  found on the hand and creating bones of the type finger.
         */
        for (Finger finger : firstHand.fingers()) {
            for(Bone.Type boneType : Bone.Type.values()) {
                Bone bone = finger.bone(boneType);
                //this prints the coordinates of the tip of that finger.
                System.out.println(bone.nextJoint());
            }
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
