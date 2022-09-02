package classes;

public class Perro implements Animal{

    public int velocidad;
    public String comida;

    public Perro(int velocidad, String comida) {
        this.velocidad = velocidad;
        this.comida = comida;
    }

    public Perro() {
        this.velocidad = 20;
        this.comida = "meat";
    }

    public void correr(){ System.out.println("Run with a bone in your mouth!");}

    public int velocidad(){return this.velocidad;}

    public String comida(){return this.comida;}

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
}
