package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Igor on 22.05.2017.
 */
public class Processor {
    int index;
    int load = 0;
    int loadSum = 0;
    double averageLoad = 0;
    ArrayList<Process> processes;
    ArrayList<Process> workingProcesses;

    public Processor(int index) {
        this.index = index;
        this.processes = new ArrayList<>();
        this.workingProcesses = new ArrayList<>();
    }

    public Processor(int index, Processor p){
        this.index = index;
        this.processes = (ArrayList<Process>)p.processes.clone();
        this.workingProcesses = new ArrayList<>();
    }
}
