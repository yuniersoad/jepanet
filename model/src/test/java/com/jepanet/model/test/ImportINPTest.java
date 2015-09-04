package com.jepanet.model.test;

import com.jepanet.model.Network;
import com.jepanet.model.elements.Junction;
import com.jepanet.model.elements.Node;
import com.jepanet.model.elements.Tank;
import com.jepanet.model.exceptions.IllegalElementInsertion;
import com.jepanet.model.io.INPReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImportINPTest {
    
    @Test
    public void simpleInpTitleNotes() throws FileNotFoundException, IOException, IllegalElementInsertion {
        Network net = networkFromInp("test_data/simple.inp");
        assertEquals("Simple	inp", net.getTitle());
        assertEquals(1, net.getNotes().size());
        assertEquals("Simple note", net.getNotes().get(0));
    
    }
    
    @Test
    public void tuto1EpanetTitleNotes() throws FileNotFoundException, IOException, IllegalElementInsertion {
        Network net = networkFromInp("test_data/tutorial1epanet.inp");
        assertEquals("Tutorial 1 Epanet", net.getTitle());
        assertEquals(2, net.getNotes().size());
        assertEquals("Notes1", net.getNotes().get(0));
        assertEquals("Notes2", net.getNotes().get(1));
    }
    
    @Test
    public void tuto1Epanet() throws IOException, FileNotFoundException, IllegalElementInsertion {
         Network net = networkFromInp("test_data/tutorial1epanet.inp");
         assertThat(net.getNodeCount(), is(10));
         Node j2 = net.getNode("2");
         
         assertThat(j2, instanceOf(Junction.class));
    }
    
    @Test
    public void tuto1EpanetElevation() throws IOException, FileNotFoundException, IllegalElementInsertion {
        Network net = networkFromInp("test_data/tutorial1epanet.inp");
        Node j2 = net.getNode("2");
        Node j8 = net.getNode("8");
        
        assertThat(j2.getElevation(), is(0.5));
        assertThat(j8.getElevation(), is(17.0));
    }

    private Network networkFromInp(String path) throws IOException, FileNotFoundException, IllegalElementInsertion {
        INPReader r = new INPReader(path);
        Network net = r.getNework();
        return net;
    }
}
