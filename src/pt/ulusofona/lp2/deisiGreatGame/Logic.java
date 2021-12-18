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
                return "Não tens erros de lógica no teu código pelos vistos *A Tool was removed from your inventory*";
            }
        }
        int positions = -(dado/2);
        programmer.movePlayer(positions, 200);
        movePlayerAbyss(boardMap,programmer);
        return "Elahhh lamento informar, mas parece que estás com uns erros de código, volta para trás e trata lá disso";

    }
}