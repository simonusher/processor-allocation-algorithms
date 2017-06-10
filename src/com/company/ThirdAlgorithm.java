package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Szymon on 10.06.2017.
 */
public class ThirdAlgorithm extends DistributedOperatingSystem{
    private double maxLoad;
    private double minLoad;
    Random random = new Random();

    public ThirdAlgorithm(ArrayList<Processor> processors, double maxLoad, double minLoad){
        super(processors.size());
        this.processorList = Generator.copyProcessors(processors);
        this.numberOfProcessors = processorList.size();
        this.maxLoad = maxLoad;
        this.minLoad = minLoad;
    }

    @Override
    protected void addProcesses() {
        for (Processor x : processorList) {
            for (int i = 0; i < x.processes.size(); i++) {
                Process process = x.processes.get(i);
                if(process.startTime <= time){
                        x.workingProcesses.add(process);
                        x.load += process.load;
                        x.processes.remove(process);
                }
            }
        }
        for (Processor y : processorList) {
            if(y.load < minLoad){
                int index = random.nextInt(this.numberOfProcessors);
                numberOfQueries++;
                Processor x = processorList.get(index);
                if(x.load >= maxLoad){
                    Process p = new Process();
                    while(y.load < minLoad && x.load >= maxLoad){
                        p = x.workingProcesses.get(0);
                        numberOfMigrations++;
                        y.workingProcesses.add(p);
                        y.load += p.load;
                        x.workingProcesses.remove(p);
                        x.load -= p.load;
                    }
                }
            }
        }
    }
}

