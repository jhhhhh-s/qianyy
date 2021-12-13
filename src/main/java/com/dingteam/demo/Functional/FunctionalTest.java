package com.dingteam.demo.Functional;

public class FunctionalTest {

    public static BranchHandle isTureOrFalse(boolean b) {

        return (trueHandle, falseHandle) -> {
            if (b) {
                trueHandle.run();
            } else {
                falseHandle.run();
            }
        };
    }


    public static void main(String[] args) {

        isTureOrFalse(false)
                .trueOrFalseHandle(
                        () -> System.out.println("TRUE"),
                        () -> System.out.println("FALSE")
                );


    }
}
