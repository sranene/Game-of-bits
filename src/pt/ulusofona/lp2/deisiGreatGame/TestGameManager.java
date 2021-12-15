package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class TestGameManager {

    GameManager game = new GameManager();

    String[][] abyssesAndTools = {};

    String[][] playerInfo = {
            {"28", "sranene", "PHP; Java", "Purple"},
            {"31", "robroche", "Java; C++; Python; Portugues", "Blue"},
            {"16", "Alberto", "Beck", "Brown"}
    };

    @Test
    public void test01CreateInitialBoard() {
        int boardSize = 28;
        boolean resultado = game.createInitialBoard(playerInfo, boardSize);
        assertTrue(resultado);
    }

    @Test
    public void test02CreateInitialBoard() {
        int boardSize = 3;
        String[][] teste = {};
        boolean resultado = game.createInitialBoard(playerInfo, boardSize, null);
        assertFalse(resultado);
        assertFalse(game.createInitialBoard(teste,20, null));
    }

    @Test
    public void test03CreateInitialBoardValidatePlayerInfo(){
        String[][] teste = {
                {"28","sranene","PHP; Java","Green"}
        };
        assertFalse(game.createInitialBoard(teste,20));
        String[][] teste0 = {
                {"28","sranene"," ","Green"},
                {"31","robroche","Python","Purple"}
        };
        assertFalse(game.createInitialBoard(teste0,20, null));
        String[][] teste1 = {
                {"", "", "", ""},
                {"", "", "", ""}
        };
        assertFalse(game.createInitialBoard(teste1,20, null));
        String[][] teste2 = {
                {"28", "", "", ""},
                {"", "", "", ""}
        };
        assertFalse(game.createInitialBoard(teste2,20, null));
        String[][] teste3 = {
                {"28", "sranene", "", ""},
                {"", "", "", ""}
        };
        assertFalse(game.createInitialBoard(teste3,20, null));
        String[][] teste4 = {
                {"28", "sranene", "PHP; Java", ""},
                {"", "", "", ""}
        };
        assertFalse(game.createInitialBoard(teste4,20, null));
        String[][] teste5 = {
                {"28", "sranene", "PHP; Java", "Green"},
                {"-2", "robroche", "Java", "Purple"}
        };
        assertFalse(game.createInitialBoard(teste5,20, null));
        String[][] teste6 = {
                {"28","sranene","PHP; Java","Green"},
                {"28","robroche","Python","Purple"}
        };
        assertFalse(game.createInitialBoard(teste6,20, null));
        String[][] teste7 = {
                {"28","sranene","PHP; Java","Green"},
                {"31","robroche","Python","Black"}
        };
        assertFalse(game.createInitialBoard(teste7,20, null));
        String[][] teste8 = {
                {"28","sranene","PHP; Java","Green"},
                {"31","robroche","Python","Brown"},
                {"16","Alberto","Beck","Green"}
        };
        assertFalse(game.createInitialBoard(teste8,20, null));
        String[][] teste9 = {
                {"28","sranene","PHP; Java","Green"},
                {"31","robroche","Python","Brown"},
                {"16","Alberto","Beck","Purple"},
                {"1","Actual :","Spanish(no)","Blue"}
        };
        assertTrue(game.createInitialBoard(teste9,20, null));

        game.moveCurrentPlayer(4);
        game.createInitialBoard(teste9,20, null);

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
        game.createInitialBoard(playerInfo, boardSize, teste);

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
        programmers.add(player2);
        programmers.add(player1);

        String expected = programmers.toString();
        String actual = game.getProgrammers(1).toString();

        assertEquals(expected, actual);

    }


    @Test
    public void test01moveCurrentPlayer() {
        int boardSize = 30;
        game.createInitialBoard(playerInfo, boardSize);
        assertFalse(game.moveCurrentPlayer(7));

    }

    @Test
    public void test02moveCurrentPlayer() {
        int boardSize = 30;
        game.createInitialBoard(playerInfo, boardSize, abyssesAndTools);

        assertTrue(game.moveCurrentPlayer(1));
        assertFalse(game.getProgrammers(2).isEmpty());
        assertEquals(16, game.getProgrammers(2).get(0).getId());

    }

    @Test
    public void test01getImagePng() {

        game.createInitialBoard(playerInfo, 30, abyssesAndTools);

        assertNotEquals("playerPurple.png", game.getImagePng(24));
        assertEquals("glory.png", game.getImagePng(30));
        assertNull(game.getImagePng(9));

    }

    @Test
    public void test02getImagePng() {

        game.createInitialBoard(playerInfo, 30, abyssesAndTools);
        assertNull(game.getImagePng(0));

    }

    @Test
    public void test03getImagePng() {

        String[][] abyssesAndTools = {
                {"1","0","1"},
                {"1","1","2"},
                {"1","2","3"},
                {"1","3","4"},
                {"1","4","5"},
                {"1","5","6"},
                {"0","0","7"},
                {"0","1","8"},
                {"0","2","9"},
                {"0","3","10"},
                {"0","4","11"},
                {"0","5","12"},
                {"0","6","13"},
                {"0","7","14"},
                {"0","8","15"},
                {"0","9","16"}
        };
        game.createInitialBoard(playerInfo, 30, abyssesAndTools);

        assertEquals("inheritance.png", game.getImagePng(1));
        assertEquals("functional.png", game.getImagePng(2));
        assertEquals("unit-tests.png", game.getImagePng(3));
        assertEquals("catch.png", game.getImagePng(4));
        assertEquals("IDE.png", game.getImagePng(5));
        assertEquals("ajuda-professor.png", game.getImagePng(6));
        assertEquals("syntax.png", game.getImagePng(7));
        assertEquals("logic.png", game.getImagePng(8));
        assertEquals("exception.png", game.getImagePng(9));
        assertEquals("file-not-found-exception.png", game.getImagePng(10));
        assertEquals("crash.png", game.getImagePng(11));
        assertEquals("duplicated-code.png", game.getImagePng(12));
        assertEquals("secondary-effects.png", game.getImagePng(13));
        assertEquals("bsod.png", game.getImagePng(14));
        assertEquals("infinite-loop.png", game.getImagePng(15));
        assertEquals("core-dumped.png", game.getImagePng(16));

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

    @Test
    public void test01getCurrentPlayerID() {
        String[][] mostrarAInes = {};
        game.createInitialBoard(playerInfo, 30, mostrarAInes);

        assertEquals(16, game.getCurrentPlayerID());

    }





}