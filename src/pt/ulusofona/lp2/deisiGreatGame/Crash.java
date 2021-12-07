package pt.ulusofona.lp2.deisiGreatGame;

public class Crash extends Abyss{

    public Crash(int id, int pos) {
        super(id, pos);
    }

    @Override
    public void react(Programmer programmer,int dado) {
        int pos = programmer.getPos();
        pos -=1;
        programmer.movePlayer(-pos,200);
    }
}
