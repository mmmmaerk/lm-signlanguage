import com.leapmotion.leap.*;
import java.io.*;
import java.util.ArrayList;

class LeapMotionListener extends Listener {

    public void onConnect(Controller leapController) {
        System.out.println("Connected");
    }

    public void onFrame(Controller leapController) {
        //creates a Frame object which represents hand/finger tracking data from a single frame.
        Frame frame = leapController.frame();

        //creates a list of hands using the hands seen in the current frame
        HandList hands = frame.hands();

        //creates hand objects out of the hands seen in the current frame
        Hand firstHand = hands.get(0);
        Hand secondHand = hands.get(1);

        //creates a list of fingers from the fingers seen on the hand
        FingerList fingers = frame.fingers();

        //create finger bone objects
        //bones are set to invalid because they aren't actually used yet
        Bone thumbFingerBone = Bone.invalid();
        Bone pointerFingerBone = Bone.invalid();
        Bone middleFingerBone = Bone.invalid();
        Bone ringFingerBone = Bone.invalid();
        Bone pinkieFingerBone = Bone.invalid();

        //finger objects are given the fingers they should represent
        //0 is always the thumb, 1 is always the pointer, and so on
        Finger thumbFinger = fingers.get(0);
        Finger pointerFinger = fingers.get(1);
        Finger middleFinger = fingers.get(2);
        Finger ringFinger = fingers.get(3);
        Finger pinkieFinger = fingers.get(4);

        //creates a text file that will hold all the letters inputted
        File word = new File("word.txt");

        char[] chars; //holds all the letters the user enters
        char currentLetter; //used when stepping through the letters in chars
        char prevLetter; //used to check when the letters change

        //markers keeps track of the points in chars where the letters are changed
        //this way the program knows what parts of chars to print out
        ArrayList<Integer> markers = new ArrayList<Integer>();

        //these for loops create bones for each finger seen on the hand.
        //each finger has three bones, with the thumb having a zero length bone at the base.
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

        //detects A
        if (thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint()) > 25 && thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint())< 55 &&
                thumbFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) > 35 && thumbFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) < 65 &&
                thumbFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint())> 55 && thumbFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint()) < 80 &&
                thumbFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint())>  60 && thumbFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) < 85&&
                pointerFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint())> 10 && pointerFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) < 35 &&
                pointerFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint())> 20 && pointerFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint()) < 30 &&
                pointerFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) > 40 && pointerFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) < 55 &&
                middleFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint()) > 10 &&  middleFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint()) < 20 &&
                middleFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) > 23 && middleFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) < 37 &&
                ringFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) > 10 && ringFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) < 25) {

            System.out.println("A");

            //writes A to word.txt
            try {
                FileWriter writer = new FileWriter(word, true);
                writer.write("A");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        //detects B
        if (thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint()) > 55 && thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint())< 75 &&
                thumbFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) > 70 && thumbFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) < 95 &&
                thumbFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint())> 70 && thumbFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint()) < 95 &&
                thumbFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint())>  50 && thumbFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) < 75 &&
                pointerFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint())> 5 && pointerFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) < 25) {

            System.out.println("B");

            //writes B to a file
            try {
                FileWriter writer = new FileWriter(word, true);
                writer.write("B");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //detects R
        if (thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint()) > 50 && thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint())< 100 &&
                thumbFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) > 50 && thumbFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) < 100 &&
                thumbFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint())> 10 && thumbFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint()) < 55 &&
                thumbFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint())>  10 && thumbFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) < 55 &&
                pointerFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint())> 0 && pointerFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) < 45 &&
                pointerFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint())> 80 && pointerFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint()) < 125 &&
                pointerFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) > 80 && pointerFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) < 125 &&
                middleFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint()) > 80 &&  middleFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint()) < 125 &&
                middleFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) > 80 && middleFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) < 125 &&
                ringFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) > 0 && ringFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) < 40) {

            System.out.println("R");

            //writes R to a file
            try {
                FileWriter writer = new FileWriter(word, true);
                writer.write("R");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        //detects when a second hand is on screen and pauses the leap motion
        if (firstHand.isValid() && secondHand.isValid()) {
            System.out.println("Finished");
            //pauses the leap motion
            leapController.setPaused(true);
            if (leapController.isPaused()) {
                try {
                    FileReader reader = new FileReader(word);
                    chars = new char[(int) word.length()];
                    reader.read(chars);

                    //adds markers based on the letters in chars[]
                    markers.add(0);
                    for (int i = 1; i < chars.length; i++) {
                        currentLetter = chars[i];
                        prevLetter = chars[i -1];

                        if (currentLetter != prevLetter) {
                            markers.add(i);
                        }
                    }
                    //prints the final word to the console
                    for (int i = 0; i <markers.size(); i++) {
                        System.out.print(chars[markers.get(i)]);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}

public class LeapASL {
    public static void main(String[] args) {
        //creates controller and listener objects which are required for the leap motion to read input
        Controller leapController = new Controller();
        LeapMotionListener leapListener = new LeapMotionListener();
        //allows the leap motion to be paused
        leapController.setPolicy(Controller.PolicyFlag.POLICY_ALLOW_PAUSE_RESUME);
        //unpauses the leap motion at launch since it pauses itself every time the program is finished
        //sometimes doesn't work for some reason
        leapController.setPaused(false);

        leapController.addListener(leapListener);

        //makes word.txt blank for a fresh run
        File word = new File("word.txt");
        try {
            FileWriter writer = new FileWriter(word, false);
            writer.write("");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Press Enter to quit");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}