package com.papei.thanos;

public class Main {
    public static void main(String[] args) {
        State state = new State(3, 3, BoatLocation.Left, 0, 0);

        System.out.println("Initial State:");
        System.out.println(state);
        System.out.println();

        BreadthFirstSearch bfs = new BreadthFirstSearch(state);

        System.out.println("Breadth First Search...");
        System.out.println();

        State endState = bfs.run();

        System.out.println("End State Found:");
        System.out.println(endState);
    }
}
