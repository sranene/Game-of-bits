package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;


import static org.junit.Assert.*;

public class TestGameManager {

    @Test
    public void test01() {

        //TreeSet<String> languages = new TreeSet<>();
        //languages.add("Java");
        //languages.add("PHP");
        //ProgrammerColor color = ProgrammerColor.PURPLE;
        //Programmer programmer = new Programmer("sranene",3,languages , color);

        String[][] playerInfo ={
                {"28","sranene", "PHP; Java", "Purple"},
                {"31","robroche","Java; C++; Python; Portugues","Blue"},
                {"16","Alberto","Beck","Brown"}
        };

        int boardSize = 28;
        boolean resultado = GameManager.createInitialBoard(playerInfo, boardSize);
        assertTrue(resultado);
    }


}
