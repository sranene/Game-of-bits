package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class UnitTests extends Tool{

    UnitTests(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals("Testes unitários")) {
                return "Não podes apanhar a ferramenta Testes unitários, porque já a tens, move along";
            }
        }
        programmer.addTool(this);
        return "Aff.. lá vais ter de inventar uns testes quaisquer.. *Testes unitários was added to your inventory*";
    }

}