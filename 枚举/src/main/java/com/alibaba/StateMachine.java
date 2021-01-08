package com.alibaba;

public class StateMachine {
    enum Signal {RED, YELLOW, GREEN}

    public static String getTrafficInstruct(Signal signal) {
        String instruct = "信号灯故障";
        switch (signal) {
            case RED:
                instruct = "红灯停";
                break;
            case YELLOW:
                instruct = "黄灯请注意";
                break;
            case GREEN:
                instruct = "绿灯行";
                break;
            default:
                break;
        }
        return instruct;
    }
}
