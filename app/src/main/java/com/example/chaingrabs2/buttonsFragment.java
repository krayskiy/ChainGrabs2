package com.example.chaingrabs2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class buttonsFragment extends Fragment {
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
        Button button1 = (Button) view.findViewById(R.id.button1);
        button1.setOnTouchListener(
                new Button.OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent m) {
                        activityCallback.handleTouch(0,m);
                        return true;
                    }
                }
        );
        Button button2 = (Button) view.findViewById(R.id.button2);
        button2.setOnTouchListener(
                new Button.OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent m) {
                        activityCallback.handleTouch(1,m);
                        return true;
                    }
                }
        );
        Button button3 = (Button) view.findViewById(R.id.button3);
        button3.setOnTouchListener(
                new Button.OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent m) {
                        activityCallback.handleTouch(2,m);
                        return true;
                    }
                }
        );
        Button button4 = (Button) view.findViewById(R.id.button4);
        button4.setOnTouchListener(
                new Button.OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent m) {
                        activityCallback.handleTouch(3,m);
                        return true;
                    }
                }
        );
        return view;
    }

}
