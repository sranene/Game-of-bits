package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Functional extends Tool {

    Functional(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals(this.title)) {
                return "Já tens esta ferramenta otario, não precisas de mais lamento";
            }
        }

        programmer.addTool(this);
        return "Wow que sorte, és o rei!! Apanhaste a ferramenta Programação Funcional!\n\n *Programação Funcional was added to your inventory*";

    }

}