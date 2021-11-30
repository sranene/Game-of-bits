package pt.ulusofona.lp2.deisiGreatGame;

public class Abyss {
    int id;
    String title;
    int pos;

    public Abyss (int id, int pos) {
        this.id = id;
        this.pos = pos;
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

    public int getId() {
        return id;
    }

    public int getPos() {
        return pos;
    }

    public String getTitle(){
        return title;
    }
}
