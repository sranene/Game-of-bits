package pt.ulusofona.lp2.deisiGreatGame;

public class Tool {
    int id;
    String title;
    int pos;

    Tool(int id, int pos){
        this.id = id;
        this.pos = pos;
        switch (id){
            case 0 -> title = "Herança";
            case 1 -> title = "Programação Funcional";
            case 2 -> title = "Testes unitários";
            case 3 -> title = "Tratamento de Excepções";
            case 4 -> title = "IDE";
            case 5 -> title = "Ajuda Do Professor";
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