package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public abstract class Tool extends Square{

    Tool(int abyssOrTool,int id, int pos) {
        super(abyssOrTool,id, pos);
        switch (id) {
            case 0 -> title = "Herança";
            case 1 -> title = "Programação Funcional";
            case 2 -> title = "Testes unitários";
            case 3 -> title = "Tratamento de Excepções";
            case 4 -> title = "IDE";
            case 5 -> title = "Ajuda Do Professor";
        }
    }

    @Override
    public abstract String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap);

    public String getTitle() {
        return title;
    }
}