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

        ab.imprimirArbol();
        if(!ab.buscar(23)){
            System.out.println("no encontrado");
        } else {
            System.out.println("Encontrado");
        }
        System.out.println(ab.getHeight());
        System.out.println(ab.getWeith());
    }
}
