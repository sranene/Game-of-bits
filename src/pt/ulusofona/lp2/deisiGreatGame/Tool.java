package pt.ulusofona.lp2.deisiGreatGame;

public class Tool extends Square{

    Tool(int id, int pos) {
        super(id, pos);
        switch (id) {
            case 0 -> title = "Herança";
            case 1 -> title = "Programação Funcional";
            case 2 -> title = "Testes unitários";
            case 3 -> title = "Tratamento de Excepções";
            case 4 -> title = "IDE";
            case 5 -> title = "Ajuda Do Professor";
            default -> title = "";
        }
    }


}