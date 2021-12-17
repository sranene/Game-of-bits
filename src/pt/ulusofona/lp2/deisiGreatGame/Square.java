package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public abstract class Square {
    protected List<Programmer> programmers = new ArrayList<>();
    protected final int id;
    protected String title;
    protected int pos;

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
        programmers.sort(Comparator.comparing(Programmer::getName));
    }
    public void removeProgrammer(Programmer programmer){
        programmers.remove(programmer);
    }

    public List<Programmer> getProgrammers () {
        return programmers;
    }


    public String getTitle(){
        return title;
    }

}