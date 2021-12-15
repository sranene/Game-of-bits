package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;
import java.util.TreeSet;
import static org.junit.Assert.*;

public class TestProgrammer {

    @Test
    public void test01CreateInitialBoard() {

        TreeSet<String> languages = new TreeSet<>();
        languages.add("Java");
        languages.add("PHP");
        ProgrammerColor color = ProgrammerColor.PURPLE;
        Programmer programmer = new Programmer("sranene",3,languages , color);

        assertEquals(programmer.getId(), 3);
        assertEquals(programmer.getName(), "sranene");

    }

    @Test
    public void test02CreateInitialBoard() {

        TreeSet<String> languages = new TreeSet<>();
        languages.add("Java");
        languages.add("PHP");
        ProgrammerColor color = ProgrammerColor.PURPLE;
        Programmer programmer = new Programmer("sranene",3,languages , color);

        assertEquals(programmer.getColor(), ProgrammerColor.PURPLE);
        assertEquals(programmer.getPos(), 1);

    }



}
