package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Processor> processors = Generator.generateProcessors(100);
        Generator.generateProcesses(processors, 300);
        FirstAlgorithm fa = new FirstAlgorithm(processors, 80, 5);
        SecondAlgorithm sa = new SecondAlgorithm(processors, 80);
        ThirdAlgorithm ta = new ThirdAlgorithm(processors, 80, 40);
        fa.handleProcessors();
        sa.handleProcessors();
        ta.handleProcessors();
    }
}
