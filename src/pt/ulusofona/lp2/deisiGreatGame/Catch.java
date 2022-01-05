package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Catch extends Tool {


    Catch(int abyssOrTool, int id, int pos) {
        super(abyssOrTool, id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        this.increaseNumSteps();
        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals("Tratamento de Excepções")) {
                return "Já tens esta ferramenta I'm sorry :(";
            }
        }
        programmer.addTool(this);
        return "Uhhh agora podes te safar de algumas exceções bem chatas *Tratamento de Excepções was added to your inventory*";
    }
}