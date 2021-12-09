package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Functional extends Tool {

    Functional(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals("Programação Funcional")) {
                return "Já tens";
            }
        }
        programmer.addTool(this);
        return "Functional";

    }

}
