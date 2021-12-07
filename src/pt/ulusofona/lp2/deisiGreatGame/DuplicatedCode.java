package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class DuplicatedCode extends Abyss{

    public DuplicatedCode(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
            programmer.setPos(programmer.getPosAnterior());
            movePlayerAbyss(boardMap,programmer);
        return "DuplicatedCode";
    }
}
