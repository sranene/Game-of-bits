package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class TestGameManager {

 @Test
 public void test01CreateInitialBoard() {
      GameManager gameManager =  new GameManager();
       String[][] playerInfo ={
                {"28","sranene", "PHP; Java", "Purple"},
                {"31","robroche","Java; C++; Python; Portugues","Blue"},
                {"16","Alberto","Beck","Brown"}
        };
        int boardSize = 28;
        boolean resultado = gameManager.createInitialBoard(playerInfo, boardSize);
        assertTrue(resultado);
 }

 @Test
 public void test02CreateInitialBoard() {

        GameManager gameManager =  new GameManager();
        String[][] playerInfo ={
                {"28","sranene", "PHP; Java", "Purple"},
                {"31","robroche","Java; C++; Python; Portugues","Blue"},
                {"16","Alberto","Beck","Brown"}
        };
        int boardSize = 3;
        boolean resultado = gameManager.createInitialBoard(playerInfo, boardSize);
        assertFalse(resultado);
 }

 @Test
 public void test01getProgrammers() {
        GameManager gameManager =  new GameManager();
        String[][] playerInfo ={
                {"28","sranene", "PHP; Java", "Purple"},
                {"31","robroche","Java; C++; Python; Portugues","Blue"},
                {"16","Alberto","Beck","Brown"}
        };

        int boardSize = 30;
        gameManager.createInitialBoard(playerInfo, boardSize);

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
        String actual = gameManager.getProgrammers(true).toString();

        assertEquals(expected, actual);

 }

 @Test
 public void test01getProgrammersPos() {
        GameManager gameManager =  new GameManager();
        String[][] playerInfo ={
                {"28","sranene", "PHP; Java", "Purple"},
                {"31","robroche","Java; C++; Python; Portugues","Blue"},
                {"16","Alberto","Beck","Brown"}
        };

        int boardSize = 30;
        gameManager.createInitialBoard(playerInfo, boardSize);

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
        String actual = gameManager.getProgrammers(1).toString();

        assertEquals(expected, actual);

 }


 @Test
 public void test01moveCurrentPlayer() {
        GameManager gameManager =  new GameManager();
        String[][] playerInfo ={
                {"28","sranene", "PHP; Java", "Purple"},
                {"31","robroche","Java; C++; Python; Portugues","Blue"},
                {"16","Alberto","Beck","Brown"}
        };
        int boardSize = 30;
        gameManager.createInitialBoard(playerInfo, boardSize);
        assertFalse(gameManager.moveCurrentPlayer(7));

 }

 @Test
 public void test02moveCurrentPlayer() {
        GameManager gameManager =  new GameManager();
        String[][] playerInfo ={
                {"28","sranene", "PHP; Java", "Purple"},
                {"31","robroche","Java; C++; Python; Portugues","Blue"},
                {"16","Alberto","Beck","Brown"}
        };
        int boardSize = 30;
        gameManager.createInitialBoard(playerInfo, boardSize);

        assertTrue(gameManager.moveCurrentPlayer(1));
        assertFalse(gameManager.getProgrammers(2).isEmpty());
        assertEquals(16,gameManager.getProgrammers(2).get(0).getId());

 }

 @Test
 public void test01getImagePng() {
        GameManager gameManager =  new GameManager();
        String[][] playerInfo ={
                {"28","sranene", "PHP; Java", "Purple"},
                {"31","robroche","Java; C++; Python; Portugues","Blue"},
                {"16","Alberto","Beck","Brown"}
        };
        int boardSize = 30;
        gameManager.createInitialBoard(playerInfo, boardSize);

        assertNotEquals("playerPurple.png", gameManager.getImagePng(24));
        assertEquals("glory.png", gameManager.getImagePng(30));
        assertEquals(null, gameManager.getImagePng(9));

 }

 /*testar se dar move current player muda para o outro*/

}
