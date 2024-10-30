package Veterinaria_pak;

public abstract class Persona {
    private int DNI;
    private String Nombre;
    private String Apellido;
    private String Nacionalidad;

    public Persona(){
//#region Constructores
    }
    public Persona(int DNI){
        this.DNI = DNI;
    }
    public Persona(int DNI, String Nombre){
        this.DNI = DNI;
        this.Nombre = Nombre;
    }
    public Persona(int DNI, String Nombre,String Apellido){
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
    }
    public Persona(int DNI, String Nombre, String Apellido, String Nacionalidad){
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Nacionalidad = Nacionalidad;
    }
//#endregion Constructores

    public int Get_dni(){
        return DNI;
    }
    public void Set_dni(int DNI){
        this.DNI = DNI;
    }
    public String Get_nombre(){
        return Nombre;
    }
    public void Set_Nombre(String Nombre){
        this.Nombre = Nombre;
    }
    public String Get_apellido(){
        return Apellido;
    }
    public void Set_apellido(String Apellido){
        this.Apellido = Apellido;
    }
    public String Get_nacionalidad(){
        return Nacionalidad;
    }
    public void Set_nacionalidad(String Nacionalidad){
        this.Nacionalidad = Nacionalidad;
    }
}
