package com.example.chaingrabs2;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class inputsFragment extends Fragment {
    public void ShowPopup(View v, int displayMessage) {
        ((MainActivity)getActivity()).ShowPopup(v,displayMessage);
    }
    View view;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.inputs_fragment,container, false);
        Button chooseGrabButton = view.findViewById(R.id.swapGrab);
        chooseGrabButton.setOnTouchListener(
                new Button.OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent m) {
                        ShowPopup(v, -1);
                        return true;
                    }
                }
        );
        return view;
    }


    //fuck this lol create a linear layout
    public void setHeader(chain chain) {
        LinearLayout startLayout = (LinearLayout)view.findViewById(R.id.startLayout);
        ArrayList<Integer> motion = chain.getInitialMotion();
        TextView chainName = (TextView)view.findViewById(R.id.grabNameText);
        chainName.setText(chain.chainName);
        ImageView imageView;
        int imageId;
        if (chain.chainName == "Cobra Clutch") {
            imageView = new ImageView(getActivity());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(100, 100));
            imageView.setImageResource(R.drawable.threefour);
            startLayout.addView(imageView);
            imageView = new ImageView(getActivity());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(100, 100));
            imageView.setImageResource(R.drawable.onefour);
            startLayout.addView(imageView);
            return;
        }
        for (int i = 0; i <= motion.size(); i++) {
            imageView = new ImageView(getActivity());
            if (i == motion.size()) {
                imageId = chain.getInputDrawable(chain.getInitialInput());
            } else {
                switch (motion.get(i)) {
                    case (1):
                        imageId = R.drawable.downback;
                        break;
                    case (2):
                        imageId = R.drawable.down;
                        break;
                    case (3):
                        imageId = R.drawable.downforward;
                        break;
                    case (4):
                        imageId = R.drawable.back;
                        break;
                    case (5):
                        imageId = R.drawable.neutral;
                        break;
                    case (6):
                        imageId = R.drawable.forward;
                        break;
                    case (7):
                        imageId = R.drawable.upback;
                        break;
                    case (8):
                        imageId = R.drawable.up;
                        break;
                    case (9):
                        imageId = R.drawable.upforward;
                        break;
                    default:
                        Log.d("", "Motion not valid");
                        imageId = R.drawable.forward;
                        break;
                }
            }
            imageView.setLayoutParams(new ViewGroup.LayoutParams(100, 100));
            imageView.setImageResource(imageId);
            startLayout.addView(imageView);
        }

    }
    public void setInputs(chain chain) {
        LinearLayout chainDisplay = (LinearLayout)view.findViewById(R.id.chainDisplay);
        chainDisplay.removeAllViews();
        sequenceGroup currentSequenceGroup = chain.currentGroup;
        ImageView imageView;
        sequence currentSequence;
        for (int i = 0; i < currentSequenceGroup.size(); i++) {
            //Create linear layouts to contain imageView inputs
            TextView extensionName = new TextView(getActivity());
            extensionName.setText(chain.currentGroup.get(i).sequenceName);
            //extensionName.setId( (i * 3) + 1);
            chainDisplay.addView(extensionName);

            LinearLayout inputLayout = new LinearLayout(getActivity());
            //inputLayout.setId( (i * 3) + 1);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0,0,0,0);
            inputLayout.setLayoutParams(params);
            chainDisplay.addView(inputLayout);

            LinearLayout successLayout = new LinearLayout(getActivity());
            successLayout.setId(i);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0,0,0,0);
            successLayout.setLayoutParams(params);
            chainDisplay.addView(successLayout);

            int imageId;
            currentSequence = currentSequenceGroup.get(i);
            for (int a = 0; a < currentSequence.size(); a++) {
                imageView = new ImageView(getActivity());
                imageId = chain.getInputDrawable(currentSequence.get(a));
                //LayoutParams(layout_height, layout_width
                imageView.setLayoutParams(new ViewGroup.LayoutParams(100, 100));
                imageView.setImageResource(imageId);
                inputLayout.addView(imageView);
                Log.d("", "Input image set");
            }
        }
    }
    //successLayout needs to add directly under inputs in inputLayout
    public void inputCleared(int clearResponse, sequenceGroup currentGroup) {
        LinearLayout successLayout;
        for (int i = 0; i < currentGroup.size(); i++) {
            int a = (int)Math.pow(2,i);
            Log.d("inputCleared","Checking if input was cleared");
            if ( (a & clearResponse) > 0) {
                Log.d("inputCleared","Input was cleared");
            } else {
                Log.d("inputCleared","Input was not cleared");
                continue;
            }
            successLayout = (LinearLayout)view.findViewById(i);
            ImageView imageView = new ImageView(getActivity());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(100, 100)); //ViewGroup.LayoutParams.MATCH_PARENT
            imageView.setImageResource(R.drawable.checkmark); //checkmark
            successLayout.addView(imageView);
            Log.d("", "Checkmark added ???");
        }

    }
    public void clearInputs() {
        LinearLayout chainDisplay = (LinearLayout)view.findViewById(R.id.chainDisplay);
        chainDisplay.removeAllViews();
    }
    public void clearHeader() {
        LinearLayout startLayout = (LinearLayout)view.findViewById(R.id.startLayout);
        startLayout.removeAllViews();
    }

}
