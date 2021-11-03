package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.*;

public class GameManager {
    Programmer currentPlayer;
    ProgrammerColor color;
    ArrayList<Programmer> players;
    TreeMap<Integer,ArrayList<Programmer>> board = new TreeMap<>();

    public GameManager() {}

    public GameManager(ArrayList<Programmer> players) {
        this.players = players;
    }

    public boolean createInitialBoard(String[][] playerInfo, int boardSize) {
        String checkId = "ppl";
        int jogadores = playerInfo.length / 4;

        if (jogadores < 2 || jogadores > 4) {
            return false;
        }

        if (jogadores * 2 < boardSize) {
            return false;
        }

        for (int x = 0; x < jogadores - 1; x++) {
            if (playerInfo[x][0].equals(checkId) || Integer.parseInt(playerInfo[x][0]) < 0) {
                return false;
            } else {
                checkId = playerInfo[x][0];
            }

            if (playerInfo[x][1].equals("") || playerInfo[x][1] == null) {
                return false;
            }

            if (!((playerInfo[x][3].equals(ProgrammerColor.GREEN.toString())) ||
                    (playerInfo[x][3].equals(ProgrammerColor.BROWN.toString()))
                    || (playerInfo[x][3].equals(ProgrammerColor.PURPLE.toString())) ||
                    (playerInfo[x][3].equals(ProgrammerColor.BLUE.toString())))) {
                return false;
            }

            for (int y = x + 1; y < jogadores - 2; y++) {
                if (playerInfo[x][3].equals(playerInfo[y][3])) {
                    return false;
                }
            }
        }


        for(int x = 2; x <= boardSize; x++){
            board.put(x,null);
        }
        /*still stuff to do*/
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
        /*incompleto*/
        return false;
    }

    public boolean gameIsOver() {
        return false;
    }

    public ArrayList<String> getGameResults() {
        return null;
    }

    public JPanel getAuthorsPanel() {
        return null;
    }

}
