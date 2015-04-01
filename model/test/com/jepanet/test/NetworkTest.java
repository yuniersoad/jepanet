package com.jepanet.test;

import com.jepanet.model.Network;
import com.jepanet.model.elements.Pipe;
import com.jepanet.model.elements.Junction;
import com.jepanet.model.elements.Link;
import com.jepanet.model.exceptions.IllegalElementInsertion;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NetworkTest {   
   
    Network net;
    String str3;
    
    @Before
    public void setUp() {
        net = new Network();
        str3 = "Hii";
    }
    
    @Test
     public void insertJunctions() throws IllegalElementInsertion {
         net.AddNode(new Junction("C1"));
         assertEquals(1, net.getNodeCount()); 

         net.AddNode(new Junction("C2"));
         assertEquals(2, net.getNodeCount());
     }
     
     @Test(expected = IllegalElementInsertion.class )
     public void insertJunctionsSameId() throws IllegalElementInsertion{
         net.AddNode(new Junction("C1"));
         net.AddNode(new Junction("C1"));         
     }
     
     @Test(expected = IllegalElementInsertion.class )
     public void insertSameNullId() throws IllegalElementInsertion{
         net.AddNode(new Junction(null));
               
     }
     
     @Test(expected = IllegalElementInsertion.class)
     public void insertSameLinkId() throws IllegalElementInsertion
     {
         net.AddNode(new Junction("C1"));
         net.AddNode(new Junction("C2"));
         
         net.AddLink(new Pipe("P1", "C1", "C2"));
         net.AddLink(new Pipe("P1", "C1", "C2"));
     }
     
     @Test(expected = IllegalElementInsertion.class)
     public void insertLinkNotExistJunctions() throws IllegalElementInsertion
     {
         net.AddLink(new Pipe("P1", "C1", "C2"));         
     }
     
     @Test
     public void insertLinks() throws IllegalElementInsertion {
         net.AddNode(new Junction("C1"));
         net.AddNode(new Junction("C2"));
         
         net.AddLink(new Pipe("P1", "C1", "C2"));
         assertEquals(1, net.getLinkCount()); 
         
         List<Link> outgoingFromC1 = net.outgoingLinksForNode("C1");
         assertEquals(1, outgoingFromC1.size());
         
         List<Link> incomingToC2 = net.incomingLinksForNode("C2");
         assertEquals(1, incomingToC2.size());
         
         assertSame(outgoingFromC1.get(0), incomingToC2.get(0));
     }
     
     @Test
     public void testStringMemorySave(){
         String str1 = "Hii";
         String str2 = "Hii";
         
         assertSame(str1, str2);
         assertSame(str3, str2);
     }
}
