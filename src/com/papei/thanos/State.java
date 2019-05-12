package com.papei.thanos;


public final class State {
    private final int missionariesLeft;
    private final int cannibalsLeft;
    private final int missionariesRight;
    private final int cannibalsRight;
    private final BoatLocation boatLocation;

    public State(int missionariesLeft, int cannibalsLeft,
                 BoatLocation boatLocation,
                 int missionariesRight, int cannibalsRight) {
        this.missionariesLeft = missionariesLeft;
        this.cannibalsLeft = cannibalsLeft;
        this.boatLocation = boatLocation;
        this.missionariesRight = missionariesRight;
        this.cannibalsRight = cannibalsRight;
    }

    public boolean isValid() {
        int sum = missionariesLeft + missionariesRight + cannibalsLeft + cannibalsRight;
        int sumLeft = missionariesLeft + cannibalsLeft;
        int sumRight = missionariesRight + cannibalsRight;

        return sum <= 6
                && missionariesLeft >= 0 && missionariesLeft <= 3
                && missionariesRight >= 0 && missionariesRight <= 3
                && (missionariesLeft == 0 || missionariesLeft >= cannibalsLeft)
                && (missionariesRight == 0 || missionariesRight >= cannibalsRight)
                && ((boatLocation == BoatLocation.Left && sumLeft > 0)
                || (boatLocation == BoatLocation.Right && sumRight > 0));
    }

    public boolean isGoal() {
        return missionariesLeft == 0 && cannibalsLeft == 0
                && missionariesRight == 3 && cannibalsRight == 3
                && boatLocation == BoatLocation.Right;
    }

    public int getMissionariesLeft() {
        return missionariesLeft;
    }

    public int getCannibalsLeft() {
        return cannibalsLeft;
    }

    public int getMissionariesRight() {
        return missionariesRight;
    }

    public int getCannibalsRight() {
        return cannibalsRight;
    }

    public BoatLocation getBoatLocation() {
        return boatLocation;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        buffer.append(display('o', missionariesLeft));
        buffer.append(" ");
        buffer.append(display('x', cannibalsLeft));

        if (boatLocation == BoatLocation.Left) {
            buffer.append(" <===>");
        }

        buffer.append("          ");

        if (boatLocation == BoatLocation.Right) {
            buffer.append("<===> ");
        }

        buffer.append(display('O', missionariesRight));
        buffer.append(" ");
        buffer.append(display('X', cannibalsRight));

        return buffer.toString();
    }

    private String display(char symbol, int count) {
        StringBuilder display = new StringBuilder();

        for (int i = 1; i <= 3; i++) {
            if (i <= count) {
                display.append(symbol);
            } else {
                display.append("_");
            }
        }

        return display.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof State)) {
            return false;
        }

        State otherState = (State) obj;

//        System.out.println(missionariesLeft + " == " + otherState.getMissionariesLeft());
//        System.out.println(cannibalsLeft + " == " + otherState.getCannibalsLeft());
//        System.out.println(missionariesRight + " == " + otherState.getMissionariesRight());
//        System.out.println(cannibalsRight + " == " + otherState.getCannibalsRight());
//        System.out.println(boatLocation + " == " + otherState.getBoatLocation());

        return missionariesLeft == otherState.getMissionariesLeft()
                && cannibalsLeft == otherState.getCannibalsLeft()
                && missionariesRight == otherState.getMissionariesRight()
                && cannibalsRight == otherState.getCannibalsRight()
                && boatLocation == otherState.getBoatLocation();
    }
}
