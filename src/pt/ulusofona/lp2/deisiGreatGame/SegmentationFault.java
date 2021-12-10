package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class SegmentationFault extends Abyss{

    public SegmentationFault(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        // verificar se existem dois jogadores nesta casa

        if (boardMap.get(pos).getProgrammers().size() > 1) {
            int count = 0;
            for(Tool tool : boardMap.get(pos).getProgrammers().get(boardMap.get(pos).getProgrammers().size()-1).getTools()){
                if(tool.getTitle().equals("Tratamento de Excepções")){
                    count++;
                    programmer.removeTool(tool);
                }
            }
            if(count == 0){
                for (Programmer programmer1 : getProgrammers()){
                    programmer1.movePlayer(-3,200);
                    movePlayerAbyss(boardMap,programmer1);
                }
            }
            return "SegmentationFault";
        }

        return "Tas safo por enquanto";

    }
}
