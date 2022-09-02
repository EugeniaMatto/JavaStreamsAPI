package classes;

public class Conejo implements Animal{

    public int velocidad;
    public String comida;

    public Conejo(int velocidad, String comida) {
        this.velocidad = velocidad;
        this.comida = comida;
    }

    public Conejo() {
        this.velocidad = 5;
        this.comida = "vegetables";
    }

    public void correr(){System.out.println("He's jumping...");}

    public int velocidad(){return this.velocidad;}

    public String comida(){return this.comida;}

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
}
