package com.jepanet.model;

import com.jepanet.model.elements.Link;
import com.jepanet.model.elements.Node;
import com.jepanet.model.exceptions.IllegalElementInsertion;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Network {
    
    private Map<String, Node> nodes;
    
    private Map<String, Link> links;
    
    private Map<String, List<String>> outAdj;
    
    private Map<String, List<String>> inAdj;

    public Network() {
        nodes = new HashMap<>();
        links = new HashMap<>();
        outAdj = new HashMap<>();
        inAdj = new HashMap<>();
    }
    
    public int getNodeCount(){
        return nodes.size();
    }
    
    public int getLinkCount(){
        return links.size();
    }
    
    public int getElementCount(){
        return getNodeCount() + getLinkCount();
    }
    
    public void AddNode(Node n) throws IllegalElementInsertion {
        final String id = n.getID();
        if (id != null && !id.isEmpty() && !nodes.containsKey(id))
            nodes.put(id, n);
        else
            throw new IllegalElementInsertion();            
    }
    
    
    public void AddLink(Link l) throws IllegalElementInsertion {
        final String id = l.getID();
        
        if (!nodes.containsKey(l.getStartNodeId()) || !nodes.containsKey(l.getEndNodeId()))
            throw  new IllegalElementInsertion();
        
        if (id != null && !id.isEmpty() && !links.containsKey(id))
            links.put(id, l);
        else 
            throw  new IllegalElementInsertion();
    }
    
    
}
