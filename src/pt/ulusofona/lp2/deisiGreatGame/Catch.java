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
        return "Uhhh apanhaste a ferramenta Tratamento de Excepções, agora podes te safar de alguns problemas bem chatos";
    }
}