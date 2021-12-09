package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Logic extends Abyss{

    public Logic(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap){
        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals("Testes unitários") || tool.getTitle().equals("Ajuda Do Professor")) {
                programmer.removeTool(tool);
                return "safaste-te";
            }
        }
        int positions = -(dado/2);
        programmer.movePlayer(positions, 200);
        movePlayerAbyss(boardMap,programmer);
        return "Logic";

    }
}
