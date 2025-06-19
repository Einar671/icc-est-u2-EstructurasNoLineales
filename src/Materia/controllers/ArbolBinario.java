package Materia.controllers;

import Materia.models.Node;

public class ArbolBinario {
    
    private Node root;
    private int weight;

    public ArbolBinario(){
        this.root = null;
    }
    
    public void insert(int value){
        root = insertRec(root, value);
        weight++;
    }

    private Node insertRec(Node padre, int value){
        if(padre == null){
            return new Node(value);
        }
        if(value<padre.getValue()){ 
        //Izquierda
        padre.setLeft(insertRec(padre.getLeft(), value));
        }else if(value>padre.getValue()){
        //Derecha
        padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    } 

    public void imprimirArbol(){
        imprimirPreOrder(root);
        imprimirInOrder(root);
    }

    private void imprimirInOrder(Node node){
        if(node !=null){
            imprimirInOrder(node.getLeft());
            System.out.print(node.getValue()+", ");
            imprimirInOrder(node.getRight());
        }
    }
    
    private void imprimirPreOrder(Node node){
        if(node !=null){
            System.out.print(node.getValue()+",");
            imprimirPreOrder(node.getLeft());
            imprimirPreOrder(node.getRight());
        }
    }

    public boolean buscar(int value){
        return buscarRec(root,value);
    }

    public int getWeith(){
        return weight;
    }

    private boolean buscarRec(Node node, int value){
        if(node == null) return false;
        if(node.getValue() == value) return true;
        if(value<node.getValue()) return buscarRec(node.getLeft(), value);
        if(value>node.getValue()) return buscarRec(node.getRight(), value);
        return false;
    }

    public int getHeight(){
        return getHeightRec(root);
    }

    private int getHeightRec(Node node){
        if(node==null) return 0;
        int leftHeight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;        
    }

    
}
