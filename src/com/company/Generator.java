package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Igor on 22.05.2017.
 */
public class Generator {
    public static Random generator = new Random();

    public static ArrayList<Processor> generateProcessors(int numberOfProcessors){
        ArrayList<Processor> processors = new ArrayList<>();
        for (int i = 0; i < numberOfProcessors; i++) {
            processors.add(new Processor(i));
        }
        return processors;
    }

    public static ArrayList<Processor> copyProcessors(ArrayList<Processor> list){
        ArrayList<Processor> newList = new ArrayList<>();
        for (Processor p : list) {
            newList.add(new Processor(p.index, p));
        }
        return newList;
    }

    public static void generateProcesses (ArrayList<Processor> processors, int maxTime){
        for (Processor processor : processors) {
            int x = 0;
            while(x < maxTime){
                int k = generator.nextInt(3) + 1;
                x += k;
                int runTime = generator.nextInt((int)(maxTime * 0.1)) + 1;
                int load = generator.nextInt(15) + 1;
                processor.processes.add(new Process(load, runTime, x));
            }
        }
    }
}
