package com.company;

import java.util.List;

/**
 * Created by Igor on 22.05.2017.
 */
public class DistributedOperatingSystem {
    int numberOfProcessors;
    List<Processor> processorList;
    int limit = 50;

    public DistributedOperatingSystem(int numberOfProcessors) {
        this.numberOfProcessors = numberOfProcessors;
        this.processorList = Generator.generateProcessors(numberOfProcessors);
    }
}
