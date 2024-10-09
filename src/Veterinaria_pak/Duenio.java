package Veterinaria_pak;

import java.io.Serializable;

public class Duenio extends Persona implements Serializable, Comportamiento, IDuenio{
    @Override
    public void comunicarse(){
        System.out.println("Se comunica menos técnica");
    }
    @Override
    public void isSoltero(){
        // if(true){
        //     System.out.println("Esta soltero");
        // }else{
        //     System.out.println("Esta en pareja");
        // }
    }

    @Override
    public void alimentarMascota(){
        System.out.println("El dueño esta alimentando a su mascota");
    }

}
