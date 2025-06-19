package Materia.controllers;

import java.util.ArrayList;
import java.util.List;

import Materia.models.Node;

public class ArbolBinario {
    
    private Node root;
    private int weight;
    private List<Node> nodosNoBalaceados;
    private boolean isBalanced;

    public ArbolBinario(){
        this.root = null;
        this.nodosNoBalaceados = new ArrayList<Node>();
        this.isBalanced = true;
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

    public void imprimirArbolInOrderWithBF(){
        imprimirInOrderwithBf(root);
    }

    public void imprimirArbolInOrder(){
        imprimirInOrder(root);
    }
    public void imprimirArbolInOrderwithHeigths(){
        imprimirArbolInOrderwithHeigths(root);
    }
    
    private void imprimirArbolInOrderwithHeigths(Node node){
        if(node !=null){
            imprimirArbolInOrderwithHeigths(node.getLeft());
            System.out.print(node.getValue()+"(h= "+ getHeightRec(node)+"), ");
            imprimirArbolInOrderwithHeigths(node.getRight());
        }
    }
    private void imprimirInOrder(Node node){
        if(node !=null){
            imprimirInOrder(node.getLeft());
            System.out.print(node.getValue()+", ");
            imprimirInOrder(node.getRight());
        }
    }
    private void imprimirInOrderwithBf(Node node){
        if(node !=null){
            imprimirInOrderwithBf(node.getLeft());
            System.out.print(node.getValue()+"(bf= "+getBF(node)+"), ");
            imprimirInOrderwithBf(node.getRight());
        }
    }
    
    private void imprimirPreOrder(Node node){
        if(node !=null){
            System.out.print(node.getValue()+",");
            imprimirPreOrder(node.getLeft());
            imprimirPreOrder(node.getRight());
        }
    }

    public void getNodosNoBalaceados(){
        List<Node> copia = new ArrayList<>(nodosNoBalaceados); // ✅ copia segura
        for (Node nodo : copia) {
            System.out.println("Nodos no equilibrados= "+nodo.getValue() + " (fE = " + getBF(nodo) + ")");
        }
    }

    public int getWeith(){
        return weight;
    }

    public boolean isBalanced(){
        return isBalanced;
    }

    public boolean buscar(int value){
        return buscarRec(root,value);
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

    

    private int getBF(Node node){
        if (node == null) return 0;
        int left = getHeightRec(node.getLeft());
        int right = getHeightRec(node.getRight());
        int factor = left-right;
        if (factor < -1 || factor > 1) {
            isBalanced = false;
            nodosNoBalaceados.add(node);
        }
        return factor;
    }




    
}
