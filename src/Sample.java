import com.leapmotion.leap.*;

import java.io.*;
import java.util.ArrayList;

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

        boolean isA;
        boolean isB;
        boolean isD;
        boolean isJ;
        boolean isV;

        File word = new File("word.txt");
        File finalWord = new File("finalWord.txt");


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

        //System.out.println(pinkieFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()));
        if (pinkieFingerBone.nextJoint().distanceTo((thumbFingerBone.nextJoint())) < 80 && pinkieFingerBone.nextJoint().distanceTo((thumbFingerBone.nextJoint())) > 50 && (middleFingerBone.nextJoint().distanceTo(thumbFingerBone.nextJoint())) > 30 && (middleFingerBone.nextJoint().distanceTo(thumbFingerBone.nextJoint())) < 45) {
            isA = true;
            System.out.println("A");

            try {
                FileWriter writer = new FileWriter(word, true);
                writer.write("A");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if ((pinkieFingerBone.nextJoint().distanceTo((thumbFingerBone.nextJoint())) < 95 && pinkieFingerBone.nextJoint().distanceTo((thumbFingerBone.nextJoint())) >  75) && (pointerFingerBone.nextJoint().distanceTo((middleFingerBone.nextJoint())) < 30 && pointerFingerBone.nextJoint().distanceTo((middleFingerBone.nextJoint())) >  20)) {
            System.out.println("B");
            isB = true;
            try {
                FileWriter writer = new FileWriter(word, true);
                writer.write("B");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (pointerFingerBone.nextJoint().distanceTo(thumbFingerBone.nextJoint()) < 105 && pointerFingerBone.nextJoint().distanceTo(thumbFingerBone.nextJoint()) > 90) {
            System.out.println("D");
            isD = true;
            /**
            try {
                FileWriter writer = new FileWriter(word, true);
                writer.write("D");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            } **/
        }

        if ((firstHand.rotationProbability(frame) == 1) && (pinkieFingerBone.nextJoint().distanceTo(thumbFingerBone.nextJoint()) > 60)) {
            System.out.println("J");
            isJ = true;
        }

        if (pointerFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) > 85 &&
                pointerFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) < 110 &&
                pinkieFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) > 35 &&
                pinkieFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) < 50) {

                isV = true;
                System.out.println("V");

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

        char[] chars;
        char currentLetter;
        char prevLetter;
        ArrayList<Integer> markers = new ArrayList<Integer>();
        File word = new File("word.txt");
        File finalWord = new File("finalWord.txt");

        leapController.addListener(leapListener);

        //run until enter is pressed
        System.out.println("Press Enter to quit");

        //makes word.txt blank
        try {
            FileWriter writer = new FileWriter(word, false);
            writer.write("");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //adds markers based on word.txt
        try {
            FileReader reader = new FileReader(word);
            chars = new char[(int) word.length()];
            reader.read(chars);

            markers.add(0);
            for (int i = 1; i < chars.length; i++) {
                currentLetter = chars[i];
                prevLetter = chars[i -1];

                if (currentLetter != prevLetter) {
                    markers.add(i);
                }
            }
            //appends the characters found at the markers to finalWord.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("finalWord.txt", true));
            System.out.print(chars);
            for (int i = 0; i <markers.size(); i++) {
                try {
                    writer.write(markers.get(i));
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
