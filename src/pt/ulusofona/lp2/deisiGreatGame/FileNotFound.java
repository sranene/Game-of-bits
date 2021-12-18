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
                return "Tás com sorte, não tens de recuar 3 casas *A Tool was removed from your inventory*";
            }
        }
        programmer.movePlayer(-3,200);
        movePlayerAbyss(boardMap,programmer);
        return "Algo não está certo.. FileNotFoundException!! Im sorry, vais ter de recuar 3 casas amigo";



    }
}