package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Loop extends Abyss{

    public Loop(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {

        programmer.setLoop(true);
        return "Loop";
    }
}
