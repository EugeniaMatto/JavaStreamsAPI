package classes;

public class Caballo implements Animal{

    public int velocidad;
    public String comida;

    public Caballo(int velocidad, String comida) {
        this.velocidad = velocidad;
        this.comida = comida;
    }

    public Caballo() {
        this.velocidad = 30;
        this.comida = "grass";
    }

    public void correr(){ System.out.println("Run very fast!!");}

    public int velocidad(){return this.velocidad;}

    public String comida(){return this.comida;}

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
}
