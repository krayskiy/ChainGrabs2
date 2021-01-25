package com.example.chaingrabs2;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class videoFragment extends Fragment {
    public interface videoListener {
        public void setUpTimer(long inputWindow);
    }
    boolean chanceLeft;
    TextView scoreDisplay;
    VideoView nextVideo;
    FrameLayout nextVideoLayout;
    VideoView grabVideo;
    FrameLayout grabVideoLayout;
    VideoView breakVideo;
    FrameLayout breakVideoLayout;
    VideoView noBreakVideo;
    FrameLayout noBreakVideoLayout;
    input breakInput;
    boolean broken;
    int grabsPlayed;
    int grabsBroken;
    View view;
    videoListener activityCallback;

    public void ShowPopup(View v, int displayMessage) {
        breakVideo.stopPlayback();
        noBreakVideo.stopPlayback();
        ((MainActivity)getActivity()).ShowPopup(v,displayMessage);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.video_fragment,container, false);
        grabsPlayed = 0;
        grabsBroken = 0;
        Button menuButton = view.findViewById(R.id.menu_button);
        menuButton.setOnTouchListener(
                new Button.OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent m) {
                        ShowPopup(v, -1);
                        return true;
                    }
                }
        );

        scoreDisplay = (TextView) view.findViewById(R.id.score_view);
        MediaController controller = new MediaController(view.getContext());
        controller.setVisibility((View.GONE));
        breakVideo = (VideoView) view.findViewById(R.id.break_video);
        breakVideo.setMediaController(controller);
        breakVideoLayout = (FrameLayout) view.findViewById(R.id.wrapper_break_video);
        noBreakVideo = (VideoView) view.findViewById(R.id.no_break_video);
        noBreakVideo.setMediaController(controller);
        noBreakVideoLayout = (FrameLayout) view.findViewById(R.id.wrapper_no_break_video);

        playVideo();
        return view;
    }
    public void grabBroken() {
        grabsBroken += 1;
        broken = true;
    }
    public boolean isChanceLeft() {
        //youOnlyGetOneShotDoNotMissYourChanceTo
        return chanceLeft;
    }
    public void chanceLost() {
        chanceLeft = false;
    }
    public void swapVisibility() {
        Log.d("swapVisibility", "grab broken, visible layout swapped");
        breakVideoLayout.setVisibility(View.VISIBLE);
        noBreakVideoLayout.setVisibility(View.GONE);

    }
    public boolean getBroken() {
        return broken;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            activityCallback = (videoFragment.videoListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement videoListener");
        }
    }

    //grabInput: 1 for 1, 2 for 2, 3 for 1+2
    //prePost: 0 for pre, 1 for post no, 2 for post yes
    public int getVideoId(int grabInput, int yesNoBreak) {
        int video_id = -1;
        switch(grabInput) {
            case(1):
                switch(yesNoBreak) {
                    case(0): video_id = R.raw.one_whole_no_break;
                    break;
                    case(1): video_id = R.raw.one_whole_w_break;
                    break;
                }
                break;
            case(2):
                switch(yesNoBreak) {
                    case(0): video_id = R.raw.two_whole_no_break;
                        break;
                    case(1): video_id = R.raw.two_whole_w_break;
                        break;
                }
                break;
            case(3):
                switch(yesNoBreak) {
                    case(0): video_id = R.raw.one_two_whole_no_break;
                        break;
                    case(1): video_id = R.raw.one_two_whole_w_break;
                        break;
                }
                break;
        }
        return video_id;
    }
    public long getInputMillis(int grabInput) {
        switch(grabInput) {
            case(1):
                return 1400;
            case(2):
                return 1433;
            case(3):
                return 1566;
        }
        return -1;
    }
    public input getBreakInput() {
        return breakInput;
    }
    //0 for pre, 1 for post no, 2 for post yes
    public int playVideo() {
        String scoreText = "Current Score:" + Integer.toString(grabsBroken) + "/" + Integer.toString(grabsPlayed);
        scoreDisplay.setText(scoreText);
        grabsPlayed += 1;
        chanceLeft = true;
        Log.d("playVideo", "function called");
        final int selection = (int)(Math.random() * 3) + 1;
        broken = false;
        if (selection == 1) {
            breakInput = new input(chain.ONE);
        } else if (selection == 2) {
            breakInput = new input(chain.TWO);
        } else  { // selection == 3
            breakInput = new input(chain.ONETWO);
        }
        int video_id = getVideoId(selection, 0);
        if (video_id == -1) {
            return -1;
        }
        Uri uri = Uri.parse("android.resource://"+view.getContext().getPackageName()+"/"+video_id);
        noBreakVideo.setVideoURI(uri);
        noBreakVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.d("noBreakVideo", "prepared");
                noBreakVideoLayout.setVisibility(View.VISIBLE);
            }
        });
        noBreakVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                playVideo();
            }
        });
        video_id = getVideoId(selection, 1);
        if (video_id == -1) {
            return -1;
        }
        uri = Uri.parse("android.resource://"+view.getContext().getPackageName()+"/"+video_id);
        breakVideo.setVideoURI(uri);
        breakVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.d("breakVideo", "prepared");
                breakVideoLayout.setVisibility(View.GONE);
            }
        });
        breakVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                playVideo();
            }
        });
        activityCallback.setUpTimer(getInputMillis(selection));
        noBreakVideo.start();
        breakVideo.start();

        return 1;
    }

}

//dysfunctional
//        grabVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//@Override
//public void onPrepared(MediaPlayer mp) {
//        Log.d("grabVideo", "prepared");
//        int video_id = getVideoId(selection, 1);
//        Uri uri = Uri.parse("android.resource://"+view.getContext().getPackageName()+"/"+video_id);
//        noBreakVideo.setVideoURI(uri);
//        noBreakVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//@Override
//public void onPrepared(MediaPlayer mp) {
//        Log.d("noBreakVideo", "prepared");
//        int video_id = getVideoId(selection, 2);
//        Uri uri = Uri.parse("android.resource://"+view.getContext().getPackageName()+"/"+video_id);
//        breakVideo.setVideoURI(uri);
//        breakVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//@Override
//public void onPrepared(MediaPlayer mp) {
//        Log.d("breakVideo", "prepared");
//        activityCallback.setUpTimer(grabVideo.getDuration());
//        grabVideo.start();
//        }
//        });
//        breakVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//@Override
//public void onCompletion(MediaPlayer mp) {
//        playVideo();
//        }
//        });
//        }
//        });
//        noBreakVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//@Override
//public void onCompletion(MediaPlayer mp) {
//        playVideo();
//        }
//        });
//        }
//        });
//        grabVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//@Override
//public void onCompletion(MediaPlayer mp) {
//        grabVideo.setVisibility(View.INVISIBLE);
//        if (broken == true) {
//        breakVideo.setVisibility(View.VISIBLE);
//        breakVideo.start();
//        } else {
//        noBreakVideo.setVisibility(View.INVISIBLE);
//        noBreakVideo.start();
//        }
//        }
//        });