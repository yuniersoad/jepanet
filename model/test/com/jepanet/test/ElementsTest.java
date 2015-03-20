package com.jepanet.test;

import com.jepanet.model.elements.Element;
import com.jepanet.model.elements.Link;
import com.jepanet.model.elements.Node;
import org.junit.Test;
import static org.junit.Assert.*;

public class ElementsTest {
    
    @Test
    public void SimpleIDsTest() {
        Element e = new Node("C1");
        assertEquals(e.getID(), "C1");
        
        e = new Link("P1", "C1", "C2");
        assertEquals(e.getID(), "P1");
    }
}
