package pt.ulusofona.lp2.deisiGreatGame;

public class Perk {
    Abyss abyss = null;
    Tool tool = null;

    Perk(Abyss abyss){
        this.abyss = abyss;
    }

    Perk(Tool tool){
        this.tool = tool;
    }

    public Abyss getAbyss() {
        return abyss;
    }

    public Tool getTool() {
        return tool;
    }

    public int toolOrAbyss(){
        if (tool == null && abyss == null){
            return -1;
        } else if (abyss == null) {
            return 1; // retorna 1 porque é uma tool
        } else {
            return 0; // retorna 0 porque é um abyss
        }
    }


}
