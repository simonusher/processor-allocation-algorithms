package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Igor on 22.05.2017.
 */
public abstract class DistributedOperatingSystem {
    int numberOfProcessors;
    ArrayList<Processor> processorList;
    double averageLoad = 0;
    double standardDeviation = 0;
    int numberOfQueries = 0;
    int numberOfMigrations = 0;
    int limit = 50;
    int time = 0;

    public DistributedOperatingSystem() {
    }

    public DistributedOperatingSystem(int numberOfProcessors) {
        this.numberOfProcessors = numberOfProcessors;
        this.processorList = Generator.generateProcessors(numberOfProcessors);
        Generator.generateProcesses(processorList, 300);
    }

    protected void deleteProcesses(){
        for (Processor p : processorList) {
            Iterator<Process> it = p.workingProcesses.iterator();
            Process process;
            while (it.hasNext()){
                process = it.next();
                if(process.endTime <= time){
                    it.remove();
                    p.load -= process.load;
                }
            }
        }
    }

    protected boolean isDone(){
        boolean isDone = true;
        for (Processor p : processorList) {
            if (!p.workingProcesses.isEmpty() || !p.processes.isEmpty()) {
                isDone = false;
                break;
            }
        }
        return isDone;
    }

    protected abstract void addProcesses();

    protected void sumLoad(){
        for (Processor p : processorList) {
            p.loadSum += p.load;
        }
    }
    
    public void handleProcessors(){
        while (!isDone()){
            deleteProcesses();
            addProcesses();
            sumLoad();
            time++;
        }
        calculateAndPrintResults();
    }
    protected void calculateAndPrintResults(){
        for (Processor p : processorList) {
            p.averageLoad = p.loadSum / (double)time;
            this.averageLoad += p.averageLoad;
        }
        this.averageLoad /= processorList.size();
        for (Processor p : processorList) {
            this.standardDeviation += Math.pow((p.averageLoad - this.averageLoad), 2);
        }
        this.standardDeviation = Math.sqrt(this.standardDeviation / this.numberOfProcessors);
        System.out.println("Results: ");
        System.out.println("Average load: " + averageLoad);
        System.out.println("Standard deviation: " + standardDeviation);
        System.out.println("Number of queries: " + numberOfQueries);
        System.out.println("Number of migrations: " + numberOfMigrations);

    }
}
