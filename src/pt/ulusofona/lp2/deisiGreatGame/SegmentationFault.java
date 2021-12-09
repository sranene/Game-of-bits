package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class SegmentationFault extends Abyss{

    public SegmentationFault(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        // verificar se existem dois jogadores nesta casa

        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals("Tratamento de Excepções") && boardMap.get(programmer.getPos()).getProgrammers().size() == 2) {
                programmer.removeTool(tool);
                return "safaste-te";
            }
        }
        if (boardMap.get(this.pos).getProgrammers().size() == 2) {
            for(Programmer programmer1 : getProgrammers()) {
                programmer1.movePlayer(-3, 200);
                movePlayerAbyss(boardMap, programmer1);
            }
            return "SegmentationFault";
        }

    return "Tas safo por enquanto";

    }
}
