package pt.ulusofona.lp2.deisiGreatGame;

public class Logic extends Abyss{

    public Logic(int id, int pos) {
        super(id, pos);
    }

    @Override
    public void react(Programmer programmer, int dado){
        int positions = -(dado/2);
        programmer.movePlayer(positions, 200);
    }
}
