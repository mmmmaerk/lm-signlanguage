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
        Hand secondHand = hands.get(1);
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
        boolean isI;
        boolean isJ;
        boolean isV;
        boolean isO;
        boolean isR;
        boolean isS;
        boolean isT;
        boolean isN;
        boolean finished;

        float thumbToPointer = thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint());
        float thumbToMiddle = thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint());
        float thumbToRing = thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint());
        float thumbToPinkie = thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint());
        float pointerToMiddle = thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint());
        float pointerToRing = thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint());
        float pointerToPinkie = thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint());
        float middleToRing = thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint());
        float middleToPinkie = thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint());
        float ringToPinkie = thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint());

        File word = new File("word.txt");
        File finalWord = new File("finalWord.txt");

        char[] chars;
        char currentLetter;
        char prevLetter;
        ArrayList<Integer> markers = new ArrayList<Integer>();

        /**
         *  This for loop was mostly taken from the Leap Motion website.
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

        if (thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint()) > 55 && thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint())< 75 &&
                thumbFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) > 70 && thumbFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) < 95 &&
                thumbFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint())> 70 && thumbFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint()) < 95 &&
                thumbFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint())>  50 && thumbFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) < 75 &&
                pointerFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint())> 5 && pointerFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) < 25) {

            isB = true;
            System.out.println("B");

            try {
                FileWriter writer = new FileWriter(word, true);
                writer.write("B");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        /*if (thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint()) > 25 && thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint())< 50 &&
                thumbFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) > 35 && thumbFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) < 55 &&
                thumbFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint())> 45 && thumbFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint()) < 65 &&
                thumbFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint())>  60 && thumbFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) < 80 &&
                pointerFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint())> 0 && pointerFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) < 25 &&
                pointerFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint())> 20 && pointerFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint()) < 40 &&
                pointerFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) > 35 && pointerFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) < 55 &&
                middleFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint()) > 5 &&  middleFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint()) < 30 &&
                middleFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) > 20 && middleFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) < 40 &&
                ringFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) > 20 && ringFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) < 100) {

            isI = true;
            System.out.println("I");

            try {
                FileWriter writer = new FileWriter(word, true);
                writer.write("I");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }*/



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

            isR = true;
            System.out.println("R");

            try {
                FileWriter writer = new FileWriter(word, true);
                writer.write("R");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }




        /*if (thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint()) > 25 && thumbFingerBone.nextJoint().distanceTo(pointerFingerBone.nextJoint())< 45 &&
                thumbFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) > 35 && thumbFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) < 55 &&
                thumbFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint())> 45 && thumbFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint()) < 65 &&
                thumbFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint())> 50 && thumbFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) < 70 &&
                pointerFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint())> 5 && pointerFingerBone.nextJoint().distanceTo(middleFingerBone.nextJoint()) < 25 &&
                pointerFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint())> 20 && pointerFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint()) < 40 &&
                pointerFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) > 35 && pointerFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) < 55 &&
                middleFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint()) > 5 &&  middleFingerBone.nextJoint().distanceTo(ringFingerBone.nextJoint()) < 25 &&
                middleFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) > 20 && middleFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) < 40 &&
                ringFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) > 5 && ringFingerBone.nextJoint().distanceTo(pinkieFingerBone.nextJoint()) < 15) {

            isN = true;
            System.out.println("N");

            try {
                FileWriter writer = new FileWriter(word, true);
                writer.write("N");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }*/



        if (firstHand.isValid() && secondHand.isValid()) {
            finished = true;
            System.out.println("Finished");
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
                    //appends the characters found at the markers to finalWord.txt
                    BufferedWriter writer = new BufferedWriter(new FileWriter("finalWord.txt", true));
                    for (int i = 0; i <markers.size(); i++) {
                        System.out.print(chars[markers.get(i)]);
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
            }

        }

    }
}

public class Sample {
    public static void main(String[] args) {
        Controller leapController = new Controller();
        SampleListener leapListener = new SampleListener();
        leapController.setPolicy(Controller.PolicyFlag.POLICY_ALLOW_PAUSE_RESUME);
        leapController.setPaused(false);
        leapController.addListener(leapListener);

        File word = new File("word.txt");

        //makes word.txt blank
        try {
            FileWriter writer = new FileWriter(word, false);
            writer.write("");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //run until enter is pressed
        System.out.println("Press Enter to quit");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}