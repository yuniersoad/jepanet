package com.jepanet.test;

import com.jepanet.model.Network;
import com.jepanet.model.io.INPReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImportINPTest {
    
    @Test
    public void simpleInp() throws FileNotFoundException, IOException {
        Network net = networkFromInp("test_data/simple.inp");
        assertEquals("Simple	inp", net.getTitle());
        assertEquals(1, net.getNotes().size());
        assertEquals("Simple note", net.getNotes().get(0));
    
    }
    
    @Test
    public void tuto1Epanet() throws FileNotFoundException, IOException {
        Network net = networkFromInp("test_data/tutorial1epanet.inp");
        assertEquals("Tutorial 1 Epanet", net.getTitle());
        assertEquals(2, net.getNotes().size());
        assertEquals("Notes1", net.getNotes().get(0));
        assertEquals("Notes2", net.getNotes().get(1));
    }

    private Network networkFromInp(String path) throws IOException, FileNotFoundException {
        INPReader r = new INPReader(path);
        Network net = r.getNework();
        return net;
    }
}
