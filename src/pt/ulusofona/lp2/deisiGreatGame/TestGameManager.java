package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import static org.junit.Assert.*;

public class TestGameManager {

    GameManager game = new GameManager();

    String[][] abyssesAndTools = {
            {"0","2","10"},
            {"1","3","15"},
            {"1","4","7"},
            {"0","7","3"},
            {"1","5","4"},
            {"0","0","1"},
            {"0","1","2"}
    };

    String[][] abyssesAndTools2 = {
            {"1","0","2"},
            {"1","1","3"},
            {"1","2","4"},
            {"1","3","5"},
            {"1","4","6"},
            {"1","5","7"},
            {"0","0","8"},
            {"0","1","9"},
            {"0","2","10"},
            {"0","3","11"},
            {"0","4","12"},
            {"0","5","13"},
            {"0","6","14"},
            {"0","7","15"},
            {"0","8","16"},
            {"0","9","17"},
            {"0","2","18"},
    };

    String[][] playerInfo = {
            {"28", "sranene", "PHP; Java", "Purple"},
            {"31", "robroche", "Java; C++; Python; Portugues", "Blue"},
            {"16", "Alberto", "Beck", "Brown"}
    };

    String[] languages1 = {"PHP", "Java"};
    String[] languages2 = {"Java", "C++", "Python", "Portugues"};
    String[] languages3 = {"Beck"};

    TreeSet<String> tree1 = new TreeSet<>(Arrays.asList(languages1));
    TreeSet<String> tree2 = new TreeSet<>(Arrays.asList(languages2));
    TreeSet<String> tree3 = new TreeSet<>(Arrays.asList(languages3));

    Programmer sranene = new Programmer("sranene", 28, tree1, ProgrammerColor.PURPLE);
    Programmer robroche = new Programmer("robroche", 31, tree2, ProgrammerColor.BLUE);
    Programmer alberto = new Programmer("Alberto", 16, tree3, ProgrammerColor.BROWN);


    @Test
    public void test01CreateInitialBoard() {
        int boardSize = 28;
        boolean resultado = game.createInitialBoard(playerInfo, boardSize);
        assertTrue(resultado);
    }

    @Test
    public void test02CreateInitialBoardSize() {
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
        String[][] teste7emeio = {
                {"28","sranene","PHP; Java","Green"},
                {"31","robroche","","Purple"}
        };
        assertFalse(game.createInitialBoard(teste7emeio,20, null));
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
        assertTrue(game.createInitialBoard(teste9,20, null));
    }

    @Test
    public void test04createInitialBoardValidateAbyssAndTools(){
        String[][] abyssesAndTools = {
                {"0","11","10"}
        };
        assertFalse(game.createInitialBoard(playerInfo,20,abyssesAndTools));
        String[][] abyssesAndTools2 = {
                {"0","0","24"}
        };
        assertFalse(game.createInitialBoard(playerInfo,20,abyssesAndTools2));
        String[][] abyssesAndTools3 = {
                {"0","-4","10"}
        };
        assertFalse(game.createInitialBoard(playerInfo,20,abyssesAndTools3));
        String[][] abyssesAndTools4 = {
                {"0","1","-9"}
        };
        assertFalse(game.createInitialBoard(playerInfo,20,abyssesAndTools4));
        String[][] abyssesAndTools5 = {
                {"1","11","10"}
        };
        assertFalse(game.createInitialBoard(playerInfo,20,abyssesAndTools5));
        String[][] abyssesAndTools6 = {
                {"1","0","24"}
        };
        assertFalse(game.createInitialBoard(playerInfo,20,abyssesAndTools6));
        String[][] abyssesAndTools7 = {
                {"1","-4","10"}
        };
        assertFalse(game.createInitialBoard(playerInfo,20,abyssesAndTools7));
        String[][] abyssesAndTools8 = {
                {"1","1","-9"}
        };
        assertFalse(game.createInitialBoard(playerInfo,20,abyssesAndTools8));
        String[][] abyssesAndTools9 = {
                {"3","4","10"}
        };
        assertFalse(game.createInitialBoard(playerInfo,20,abyssesAndTools9));
        String[][] abyssesAndTools10 = {
                {"0","2","10"},
                {"1","3","15"},
                {"1","4","7"},
                {"0","3","3"},
                {"1","5","4"},
                {"0","0","1"},
                {"0","1","2"}
        };
        assertTrue(game.createInitialBoard(playerInfo,20,abyssesAndTools10));
        String[][] abyssesAndTools11 = {
                {"1","2","10"},
                {"0","4","11"},
                {"0","5","12"},
                {"0","6","9"},
                {"1","0","4"},
                {"0","7","19"},
                {"0","8","15"},
                {"1","1","2"},
                {"0","9","5"}
        };
        assertTrue(game.createInitialBoard(playerInfo,20,abyssesAndTools11));
    }

    @Test
    public void test01getProgrammers() {

        int boardSize = 30;
        game.createInitialBoard(playerInfo, boardSize);
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

        game.createInitialBoard(playerInfo, 30, abyssesAndTools2);

        assertEquals("inheritance.png", game.getImagePng(2));
        assertEquals("functional.png", game.getImagePng(3));
        assertEquals("unit-tests.png", game.getImagePng(4));
        assertEquals("catch.png", game.getImagePng(5));
        assertEquals("IDE.png", game.getImagePng(6));
        assertEquals("ajuda-professor.png", game.getImagePng(7));
        assertEquals("syntax.png", game.getImagePng(8));
        assertEquals("logic.png", game.getImagePng(9));
        assertEquals("exception.png", game.getImagePng(10));
        assertEquals("file-not-found-exception.png", game.getImagePng(11));
        assertEquals("crash.png", game.getImagePng(12));
        assertEquals("duplicated-code.png", game.getImagePng(13));
        assertEquals("secondary-effects.png", game.getImagePng(14));
        assertEquals("bsod.png", game.getImagePng(15));
        assertEquals("infinite-loop.png", game.getImagePng(16));
        assertEquals("core-dumped.png", game.getImagePng(17));

    }

    @Test
    public void test01getTitle() {

        game.createInitialBoard(playerInfo, 30, abyssesAndTools2);

        assertNull(game.getTitle(0));
        assertNull(game.getTitle(31));
        assertEquals("Herança", game.getTitle(2));
        assertEquals("Tratamento de Excepções", game.getTitle(5));
        assertEquals("IDE", game.getTitle(6));
        assertEquals("File Not Found Exception", game.getTitle(11));
        assertEquals("Blue Screen of Death", game.getTitle(15));
        assertEquals("Segmentation Fault", game.getTitle(17));

    }

    @Test
    public void test01getProgrammersInfo() {
        game.createInitialBoard(playerInfo, 30, abyssesAndTools);
        game.moveCurrentPlayer(6);
        game.reactToAbyssOrTool();
        assertEquals("Alberto : IDE | sranene : No tools | robroche : No tools", game.getProgrammersInfo());
        game.nextNode();
        game.moveCurrentPlayer(2);
        game.reactToAbyssOrTool();
        assertEquals("Alberto : IDE | sranene : No tools | ", game.getProgrammersInfo());
    }

    @Test
    public void test01getProgrammersInfoCatchesSameTool() {
        game.createInitialBoard(playerInfo, 30, abyssesAndTools);
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

        assertTrue(game.createInitialBoard(playerInfo, 30, abyss));
        game.moveCurrentPlayer(6);//Alberto vai po 7
        game.reactToAbyssOrTool();
        game.moveCurrentPlayer(4);//sranene vai po 5
        game.reactToAbyssOrTool();
        game.moveCurrentPlayer(5);//robroche vai po 6
        game.reactToAbyssOrTool();
        game.moveCurrentPlayer(1);//ALberto perde pos 8
        game.reactToAbyssOrTool();
        assertEquals("16 | Alberto | 8 | No tools | Beck | Derrotado",game.getCurrentPlayer().toString());
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
        assertTrue(game.createInitialBoard(playerInfo, 30, abyss));
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
        assertTrue(game.createInitialBoard(playerInfo, 30, abyss));
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
        game.createInitialBoard(playerInfo, 30, abyssesAndTools);
        assertEquals(16, game.getCurrentPlayerID());

    }

    @Test
    public void test01getProgrammersPosition(){
        List<Programmer> lista = new ArrayList<>();
        lista.add(alberto);
        alberto.setPos(5);
        game.createInitialBoard(playerInfo,30,abyssesAndTools);
        assertNull(game.getProgrammers(40));
        assertNull(game.getProgrammers(20));
        game.moveCurrentPlayer(4);
        game.reactToAbyssOrTool();
        assertEquals(lista.toString(), game.getProgrammers(5).toString());
        alberto.setPos(1);
        alberto.setPos(1);
        alberto.setPos(1);
    }

    @Test
    public void test01getProgrammersDefeated(){
        List<Programmer> lista = new ArrayList<>();
        lista.add(alberto);
        lista.add(sranene);
        lista.add(robroche);
        game.createInitialBoard(playerInfo,30,abyssesAndTools);
        assertEquals(lista.toString(),game.getProgrammers(true).toString());
        game.moveCurrentPlayer(2);
        game.reactToAbyssOrTool();
        lista.remove(alberto);
        assertEquals(lista.toString(),game.getProgrammers(false).toString());
    }

    @Test
    public void test01GameOverBoardSize(){
        game.createInitialBoard(playerInfo,19,abyssesAndTools);
        game.moveCurrentPlayer(6);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(6);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(6);
        game.reactToAbyssOrTool();
        assertTrue(game.gameIsOver());
    }

    @Test
    public void test01getWinner(){
        game.createInitialBoard(playerInfo,19, abyssesAndTools);
        game.moveCurrentPlayer(2);
        game.reactToAbyssOrTool();
        game.moveCurrentPlayer(2);
        game.reactToAbyssOrTool();
        game.moveCurrentPlayer(2);
        game.reactToAbyssOrTool();
        assertNull(game.getWinner());
    }

    @Test
    public void test01moveCurrentPLayerLooped(){
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        game.moveCurrentPlayer(6);
        game.getCurrentPlayer().setPos(16);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        assertFalse(game.moveCurrentPlayer(6));

    }

    @Test
    public void test01getAuthorsPanel(){
        JPanel panel = new JPanel();
        JLabel jlabel1 = new JLabel("Inês Marques - a22001936");
        JLabel jlabel2 = new JLabel("Robert Cachapa - a22006023");

        panel.setBounds(40, 80, 200, 200);
        panel.setBackground(Color.white);
        panel.add(jlabel1);
        panel.add(jlabel2);

        assertEquals(panel.toString(), game.getAuthorsPanel().toString());

    }
    @Test
    public void test01Catch2x(){
        game.createInitialBoard(playerInfo,20,abyssesAndTools);
        game.moveCurrentPlayer(3);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.getCurrentPlayer().setPos(15);
        assertEquals("Uhhh agora podes te safar de algumas exceções bem chatas *Tratamento de Excepções was added to your inventory*",game.reactToAbyssOrTool());
        game.nextNode();
        game.nextNode();
        assertEquals("Já tens esta ferramenta I'm sorry :(",game.reactToAbyssOrTool());
    }

    @Test
    public void test01Crash(){
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        game.moveCurrentPlayer(2);
        game.getCurrentPlayer().setPos(12);
        assertEquals("Bem, parece que vais ter de voltar para a primeira casa, já não ganhas este jogo im sorry",game.reactToAbyssOrTool());
        assertEquals(1,game.getCurrentPlayer().getPos());
    }

    @Test
    public void test01DuplicatedCode(){
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        game.moveCurrentPlayer(2);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.getCurrentPlayer().setPos(13);
        assertEquals("Oops, parece que agora tens código a duplicar, volta lá pra casa onde tavas, maroto",game.reactToAbyssOrTool());
    }

    @Test
    public void test02DuplicatedCodeHeranca(){
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.getCurrentPlayer().setPos(13);
        assertEquals("Muito bem, usaste a Herança para evitar código duplicado...até dás a ideia de que és inteligente *A Tool was removed from your inventory*",game.reactToAbyssOrTool());
    }

    @Test
    public void test01Exception(){
        String[][] abyssesAndTools = {
                {"1","3","2"},
                {"1","0","3"},
                {"0","2","4"},
                {"0","2","5"},
        };

        List<Square> tools = new ArrayList<>();


        game.createInitialBoard(playerInfo,20,abyssesAndTools);
        tools.add(game.boardMap.get(3));
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        assertEquals(tools, game.getCurrentPlayer().getTools());
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        assertEquals(3, game.getCurrentPlayer().getPos());

    }

    @Test
    public void test01Ide2x(){

        String[][] abyssesAndTools = {
                {"1","3","2"},
                {"1","4","3"},
                {"1","4","4"},
        };

        game.createInitialBoard(playerInfo,20, abyssesAndTools);
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(1);
        assertEquals("Já tens este IDE, não achas que te chega?", game.reactToAbyssOrTool());
    }

    @Test
    public void test01Heranca2x(){
        List<Square> lista = new ArrayList<>();
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        game.moveCurrentPlayer(1);
        assertEquals("Parabéns! Ganhaste a habilidade de fazer herança no teu programa, aproveita colega *Herança was added to your inventory*",game.reactToAbyssOrTool());
        lista.add(game.boardMap.get(2));
        assertEquals(lista,game.getCurrentPlayer().getTools());
        game.nextNode();
        game.nextNode();
        assertEquals("Já tens a ferramenta Herança, excusas de tentar apanhar outra vez, o teu pai já não volta",game.reactToAbyssOrTool());
        assertEquals(lista,game.getCurrentPlayer().getTools());
    }

    @Test
    public void test01AjudaDoProfessor(){
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        List<Square> lista = new ArrayList<>();
        lista.add(game.boardMap.get(3));
        lista.add(game.boardMap.get(7));
        game.moveCurrentPlayer(2);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(4);
        assertEquals("Agora já podes pedir ajuda aos professores, mas não abuses *Ajuda do Professor was added to your inventory*",game.reactToAbyssOrTool());
        assertEquals("Epah já tens esta ferramenta, para lá de chatear o stor",game.reactToAbyssOrTool());
        assertEquals(lista,game.getCurrentPlayer().getTools());
    }

    @Test
    public void test01FileNotFound(){
        List<Square> lista = new ArrayList<>();
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.getCurrentPlayer().setPos(11);
        assertEquals("Algo não está certo.. FileNotFoundException!! Im sorry, vais ter de recuar 3 casas amigo",game.reactToAbyssOrTool());
        assertEquals(8,game.getCurrentPlayer().getPos());
        game.moveCurrentPlayer(6);
        assertEquals("Agora já podes pedir ajuda aos professores, mas não abuses *Ajuda do Professor was added to your inventory*",game.reactToAbyssOrTool());
        lista.add(game.boardMap.get(7));
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(4);
        assertEquals("Tás com sorte, não tens de recuar 3 casas *A Tool was removed from your inventory*",game.reactToAbyssOrTool());
        lista.clear();
        assertEquals(11,game.getCurrentPlayer().getPos());
        assertEquals(lista,game.getCurrentPlayer().getTools());
    }

    @Test
    public void test01LogicVsTool() {
        String[][] abyssesAndTools = {
                {"1","0","2"},
                {"1","2","3"},
                {"0","1","4"},
                {"0","1","10"}
        };

        List<Square> tools = new ArrayList<>();

        game.createInitialBoard(playerInfo,20, abyssesAndTools);
        tools.add(game.boardMap.get(2));
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        assertEquals(tools, game.getCurrentPlayer().getTools());
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        tools.add(game.boardMap.get(3));
        assertEquals(tools,game.getCurrentPlayer().getTools());
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        tools.remove(game.boardMap.remove(3));
        assertEquals(tools,game.getCurrentPlayer().getTools());
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(6);
        game.reactToAbyssOrTool();
        assertEquals(7, game.getCurrentPlayer().getPos());
    }

    @Test
    public void test01Loop(){
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        game.moveCurrentPlayer(1);
        game.getCurrentPlayer().setPos(16);
        assertEquals("Estás num loop infinito.. what the hell were you doing",game.reactToAbyssOrTool());
        game.nextNode();
        game.nextNode();
        assertFalse(game.moveCurrentPlayer(2));
    }

    @Test
    public void test01LoopTool(){
        List<Square> lista = new ArrayList<>();
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(1);
        assertEquals( "Wow que sorte, és o rei!!!!!!! *Programação Funcional was added to your inventory*",game.reactToAbyssOrTool());
        lista.add(game.boardMap.get(2));
        lista.add(game.boardMap.get(3));
        assertEquals(lista,game.getCurrentPlayer().getTools());
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(1);
        game.getCurrentPlayer().setPos(15);
        game.moveCurrentPlayer(1);
        assertEquals("Tás safo my friend *A Tool was removed from your inventory*",game.reactToAbyssOrTool());
        lista.remove(game.boardMap.get(3));
        assertEquals(lista,game.getCurrentPlayer().getTools());
        game.nextNode();
        game.nextNode();
        assertTrue(game.moveCurrentPlayer(2));
    }
    @Test
    public void test02Loop(){
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        game.moveCurrentPlayer(2);
        game.getCurrentPlayer().setPos(15);
        game.moveCurrentPlayer(1);
        assertEquals("Estás num loop infinito.. what the hell were you doing",game.reactToAbyssOrTool());
        game.moveCurrentPlayer(2);
        game.getCurrentPlayer().setPos(15);
        game.moveCurrentPlayer(1);
        assertEquals("Estás num loop infinito.. what the hell were you doing",game.reactToAbyssOrTool());
        game.nextNode();
        assertTrue(game.moveCurrentPlayer(2));
        game.nextNode();
        assertFalse(game.moveCurrentPlayer(2));

    }
    @Test
    public void test02LoopTool(){
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(1);
        game.getCurrentPlayer().setPos(15);
        game.moveCurrentPlayer(1);
        assertEquals("Estás num loop infinito.. what the hell were you doing",game.reactToAbyssOrTool());
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(1);
        assertEquals( "Wow que sorte, és o rei!!!!!!! *Programação Funcional was added to your inventory*",game.reactToAbyssOrTool());
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(1);
        game.getCurrentPlayer().setPos(15);
        game.moveCurrentPlayer(1);
        assertEquals("Tás safo my friend *A Tool was removed from your inventory*",game.reactToAbyssOrTool());
        game.nextNode();
        assertFalse(game.moveCurrentPlayer(2));
        game.nextNode();
        assertTrue(game.moveCurrentPlayer(2));
    }

    @Test
    public void test01Syntax(){
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        game.moveCurrentPlayer(2);
        game.getCurrentPlayer().setPos(8);
        game.reactToAbyssOrTool();
        assertEquals(7,game.getCurrentPlayer().getPos());
    }
    @Test
    public void test01SyntaxTool(){
        List<Square> lista = new ArrayList<>();
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        lista.add(game.boardMap.get(2));
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(5);
        game.reactToAbyssOrTool();
        lista.add(game.boardMap.get(7));
        assertEquals(lista,game.getCurrentPlayer().getTools());
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        lista.remove(game.boardMap.get(7));
        assertEquals(lista,game.getCurrentPlayer().getTools());
    }

    @Test
    public void test01SegmentationFault(){
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        game.moveCurrentPlayer(1);
        game.getCurrentPlayer().setPos(16);
        game.moveCurrentPlayer(1);
        assertEquals("Tás safo por enquanto...",game.reactToAbyssOrTool());
        game.moveCurrentPlayer(1);
        game.getCurrentPlayer().setPos(16);
        game.moveCurrentPlayer(1);
        assertEquals("Vish tão todos com um SegmentationFault, este aqui é lixado..",game.reactToAbyssOrTool());
    }
    @Test
    public void test01SegmentationFaultTool(){
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        game.moveCurrentPlayer(1);
        game.getCurrentPlayer().setPos(16);
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(3);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(1);
        game.getCurrentPlayer().setPos(16);
        game.moveCurrentPlayer(1);
        assertEquals("Very very very lucky.. *A Tool was removed from your inventory*",game.reactToAbyssOrTool());
    }

    @Test
    public void test01SideEffects(){
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(5);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(1);
        game.getCurrentPlayer().setPos(13);
        game.moveCurrentPlayer(1);
        assertEquals(8,game.getCurrentPlayer().getPosAnteriorAnterior());
        game.reactToAbyssOrTool();
        assertEquals(13,game.getCurrentPlayer().getPosAnteriorAnterior());
    }

    @Test
    public void test01SideEffectTool(){
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        game.moveCurrentPlayer(2);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(2);
        game.getCurrentPlayer().setPos(13);
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        assertEquals(14,game.getCurrentPlayer().getPos());
    }

    @Test
    public void test01UnitTestsx2(){
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(2);
        assertEquals("Aff.. lá vais ter de inventar uns testes quaisquer.. *Testes unitários was added to your inventory*",game.reactToAbyssOrTool());
        assertEquals("Não podes apanhar a ferramenta Testes unitários, porque já a tens, move along",game.reactToAbyssOrTool());
    }
    @Test
    public void test01GetAbyssIdAndPos(){
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        assertEquals(0,game.boardMap.get(8).getId());
        assertEquals(8,game.boardMap.get(8).getPos());
        assertEquals(-1,game.boardMap.get(19).getId());
        assertEquals(19,game.boardMap.get(19).getPos());
    }
    @Test
    public void test01SairBoard(){
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        game.moveCurrentPlayer(2);
        game.getCurrentPlayer().setPos(19);
        game.moveCurrentPlayer(5);
        assertEquals(16,game.getCurrentPlayer().getPos());
    }
    @Test
    public void test02SairBoard(){
        String[][] abyss ={
                {"0","2","2"}
        };
        game.createInitialBoard(playerInfo,20,abyss);
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        assertEquals(1,game.getCurrentPlayer().getPos());
    }
    @Test
    public void test01Programmer() {

        TreeSet<String> languages = new TreeSet<>();
        languages.add("Java");
        languages.add("PHP");
        ProgrammerColor color = ProgrammerColor.PURPLE;
        Programmer programmer = new Programmer("sranene",3,languages , color);

        assertEquals(programmer.getId(), 3);
        assertEquals(programmer.getName(), "sranene");

    }

    @Test
    public void test02Programmer() {

        TreeSet<String> languages = new TreeSet<>();
        languages.add("Java");
        languages.add("PHP");
        ProgrammerColor color = ProgrammerColor.PURPLE;
        Programmer programmer = new Programmer("sranene",3,languages , color);

        assertEquals(programmer.getColor(), ProgrammerColor.PURPLE);
        assertEquals(programmer.getPos(), 1);

    }
    @Test
    public void test03Programmer(){
        game.createInitialBoard(playerInfo,20,abyssesAndTools2);
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        game.nextNode();
        game.nextNode();
        game.moveCurrentPlayer(1);
        game.reactToAbyssOrTool();
        assertEquals("16 | Alberto | 4 | Herança;Programação Funcional;Testes unitários | Beck | Em Jogo",game.getCurrentPlayer().toString());
        assertEquals("Alberto : Herança;Programação Funcional;Testes unitários | sranene : No tools | robroche : No tools",game.getProgrammersInfo());
    }
    @Test
    public void test01Main(){
        String[] teste = new String[1];
        Main.main(teste);
    }

}