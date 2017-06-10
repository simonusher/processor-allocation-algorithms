package com.company;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Szymon on 10.06.2017.
 */
public class FirstAlgorithm extends DistributedOperatingSystem{
    int maxNumberOfQueries;
    double maxLoad;
    Random random = new Random();

    public FirstAlgorithm(int numberOfProcessors, int maxNumberOfQueries, double maxLoad) {
        super(numberOfProcessors);
        this.maxNumberOfQueries = maxNumberOfQueries;
        this.maxLoad = maxLoad;
    }

    public FirstAlgorithm(ArrayList<Processor> processors, double maxLoad, int maxNumberOfQueries){
        super(processors.size());
        this.processorList = Generator.copyProcessors(processors);
        this.numberOfProcessors = processorList.size();
        this.maxLoad = maxLoad;
        this.maxNumberOfQueries = maxNumberOfQueries;
    }

    @Override
    protected void addProcesses() {
        for (Processor x : processorList) {
            for (int i = 0; i < x.processes.size(); i++) {
                Process process = x.processes.get(i);
                if(process.startTime <= time){
                    boolean found = false;
                    for (int j = 0; j < maxNumberOfQueries; j++) {
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
                        if(found) break;
                    }
                    if(!found){
                        x.workingProcesses.add(process);
                        x.load += process.load;
                        x.processes.remove(process);
                    }
                }
            }
        }
    }
}
