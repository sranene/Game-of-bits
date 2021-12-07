package pt.ulusofona.lp2.deisiGreatGame;

public class Exception extends Abyss{

    public Exception(int id, int pos) {
        super(id, pos);
    }

    @Override
    public void react(Programmer programmer,int dado) {
        programmer.movePlayer(-2,200);
    }
}

