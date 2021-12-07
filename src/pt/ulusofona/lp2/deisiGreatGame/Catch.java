package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Catch extends Tool {

    public Catch(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        if (!programmer.getTools().contains(this)){
            programmer.addTool(this);
        }
        return "Catch";
    }
}
