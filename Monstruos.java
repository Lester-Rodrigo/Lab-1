public class Monstruos {
    private String nombre; 
    private Habilidad habilidad;
    private String tipo;
    private int ataque;
    private int defensa; 

    public Monstruos(String nombre, Habilidad habilidad, String tipo, int ataque, int defensa){
        this.nombre = nombre;
        this.tipo = tipo;
        this.habilidad = habilidad;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public String getNombre(){
        return nombre;
    }

    public String getTipo(){
        return tipo;
    }

    public Habilidad getHabilidad(){
        return habilidad;
    }

    public int getAtaque(){
        return ataque;
    }

    public int getDefensa(){
        return defensa;
    }
}
