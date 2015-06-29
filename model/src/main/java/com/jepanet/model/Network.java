package com.jepanet.model;

import com.jepanet.model.elements.Link;
import com.jepanet.model.elements.Node;
import com.jepanet.model.exceptions.IllegalElementInsertion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Network {
    
    private String title;
    private final List<String> notes;
    
    final private Map<String, Node> nodes;
    
    final private Map<String, Link> links;
    
    final private Map<String, List<String>> outAdj;
    
    final private Map<String, List<String>> inAdj;

    public Network() {
        nodes = new HashMap<>();
        links = new HashMap<>();
        outAdj = new HashMap<>();
        inAdj = new HashMap<>();
        notes = new ArrayList<>();
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void clearNotes()
    {
        notes.clear();
    }
            
    public void addNote(String note){
        notes.add(note);
    }
    
    public List<String> getNotes()
    {
        return notes;
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
        final String startNodeId = l.getStartNodeId();
        final String endNodeId = l.getEndNodeId();
        
        if (!nodes.containsKey(startNodeId) || !nodes.containsKey(endNodeId))
            throw  new IllegalElementInsertion();
        
        if (id != null && !id.isEmpty() && !links.containsKey(id)){
            links.put(id, l);
            addAdjacency(outAdj, startNodeId, l);
            addAdjacency(inAdj, endNodeId, l);
        }
        else 
            throw  new IllegalElementInsertion();
    }
    
    public List<Link> outgoingLinksForNode(String nodeId) {
        return getLinksInAdj(nodeId, outAdj);        
    }    
    
    public List<Link> outgoingLinksForNode(Node node) {
        return outgoingLinksForNode(node.getID());
    }
    
    public List<Link> incomingLinksForNode(String nodeId){
        return getLinksInAdj(nodeId, inAdj);
    }
    
    public List<Link> incomingLinksForNode(Node node){
        return incomingLinksForNode(node.getID());
    }
    
    
    private List<Link> getLinksInAdj(String nodeId, Map<String, List<String>> adjList) {
        final List<Link> result;
        List<String> linkIDs = adjList.get(nodeId);
        
        if (linkIDs != null) {
            result = new ArrayList<>(linkIDs.size());
            linkIDs.forEach((l_id) -> result.add(links.get(l_id)));            
        } else
            result = new ArrayList<>();
        
        return result;        
    }

    private void addAdjacency(Map<String, List<String>> adjList, String nodeId, Link l) {
       
       List<String> adjLinks = adjList.get(nodeId);
        if (adjLinks == null) {
            
            adjLinks = new LinkedList<>();
            adjList.put(nodeId, adjLinks);
        }
        
        adjLinks.add(l.getID());
        
            
    }
}
