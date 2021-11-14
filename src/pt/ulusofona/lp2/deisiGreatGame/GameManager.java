package pt.ulusofona.lp2.deisiGreatGame;

import java.awt.*;
import java.util.*;
import javax.swing.*;


public class GameManager {
    Programmer currentPlayer;
    ProgrammerColor color;
    static TreeMap<Integer,ArrayList<Programmer>> board = new TreeMap<>();

    public GameManager() {}

    Node head = null;

    Node tail = null;

    int nrTurnos = 1;

    public boolean createInitialBoard(String[][] playerInfo, int boardSize) {
        String[] languages;
        board.clear();
        currentPlayer = null;
        if(head != null) {
            if (head.next.next != null && head.next.next != tail) {
                head.next.next = null;
            }
            if (head.next != tail) {
                head.next = null;
            }
            head = null;
            tail = null;
        }
        nrTurnos = 1;
        ArrayList<Programmer> players = new ArrayList<>();
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

            for (int y = x + 1; y < jogadores ; y++) {
                if(Integer.parseInt(playerInfo[x][0]) < 0 || playerInfo[x][0] == null){
                    return false;
                }else if(x == jogadores-1){
                    break;
                }else if(playerInfo[x][0].equals(playerInfo[y][0])){
                    return false;
                }else if (playerInfo[x][3].equals(playerInfo[y][3])) {
                    return false;
                }
            }
        }

        for (String[] strings : playerInfo) {
            languages = strings[2].split(";");
            for(int b = 0; b < languages.length; b++){
                languages[b] = languages[b].trim();
            }
            TreeSet<String> tree = new TreeSet<>(Arrays.asList(languages));
            switch (strings[3]) {
                case "Green" -> color = ProgrammerColor.GREEN;
                case "Blue" -> color = ProgrammerColor.BLUE;
                case "Brown" -> color = ProgrammerColor.BROWN;
                case "Purple" -> color = ProgrammerColor.PURPLE;
            }

            players.add(new Programmer(strings[1], Integer.parseInt(strings[0]), tree, color));
        }
        players.sort(Comparator.comparing(Programmer::getId));
        for (Programmer player : players) {

            Node newNode = new Node(player);
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
        }
        tail.next = head;
        board.put(1,players);
        for(int x = 2; x <= boardSize; x++){
            board.put(x,new ArrayList<>());
        }
        return true;
    }

    public String getImagePng(int position) {
        if (position < 1 || position > board.size()) {
            return null;
        }
        if (position == board.size()) {
            return "glory.png";
        } else if (board.get(position) != null && !(board.get(position).isEmpty())) {
            return "player" + board.get(position).get(0).color.toString() + ".png";
        } else {
            return "blank.png";
        }

    }

    public ArrayList<Programmer> getProgrammers() {
        ArrayList<Programmer> programmers = new ArrayList<>();
        for (int x = 1; x <= board.size(); x++) {
            if (!(board.get(x).isEmpty())) {
                programmers.addAll(board.get(x));
            }
        }
        return programmers;
    }

    public ArrayList<Programmer> getProgrammers(int position) {
        if (!(board.containsKey(position))) {
            return null;
        }
        if (board.get(position) == null) {
            return null;
        }

        return board.get(position);
    }

    public int getCurrentPlayerID() {
        return head.programmer.getId();
    }

    public boolean moveCurrentPlayer(int nrPositions) {
        if (nrPositions < 1 || nrPositions > 6) {
            return false;
        }
        currentPlayer = head.programmer;

        board.get(currentPlayer.getPos()).remove(currentPlayer);

        currentPlayer.movePlayer(nrPositions);

        board.get(currentPlayer.getPos()).add(currentPlayer);

        nrTurnos +=1;

        head = head.next;

        tail = tail.next;

        return true;
    }

    public boolean gameIsOver() {
        return !(board.get(board.size()).isEmpty());
    }

    public ArrayList<String> getGameResults() {

        ArrayList<String> results = new ArrayList<>();
        ArrayList<Programmer> programmers;
        programmers = getProgrammers();
        programmers.remove(board.get(board.size()).get(0));
        programmers.sort(Comparator.comparing(Programmer::getPos).reversed());

        results.add("O GRANDE JOGO DO DEISI");
        results.add("");
        results.add("NR. DE TURNOS");
        results.add("" + nrTurnos);
        results.add("");
        results.add("VENCEDOR");
        results.add(board.get(board.size()).get(0).name);
        results.add("");
        results.add("RESTANTES");
        for (Programmer programmer : programmers){
            results.add(programmer.name + " " + programmer.pos);
        }
        return results;
    }

    public JPanel getAuthorsPanel() {

        JFrame f = new JFrame("Créditos");
        JPanel panel = new JPanel();

        JLabel jlabel1 = new JLabel("Inês Marques - a22001936");
        JLabel jlabel2 = new JLabel("Robert Cachapa - a22006023");

        panel.setBounds(40,80,200,200);
        panel.setBackground(Color.white);

        panel.add(jlabel1);
        panel.add(jlabel2);
        f.add(panel);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);

        return panel;
    }

}
