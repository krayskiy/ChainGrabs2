package com.example.chaingrabs2;

import android.content.Context;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class buttonsFragment extends Fragment {
    Scene fourButtonScene;
    Scene threeButtonScene;
    int currentButtons;
    ViewGroup sceneRoot;
    buttonsListener activityCallback;
    public interface buttonsListener {
        public void handleTouch(int pressedIndex, MotionEvent m);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            activityCallback = (buttonsListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement ToolbarListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.buttons_fragment,container, false);
        sceneRoot = (ViewGroup) view.findViewById(R.id.buttons_frame_layout);
        fourButtonScene = Scene.getSceneForLayout(sceneRoot, R.layout.four_button_scene, view.getContext());
        threeButtonScene = Scene.getSceneForLayout(sceneRoot, R.layout.three_button_scene, view.getContext());
        currentButtons = 0;
//        Button button1 = (Button) view.findViewById(R.id.button1);
//        button1.setOnTouchListener(
//                new Button.OnTouchListener() {
//                    public boolean onTouch(View v, MotionEvent m) {
//                        activityCallback.handleTouch(0,m);
//                        return true;
//                    }
//                }
//        );
//        Button button2 = (Button) view.findViewById(R.id.button2);
//        button2.setOnTouchListener(
//                new Button.OnTouchListener() {
//                    public boolean onTouch(View v, MotionEvent m) {
//                        activityCallback.handleTouch(1,m);
//                        return true;
//                    }
//                }
//        );
//        Button button3 = (Button) view.findViewById(R.id.button3);
//        button3.setOnTouchListener(
//                new Button.OnTouchListener() {
//                    public boolean onTouch(View v, MotionEvent m) {
//                        activityCallback.handleTouch(2,m);
//                        return true;
//                    }
//                }
//        );
//        Button button4 = (Button) view.findViewById(R.id.button4);
//        button4.setOnTouchListener(
//                new Button.OnTouchListener() {
//                    public boolean onTouch(View v, MotionEvent m) {
//                        activityCallback.handleTouch(3,m);
//                        return true;
//                    }
//                }
//        );
        return view;
    }

    public void setFourButtonScene() {
        if (currentButtons != 4) {
            Transition trans = new AutoTransition();
            TransitionManager.go(fourButtonScene, trans);
            Button button1 = (Button) getView().findViewById(R.id.button1);
            button1.setOnTouchListener(
                    new Button.OnTouchListener() {
                        public boolean onTouch(View v, MotionEvent m) {
                            activityCallback.handleTouch(0, m);
                            return true;
                        }
                    }
            );
            Button button2 = (Button) getView().findViewById(R.id.button2);
            button2.setOnTouchListener(
                    new Button.OnTouchListener() {
                        public boolean onTouch(View v, MotionEvent m) {
                            activityCallback.handleTouch(1, m);
                            return true;
                        }
                    }
            );
            Button button3 = (Button) getView().findViewById(R.id.button3);
            button3.setOnTouchListener(
                    new Button.OnTouchListener() {
                        public boolean onTouch(View v, MotionEvent m) {
                            activityCallback.handleTouch(2, m);
                            return true;
                        }
                    }
            );
            Button button4 = (Button) getView().findViewById(R.id.button4);
            button4.setOnTouchListener(
                    new Button.OnTouchListener() {
                        public boolean onTouch(View v, MotionEvent m) {
                            activityCallback.handleTouch(3, m);
                            return true;
                        }
                    }
            );
            currentButtons = 4;
        }
    }

    public void setThreeButtonScene() {
        if (currentButtons != 3) {
            Transition trans = new AutoTransition();
            TransitionManager.go(threeButtonScene, trans);
            Button button1 = (Button) getView().findViewById(R.id.button3);
            button1.setOnTouchListener(
                    new Button.OnTouchListener() {
                        public boolean onTouch(View v, MotionEvent m) {
                            activityCallback.handleTouch(0, m);
                            return true;
                        }
                    }
            );
            Button button2 = (Button) getView().findViewById(R.id.button1);
            button2.setOnTouchListener(
                    new Button.OnTouchListener() {
                        public boolean onTouch(View v, MotionEvent m) {
                            activityCallback.handleTouch(1, m);
                            return true;
                        }
                    }
            );
            Button button3 = (Button) getView().findViewById(R.id.button2);
            button3.setOnTouchListener(
                    new Button.OnTouchListener() {
                        public boolean onTouch(View v, MotionEvent m) {
                            activityCallback.handleTouch(4, m);
                            return true;
                        }
                    }
            );
            currentButtons = 3;
        }
    }

}
