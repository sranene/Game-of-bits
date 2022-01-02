package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class DuplicatedCode extends Abyss {


    public DuplicatedCode(int abyssOrTool, int id, int pos) {
        super(abyssOrTool, id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer, Square> boardMap) {
        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals("Herança")) {
                programmer.removeTool(tool);
                return "Muito bem, usaste a Herança para evitar código duplicado...até dás a ideia de que és inteligente *A Tool was removed from your inventory*";
            }
        }
        programmer.setPos(programmer.getPosAnterior());
        movePlayerAbyss(boardMap, programmer);
        return "Oops, parece que agora tens código a duplicar, volta lá pra casa onde tavas, maroto";
    }

}