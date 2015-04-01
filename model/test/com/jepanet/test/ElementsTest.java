package com.jepanet.test;

import com.jepanet.model.elements.Element;
import com.jepanet.model.elements.Junction;
import com.jepanet.model.elements.Pipe;
import org.junit.Test;
import static org.junit.Assert.*;

public class ElementsTest {
    
    @Test
    public void SimpleIDsTest() {
        Element e = new Junction("C1");
        assertEquals(e.getID(), "C1");
        
        e = new Pipe("P1", "C1", "C2");
        assertEquals(e.getID(), "P1");
    }
}
