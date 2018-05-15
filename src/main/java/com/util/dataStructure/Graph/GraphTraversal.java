package com.util.dataStructure.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class GraphTraversal {
    
    private HashMap<Integer,Node> nodeLookUp =  new HashMap<Integer,Node>();
    
    public static class Node{
        int id;
        LinkedList<Node> adjacent = new LinkedList<Node>();
        
        Node(int id){
            this.id =id;
        }
    }
    
    private Node getNode(int id){
        return nodeLookUp.get(new Integer(id));
    }
    
    private void addEdge(int source,int destination){
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }
    
    public boolean hasPathDFS(int source,int destination){
        Node s = getNode(source);
        Node d = getNode(destination); 
        HashSet<Integer>visited = new HashSet<Integer>();
        return hasDFS(s,d,visited);
    }

    private boolean hasDFS(Node source, Node destination, HashSet<Integer> visited) {
        if(visited.contains(source.id)){
            return false;
        }
        visited.add(source.id);
        if(source == destination){
            return true;
        }
        for(Node child : source.adjacent){
            if(hasDFS(child,destination,visited)){
                return true;
            }
        }
        return false;
        
    }
    
    public boolean hasPathBFS(Node source,Node destination){
        LinkedList<Node> nextToVist = new LinkedList<Node>();
        HashSet<Integer>visited = new HashSet<Integer>();
        nextToVist.add(source);
        while(!nextToVist.isEmpty()){
            Node node = nextToVist.remove();
            if(node == destination){
                return true;
            }
            if(visited.contains(node.id)){
                continue;
            }else{
                visited.add(node.id);
            }
            for(Node child : node.adjacent){
                nextToVist.add(child);
            }
        }
        return false;
    }

}
