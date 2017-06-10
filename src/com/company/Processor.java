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
    List<Process> processes;
    List<Process> workingProcesses;

    public Processor(int index) {
        this.index = index;
        this.processes = new ArrayList<>();
        this.workingProcesses = new ArrayList<>();
    }
}
