package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class FileNotFound extends Abyss{

    public FileNotFound(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        if (!Catch.class.isAssignableFrom(programmer.getTools().getClass()) &&
                !TeachersHelp.class.isAssignableFrom(programmer.getTools().getClass()) ) {
            programmer.movePlayer(-3,200);
            movePlayerAbyss(boardMap,programmer);
            return "FileNotFound";
        }
        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals("Programação Funcional") || tool.getTitle().equals("Ajuda Do Professor")) {
                programmer.removeTool(tool);
            }
        }
        return "safaste-te";
    }
}
