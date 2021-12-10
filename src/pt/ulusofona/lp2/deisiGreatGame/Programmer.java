package pt.ulusofona.lp2.deisiGreatGame;

import java.util.*;

public class Programmer {
    String name;
    int id;
    boolean defeated;
    TreeSet<String> languages;
    List<Tool> tools = new ArrayList<>();
    TreeSet<String> toolsTitle = new TreeSet<>();
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

    public void addToolTitle(String tool){
        this.toolsTitle.add(tool);
    }

    public TreeSet<String> getToolsTitle(){
        return toolsTitle;
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
        if (toolsTitle.isEmpty()) {
            res.append("No tools");
        } else {
            int i = 0;
            for(String tool : toolsTitle) {
                if (i == toolsTitle.size()) {
                    res.append(tool);
                }
                res.append(tool).append(";");
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
        if (toolsTitle.isEmpty()) {
            tools.append("No tools");
        } else {
            int i = 0;
            for(String tool : toolsTitle) {
                if (i == toolsTitle.size()) {
                    tools.append(tool);
                }
                tools.append(tool).append(";");
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
