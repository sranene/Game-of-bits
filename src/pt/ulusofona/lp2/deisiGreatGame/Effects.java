package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Effects extends Abyss{

    public Effects(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        programmer.setPos(programmer.getPosAnteriorAnterior());
        movePlayerAbyss(boardMap,programmer);
        return "Effects";
    }
}
