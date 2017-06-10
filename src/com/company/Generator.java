package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Igor on 22.05.2017.
 */
public class Generator {
    public static Random generator = new Random();

    public static List<Processor> generateProcessors(int numberOfProcessors){
        List<Processor> processors = new ArrayList<>();
        for (int i = 0; i < numberOfProcessors; i++) {
            processors.add(new Processor(i));
        }
        return processors;
    }

    public static void generateProcesses (List<Processor> processors, int maxTime){
        for (Processor processor : processors) {
            int x = 0;
            while(x < maxTime){
                int k = generator.nextInt(10) + 1;
                x += k;
                int runTime = generator.nextInt((int)(maxTime * 0.1)) + 1;
                int load = generator.nextInt(50) + 1;
                processor.processes.add(new Process(load, runTime, x));
            }
        }
    }
}
