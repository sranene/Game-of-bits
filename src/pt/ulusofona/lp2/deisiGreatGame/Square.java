package pt.ulusofona.lp2.deisiGreatGame;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public abstract class Square {
    List<Programmer> programmers = new ArrayList<>();
    int id;
    String title;
    int pos;

    public Square(int id,int pos){
        this.id = id;
        this.pos = pos;
    }

    public Square(int pos){
        this.id = -1;
        this.title = null;
        this.pos = pos;
    }

    public abstract String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap);

    public int getId(){
        return id;
    }

    public int getPos(){
        return pos;
    }

    public void addProgrammer(Programmer programmer) {
        programmers.add(programmer);
    }
    public void removeProgrammer(Programmer programmer){
        programmers.remove(programmer);
    }

    public void addArrayProgrammers(List<Programmer> programmers1){
        programmers = programmers1;
    }

    public List<Programmer> getProgrammers () {
        return programmers;
    }

    public String getTitle(){
        return title;
    }

}
