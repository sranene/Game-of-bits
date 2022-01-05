package pt.ulusofona.lp2.deisiGreatGame;

import java.util.*;

public class Programmer {
    private final String name;
    private final int id;
    private final TreeSet<String> languages;
    private final ProgrammerColor color;
    private List<Tool> tools = new ArrayList<>();
    private int pos = 1;
    private int posAnterior = 1;
    private int posAnteriorAnterior = 1;
    private boolean loop = false;
    private boolean defeated = false;

    Programmer(String name, int id, TreeSet<String> languages, ProgrammerColor color) {
        this.name = name;
        this.languages = languages;
        this.id = id;
        this.color = color;
    }
    Programmer(int id,String name,ProgrammerColor color,int pos,int posAnterior,int posAnteriorAnterior,TreeSet<String> languages,List<Tool> tools,boolean loop,boolean defeated){
        this.id = id;
        this.name = name;
        this.color = color;
        this.pos = pos;
        this.posAnterior = posAnterior;
        this.posAnteriorAnterior = posAnteriorAnterior;
        this.languages = languages;
        this.tools = tools;
        this.loop = loop;
        this.defeated = defeated;
    }

    public int getId() {
        return id;
    }

    public boolean isDefeated(){
        return defeated;
    }

    public List<String> getLanguages() {

        return new ArrayList<>(this.languages);

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

    public String getFirstName(){
        return name.split(" ")[0];
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
        posAnterior = this.pos;
        this.pos = pos;
    }

    public void movePlayer(int nrCasas, int size){
        posAnteriorAnterior = posAnterior;
        posAnterior = pos;
        pos += nrCasas;
        if(pos < 1){
            pos = 1;
        }
        if(pos > size){
            int sub;
            sub = pos-size;
            pos =size;
            pos -= sub;
        }
    }

    public boolean getLoop(){
        return loop;
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
        loop = looped;
    }

    public void removeTool(Tool tool) {
        if(tools.contains(tool)) {
            this.tools.remove(tool);
        }
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


    public String toStringToFile(){

        StringBuilder result = new StringBuilder();
        result.append(id).append("/");
        result.append(name).append("/");
        result.append(color.toString()).append("/");
        result.append(pos).append("/");
        result.append(posAnterior).append("/");
        result.append(posAnteriorAnterior).append("/");
        int aux = 0;
        for (String language : this.languages) {
            if (this.languages.size() - 1 == aux) {
                result.append(language).append("/");
                break;
            }
            aux++;
            result.append(language).append(";");
        }
        if (this.tools.isEmpty()) {
            result.append("No tools").append("/");
        } else {
            int i = 1;
            for(Tool tool : this.tools) {
                if (i == this.tools.size()) {
                    result.append(tool.getTitle()).append("/");
                } else {
                    result.append(tool.getTitle()).append(";");
                }
                i++;
            }
        }
        if(loop){
            result.append("Loop").append("/");
        }else{
            result.append("No Loop").append("/");
        }
        if(defeated){
            result.append("Derrotado");
        }else{
            result.append("Em Jogo");
        }

        return result.toString();
    }

}