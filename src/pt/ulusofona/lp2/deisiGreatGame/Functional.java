package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Functional extends Tool {

    Functional(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
            if (programmer.getToolsTitle().contains(this.title)) {
                return "Já tens";
            }
        programmer.addTool(this);
        programmer.addToolTitle(this.title);
        return "Functional";
    }

}
