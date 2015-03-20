package com.jepanet.test;

import com.jepanet.model.Network;
import com.jepanet.model.elements.Link;
import com.jepanet.model.elements.Node;
import com.jepanet.model.exceptions.IllegalElementInsertion;
import org.junit.After;
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
     public void insertNodes() throws IllegalElementInsertion {
         net.AddNode(new Node("C1"));
         assertEquals(1, net.getNodeCount()); 

         net.AddNode(new Node("C2"));
         assertEquals(2, net.getNodeCount());
     }
     
     @Test(expected = IllegalElementInsertion.class )
     public void insertNodesSameId() throws IllegalElementInsertion{
         net.AddNode(new Node("C1"));
         net.AddNode(new Node("C1"));         
     }
     
     @Test(expected = IllegalElementInsertion.class )
     public void insertSameNullId() throws IllegalElementInsertion{
         net.AddNode(new Node(null));
               
     }
     
     @Test(expected = IllegalElementInsertion.class)
     public void insertSameLinkId() throws IllegalElementInsertion
     {
         net.AddNode(new Node("C1"));
         net.AddNode(new Node("C2"));
         
         net.AddLink(new Link("P1", "C1", "C2"));
         net.AddLink(new Link("P1", "C1", "C2"));
     }
     
     @Test
     public void insertLinks() throws IllegalElementInsertion {
         net.AddNode(new Node("C1"));
         net.AddNode(new Node("C2"));
         
         net.AddLink(new Link("P1", "C1", "C2"));
         assertEquals(1, net.getLinkCount()); 
     }
     
     @Test
     public void testStringMemorySave(){
         String str1 = "Hii";
         String str2 = "Hii";
         
         assertSame(str1, str2);
         assertSame(str3, str2);
     }
}
