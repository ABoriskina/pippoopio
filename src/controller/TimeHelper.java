package controller;

import java.util.TimerTask;
import javax.swing.JLabel;

public class TimeHelper extends TimerTask {
    LauchFrame.UserKeyListener lauchFrameUserKeyListener;
    LauchFrame lauchFrame;

    public TimeHelper(LauchFrame.UserKeyListener lauchFrameUserKeyListener, LauchFrame lauchFrame){
        this.lauchFrameUserKeyListener = lauchFrameUserKeyListener;
        this.lauchFrame = lauchFrame;
    }

    public void run() {
        lauchFrameUserKeyListener.showTime();

    }

}
