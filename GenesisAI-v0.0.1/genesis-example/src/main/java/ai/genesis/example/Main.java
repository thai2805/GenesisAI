package ai.genesis.example;

import ai.genesis.runtime.DefaultBrain;
import ai.genesis.runtime.DefaultBrainRuntime;

public class Main {
    public static void main(String[] args) {
        var brain = new DefaultBrain(new DefaultBrainRuntime());
        System.out.println(brain.think("Hello Genesis"));
    }
}