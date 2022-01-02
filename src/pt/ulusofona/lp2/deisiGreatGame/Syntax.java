package pt.ulusofona.lp2.deisiGreatGame;

        import java.util.TreeMap;

public class Syntax extends Abyss{

    public Syntax(int abyssOrTool, int id, int pos) {
        super(abyssOrTool, id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals("Ajuda Do Professor") || tool.getTitle().equals("IDE")) {
                programmer.removeTool(tool);
                return "Nice my friend, não tens erros de sintaxe no código *A Tool was removed from your inventory*";
            }
        }
        programmer.movePlayer(-1,200);
        movePlayerAbyss(boardMap,programmer);
        return "You look dumb, erro de sintaxe???? Isso é bem fácil de detetar.. recua 1 casa";

    }
}