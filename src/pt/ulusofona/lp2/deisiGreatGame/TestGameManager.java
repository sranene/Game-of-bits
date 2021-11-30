package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class TestGameManager {

 @Test
 public void test01CreateInitialBoard() {

       /* String[][] playerInfo ={
                {"28","sranene", "PHP; Java", "Purple"},
                {"31","robroche","Java; C++; Python; Portugues","Blue"},
                {"16","Alberto","Beck","Brown"}
        };
        int boardSize = 28;
        boolean resultado = GameManager.createInitialBoard(playerInfo, boardSize);
        assertTrue(resultado);*/
 }

 @Test
 public void test02CreateInitialBoard() {
/*
        String[][] playerInfo ={
                {"28","sranene", "PHP; Java", "Purple"},
                {"31","robroche","Java; C++; Python; Portugues","Blue"},
                {"16","Alberto","Beck","Brown"}
        };
        int boardSize = 3;
        boolean resultado = GameManager.createInitialBoard(playerInfo, boardSize);
        assertFalse(resultado);*/
 }

 @Test
 public void test01getProgrammers() {
/*
        String[][] playerInfo ={
                {"28","sranene", "PHP; Java", "Purple"},
                {"31","robroche","Java; C++; Python; Portugues","Blue"},
                {"16","Alberto","Beck","Brown"}
        };

        int boardSize = 30;
        GameManager.createInitialBoard(playerInfo, boardSize);

        String[] languages1 = {"PHP", "Java"};
        String[] languages2 = {"Java", "C++", "Python", "Portugues"};
        String[] languages3 = {"Beck"};
        TreeSet<String> tree1 = new TreeSet<>(Arrays.asList(languages1));
        TreeSet<String> tree2 = new TreeSet<>(Arrays.asList(languages2));
        TreeSet<String> tree3 = new TreeSet<>(Arrays.asList(languages3));


        Programmer player1 = new Programmer("sranene",28, tree1, ProgrammerColor.PURPLE);
        Programmer player2 = new Programmer("robroche",31, tree2, ProgrammerColor.BLUE);
        Programmer player3 = new Programmer("Alberto",16, tree3, ProgrammerColor.BROWN);

        ArrayList<Programmer> programmers = new ArrayList<>();
        programmers.add(player3);
        programmers.add(player1);
        programmers.add(player2);

        String expected = programmers.toString();
        String actual = GameManager.getProgrammers().toString();

        assertEquals(expected, actual);*/

 }

 @Test
 public void test01getProgrammersPos() {
/*
        String[][] playerInfo ={
                {"28","sranene", "PHP; Java", "Purple"},
                {"31","robroche","Java; C++; Python; Portugues","Blue"},
                {"16","Alberto","Beck","Brown"}
        };

        int boardSize = 30;
        GameManager.createInitialBoard(playerInfo, boardSize);

        String[] languages1 = {"PHP", "Java"};
        String[] languages2 = {"Java", "C++", "Python", "Portugues"};
        String[] languages3 = {"Beck"};
        TreeSet<String> tree1 = new TreeSet<>(Arrays.asList(languages1));
        TreeSet<String> tree2 = new TreeSet<>(Arrays.asList(languages2));
        TreeSet<String> tree3 = new TreeSet<>(Arrays.asList(languages3));


        Programmer player1 = new Programmer("sranene",28, tree1, ProgrammerColor.PURPLE);
        Programmer player2 = new Programmer("robroche",31, tree2, ProgrammerColor.BLUE);
        Programmer player3 = new Programmer("Alberto",16, tree3, ProgrammerColor.BROWN);

        ArrayList<Programmer> programmers = new ArrayList<>();
        programmers.add(player3);
        programmers.add(player1);
        programmers.add(player2);

        String expected = programmers.toString();
        String actual = GameManager.getProgrammers(1).toString();

        assertEquals(expected, actual);*/

 }


 @Test
 public void test01moveCurrentPlayer() {
/*
        String[][] playerInfo ={
                {"28","sranene", "PHP; Java", "Purple"},
                {"31","robroche","Java; C++; Python; Portugues","Blue"},
                {"16","Alberto","Beck","Brown"}
        };
        int boardSize = 30;
        GameManager.createInitialBoard(playerInfo, boardSize);

        assertFalse(GameManager.moveCurrentPlayer(7));
*/
 }

 @Test
 public void test02moveCurrentPlayer() {
/*
        String[][] playerInfo ={
                {"28","sranene", "PHP; Java", "Purple"},
                {"31","robroche","Java; C++; Python; Portugues","Blue"},
                {"16","Alberto","Beck","Brown"}
        };
        int boardSize = 30;
        GameManager.createInitialBoard(playerInfo, boardSize);

        assertTrue(GameManager.moveCurrentPlayer(1));*/

 }

 @Test
 public void test01getImagePng() {
/*
        String[][] playerInfo ={
                {"28","sranene", "PHP; Java", "Purple"},
                {"31","robroche","Java; C++; Python; Portugues","Blue"},
                {"16","Alberto","Beck","Brown"}
        };
        int boardSize = 30;
        GameManager.createInitialBoard(playerInfo, boardSize);

        assertFalse(GameManager.getImagePng(24).equals("playerPurple.png"));
        assertTrue(GameManager.getImagePng(30).equals("glory.png"));
        assertEquals("blank.png", GameManager.getImagePng(9));*/

 }


}
