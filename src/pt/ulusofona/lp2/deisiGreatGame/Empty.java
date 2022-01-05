package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Empty extends Square {

    public Empty(int pos) {
        super(pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        this.increaseNumSteps();
        return null;
    }

}
