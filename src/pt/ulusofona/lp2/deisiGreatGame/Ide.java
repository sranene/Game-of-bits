package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Ide extends Tool {

    Ide(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals("IDE")) {
                return "Já tens";
            }
        }
        programmer.addTool(this);
        return "IDE";
    }

}
