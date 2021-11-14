package pt.ulusofona.lp2.deisiGreatGame;

import java.util.*;

public class Programmer {
    String name;
    int id;
    TreeSet<String> languages;
    ProgrammerColor color;
    static int pos = 1;

    Programmer(String name, int id, TreeSet<String> languages, ProgrammerColor color) {
        this.name = name;
        this.languages = languages;
        this.id = id;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProgrammerColor getColor() {
        return color;
    }

    public int getPos(){
        return pos;
    }

    public static void movePlayer(int nrCasas){
        int sub;
        pos += nrCasas;
        if(pos > GameManager.board.size()){
            sub = pos-GameManager.board.size();
            pos = GameManager.board.size();
            pos -= sub;
        }
    }

    public String toString() {
        StringBuilder languages = new StringBuilder();
        int aux = 0;
        for(String language : this.languages) {
            if (this.languages.size()-1 == aux) {
                languages.append(language);
                break;
            }
            aux++;
            languages.append(language).append("; ");
        }
        /*
        Nota: Para programadores que saiam do
        jogo, <Pos> deve ter a posição onde
        estavam quando perderam o jogo.

        Nota: Nesta primeira parte do projecto, os
        programadores nunca saem de Jogo.

        <Estado> deve ter o valor “Em Jogo”
        (caso o jogador ainda esteja em jogo)
        ou “Derrotado” (caso o jogador tenha
        saído do jogo).
        */

        return id + " | " + name + " | " + pos + " | " + languages + " | Em Jogo";
    }



}
