package com.example.chaingrabs2;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

class input {
    public int[] inputs;
    private boolean cleared;
    public input() {
        inputs = new int[4];
        cleared = false;
    }
    public input(int[] cInput) {
        inputs = new int[4];
        cleared = false;
        this.inputs[0] = cInput[0];
        this.inputs[1] = cInput[1];
        this.inputs[2] = cInput[2];
        this.inputs[3] = cInput[3];
    }
    public input(int a, int b, int c, int d) {
        inputs = new int[]{a,b,c,d};
        cleared = false;
    }
    //copy constructor
    public input(input cInput) {
        inputs = new int[4];
        this.inputs[0] = cInput.inputs[0];
        this.inputs[1] = cInput.inputs[1];
        this.inputs[2] = cInput.inputs[2];
        this.inputs[3] = cInput.inputs[3];
    }
    public boolean notEmpty() {
        if (this.inputs[0] != 0 ||
                this.inputs[1] != 0 ||
                this.inputs[2] != 0 ||
                this.inputs[3] != 0) {
            return true;
        }
        return true;
    }
    public boolean notEquals(input cInput) {
        if (this.inputs[0] == cInput.inputs[0] &&
        this.inputs[1] == cInput.inputs[1] &&
        this.inputs[2] == cInput.inputs[2] &&
        this.inputs[3] == cInput.inputs[3]) {
            return false;
        }
        return true;
    }
    public void adjust(int a, int b, int c, int d) {
        inputs[0] = a;
        inputs[1] = b;
        inputs[2] = c;
        inputs[3] = d;
    }
    //    public void clear() {
//        cleared = true;
//    }
    public boolean match(input userInput) {
        for (int i = 0; i < 4; i++) {
            if (this.inputs[i] == 1 && userInput.inputs[i] == 0) {
                return false;
            }
        }
        cleared = true;
        String nums = Integer.toString(this.inputs[0]) + Integer.toString(this.inputs[1]) + Integer.toString(this.inputs[2]) + Integer.toString(this.inputs[3]);
        Log.d("Clear", "Input " + nums + " has been successfully cleared");
        return true;
    }
}
class sequence {
    String sequenceName;
    ArrayList<input> seq;
    boolean cleared;
    int currentInput;
    sequenceGroup nextGroup;
    public sequence() {
        seq = new ArrayList<input>();
        cleared = false;
        currentInput = 0;
        nextGroup = null;
    }
    public int size() {
        return seq.size();
    }
    public input get(int a) {
        return seq.get(a);
    }
    public void setNextGroup(sequenceGroup group) {
        nextGroup = group;
    }
    public void setSequenceName(String name) {
        sequenceName = name;
    }
    public void add(input in) {
        seq.add(in);
    }
    public boolean clear(input in) {
        if (cleared == false) {
            Log.d("Clear", "Sequence is being cleared");
            if (seq.get(currentInput).match(in) == true) {
                currentInput += 1;
                if (currentInput == seq.size()) {
                    Log.d("Clear", "Sequence has been cleared");
                    cleared = true;
                }
                return true;
            }

        } else {
            Log.d("Clear", "Current sequence is already cleared");
            return true;
        }
        return false;
    }
    //displays ratio of correct inputs
    public String ratio() {
        String response = Integer.toString(currentInput) + "/" + Integer.toString(seq.size());
        return response;
    }
}
class sequenceGroup {
    ArrayList<sequence> s;
    public sequenceGroup() {
        s = new ArrayList<sequence>();
    }
    public void add(sequence sequence) {
        s.add(sequence);
    }
    public int size() {
        return s.size();
    }
    public sequence get(int i) {
        return s.get(i);
    }
}

class chain {
    public static int[] ZERO = new int[]{0,0,0,0};
    public static int[] ONE = new int[]{1,0,0,0};
    public static int[] TWO = new int[]{0,1,0,0};
    public static int[] THREE = new int[]{0,0,1,0};
    public static int[] FOUR = new int[]{0,0,0,1};
    public static int[] ONETWO = new int[]{1,1,0,0};
    public static int[] THREEFOUR = new int[]{0,0,1,1};
    public static int[] ONETHREE = new int[]{1,0,1,0};
    public static int[] TWOFOUR = new int[]{0,1,0,1};
    public static int[] ONEFOUR = new int[]{1,0,0,1};
    public static int[] TWOTHREE = new int[]{0,1,1,0};
    public static int[] ONETWOTHREE = new int[]{1,1,1,0};
    public static int[] TWOTHREEFOUR = new int[]{0,1,1,1};
    public static int[] ONETHREEFOUR = new int[]{1,0,1,1};
    public static int[] ONETWOFOUR = new int[]{1,1,0,1};
    public static int[] ONETWOTHREEFOUR = new int[]{1,1,1,1};


    ArrayList<Integer> initialMotion;
    input initialInput;
    sequenceGroup currentGroup;
    boolean cleared;
    String chainName;

    public chain() {
    }
    public void setCurrentGroup(sequenceGroup group) {
        currentGroup = group;
    }
    public void setChainName(String name) {
        chainName = name;
    }
    public String getChainName(){
        return chainName;
    }
    public int getInputDrawable(input input) {
        if (Arrays.equals(input.inputs,ONE)) {
            return R.drawable.one;
        } else if (Arrays.equals(input.inputs, TWO)) {
            return R.drawable.two;
        } else if (Arrays.equals(input.inputs, THREE)) {
            return R.drawable.three;
        } else if (Arrays.equals(input.inputs, FOUR)) {
            return R.drawable.four;
        } else if (Arrays.equals(input.inputs, ONETWO)) {
            return R.drawable.onetwo;
        } else if (Arrays.equals(input.inputs, THREEFOUR)) {
            return R.drawable.threefour;
        } else if (Arrays.equals(input.inputs, ONETHREE)) {
            return R.drawable.onethree;
        } else if (Arrays.equals(input.inputs, TWOFOUR)) {
            return R.drawable.twofour;
        } else if (Arrays.equals(input.inputs, ONEFOUR)) {
            return R.drawable.onefour;
        } else if (Arrays.equals(input.inputs, TWOTHREE)) {
            return R.drawable.twothree;
        } else if (Arrays.equals(input.inputs, ONETWOTHREE)) {
            return R.drawable.onetwothree;
        } else if (Arrays.equals(input.inputs, TWOTHREEFOUR)) {
            return R.drawable.twothreefour;
        } else if (Arrays.equals(input.inputs, ONETHREEFOUR)) {
            return R.drawable.onethreefour;
        } else if (Arrays.equals(input.inputs, ONETWOFOUR)) {
            return R.drawable.onetwofour;
        } else if (Arrays.equals(input.inputs, ONETWOTHREEFOUR)) {
            return R.drawable.onetwothreefour;
        }
        return -1;
    }
    public void setInitialMotion(ArrayList<Integer> motion) {
        initialMotion = motion;
    }
    public void setInitialInput(input input) {
        initialInput = input;
    }
    public ArrayList<Integer> getInitialMotion() {
        return initialMotion;
    }
    public input getInitialInput() {
        return initialInput;
    }

    //call clear(input) to check if input is valid
    public int clear(input input) {
        int returnValue = 0;
        if (cleared == true)
        {
            Log.d("Clear", "Chain has already been cleared");
            return -1;
        }

        for (int i = 0; i < currentGroup.size(); i++) {
            if (currentGroup.get(i).clear(input) == true) {
                String logR = "sequence " + String.valueOf(i) + " input has been cleared";
                Log.d("ChainClear", logR);
                if (currentGroup.get(i).cleared == true) {
                    if (currentGroup.get(i).nextGroup != null) {
                        currentGroup = currentGroup.get(i).nextGroup;
                    } else {
                        cleared = true;
                    }
                }
                returnValue +=  Math.pow(2,i);
            } else {
                String logR = "sequence " + String.valueOf(i) + " input has not been cleared";
                Log.d("ChainClear", logR);
            }
        }
        Log.d("ReturnValue", String.valueOf(returnValue));
        return returnValue;
    }

    //call to get sequence that currently needs to be cleared
    public sequenceGroup getSequenceGroup() {
        String debug = "Attempting to access current sequence group";
        Log.d("Clear", debug);
        return currentGroup;
    }
}
