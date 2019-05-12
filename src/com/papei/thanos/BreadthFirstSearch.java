package com.papei.thanos;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public final class BreadthFirstSearch {
    private State initialState;
    private Queue<State> searchSpace = new LinkedList<>();
    private Set<State> visited = new HashSet<>();

    public BreadthFirstSearch(State initialState) {
        this.initialState = initialState;
    }

    public State run() {
        if (initialState.isGoal()) {
            return initialState;
        }

        searchSpace.add(initialState);

        while (true) {
            State state = searchSpace.poll();
            visited.add(state);

            StateSpace stateSpace = new StateSpace(state);

            for (State child : stateSpace.getNextStates()) {
                if (searchSpace.contains(child) || visited.contains(child)) {
                    continue;
                }

                if (child.isGoal()) {
                    return child;
                }

                searchSpace.add(child);
            }
        }
    }
}
