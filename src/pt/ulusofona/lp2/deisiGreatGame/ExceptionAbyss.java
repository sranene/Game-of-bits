package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class ExceptionAbyss extends Abyss{


    public ExceptionAbyss(int abyssOrTool, int id, int pos) {
        super(abyssOrTool, id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        this.increaseNumSteps();
        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals("Tratamento de Excepções") || tool.getTitle().equals("Ajuda Do Professor")) {
                programmer.removeTool(tool);
                return "Hummm como tens uma ferramenta para o Exception, estás safo.. *A Tool was removed from your inventory*";
            }
        }
        programmer.movePlayer(-2,200);
        movePlayerAbyss(boardMap,programmer);
        return "Ai ai ai, caiste no Exception.. lamento, mas terás de recuar 2 casas";

    }
}