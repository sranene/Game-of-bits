package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.List;

public class Square {
    List<Programmer> programmers = new ArrayList<>();
    int id;
    String title;
    int pos;

    public Square(int id, int pos){
        this.id = id;
        this.pos = pos;
    }

    public Square(int pos){
        this.id = -1;
        this.title = "Empty";
        this.pos = pos;
    }

    public int getId(){
        return id;
    }

    public int getPos(){
        return pos;
    }

    public void addProgrammer(Programmer programmer){
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

    public Square getAbyssOrTool(int numero){
        if(numero == 0){
            return new Syntax(id,pos);
        }else if(numero == 1){
            return new Logic(id,pos);
        }
        else return null;
    }

}
