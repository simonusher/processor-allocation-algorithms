package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Szymon on 10.06.2017.
 */
public class SecondAlgorithm extends DistributedOperatingSystem{
    double maxLoad;
    Random random = new Random();

    public SecondAlgorithm(int numberOfProcessors, double maxLoad) {
        super(numberOfProcessors);
        this.maxLoad = maxLoad;
    }

    public SecondAlgorithm(ArrayList<Processor> processors, double maxLoad){
        super(processors.size());
        this.processorList = Generator.copyProcessors(processors);
        this.numberOfProcessors = processorList.size();
        this.maxLoad = maxLoad;
    }

    protected boolean checkProcessors(){
        boolean checkProcessors = false;
        for (Processor p : processorList) {
            if(p.load < maxLoad) checkProcessors = true;
        }
        return checkProcessors;
    }

    @Override
    protected void addProcesses() {
        for (Processor x : processorList) {
            for (int i = 0; i < x.processes.size(); i++) {
                Process process = x.processes.get(i);
                if(process.startTime <= time){
                    if(x.load < maxLoad || !checkProcessors()){
                        x.workingProcesses.add(process);
                        x.load += process.load;
                        x.processes.remove(process);
                    }
                    else {
                        boolean found = false;
                        while(!found){
                            int index = random.nextInt(this.numberOfProcessors);
                            numberOfQueries++;
                            Processor y = processorList.get(index);
                            if(y.load < maxLoad){
                                found = true;
                                numberOfMigrations++;
                                y.workingProcesses.add(process);
                                y.load += process.load;
                                x.processes.remove(process);
                            }
                        }
                    }
                }
            }
        }
    }
}
