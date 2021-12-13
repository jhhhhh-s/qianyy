package com.dingteam.demo.Functional;

@FunctionalInterface
public interface BranchHandle {


    void trueOrFalseHandle(Runnable trueHandle, Runnable falseHandle);



}
