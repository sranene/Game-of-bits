package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class FileNotFound extends Abyss{

    public FileNotFound(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals("Tratamento de Excepções") || tool.getTitle().equals("Ajuda Do Professor")) {
                programmer.removeTool(tool);
                return "safaste-te";
            }
        }
        programmer.movePlayer(-3,200);
        movePlayerAbyss(boardMap,programmer);
        return "FileNotFound";



    }
}
