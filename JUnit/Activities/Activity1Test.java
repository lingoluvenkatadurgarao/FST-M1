package activities;


import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static javax.print.attribute.standard.MediaSizeName.A;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1Test {
   static ArrayList list;


    @BeforeEach
    public void setUp() {
        list = new ArrayList<>();
        list.add("Alpha");
        list.add("Beta");
    }

    @Test
    public void insertTest() {
       assertEquals(2, list.size(), "Wrong Size");
        list.add("Gama");
       assertEquals(3, list.size(), "Wrong Size");
       assertEquals("Alpha", list.get(0), "Wrong Element");
       assertEquals("Beta", list.get(1), "Wrong Element");
       assertEquals("Gama", list.get(2), "Wrong Element");
    }
        @Test
        @Tag("A")
        public void replaceTest () {
           assertEquals(2, list.size());
            list.add("Delta");
            assertEquals(3, list.size(), "Wrong Size");
            list.set(1, "Dollor");
            assertEquals("Alpha", list.get(0), "Wrong Element");
            assertEquals("Dollor", list.get(1), "Wrong Element");
            assertEquals("Delta", list.get(2), "Wrong Element");
        }

    }

