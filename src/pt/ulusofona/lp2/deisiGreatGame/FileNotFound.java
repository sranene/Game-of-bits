package pt.ulusofona.lp2.deisiGreatGame;

public class FileNotFound extends Abyss{

    public FileNotFound(int id, int pos) {
        super(id, pos);
    }

    @Override
    public void react(Programmer programmer,int dado) {
        programmer.movePlayer(-2,200);
    }
}
