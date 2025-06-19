import Materia.controllers.ArbolBinario;

public class App {
    public static void main(String[] args) throws Exception {
        ArbolBinario ab = new ArbolBinario();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);
        System.out.println("Nombre: Einar Kaalhus");
        System.out.println("\nPeso del arbol = "+ab.getWeith());
        System.out.println("Altura es = "+ab.getHeight());
        System.out.println("\nArbol InOrder");
        ab.imprimirArbolInOrder();
        System.out.println("\n\nArbol InOrder con alturas");
        ab.imprimirArbolInOrderwithHeigths();
        System.out.println("\n\nArbol InOrder con Factor de Equilibrio");
        ab.imprimirArbolInOrderWithBF();
        System.out.println("\n\nArbol equilibrado = "+ab.isBalanced());
        System.out.println("Agregamos valor = 15");
        ab.insert(15);
        System.out.println("\n\nArbol InOrder con Factor de Equilibrio");
        ab.imprimirArbolInOrderWithBF();
        System.out.println("\n\nArbol equilibrado = "+ab.isBalanced());
        ab.getNodosNoBalaceados();

        
    }
}
