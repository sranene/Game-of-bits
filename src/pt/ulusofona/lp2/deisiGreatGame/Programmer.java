package pt.ulusofona.lp2.deisiGreatGame;

import java.util.*;

public class Programmer {
    String name;
    TreeSet<String> languages;
    int id;
    ProgrammerColor color;
    int pos;

    Programmer(String name, TreeSet<String> languages, int id, ProgrammerColor color) {
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

    public String toString() {
        String languages = "";
        int aux = 0;
        for(String language : this.languages) {
            if (this.languages.size() == aux) {
                languages += language;
                break;
            }
            aux++;
            languages += language + "; ";
        }
        /*falta:
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

        return id + " | " + name + " | " + pos + " | " + languages;
    }



}
