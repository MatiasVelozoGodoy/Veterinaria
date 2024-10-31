package Veterinaria_pak;

public abstract class Animal implements Comportamiento {
    private String nombre;
    private String color;
    private String raza;
    private int edad;

    public Animal(){

    }
    public Animal(String nombre){

    }
    public Animal(String nombre, String color){
        this.nombre = nombre;
        this.color = color;
    }

    public Animal(String nombre, String color, String raza){
        this.nombre = nombre;
        this.color = color;
        this.raza = raza;
    }

    public Animal(String nombre ,String color, String raza, int edad){
        this.nombre = nombre;
        this.color = color;
        this.raza = raza;
        this.edad = edad;
    }


}
