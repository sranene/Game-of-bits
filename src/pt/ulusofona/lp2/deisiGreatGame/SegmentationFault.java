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
            for(Tool tool : programmer.getTools()){
                if(tool.getTitle().equals("Tratamento de Excepções")){
                    count++;
                    programmer.removeTool(tool);
                }
            }
            if(count == 0){
                int programmersSize = programmers.size();
                for (int x = 0; x< programmersSize;x++){
                    programmers.get(0).movePlayer(-3,200);
                    movePlayerAbyss(boardMap,programmers.get(0));
                }

                return "Vish tão todos com um SegmentationFault, este aqui é lixado..";
            }

            return "Very very very lucky.. *A Tool was removed from your inventory*";
        }

        return "Tás safo por enquanto...";

    }
}