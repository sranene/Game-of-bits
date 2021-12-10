package pt.ulusofona.lp2.deisiGreatGame;

import java.util.*;

public class Programmer {
    String name;
    int id;
    boolean defeated = false;
    TreeSet<String> languages;
    List<Tool> tools = new ArrayList<>();
    ProgrammerColor color;
    int pos = 1;
    int posAnterior = 1;
    int posAnteriorAnterior = 1;
    boolean loop = false;

    Programmer(String name, int id, TreeSet<String> languages, ProgrammerColor color) {
        this.name = name;
        this.languages = languages;
        this.id = id;
        this.color = color;
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

    public int getPosAnterior() {
        return posAnterior;
    }

    public int getPosAnteriorAnterior() {
        return posAnteriorAnterior;
    }

    public void setPos(int pos) {
        posAnteriorAnterior = posAnterior;
        posAnterior = pos;
        this.pos = pos;
    }

    public void movePlayer(int nrCasas, int size){
        posAnteriorAnterior = posAnterior;
        posAnterior = pos;
        int sub;
        pos += nrCasas;
        if(pos < 1){
            pos -= nrCasas;
        }
        if(pos > size){
            sub = pos-size;
            pos =size;
            pos -= sub;
        }
    }

    public boolean getLoop(){
        return this.loop;
    }

    public String getStringTools() {
        StringBuilder res = new StringBuilder();
        if (this.tools.isEmpty()) {
            res.append("No tools");
        } else {
            int i = 1;
            for(Tool tool : this.tools) {
                if (i == this.tools.size()) {
                    res.append(tool.getTitle());
                } else {
                    res.append(tool.getTitle()).append(";");
                }
                i++;
            }
        }
        return res.toString();
    }

    public void setLoop(boolean looped){
        this.loop = looped;
    }

    public String toString() {
        StringBuilder languages = new StringBuilder();
        StringBuilder tools = new StringBuilder();
        String status;
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
            int i = 1;
            for(Tool tool : this.tools) {
                if (i == this.tools.size()) {
                    tools.append(tool.getTitle());
                } else {
                    tools.append(tool.getTitle()).append(";");
                }
                i++;
            }
        }
        // status
        if (defeated) {
            status = "Derrotado";
        } else {
            status = "Em Jogo";
        }

        return id + " | " + name + " | " + pos + " | " + tools + " | " + languages + " | " + status;
    }


    public void removeTool(Tool tool) {
        if(tools.contains(tool)) {
            this.tools.remove(tool);
        }
    }
}
