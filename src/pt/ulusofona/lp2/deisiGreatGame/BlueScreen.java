package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class BlueScreen extends Abyss{


    public BlueScreen(int abyssOrTool, int id, int pos) {
        super(abyssOrTool, id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        this.increaseNumSteps();
        programmer.gotDefeated();
        return "AHAHAHAH GG";
    }
}