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
            for (Tool tool : boardMap.get(pos).getProgrammers().get(boardMap.get(pos).getProgrammers().size() - 1).getTools()) {
                if (tool.getTitle().equals("Tratamento de Excepções")) {
                    count++;
                    programmer.removeTool(tool);
                }
            }
            if (count == 0) {
                programmer.setLoop(true);
                boardMap.get(pos).getProgrammers().get(0).setLoop(false);
                return "tas preso";
            }
            return "safaste-te";
        } else {
            programmer.setLoop(true);
        }
        return "Loop";
    }

}
