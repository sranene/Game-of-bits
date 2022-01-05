package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Functional extends Tool {


    Functional(int abyssOrTool, int id, int pos) {
        super(abyssOrTool, id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        this.increaseNumSteps();
        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals(this.title)) {
                return "Já tens esta ferramenta, não precisas de mais lamento";
            }
        }

        programmer.addTool(this);
        return "Wow que sorte, és o rei!!!!!!! *Programação Funcional was added to your inventory*";

    }

}