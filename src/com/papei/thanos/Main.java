package com.papei.thanos;

public class Main {
    public static void main(String[] args) {
        System.out.println("Missionaries and Cannibals");
        System.out.println("Thanos Paravantis - P16112");
        System.out.println("thanosparavantis@gmail.com");
        System.out.println();

        State state = new State(3, 3, BoatLocation.Left, 0, 0);

        useSearchAlgorithm(new BreadthFirstSearch(state));

        System.out.println();

        useSearchAlgorithm(new HillClimbingSearch(state));
    }

    private static void useSearchAlgorithm(SearchAlgorithm searchAlgorithm) {
        System.out.println("Applying: " + searchAlgorithm);
        System.out.println();

        State endState = searchAlgorithm.run();

        System.out.println();
        System.out.println("End State:");
        System.out.println(endState);
    }
}
