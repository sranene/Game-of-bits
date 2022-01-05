package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Crash extends Abyss{


    public Crash(int abyssOrTool, int id, int pos) {
        super(abyssOrTool, id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        this.increaseNumSteps();
        programmer.setPos(1);
        movePlayerAbyss(boardMap,programmer);
        return "Bem, parece que vais ter de voltar para a primeira casa, já não ganhas este jogo im sorry";
    }
}