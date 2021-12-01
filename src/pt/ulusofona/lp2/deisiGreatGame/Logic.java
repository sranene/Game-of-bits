package pt.ulusofona.lp2.deisiGreatGame;

public class Logic extends Abyss{

    public Logic(int id, int pos) {
        super(id, pos);
    }

    public void logic(Programmer programmer){
        programmer.movePlayer(-2,200);
    }

}
