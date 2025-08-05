import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Controlador controlador = new Controlador();
        Monstruos ganador;

        Habilidad h1 = new Habilidad("Torrente", 15);
        Habilidad h2 = new Habilidad("Llama incandescente", 20);
        Habilidad h3 = new Habilidad("Fertilizante", 10);
        Habilidad h4 = new Habilidad( "Sobre carga", 100);

        Monstruos p1 = new Monstruos("Poliwag", h1, "agua", 15, 10);
        Monstruos p2 = new Monstruos("Pikachu", h4, "electrico", 15, 0);
        Monstruos p3 = new Monstruos("Bulbasaur", h3, "planta", 10, 20);
        Monstruos p4 = new Monstruos("Charmander", h2, "fuego", 20, 5);
        Monstruos p5 = new Monstruos("Squirtle", h1, "agua", 10, 20);
        Monstruos p6 = new Monstruos("Tepig", h2, "fuego", 25, 5);
        Monstruos p7 = new Monstruos("Pichu", h4, "electrico", 10, 0);
        Monstruos p8 = new Monstruos("Treecko", h3, "planta", 15, 15);

        Entrenador n1 = new Entrenador("Pal", null);
        Entrenador n2 = new Entrenador("Alex", null);

        List <Monstruos> pokemond = new ArrayList<>();
        pokemond.add(p1);
        pokemond.add(p2);
        pokemond.add(p3);
        pokemond.add(p4);
        pokemond.add(p5);
        pokemond.add(p6);
        pokemond.add(p7);
        pokemond.add(p8);
        List <Monstruos> equipo1 = new ArrayList<>();
        List <Monstruos> equipo2 = new ArrayList<>();
        
        for (int i = 0; i<8; i ++){
        Random opciones = new Random();
        int x = opciones.nextInt(pokemond.size());
            if (equipo1.size()< 4) {
                equipo1.add(pokemond.get(x));
                pokemond.remove(x);
            }
            else{
                equipo2.add(pokemond.get(x));
                pokemond.remove(x);
            }
            }

        int N1ganado = 0;
        int N2ganado = 0;

        for (int ii = 0; ii<4; ii++){
            Random n = new Random();
            switch (ii) {
                case 0:
                //Ronda 1
                System.out.println("Equipo de " + n1.getNombre() + ":");
                for(int iii = 0; iii<equipo1.size(); iii++){
                    System.out.println(equipo1.get(iii).getNombre() + " "  +"["+ equipo1.get(iii).getTipo()+ "]");
                } 
                try{Thread.sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("--------------------------------------------");
                int peleador1 = n.nextInt(equipo1.size());
                    if (n1.getPokemon() == null) {
                        n1.setPokemon(equipo1.get(peleador1));
                        equipo1.remove(peleador1);
                    }
                    System.out.println("Equipo de " + n2.getNombre() + ":");
                for(int iii = 0; iii<equipo2.size(); iii++){
                    System.out.println(equipo2.get(iii).getNombre() + " " + "["+ equipo2.get(iii).getTipo()+ "]");
                }
                try{Thread.sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                    int peleador2 = n.nextInt(equipo2.size());
                    if (n2.getPokemon() == null) {
                        n2.setPokemon(equipo2.get(peleador2));
                        equipo2.remove(peleador2);
                    }
                    System.out.println("**************************************");
                    System.out.println("Ronda 1:");
                    System.out.println(n1.getNombre()+ " a elegido a " + n1.getPokemon().getNombre());
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    System.out.println(n2.getNombre()+ " a elegido a " + n2.getPokemon().getNombre());
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    int accion1 = n.nextInt(100)+1;
                    int accion2 = n.nextInt(100)+1;
                    int sucORfail1 = n1.getPokemon().getHabilidad().Activartefecto();
                    int sucORfail2 = n2.getPokemon().getHabilidad().Activartefecto();
                    //Entrenador 1
                   System.out.println(controlador.decision(accion1, n1, n2));
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    System.out.println(controlador.Efectividadaccion(accion1, n1.getPokemon(), n2.getPokemon(), sucORfail1));
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    //Entrenador 2
                    System.out.println(controlador.decision(accion2, n2, n1));
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    System.out.println(controlador.Efectividadaccion(accion2, n2.getPokemon(), n1.getPokemon(), sucORfail2));
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    //Ver el poder de los pokemons
                    System.out.println(controlador.Podertotal(accion1, accion2, n1.getPokemon(), n2.getPokemon(), sucORfail1, sucORfail2));
                    //Ver el ganador
                    ganador = controlador.jugarRonda(accion1, accion2, n1.getPokemon(), n2.getPokemon(), sucORfail1, sucORfail2);
                    if (ganador == null) {
                        System.out.println("La ronda terminó en un empate");
                    }
                    else{
                    if(ganador.getNombre() == n1.getPokemon().getNombre()){
                        System.out.println("El ganor de la ronda es " + n1.getNombre());
                        N1ganado += 1 ;
                    }
                    else if (ganador.getNombre() == n2.getPokemon().getNombre()){
                        System.out.println("El ganor de la ronda es " + n2.getNombre());
                        N2ganado += 1;
                    }
                    }
                    break;
                
                case 1:
                //Ronda 2
                n1.setPokemon(null);
                n2.setPokemon(null);
                try{Thread.sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("--------------------------------------------");
                int l3 = n.nextInt(equipo1.size());
                    if (n1.getPokemon() == null) {
                        n1.setPokemon(equipo1.get(l3));
                        equipo1.remove(l3);
                    }
                    int l4 = n.nextInt(equipo2.size());
                    if (n2.getPokemon() == null) {
                        n2.setPokemon(equipo2.get(l4));
                        equipo2.remove(l4);
                    }
                    System.out.println("**************************************");
                    System.out.println("Ronda 2:");
                    System.out.println(n1.getNombre()+ " a elegido a " + n1.getPokemon().getNombre());
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    System.out.println(n2.getNombre()+ " a elegido a " + n2.getPokemon().getNombre());
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    accion1 = n.nextInt(100)+1;
                    accion2 = n.nextInt(100)+1;
                    sucORfail1 = n1.getPokemon().getHabilidad().Activartefecto();
                    sucORfail2 = n2.getPokemon().getHabilidad().Activartefecto();
                    //Entrenador 1
                   System.out.println(controlador.decision(accion1, n1, n2));
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    System.out.println(controlador.Efectividadaccion(accion1, n1.getPokemon(), n2.getPokemon(), sucORfail1));
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    //Entrenador 2
                    System.out.println(controlador.decision(accion2, n2, n1));
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    System.out.println(controlador.Efectividadaccion(accion2, n2.getPokemon(), n1.getPokemon(), sucORfail2));
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    //Ver el poder de los pokemons
                    System.out.println(controlador.Podertotal(accion1, accion2, n1.getPokemon(), n2.getPokemon(), sucORfail1, sucORfail2));
                    //Ver el ganador
                    ganador = controlador.jugarRonda(accion1, accion2, n1.getPokemon(), n2.getPokemon(), sucORfail1, sucORfail2);
                    if (ganador == null) {
                        System.out.println("La ronda terminó en un empate");
                    }
                    else{
                    if(ganador.getNombre() == n1.getPokemon().getNombre()){
                        System.out.println("El ganor de la ronda es " + n1.getNombre());
                        N1ganado += 1 ;
                    }
                    else if (ganador.getNombre() == n2.getPokemon().getNombre()){
                        System.out.println("El ganor de la ronda es " + n2.getNombre());
                        N2ganado += 1;
                    }
                    }
                    break;

                case 2:
                //Ronda 3
                n1.setPokemon(null);
                n2.setPokemon(null);
                try{Thread.sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("--------------------------------------------");
                int l5 = n.nextInt(equipo1.size());
                    if (n1.getPokemon() == null) {
                        n1.setPokemon(equipo1.get(l5));
                        equipo1.remove(l5);
                    }
                try{Thread.sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                    int l6 = n.nextInt(equipo2.size());
                    if (n2.getPokemon() == null) {
                        n2.setPokemon(equipo2.get(l6));
                        equipo2.remove(l6);
                    }
                    System.out.println("**************************************");
                    System.out.println("Ronda 3:");
                    System.out.println(n1.getNombre()+ " a elegido a " + n1.getPokemon().getNombre());
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    System.out.println(n2.getNombre()+ " a elegido a " + n2.getPokemon().getNombre());
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    accion1 = n.nextInt(100)+1;
                    accion2 = n.nextInt(100)+1;
                    sucORfail1 = n1.getPokemon().getHabilidad().Activartefecto();
                    sucORfail2 = n2.getPokemon().getHabilidad().Activartefecto();
                    //Entrenador 1
                   System.out.println(controlador.decision(accion1, n1, n2));
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    System.out.println(controlador.Efectividadaccion(accion1, n1.getPokemon(), n2.getPokemon(), sucORfail1));
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    //Entrenador 2
                    System.out.println(controlador.decision(accion2, n2, n1));
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    System.out.println(controlador.Efectividadaccion(accion2, n2.getPokemon(), n1.getPokemon(), sucORfail2));
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    //Ver el poder de los pokemons
                    System.out.println(controlador.Podertotal(accion1, accion2, n1.getPokemon(), n2.getPokemon(), sucORfail1, sucORfail2));
                    //Ver el ganador
                    ganador = controlador.jugarRonda(accion1, accion2, n1.getPokemon(), n2.getPokemon(), sucORfail1, sucORfail2);
                    if (ganador == null) {
                        System.out.println("La ronda terminó en un empate");
                    }
                    else{
                    if(ganador.getNombre() == n1.getPokemon().getNombre()){
                        System.out.println("El ganor de la ronda es " + n1.getNombre());
                        N1ganado += 1 ;
                    }
                    else if (ganador.getNombre() == n2.getPokemon().getNombre()){
                        System.out.println("El ganor de la ronda es " + n2.getNombre());
                        N2ganado += 1;
                    }
                    }
                    break;

                case 3:
                //Ronda 4
                n1.setPokemon(null);
                n2.setPokemon(null);
                try{Thread.sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("--------------------------------------------");
                int l7 = n.nextInt(equipo1.size());
                    if (n1.getPokemon() == null) {
                        n1.setPokemon(equipo1.get(l7));
                        equipo1.remove(l7);
                    }
                    int l8 = n.nextInt(equipo2.size());
                    if (n2.getPokemon() == null) {
                        n2.setPokemon(equipo2.get(l8));
                        equipo2.remove(l8);
                    }
                    System.out.println("**************************************");
                    System.out.println("Ronda 4:");
                    System.out.println(n1.getNombre()+ " a elegido a " + n1.getPokemon().getNombre());
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    System.out.println(n2.getNombre()+ " a elegido a " + n2.getPokemon().getNombre());
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    accion1 = n.nextInt(100)+1;
                    accion2 = n.nextInt(100)+1;
                    sucORfail1 = n1.getPokemon().getHabilidad().Activartefecto();
                    sucORfail2 = n2.getPokemon().getHabilidad().Activartefecto();
                    //Entrenador 1
                   System.out.println(controlador.decision(accion1, n1, n2));
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    System.out.println(controlador.Efectividadaccion(accion1, n1.getPokemon(), n2.getPokemon(), sucORfail1));
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    //Entrenador 2
                    System.out.println(controlador.decision(accion2, n2, n1));
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    System.out.println(controlador.Efectividadaccion(accion2, n2.getPokemon(), n1.getPokemon(), sucORfail2));
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    //Ver el poder de los pokemons
                    System.out.println(controlador.Podertotal(accion1, accion2, n1.getPokemon(), n2.getPokemon(), sucORfail1, sucORfail2));
                    //Ver el ganador
                    ganador = controlador.jugarRonda(accion1, accion2, n1.getPokemon(), n2.getPokemon(), sucORfail1, sucORfail2);
                    if (ganador == null) {
                        System.out.println("La ronda terminó en un empate");
                    }
                    else{
                    if(ganador.getNombre() == n1.getPokemon().getNombre()){
                        System.out.println("El ganor de la ronda es " + n1.getNombre());
                        N1ganado += 1 ;
                    }
                    else if (ganador.getNombre() == n2.getPokemon().getNombre()){
                        System.out.println("El ganor de la ronda es " + n2.getNombre());
                        N2ganado += 1;
                    }
                    }
                    break;
            }
        }
        try{Thread.sleep(1500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        System.out.println("**************************************");
        if (N1ganado>N2ganado) {
            System.out.println("El ganador de este combate pokemon es " + n1.getNombre());
        }
        else if (N1ganado<N2ganado){
            System.out.println("El ganador de este combate pokemon es " + n2.getNombre());
        }
        else{
            System.out.println("El combate termina en un empate");
        }
    }
}
