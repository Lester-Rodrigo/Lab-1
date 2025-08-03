public class Entrenador {
    private String nombre;
    private Monstruos pokemon;
    

    public Entrenador (String nombre, Monstruos pokemon){
        this.nombre = nombre;
        this.pokemon = pokemon;
    }

    public String getNombre(){
        return nombre;
    }

    public Monstruos getPokemon(){
        return pokemon;
    }

    public void setPokemon(Monstruos pokemon){
        this.pokemon = pokemon;
    }
}
