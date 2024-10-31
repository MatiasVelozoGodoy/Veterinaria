package Veterinaria_pak;

import java.io.Serializable;


public class Veterinario extends Persona implements Serializable, Comportamiento, IVeterinario{

    @Override
    public void comunicarse() {
        System.out.println("Se comunica de manera más técnica");
        
    }


    @Override
    public void diagnosticarAnimal() {
        System.out.println("El veterinario esta diagnosticando al animal");
    }

    @Override
    public void recetarTratamiento() {
        System.out.println("El veterinario le esta recetando medicamento al animal");
    }

    @Override
    public void movimiento() {
        System.out.println("Camina de manera normal");
    }


    @Override
    public void alimentarse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alimentarse'");
    }
    
}
