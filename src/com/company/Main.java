package com.company;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        DistributedOperatingSystem dos = new DistributedOperatingSystem(100);
        Generator.generateProcesses(dos.processorList, 300);
        for (Processor processor :
                dos.processorList) {
            System.out.println(processor.processes);
        }
        Processor r = dos.processorList.get(0);
        System.out.println(r.processes);
        int time = 0;
        Iterator<Process> it;
        while(!r.processes.isEmpty() || !r.workingProcesses.isEmpty()){
            it = r.workingProcesses.iterator();
            while(it.hasNext()){
                Process p = it.next();
                if(p.endTime <= time){
                    r.load -= p.load;
                    it.remove();
                }
            }
            it = r.processes.iterator();
            while(it.hasNext()){
                Process p = it.next();
                if(p.startTime <= time){
                    r.load += p.load;
                    r.workingProcesses.add(p);
                    it.remove();
                }
            }
            r.loadSum +=r.load;
            time++;
        }
        System.out.println(r.loadSum / (double)time);
    }
}
