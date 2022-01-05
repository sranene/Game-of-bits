package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Ide extends Tool {


    Ide(int abyssOrTool, int id, int pos) {
        super(abyssOrTool, id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        this.increaseNumSteps();
        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals("IDE")) {
                return "Já tens este IDE, não achas que te chega?";
            }
        }
        programmer.addTool(this);
        return "Cool, agora podes tentar criar uns programazinhos como deve ser *Ide was added to your inventory*";
    }

}