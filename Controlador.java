public class Controlador {
    private Monstruos ganador;
    private String texto;
    private String texto1;

    public Controlador(){
    }

    //Objeto para jugar una ronda.
    public Monstruos jugarRonda(int atacarOhabilidad1, int atacarOhabilidad2, Monstruos pokemon1, Monstruos pokemon2, int sucORfail1, int sucORfail2) {
        if (atacarOhabilidad1<51) {
            if (pokemon1.getTipo() == "fuego" && pokemon2.getTipo() == "planta") {
                pokemon1.setAtaque(pokemon1.getAtaque() + 20);
            }
            else if (pokemon1.getTipo() == "fuego" && pokemon2.getTipo() == "agua") {
                pokemon1.setAtaque(pokemon1.getAtaque() - 10);
            }
            else if (pokemon1.getTipo() == "planta" && pokemon2.getTipo() == "agua") {
                pokemon1.setAtaque(pokemon1.getAtaque() + 20);
            }
            else if (pokemon1.getTipo() == "planta" && pokemon2.getTipo() == "fuego") {
                pokemon1.setAtaque(pokemon1.getAtaque() - 10);
            }
            else if(pokemon1.getTipo() == "agua" && pokemon2.getTipo() == "fuego") {
                pokemon1.setAtaque(pokemon1.getAtaque() + 20);
            }
            else if (pokemon1.getTipo() == "agua" && pokemon2.getTipo() == "planta") {
                pokemon1.setAtaque(pokemon1.getAtaque() - 10);
            }
            else if (pokemon1.getTipo() == "agua" && pokemon2.getTipo() == "electrico") {
                pokemon1.setAtaque(pokemon1.getAtaque() - 10);
            }
            else if (pokemon1.getTipo() == "electrico" && pokemon2.getTipo() == "agua") {
                pokemon1.setAtaque(pokemon1.getAtaque() + 20);
            }
        }
        else{
                pokemon1.setAtaque(pokemon1.getAtaque() + sucORfail1);
        }
    if (atacarOhabilidad2<51) {
            if (pokemon2.getTipo() == "fuego" && pokemon1.getTipo() == "planta") {
                pokemon2.setAtaque(pokemon2.getAtaque() + 20);
            }
            else if (pokemon2.getTipo() == "fuego" && pokemon1.getTipo() == "agua") {
                pokemon2.setAtaque(pokemon2.getAtaque() - 10);
            }
            else if (pokemon2.getTipo() == "planta" && pokemon1.getTipo() == "agua") {
                pokemon2.setAtaque(pokemon2.getAtaque() + 20);
            }
            else if (pokemon2.getTipo() == "planta" && pokemon1.getTipo() == "fuego") {
                pokemon2.setAtaque(pokemon2.getAtaque() - 10);
            }
            else if (pokemon2.getTipo() == "agua" && pokemon1.getTipo() == "fuego") {
                pokemon2.setAtaque(pokemon2.getAtaque() + 20);
            }
            else if (pokemon2.getTipo() == "agua" && pokemon1.getTipo() == "planta") {
                pokemon2.setAtaque(pokemon2.getAtaque() - 10);
            }
            else if (pokemon2.getTipo() == "agua" && pokemon1.getTipo() == "electrico") {
                pokemon2.setAtaque(pokemon2.getAtaque() - 10);
            }
            else if (pokemon2.getTipo() == "electrico" && pokemon1.getTipo() == "agua") {
                pokemon2.setAtaque(pokemon2.getAtaque() + 20);
            }
        }
        else{
            pokemon2.setAtaque(pokemon2.getAtaque() + sucORfail2);
        }
        int TP1 = pokemon1.getAtaque() + pokemon1.getDefensa();
        int TP2 = pokemon2.getAtaque() + pokemon2.getDefensa();
        if (TP1 == TP2) {
            ganador = null;
        }
        else{
        if(TP1 > TP2){
            ganador = pokemon1 ;
        }
        else if (TP1 < TP2){
                ganador = pokemon2 ;
        }
        }
        return ganador;
    }



    // Objeto que indica qué va a realizar el entrenador.
    public String decision (int atacarOhabilidad1, Entrenador entrenador1, Entrenador entrenador2){
        if (atacarOhabilidad1<51){
            texto =  (entrenador1.getNombre() + " va a atacar al pokemon de " + entrenador2.getNombre());
        } 
        else{
            texto = (entrenador1.getNombre() + " va a usar la habilidad especial de su pokemon ");
        }
        return texto;
    }



    //Objeto para ver si qué acción hizo y cual fue el desenlace de esta.
    public String Efectividadaccion (int atacarOhabilidad1, Monstruos pokemon1, Monstruos pokemon2, int sucORfail) {
        if (atacarOhabilidad1<51) {
            if (pokemon1.getTipo() == "fuego" && pokemon2.getTipo() == "planta") {
                texto1 = ("El ataque de " + pokemon1.getNombre() + " a sido super efectivo");
            }
            else if (pokemon1.getTipo() == "fuego" && pokemon2.getTipo() == "agua") {
                 texto1 = ("El ataque de " + pokemon1.getNombre() + " a sido poco efectivo");
            }
            else if (pokemon1.getTipo() == "planta" && pokemon2.getTipo() == "agua") {
               texto1 = ("El ataque de " + pokemon1.getNombre() + " a sido super efectivo");
            }
            else if (pokemon1.getTipo() == "planta" && pokemon2.getTipo() == "fuego") {
                texto1 = ("El ataque de " + pokemon1.getNombre() + " a sido poco efectivo");
            }
            else if(pokemon1.getTipo() == "agua" && pokemon2.getTipo() == "fuego") {
                texto1 = ("El ataque de " + pokemon1.getNombre() + " a sido super efectivo");
            }
            else if (pokemon1.getTipo() == "agua" && pokemon2.getTipo() == "planta") {
                texto1 = ("El ataque de " + pokemon1.getNombre() + " a sido poco efectivo");
            }
            else if (pokemon1.getTipo() == "agua" && pokemon2.getTipo() == "electrico") {
                texto1 = ("El ataque de " + pokemon1.getNombre() + " a sido poco efectivo");
            }
            else if (pokemon1.getTipo() == "electrico" && pokemon2.getTipo() == "agua") {
                texto1 = ("El ataque de " + pokemon1.getNombre() + " a sido super efectivo");
            }
            else{
                texto1 = (pokemon2.getNombre() + " a evitado el ataque de " + pokemon1.getNombre());
            }
        }
        else{
            if (sucORfail != 0) {
                texto1 = (pokemon1.getNombre() + " a activado su habilidad especial " + "¡"+ pokemon1.getHabilidad().getNombre() + "!");
            }
            else {
                texto1 = (pokemon1.getNombre() + " a fallado en activar su habilidad especial");
            }
        }
        return texto1;
    }



    //Objeto para ver el poder total de cada pokemon.
    public String Podertotal(int atacarOhabilidad1, int atacarOhabilidad2, Monstruos pokemon1, Monstruos pokemon2, int sucORfail1, int sucORfail2) {
         if (atacarOhabilidad1<51) {
            if (pokemon1.getTipo() == "fuego" && pokemon2.getTipo() == "planta") {
                pokemon1.setAtaque(pokemon1.getAtaque() + 20);
            }
            else if (pokemon1.getTipo() == "fuego" && pokemon2.getTipo() == "agua") {
                pokemon1.setAtaque(pokemon1.getAtaque() - 10);
            }
            else if (pokemon1.getTipo() == "planta" && pokemon2.getTipo() == "agua") {
                pokemon1.setAtaque(pokemon1.getAtaque() + 20);
            }
            else if (pokemon1.getTipo() == "planta" && pokemon2.getTipo() == "fuego") {
                pokemon1.setAtaque(pokemon1.getAtaque() - 10);
            }
            else if(pokemon1.getTipo() == "agua" && pokemon2.getTipo() == "fuego") {
                pokemon1.setAtaque(pokemon1.getAtaque() + 20);
            }
            else if (pokemon1.getTipo() == "agua" && pokemon2.getTipo() == "planta") {
                pokemon1.setAtaque(pokemon1.getAtaque() - 10);
            }
            else if (pokemon1.getTipo() == "agua" && pokemon2.getTipo() == "electrico") {
                pokemon1.setAtaque(pokemon1.getAtaque() - 10);
            }
            else if (pokemon1.getTipo() == "electrico" && pokemon2.getTipo() == "agua") {
                pokemon1.setAtaque(pokemon1.getAtaque() + 20);
            }
        }
        else{
                pokemon1.setAtaque(pokemon1.getAtaque() + sucORfail1);
        }
    if (atacarOhabilidad2<51) {
            if (pokemon2.getTipo() == "fuego" && pokemon1.getTipo() == "planta") {
                pokemon2.setAtaque(pokemon2.getAtaque() + 20);
            }
            else if (pokemon2.getTipo() == "fuego" && pokemon1.getTipo() == "agua") {
                pokemon2.setAtaque(pokemon2.getAtaque() - 10);
            }
            else if (pokemon2.getTipo() == "planta" && pokemon1.getTipo() == "agua") {
                pokemon2.setAtaque(pokemon2.getAtaque() + 20);
            }
            else if (pokemon2.getTipo() == "planta" && pokemon1.getTipo() == "fuego") {
                pokemon2.setAtaque(pokemon2.getAtaque() - 10);
            }
            else if (pokemon2.getTipo() == "agua" && pokemon1.getTipo() == "fuego") {
                pokemon2.setAtaque(pokemon2.getAtaque() + 20);
            }
            else if (pokemon2.getTipo() == "agua" && pokemon1.getTipo() == "planta") {
                pokemon2.setAtaque(pokemon2.getAtaque() - 10);
            }
            else if (pokemon2.getTipo() == "agua" && pokemon1.getTipo() == "electrico") {
                pokemon2.setAtaque(pokemon2.getAtaque() - 10);
            }
            else if (pokemon2.getTipo() == "electrico" && pokemon1.getTipo() == "agua") {
                pokemon2.setAtaque(pokemon2.getAtaque() + 20);
            }
        }
        else{
            pokemon2.setAtaque(pokemon2.getAtaque() + sucORfail2);
        }
        int TP1 = pokemon1.getAtaque() + pokemon1.getDefensa();
        int TP2 = pokemon2.getAtaque() + pokemon2.getDefensa();
        return ("El poder total de " + pokemon1.getNombre() + " es de " + TP1 + "\n" + "El poder total de " + pokemon2.getNombre() + " es de " + TP2);
    }
}   