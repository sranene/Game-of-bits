package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Syntax extends Abyss{

    public Syntax(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals("Ajuda Do Professor") || tool.getTitle().equals("IDE")) {
                programmer.removeTool(tool);
                return "safaste-te";
            }
        }
        programmer.movePlayer(-1,200);
        movePlayerAbyss(boardMap,programmer);
        return "Syntax";

    }
}
