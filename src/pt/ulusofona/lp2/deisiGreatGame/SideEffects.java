package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class SideEffects extends Abyss{

    public SideEffects(int abyssOrTool, int id, int pos) {
        super(abyssOrTool, id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {

        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals("Programação Funcional")) {
                programmer.removeTool(tool);
                return "Não tiveste efeitos secundários.. mas toma cuidadinho, nunca se sabe.. *A Tool was removed from your inventory*";
            }
        }

        programmer.setPos(programmer.getPosAnteriorAnterior());
        movePlayerAbyss(boardMap,programmer);
        return "Hehe bem burro, ficaste com efeitos secundários," +
                "volta para a casa onde estavas antes da onde estavas :DDD";
    }
}