package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Inheritance extends Tool {

    Inheritance(int abyssOrTool, int id, int pos) {
        super(abyssOrTool, id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        this.increaseNumSteps();
        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals("Herança")) {
                return "Já tens a ferramenta Herança, excusas de tentar apanhar outra vez," +
                        " o teu pai já não volta";
            }
        }
        programmer.addTool(this);
        return "Parabéns! Ganhaste a habilidade de fazer herança no teu programa, aproveita colega *Herança was added to your inventory*";
    }
}