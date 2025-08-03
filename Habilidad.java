import java.util.Random;

public class Habilidad {
    private String nombre;
    private int efecto;

    public Habilidad(String nombre, int efecto){
        this.nombre = nombre;
        this.efecto = efecto;
    }

    public int getEfecto(){
        return efecto;
    }

    public String getNombre(){
        return nombre;
    }

    public int Activartefecto(){
        Random numero = new Random();
        int x = numero.nextInt(100)+1;
        if (0<= x && x<31){
            return efecto;
        }
        else{
            return 0;
        }
    }
}
