package Veterinaria_pak;

public class Perros extends Animal implements  Comportamiento {
    private String tamaño;
    private double peso;

    public Perros(){                
    }

    @Override
    public void comunicarse() {
        System.out.println("Ladra");
    }

    @Override
    public void movimiento() {
        System.out.println("");
    }

    @Override
    public void alimentarse() {
        System.out.println("");
    }

}
