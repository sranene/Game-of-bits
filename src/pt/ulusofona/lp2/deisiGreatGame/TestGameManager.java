package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class TestGameManager {

    GameManager game = new GameManager();

    String[][] playerInfo2 = {
            {"28", "sranene", "PHP; Java", "Purple"},
            {"31", "robroche", "Java; C++; Python; Portugues", "Blue"},
    };
    
    String[][] playerInfo3 = {
            {"28", "sranene", "PHP; Java", "Purple"},
            {"31", "robroche", "Java; C++; Python; Portugues", "Blue"},
            {"16", "Alberto", "Beck", "Brown"}
    };


    @Test
    public void test01CreateInitialBoard() {
        int boardSize = 28;
        boolean resultado = game.createInitialBoard(playerInfo3, boardSize);
        assertTrue(resultado);
    }

    @Test
    public void test02CreateInitialBoard() {
        int boardSize = 3;
        String[][] teste = {};
        boolean resultado = game.createInitialBoard(playerInfo3, boardSize);
        assertFalse(resultado);
        assertFalse(game.createInitialBoard(teste,20));
    }

    @Test
    public void test03CreateInitialBoardValidatePlayerInfo(){
        String[][] teste = {
                {"", "", "", ""},
                {"", "", "", ""}
        };
        assertFalse(game.createInitialBoard(teste,20));
        String[][] teste2 = {
                {"28", "", "", ""},
                {"", "", "", ""}
        };
        assertFalse(game.createInitialBoard(teste2,20));
        String[][] teste3 = {
                {"28", "sranene", "", ""},
                {"", "", "", ""}
        };
        assertFalse(game.createInitialBoard(teste3,20));
        String[][] teste4 = {
                {"28", "sranene", "PHP; Java", ""},
                {"", "", "", ""}
        };
        assertFalse(game.createInitialBoard(teste4,20));
        String[][] teste5 = {
                {"28", "sranene", "PHP; Java", "Green"},
                {"-2", "robroche", "Java", "Purple"}
        };
        assertFalse(game.createInitialBoard(teste5,20));
        String[][] teste6 = {
                {"28","sranene","PHP; Java","Green"},
                {"28","robroche","Python","Purple"}
        };
        assertFalse(game.createInitialBoard(teste6,20));
        String[][] teste7 = {
                {"28","sranene","PHP; Java","Green"},
                {"31","robroche","Python","Black"}
        };
        assertFalse(game.createInitialBoard(teste7,20));
        String[][] teste8 = {
                {"28","sranene","PHP; Java","Green"},
                {"31","robroche","Python","Brown"},
                {"16","Alberto","Beck","Green"}
        };
        assertFalse(game.createInitialBoard(teste8,20));
        String[][] teste9 = {
                {"28","sranene","PHP; Java","Green"},
                {"31","robroche","Python","Brown"},
                {"16","Alberto","Beck","Purple"},
                {"1","Actual :","Spanish(no)","Blue"}
        };
        assertTrue(game.createInitialBoard(teste9,20));
        game.moveCurrentPlayer(4);
        game.createInitialBoard(teste9,20);
    }


    @Test
    public void test01getProgrammers() {


        int boardSize = 30;
        game.createInitialBoard(playerInfo3, boardSize);
        String[] languages1 = {"PHP", "Java"};
        String[] languages2 = {"Java", "C++", "Python", "Portugues"};
        String[] languages3 = {"Beck"};
        TreeSet<String> tree1 = new TreeSet<>(Arrays.asList(languages1));
        TreeSet<String> tree2 = new TreeSet<>(Arrays.asList(languages2));
        TreeSet<String> tree3 = new TreeSet<>(Arrays.asList(languages3));


        Programmer player1 = new Programmer("sranene", 28, tree1, ProgrammerColor.PURPLE);
        Programmer player2 = new Programmer("robroche", 31, tree2, ProgrammerColor.BLUE);
        Programmer player3 = new Programmer("Alberto", 16, tree3, ProgrammerColor.BROWN);

        ArrayList<Programmer> programmers = new ArrayList<>();
        programmers.add(player3);
        programmers.add(player1);
        programmers.add(player2);

        String expected = programmers.toString();
        String actual = game.getProgrammers(true).toString();

        assertEquals(expected, actual);

    }

    @Test
    public void test01getProgrammersPos() {


        String[][] teste = {};
        int boardSize = 30;
        game.createInitialBoard(playerInfo3, boardSize, teste);

        String[] languages1 = {"PHP", "Java"};
        String[] languages2 = {"Java", "C++", "Python", "Portugues"};
        String[] languages3 = {"Beck"};
        TreeSet<String> tree1 = new TreeSet<>(Arrays.asList(languages1));
        TreeSet<String> tree2 = new TreeSet<>(Arrays.asList(languages2));
        TreeSet<String> tree3 = new TreeSet<>(Arrays.asList(languages3));


        Programmer player1 = new Programmer("sranene", 28, tree1, ProgrammerColor.PURPLE);
        Programmer player2 = new Programmer("robroche", 31, tree2, ProgrammerColor.BLUE);
        Programmer player3 = new Programmer("Alberto", 16, tree3, ProgrammerColor.BROWN);

        ArrayList<Programmer> programmers = new ArrayList<>();
        programmers.add(player3);
        programmers.add(player1);
        programmers.add(player2);

        String expected = programmers.toString();
        String actual = game.getProgrammers(1).toString();

        assertEquals(expected, actual);

    }


    @Test
    public void test01moveCurrentPlayer() {

        int boardSize = 30;
        game.createInitialBoard(playerInfo3, boardSize);
        assertFalse(game.moveCurrentPlayer(7));

    }

    @Test
    public void test02moveCurrentPlayer() {

        String[][] mostrarAInes = {};
        int boardSize = 30;
        game.createInitialBoard(playerInfo3, boardSize, mostrarAInes);

        assertTrue(game.moveCurrentPlayer(1));
        assertFalse(game.getProgrammers(2).isEmpty());
        assertEquals(16, game.getProgrammers(2).get(0).getId());

    }

    @Test
    public void test01getImagePng() {


        String[][] mostrarAInes = {};
        game.createInitialBoard(playerInfo3, 30, mostrarAInes);

        assertNotEquals("playerPurple.png", game.getImagePng(24));
        assertEquals("glory.png", game.getImagePng(30));
        assertNull(game.getImagePng(9));

    }

    @Test
    public void test01getProgrammersInfo() {


        String[][] mostrarAInes = {};
        game.createInitialBoard(playerInfo3, 30, mostrarAInes);
        game.moveCurrentPlayer(1);
        Functional functional = new Functional(1, 2);
        game.currentPlayer.addTool(functional);

        assertEquals("Alberto : Programação Funcional | sranene : No tools | robroche : No tools", game.getProgrammersInfo());
    }

    @Test
    public void test01getProgrammersInfoCatchesSameTool() {


        String[][] mostrarAInes = {};
        game.createInitialBoard(playerInfo3, 30, mostrarAInes);
        game.moveCurrentPlayer(1);
        Functional functional = new Functional(1, 2);
        functional.react(game.currentPlayer, 1, game.boardMap);
        game.moveCurrentPlayer(3);
        functional.react(game.currentPlayer, 3, game.boardMap);
        game.moveCurrentPlayer(3);
        functional.react(game.currentPlayer, 3, game.boardMap);
        game.moveCurrentPlayer(6);
        functional.react(game.currentPlayer, 6, game.boardMap);

        assertEquals("Alberto : Programação Funcional | sranene : No tools | robroche : No tools", game.getProgrammersInfo());

    }

    @Test
    public void test01BlueScreen(){
        String[][] abyss ={
            { "0", "7", "8" }
        };

        assertTrue(game.createInitialBoard(playerInfo3, 30, abyss));
        game.moveCurrentPlayer(6);//Alberto vai po 7
        game.reactToAbyssOrTool();
        game.moveCurrentPlayer(4);//sranene vai po 5
        game.reactToAbyssOrTool();
        game.moveCurrentPlayer(5);//robroche vai po 6
        game.reactToAbyssOrTool();
        game.moveCurrentPlayer(1);//ALberto perde pos 8
        game.reactToAbyssOrTool();
        game.moveCurrentPlayer(4);//sranene vai po 9
        game.reactToAbyssOrTool();
        game.moveCurrentPlayer(5);//robroche vai po 11
        game.reactToAbyssOrTool();
        game.moveCurrentPlayer(3);//sranene vai po 12
        game.reactToAbyssOrTool();
        game.moveCurrentPlayer(6);//robroche vai po 17
        game.reactToAbyssOrTool();


        assertEquals(8,game.getProgrammers(true).get(0).getPos());
        assertEquals(12,game.getProgrammers(true).get(1).getPos());
        assertEquals(17,game.getProgrammers(true).get(2).getPos());
    }

    @Test
    public void test01GameResultsBlueScreen(){
        String[][] abyss ={
                { "0", "7", "8" }
        };
        ArrayList<String> results = new ArrayList<>();
        assertTrue(game.createInitialBoard(playerInfo3, 30, abyss));
        game.moveCurrentPlayer(6);//Alberto vai po 7
        game.reactToAbyssOrTool();
        assertFalse(game.gameIsOver());
        game.moveCurrentPlayer(4);//sranene vai po 5
        game.reactToAbyssOrTool();
        assertFalse(game.gameIsOver());
        game.moveCurrentPlayer(5);//robroche vai po 6
        game.reactToAbyssOrTool();
        assertFalse(game.gameIsOver());
        game.moveCurrentPlayer(1);//ALberto perde pos 8
        game.reactToAbyssOrTool();
        assertFalse(game.gameIsOver());
        game.moveCurrentPlayer(3);//sranene vai po 8
        game.reactToAbyssOrTool();
        assertTrue(game.gameIsOver());

        results.add("O GRANDE JOGO DO DEISI");
        results.add("");
        results.add("NR. DE TURNOS");
        results.add("" + 6);
        results.add("");
        results.add("VENCEDOR");
        results.add("robroche");
        results.add("");
        results.add("RESTANTES");
        results.add("Alberto 8");
        results.add("sranene 8");
        assertEquals(results,game.getGameResults());
    }

    @Test
    public void test01ProgrammersInfoBlueScreen(){
        String[][] abyss ={
                { "0", "7", "8" }
        };
        assertTrue(game.createInitialBoard(playerInfo3, 30, abyss));
        game.moveCurrentPlayer(6);//Alberto vai po 7
        game.reactToAbyssOrTool();
        game.moveCurrentPlayer(4);//sranene vai po 5
        game.reactToAbyssOrTool();
        game.moveCurrentPlayer(5);//robroche vai po 6
        game.reactToAbyssOrTool();
        game.moveCurrentPlayer(1);//ALberto perde pos 8
        game.reactToAbyssOrTool();
        game.moveCurrentPlayer(6);//sranene vai po 8
        game.reactToAbyssOrTool();



        assertEquals("sranene : No tools | robroche : No tools",game.getProgrammersInfo());
    }


}





