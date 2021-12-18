package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Loop extends Abyss{

    public Loop(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {

        if (boardMap.get(pos).getProgrammers().size() > 1) {
            int count = 0;
            for (int x = 0; x < programmer.getTools().size(); x++) {
                if (programmer.getTools().get(x).getTitle().equals("Programação Funcional")) {
                    programmer.removeTool(programmer.getTools().get(x));
                    count++;
                }
            }
            if (count == 0) {
                programmer.setLoop(true);
                boardMap.get(pos).getProgrammers().get(0).setLoop(false);
                return "Estás num loop infinito.. what the hell were you doing";
            }
            return "Tás safo my friend";

        } else {
            int count = 0;
            if (programmer.getTools() != null && !programmer.getTools().isEmpty()) {
                for (int x = 0; x < programmer.getTools().size(); x++) {
                    if (programmer.getTools().get(x).getTitle().equals("Programação Funcional")) {
                        programmer.removeTool(programmer.getTools().get(x));
                        count++;
                    }
                }
            }

            if (count == 0) {
                programmer.setLoop(true);
                return "Estás num loop infinito.. what the hell were you doing";
            }


        }
        return "Tás safo my friend";
    }

}