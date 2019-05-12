package com.papei.thanos;

public final class Operators {
    private Operators() {}

    public static State oneMissionaryLeft(State state) {
        return new State(
                state.getMissionariesLeft() + 1,
                state.getCannibalsLeft(),
                BoatLocation.Left,
                state.getMissionariesRight() - 1,
                state.getCannibalsRight());
    }

    public static State oneCannibalLeft(State state) {
        return new State(
                state.getMissionariesLeft(),
                state.getCannibalsLeft() + 1,
                BoatLocation.Left,
                state.getMissionariesRight(),
                state.getCannibalsRight() - 1);
    }

    public static State oneMissionaryOneCannibalLeft(State state) {
        return new State(
                state.getMissionariesLeft() + 1,
                state.getCannibalsLeft() + 1,
                BoatLocation.Left,
                state.getMissionariesRight() - 1,
                state.getCannibalsRight() - 1);
    }

    public static State twoMissionariesLeft(State state) {
        return new State(
                state.getMissionariesLeft() + 2,
                state.getCannibalsLeft(),
                BoatLocation.Left,
                state.getMissionariesRight() - 2,
                state.getCannibalsRight());
    }

    public static State twoCannibalsLeft(State state) {
        return new State(
                state.getMissionariesLeft(),
                state.getCannibalsLeft() + 2,
                BoatLocation.Left,
                state.getMissionariesRight(),
                state.getCannibalsRight() - 2);
    }

    public static State oneMissionaryRight(State state) {
        return new State(
                state.getMissionariesLeft() - 1,
                state.getCannibalsLeft(),
                BoatLocation.Right,
                state.getMissionariesRight() + 1,
                state.getCannibalsRight());
    }

    public static State oneCannibalRight(State state) {
        return new State(
                state.getMissionariesLeft(),
                state.getCannibalsLeft() - 1,
                BoatLocation.Right,
                state.getMissionariesRight(),
                state.getCannibalsRight() + 1);
    }

    public static State oneMissionaryOneCannibalRight(State state) {
        return new State(
                state.getMissionariesLeft() - 1,
                state.getCannibalsLeft() - 1,
                BoatLocation.Right,
                state.getMissionariesRight() + 1,
                state.getCannibalsRight() + 1);
    }

    public static State twoMissionariesRight(State state) {
        return new State(
                state.getMissionariesLeft() - 2,
                state.getCannibalsLeft(),
                BoatLocation.Right,
                state.getMissionariesRight() + 2,
                state.getCannibalsRight());
    }

    public static State twoCannibalsRight(State state) {
        return new State(
                state.getMissionariesLeft(),
                state.getCannibalsLeft() - 2,
                BoatLocation.Right,
                state.getMissionariesRight(),
                state.getCannibalsRight() + 2);
    }
}
