package com.company;

/**
 * Created by Igor on 22.05.2017.
 */
public class Process {
    int load;
    int runTime;
    int startTime;
    int endTime;

    public Process(int load, int runTime, int startTime) {
        this.load = load;
        this.runTime = runTime;
        this.startTime = startTime;
        this.endTime = startTime + runTime;
    }

    @Override
    public String toString() {
        return "Load: " + load + " Runtime: " + runTime + " Start time: " + startTime;
    }
}
