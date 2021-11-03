package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.swing.*;

public class GameManager {
    Programmer currentPlayer;
    ProgrammerColor color;
    ArrayList<Programmer> players;
    static TreeMap<Integer,ArrayList<Programmer>> board = new TreeMap<>();

    public GameManager() {}

    public GameManager(ArrayList<Programmer> players) {
        this.players = players;
    }

    public boolean createInitialBoard(String[][] playerInfo, int boardSize) {
        String checkId = "ppl";
        String[] languages;
        TreeSet<String> tree = new TreeSet<>();
        int jogadores = playerInfo.length / 4;

        if (jogadores < 2 || jogadores > 4) {
            return false;
        }

        if (jogadores * 2 < boardSize) {
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

        for (int x = 0; x < jogadores; x++){
            languages = playerInfo[x][2].split(";");
            tree.clear();
            tree.addAll(Arrays.asList(languages));
            switch (playerInfo[x][3]){
                case "Green" -> color = ProgrammerColor.GREEN;
                case "Blue" -> color = ProgrammerColor.BLUE;
                case "Brown" -> color = ProgrammerColor.BROWN;
                case "Purple" -> color = ProgrammerColor.PURPLE;
            }

            players.add(new Programmer(playerInfo[x][1],tree,Integer.parseInt(playerInfo[x][0]),color));
        }
        board.put(1,players);
        for(int x = 2; x <= boardSize; x++){
            board.put(x,null);
        }
        return true;
    }

    public String getImagePng(int position) {
        if (position < 1 || position > board.size()) {
            return null;
        }
        if (position == board.size()) {
            return "glory.png";
        } else {
            return "blank.png";
            /*se criarmos as nossas proprias imagens o código será:
             * return "position" + position + ".png";*/
        }

    }

    public ArrayList<Programmer> getProgrammers() {
        return players;
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
        return currentPlayer.getId();
    }

    public boolean moveCurrentPlayer(int nrPositions) {
        if (nrPositions < 1 || nrPositions > 6) {
            return false;
        }
        board.get(currentPlayer.getPos()).remove(currentPlayer);

        board.get(currentPlayer.movePlayer(nrPositions)).add(currentPlayer);

        return true;
    }

    public boolean gameIsOver() {
        return !(board.get(board.size()).isEmpty());
    }

    public ArrayList<String> getGameResults() {
        return null;
    }

    public JPanel getAuthorsPanel() {
        return null;
    }

}
