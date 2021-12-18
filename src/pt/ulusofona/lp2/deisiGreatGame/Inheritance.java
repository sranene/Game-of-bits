package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Inheritance extends Tool {

    Inheritance(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals("Herança")) {
                return "Já tens a ferramenta Herança, excusas de tentar apanhar outra vez," +
                        " o teu pai já não volta";
            }
        }
        programmer.addTool(this);
        return "Parabéns! Ganhaste a habilidade de fazer herança no teu programa, aproveita colega\n\n *Herança was added to your inventory*";
    }
}