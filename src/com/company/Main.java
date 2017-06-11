package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static int numberOfProcessors = 100;
    public static int maxTime = 300;
    public static int maxLoad = 80;
    public static int minLoad = 20;
    public static int maxNumberOfQueries = 5;

    public static void main(String[] args) {
        ArrayList<Processor> processors = Generator.generateProcessors(numberOfProcessors);
        Generator.generateProcesses(processors, maxTime);
        FirstAlgorithm fa = new FirstAlgorithm(processors, maxLoad, maxNumberOfQueries);
        SecondAlgorithm sa = new SecondAlgorithm(processors, maxLoad);
        ThirdAlgorithm ta = new ThirdAlgorithm(processors, maxLoad, minLoad);
        fa.handleProcessors();
        sa.handleProcessors();
        ta.handleProcessors();
    }
}
