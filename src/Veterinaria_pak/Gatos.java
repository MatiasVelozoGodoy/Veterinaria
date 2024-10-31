package Veterinaria_pak;

public class Gatos implements Comportamiento{

    @Override
    public void comunicarse() {
        System.out.println("Maulla");
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
