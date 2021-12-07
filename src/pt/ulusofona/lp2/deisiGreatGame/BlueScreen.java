package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class BlueScreen extends Abyss{

    public BlueScreen(int id, int pos) {
        super(id, pos);
}

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        programmer.gotDefeated();
        return "BlueScreen";
    }
}
