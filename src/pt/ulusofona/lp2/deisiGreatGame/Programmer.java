package pt.ulusofona.lp2.deisiGreatGame;

import java.util.*;

public class Programmer {
    String name;
    int id;
    boolean defeated;
    TreeSet<String> languages;
    List<Tool> tools = new ArrayList<>();
    ProgrammerColor color;
    int pos = 1;

    Programmer(String name, int id, TreeSet<String> languages, ProgrammerColor color) {
        this.name = name;
        this.languages = languages;
        this.id = id;
        this.color = color;
        this.defeated = false;
    }

    public int getId() {
        return id;
    }

    public boolean isDefeated(){
        return defeated;
    }

    public void gotDefeated() {
        this.defeated = true;
    }

    public void addTool(Tool tool) {
        this.tools.add(tool);
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

    public List<Tool> getTools() {
        return tools;
    }

    public void movePlayer(int nrCasas){
        int sub;
        pos += nrCasas;
        if(pos < 1){
            pos -= nrCasas;
        }
        if(pos > GameManager.boardProgrammers.size()){
            sub = pos-GameManager.boardProgrammers.size();
            pos = GameManager.boardProgrammers.size();
            pos -= sub;
        }
    }

    public String toString() {
        StringBuilder languages = new StringBuilder();
        StringBuilder tools = new StringBuilder();
        String status = "";
        // languages
        int aux = 0;
        for(String language : this.languages) {
            if (this.languages.size() - 1 == aux) {
                languages.append(language);
                break;
            }
            aux++;
            languages.append(language).append("; ");
        }
        // tools
        if (this.tools.isEmpty()) {
            tools.append("No tools");
        } else {
            int i = 0;
            for(Tool tool : this.tools) {
                if (i == this.tools.size()) {
                    tools.append(tool.getTitle());
                }
                tools.append(tool.getTitle()).append(";");
                i++;
            }
        }
        // status
        if (defeated) {
            status = "Derrotado";
        } else {
            status = "Em Jogo";
        }

        /*
        Nota: Para programadores que saiam do
        jogo, <Pos> deve ter a posição onde
        estavam quando perderam o jogo.

        <Estado> deve ter o valor “Em Jogo”
        (caso o jogador ainda esteja em jogo)
        ou “Derrotado” (caso o jogador tenha
        saído do jogo).
        */

        return id + " | " + name + " | " + pos + " | " + tools + " | " + languages + " | " + status;
    }



}
