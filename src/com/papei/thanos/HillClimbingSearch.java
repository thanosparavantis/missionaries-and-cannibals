package com.papei.thanos;

import java.util.Comparator;
import java.util.List;

public class HillClimbingSearch implements SearchAlgorithm {
    private State state;

    public HillClimbingSearch(State initialState) {
        this.state = initialState;
    }

    @Override
    public State run() {
        while (!state.isGoal()) {
            StateSpace stateSpace = new StateSpace(state);

            List<State> nextStates = stateSpace.getNextStates();

            if (nextStates.isEmpty()) {
                break;
            }

            State bestState = nextStates.stream()
                    .max(Comparator.comparingInt(State::getHeuristicValue))
                    .get();

            int currentScore = state.getHeuristicValue();
            int nextScore = bestState.getHeuristicValue();

            System.out.println("Current:");
            System.out.println(state);

            System.out.println("Current score: " + currentScore);

            System.out.println("Next:");
            System.out.println(bestState);

            System.out.println("Next score: " + nextScore);

            if (currentScore >= nextScore) {
                System.out.println("Current score greater than next, stopping...");
                break;
            } else {
                System.out.println("Moving into the next best state...");
                this.state = bestState;
            }
        }

        return state;
    }

    @Override
    public String toString() {
        return "Hill Climbing Search Algorithm";
    }
}
