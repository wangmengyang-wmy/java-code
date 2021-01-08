package com.alibaba;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

public class OtherTest {
    public static void main(String[] args) {
        // EnumSet的使用
        System.out.println("EnumSet展示");
        EnumSet<ErrorCodeEn> errSet = EnumSet.allOf(ErrorCodeEn.class);
        for (ErrorCodeEn e : errSet) {
            System.out.println(e.name() + " : " + e.ordinal());
        }

        // EnumMap的使用
        System.out.println("EnumMap展示");
        EnumMap<StateMachine.Signal, String> errMap = new EnumMap(StateMachine.Signal.class);
        errMap.put(StateMachine.Signal.RED, "红灯");
        errMap.put(StateMachine.Signal.YELLOW, "黄灯");
        errMap.put(StateMachine.Signal.GREEN, "绿灯");
        for (Map.Entry<StateMachine.Signal, String> entry : errMap.entrySet()) {
            System.out.println(entry.getKey().name() + " : " + entry.getValue());
        }
    }
}
