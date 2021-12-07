package pt.ulusofona.lp2.deisiGreatGame;

public abstract class Abyss extends Square {

    public Abyss(int id, int pos) {
        super(id, pos);
        switch (id) {
            case 0 -> title = "Erro de sintaxe";
            case 1 -> title = "Erro de lógica";
            case 2 -> title = "Exception";
            case 3 -> title = "File Not Found Exception";
            case 4 -> title = "Crash (aka Rebentanço)";
            case 5 -> title = "Duplicated Code";
            case 6 -> title = "Efeitos secundários";
            case 7 -> title = "Blue Screen of Death";
            case 8 -> title = "Ciclo infinito";
            case 9 -> title = "Segmentation Fault";
            default -> title = "";
        }
    }


    @Override
    public abstract void react(Programmer programmer, int dado);


    public int getId() {
        return id;
    }

    public int getPos() {
        return pos;
    }

    public String getTitle() {
        return title;
    }
}
