package Materia.controllers;

import Materia.models.Node;

public class ArbolBinario {
    
    private Node root;

    public ArbolBinario(){
        this.root = null;
    }
    
    public void insert(int value){
        root = insertRec(root, value);
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
}
