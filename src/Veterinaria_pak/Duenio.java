package Veterinaria_pak;

import java.io.Serializable;

public class Duenio extends Persona implements Serializable, Comportamiento, IDuenio{

    
    @Override
    public void comunicarse(){
        System.out.println("Se comunica menos técnica");
    }

    @Override
    public void alimentarMascota(){
        System.out.println("El dueño esta alimentando a su mascota");
    }

    @Override
    public void movimiento(){
        System.out.println("");
    }

    @Override
    public void alimentarse() {
        System.out.println("");
    }

}
