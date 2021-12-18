package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Catch extends Tool {

    public Catch(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals("Tratamento de Excepções")) {
                return "Já tens esta ferramenta I'm sorry :(";
            }
        }
        programmer.addTool(this);
        return "Uhhh agora podes te safar de algumas exceções bem chatas\n\n *Tratamento de Excepções was added to your inventory*";
    }
}