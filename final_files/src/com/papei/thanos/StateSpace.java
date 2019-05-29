package com.papei.thanos;

import java.util.ArrayList;
import java.util.List;

public class StateSpace {
    private List<State> nextStates = new ArrayList<>();

    public StateSpace(State initialState) {
        findSpace(initialState);
    }

    private void findSpace(State state) {
        if (state.getBoatLocation() == BoatLocation.Left) {
            applyValidOperators(
                    Operators.oneMissionaryRight(state),
                    Operators.oneCannibalRight(state),
                    Operators.oneMissionaryOneCannibalRight(state),
                    Operators.twoMissionariesRight(state),
                    Operators.twoCannibalsRight(state));
        } else {
            applyValidOperators(
                    Operators.oneMissionaryLeft(state),
                    Operators.oneCannibalLeft(state),
                    Operators.oneMissionaryOneCannibalLeft(state),
                    Operators.twoMissionariesLeft(state),
                    Operators.twoCannibalsLeft(state));
        }
    }

    private void applyValidOperators(State... states) {
        for (State state : states) {
            if (state.isValid()) {
                nextStates.add(state);
            }
        }
    }

    public List<State> getNextStates() {
        return nextStates;
    }
}
