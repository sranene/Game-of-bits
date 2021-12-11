package pt.ulusofona.lp2.deisiGreatGame;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;


public class GameManager {
    Programmer currentPlayer;
    Node head = null;
    Node tail = null;
    ProgrammerColor color;
    List<Programmer> programmers = new ArrayList<>();
    TreeMap<Integer, Square> boardMap = new TreeMap<>();
    int dado = 0;
    int nrTurnos = 1;

    public GameManager() {}

    public Abyss checkAbyss(int id, int pos) {
        switch (id) {
            case 0 -> {
                return new Syntax(id, pos);
            }
            case 1 -> {
                return new Logic(id, pos);
            }
            case 2 -> {
                return new Exception(id, pos);
            }
            case 3 -> {
                return new FileNotFound(id, pos);
            }
            case 4 -> {
                return new Crash(id, pos);
            }
            case 5 -> {
                return new DuplicatedCode(id, pos);
            }
            case 6 -> {
                return new SideEffects(id, pos);
            }
            case 7 -> {
                return new BlueScreen(id, pos);
            }
            case 8 -> {
                return new Loop(id, pos);
            }
            case 9 -> {
                return new SegmentationFault(id, pos);
            }
            default -> {
                return null;

            }
        }
    }
    public Tool checkTool(int id, int pos) {
        switch (id) {
            case 0 -> {
                return new Inheritance(id, pos);
            }
            case 1 -> {
                return new Functional(id, pos);
            }
            case 2 -> {
                return new UnitTests(id, pos);
            }
            case 3 -> {
                return new Catch(id, pos);
            }
            case 4 -> {
                return new Ide(id, pos);
            }
            case 5 -> {
                return new TeachersHelp(id, pos);
            }
            default -> {
                return null;

            }
        }
    }

    public boolean createInitialBoard(String[][] playerInfo, int boardSize) {
        String[] languages;
        boardMap.clear();
        programmers.clear();
        currentPlayer = null;
        nrTurnos = 1;
        if (head != null) {
            if (head.next.next != null && head.next.next != tail) {
                head.next.next = null;
            }
            if (head.next != tail) {
                head.next = null;
            }
            head = null;
            tail = null;
        }

        int jogadores = playerInfo.length;

        if (jogadores < 2 || jogadores > 4) {
            return false;
        }

        if (jogadores * 2 > boardSize) {
            return false;
        }

        for (int x = 0; x < jogadores; x++) {

            if (playerInfo[x][1].equals("") || playerInfo[x][1] == null || playerInfo[x][1].equals(" ")) {
                return false;
            }

            if (!((playerInfo[x][3].equals(ProgrammerColor.GREEN.toString())) ||
                    (playerInfo[x][3].equals(ProgrammerColor.BROWN.toString()))
                    || (playerInfo[x][3].equals(ProgrammerColor.PURPLE.toString())) ||
                    (playerInfo[x][3].equals(ProgrammerColor.BLUE.toString())))) {
                return false;
            }

            for (int y = x + 1; y < jogadores; y++) {
                if (Integer.parseInt(playerInfo[x][0]) < 0 || playerInfo[x][0] == null) {
                    return false;
                } else if (x == jogadores - 1) {
                    break;
                } else if (playerInfo[x][0].equals(playerInfo[y][0])) {
                    return false;
                } else if (playerInfo[x][3].equals(playerInfo[y][3])) {
                    return false;
                }
            }
        }

        for (String[] strings : playerInfo) {
            languages = strings[2].split(";");
            for (int b = 0; b < languages.length; b++) {
                languages[b] = languages[b].trim();
            }
            TreeSet<String> tree = new TreeSet<>(Arrays.asList(languages));
            switch (strings[3]) {
                case "Green" -> color = ProgrammerColor.GREEN;
                case "Blue" -> color = ProgrammerColor.BLUE;
                case "Brown" -> color = ProgrammerColor.BROWN;
                case "Purple" -> color = ProgrammerColor.PURPLE;
            }
            Programmer programmer = new Programmer(strings[1], Integer.parseInt(strings[0]), tree, color);
            programmers.add(programmer);
        }
        programmers.sort(Comparator.comparing(Programmer::getId));
        for (Programmer player : programmers) {

            Node newNode = new Node(player);
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            tail.next = head;
        }

        return true;
    }

    public boolean createInitialBoard(String[][] playerInfo, int boardSize, String[][] abyssesAndTools) {
        boolean check;
        check = createInitialBoard(playerInfo, boardSize);
        if (check){
            boardMap.put(1, new Empty(1));
            for(Programmer programmer : programmers) {
                boardMap.get(1).addProgrammer(programmer);
            }
            for (int x = 2; x <= boardSize; x++) {
                boardMap.put(x, new Empty(x));
            }

            for (String[] abyssesAndTool : abyssesAndTools) {
                int checkID = Integer.parseInt(abyssesAndTool[1]);
                int checkPos = Integer.parseInt(abyssesAndTool[2]);

                if (abyssesAndTool[0].equals("0")) {
                    if (checkID >= 0 && checkID <= 9 && checkPos >= 0 && checkPos <= boardSize) {
                        boardMap.put(checkPos, checkAbyss(checkID, checkPos));
                    } else {
                        return false;
                    }
                } else if (abyssesAndTool[0].equals("1")) {
                    if (checkID >= 0 && checkID <= 5 && checkPos >= 0 && checkPos <= boardSize) {
                        boardMap.put(checkPos, checkTool(checkID, checkPos));
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public String getImagePng(int position) {
        if (position < 1 || position > boardMap.size()) {
            return null;
        }
        if (position == boardMap.size()) {
            return "glory.png";
        }
        if(boardMap.containsKey(position)) {
            if (boardMap.get(position).getTitle() != null) {
                switch (boardMap.get(position).getTitle()) {
                    case "Herança" -> {
                        return "inheritance.png";
                    }
                    case "Programação Funcional" -> {
                        return "functional.png";
                    }
                    case "Testes unitários" -> {
                        return "unit-tests.png";
                    }
                    case "Tratamento de Excepções" -> {
                        return "catch.png";
                    }
                    case "IDE" -> {
                        return "IDE.png";
                    }
                    case "Ajuda Do Professor" -> {
                        return "ajuda-professor.png";
                    }
                    case "Erro de sintaxe" -> {
                        return "syntax.png";
                    }
                    case "Erro de lógica" -> {
                        return "logic.png";
                    }
                    case "Exception" -> {
                        return "exception.png";
                    }
                    case "File Not Found Exception" -> {
                        return "file-not-found-exception.png";
                    }
                    case "Crash (aka Rebentanço)" -> {
                        return "crash.png";
                    }
                    case "Duplicated Code" -> {
                        return "duplicated-code.png";
                    }
                    case "Efeitos secundários" -> {
                        return "secondary-effects.png";
                    }
                    case "Blue Screen of Death" -> {
                        return "bsod.png";
                    }
                    case "Ciclo infinito" -> {
                        return "infinite-loop.png";
                    }
                    case "Segmentation Fault" -> {
                        return "core-dumped.png";
                    }
                }

            }
        }

        return null;

    }

    public List<Programmer> getProgrammers(boolean includeDefeated) {
        if (includeDefeated) {
            return programmers;
        } else {
            List<Programmer> resProgrammers = new ArrayList<>();
            for (Programmer programmer : programmers) {
                if (!programmer.isDefeated()) {
                    resProgrammers.add(programmer);
                }
            }
            return resProgrammers;
        }
    }

    public List<Programmer> getProgrammers(int position) {
        if (!(boardMap.containsKey(position))) {
            return null;
        }
        if (boardMap.get(position) == null) {
            return null;
        }

        return boardMap.get(position).getProgrammers();
    }

    public int getCurrentPlayerID() {
        return head.programmer.getId();
    }

    public boolean moveCurrentPlayer(int nrSpaces) {
        if (nrSpaces < 1 || nrSpaces > 6) {
            return false;
        }

        dado = nrSpaces;
        currentPlayer = head.programmer;

        if (!currentPlayer.getLoop()) {
            if (boardMap.get(currentPlayer.getPos()) != null) {
                boardMap.get(currentPlayer.getPos()).removeProgrammer(currentPlayer);
                currentPlayer.movePlayer(nrSpaces, boardMap.size());
                boardMap.get(currentPlayer.getPos()).addProgrammer(currentPlayer);
            }
            return true;
        }

        return false;

    }

    public void nextNode() {
        nrTurnos += 1;
        head = head.next;
        tail = tail.next;

    }

    public String reactToAbyssOrTool() {
        int count = 0;
        String res = null;

        if(boardMap.containsKey(currentPlayer.getPos()) && !currentPlayer.isDefeated()){
            res = boardMap.get(currentPlayer.getPos()).react(currentPlayer, dado, boardMap);
        }
        if(currentPlayer.isDefeated()){
            head = head.next;
            tail.next = null;
            tail.next = head;
            count++;
            nrTurnos++;
        }
        if(count == 0) {
            nextNode();
        }

        return res;
    }

    public Programmer getWinner(){
        for(Programmer programmer : programmers){
            if(!programmer.isDefeated()){
                return programmer;
            }
        }
        return null;
    }

    public boolean gameIsOver() {
        int countGameOver = 0;
        for(Programmer programmer : programmers){
            if(programmer.isDefeated()){
                countGameOver++;
            }
        }
        if (boardMap.get(boardMap.size()) != null) {
            if(countGameOver == programmers.size() - 1) {
                return true;
            }else if(!boardMap.get(boardMap.size()).getProgrammers().isEmpty()){
                Programmer programmerSave = boardMap.get(boardMap.size()).getProgrammers().get(0);
                programmers.remove(boardMap.get(boardMap.size()).getProgrammers().get(0));
                for(Programmer programmer : programmers){
                    programmer.gotDefeated();
                }
                programmers.add(programmerSave);
                return true;

            }
        }
        return false;
    }

    public List<String> getGameResults() {

        List<String> results = new ArrayList<>();
        List<Programmer> programmers;
        programmers = getProgrammers(true);
        Programmer programmerSave = getWinner();
        programmers.remove(getWinner());
        programmers.sort(Comparator.comparing(Programmer::getPos).reversed());

        results.add("O GRANDE JOGO DO DEISI");
        results.add("");
        results.add("NR. DE TURNOS");
        results.add("" + nrTurnos);
        results.add("");
        results.add("VENCEDOR");
        results.add(programmerSave.getName());
        results.add("");
        results.add("RESTANTES");
        for (Programmer programmer : programmers) {
            results.add(programmer.getName() + " " + programmer.getPos());
        }
        programmers.add(programmerSave);
        return results;
    }

    public JPanel getAuthorsPanel() {

        JPanel panel = new JPanel();

        JLabel jlabel1 = new JLabel("Inês Marques - a22001936");
        JLabel jlabel2 = new JLabel("Robert Cachapa - a22006023");

        panel.setBounds(40, 80, 200, 200);
        panel.setBackground(Color.white);

        panel.add(jlabel1);
        panel.add(jlabel2);

        return panel;

    }

    public String getTitle(int position) {

        if (position < 0 || position > boardMap.size()) {
            return null;
        }
        if (boardMap.containsKey(position)) {
            return boardMap.get(position).getTitle();
        }
        return null;

    }

    public String getProgrammersInfo() {
        StringBuilder res = new StringBuilder();
        int programmersSize = programmers.size();
        int i = 0;
        for (Programmer programmer : programmers) {
            if (!programmer.isDefeated()) {

                res.append(programmer.getName()).append(" : ");
                res.append(programmer.getStringTools());

                i++;
                if (programmersSize == i) {
                    return res.toString();
                }
                res.append(" | ");
            }else {
                i++;
            }

        }
        return res.toString();
    }
}