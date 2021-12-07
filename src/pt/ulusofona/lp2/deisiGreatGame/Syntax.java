package pt.ulusofona.lp2.deisiGreatGame;

public class Syntax extends Abyss{

    public Syntax(int id, int pos) {
        super(id, pos);
    }

    @Override
    public void react(Programmer programmer,int dado) {
        programmer.movePlayer(-1,200);
    }
}
