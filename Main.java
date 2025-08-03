import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

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
                int l1 = n.nextInt(equipo1.size());
                    if (n1.getPokemon() == null) {
                        n1.setPokemon(equipo1.get(l1));
                        equipo1.remove(l1);
                    }
                    System.out.println("Equipo de " + n2.getNombre() + ":");
                for(int iii = 0; iii<equipo2.size(); iii++){
                    System.out.println(equipo2.get(iii).getNombre() + " " + "["+ equipo2.get(iii).getTipo()+ "]");
                }
                try{Thread.sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                    int l2 = n.nextInt(equipo2.size());
                    if (n2.getPokemon() == null) {
                        n2.setPokemon(equipo2.get(l2));
                        equipo2.remove(l2);
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
                    int d1 = n.nextInt(100)+1;
                    if (d1<51) {
                        System.out.println(n1.getNombre() + " va a atacar al pokemon de " + n2.getNombre());
                        try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        if (n1.getPokemon().getTipo() == "fuego" && n2.getPokemon().getTipo() == "planta") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "fuego" && n2.getPokemon().getTipo() == "agua") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "planta" && n2.getPokemon().getTipo() == "agua") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "planta" && n2.getPokemon().getTipo() == "fuego") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "agua" && n2.getPokemon().getTipo() == "fuego") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "agua" && n2.getPokemon().getTipo() == "planta") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "agua" && n2.getPokemon().getTipo() == "electrico") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "electrico" && n2.getPokemon().getTipo() == "agua") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else{
                            System.err.println(n2.getPokemon().getNombre() + " a evitado el ataque de " + n1.getPokemon().getNombre());
                        }
                    }
                    else{
                        int sucORfail = n1.getPokemon().getHabilidad().Activartefecto();
                        System.out.println(n1.getNombre() + " va a usar la habilidad especial de su pokemon");
                        try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + sucORfail);
                        if (sucORfail != 0) {
                            System.out.println(n1.getPokemon().getNombre() + " a activado su habilidad especial " + "¡"+ n1.getPokemon().getHabilidad().getNombre() + "!");
                        }
                        else {
                            System.out.println(n1.getPokemon().getNombre() + " a fallado en activar su habilidad especial");
                        }
                    }
                int d2 = n.nextInt(100)+1;
                if (d2<51) {
                    System.out.println(n2.getNombre() + " va a atacar al pokemon de " + n1.getNombre());
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        if (n2.getPokemon().getTipo() == "fuego" && n1.getPokemon().getTipo() == "planta") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "fuego" && n1.getPokemon().getTipo() == "agua") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "planta" && n1.getPokemon().getTipo() == "agua") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "planta" && n1.getPokemon().getTipo() == "fuego") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "agua" && n1.getPokemon().getTipo() == "fuego") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "agua" && n1.getPokemon().getTipo() == "planta") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "agua" && n1.getPokemon().getTipo() == "electrico") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "electrico" && n1.getPokemon().getTipo() == "agua") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else{
                            System.err.println(n1.getPokemon().getNombre() + " a evitado el ataque de " + n2.getPokemon().getNombre());
                        }
                    }
                    else{
                        int sucORfail = n2.getPokemon().getHabilidad().Activartefecto();
                        System.out.println(n2.getNombre() + " va a usar la habilidad especial de su pokemon");
                        try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + sucORfail);
                        if (sucORfail != 0) {
                            System.out.println(n2.getPokemon().getNombre() + " a activado su habilidad especial " + "¡"+ n2.getPokemon().getHabilidad().getNombre() + "!");
                        }
                        else {
                            System.out.println(n2.getPokemon().getNombre() + " a fallado en activar su habilidad especial");
                        }
                    }
                    int TP1 = n1.getPokemon().getAtaque() + n1.getPokemon().getDefensa();
                    int TP2 = n2.getPokemon().getAtaque() + n2.getPokemon().getDefensa();
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    System.out.println("El poder total de " + n1.getPokemon().getNombre() + " es de " + TP1);
                    System.out.println("El poder total de " + n2.getPokemon().getNombre() + " es de " + TP2);
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    if(TP1 > TP2){
                        System.out.println("El ganor de la ronda es " + n1.getNombre());
                        N1ganado += 1 ;
                    }
                    else if (TP1 < TP2){
                        System.out.println("El ganor de la ronda es " + n2.getNombre());
                        N2ganado += 1;
                    }
                    else{
                        System.out.println("La ronda terminó en un empate");
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
                    int d3 = n.nextInt(100)+1;
                    if (d3<51) {
                        System.out.println(n1.getNombre() + " va a atacar al pokemon de " + n2.getNombre());
                        try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        if (n1.getPokemon().getTipo() == "fuego" && n2.getPokemon().getTipo() == "planta") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "fuego" && n2.getPokemon().getTipo() == "agua") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "planta" && n2.getPokemon().getTipo() == "agua") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "planta" && n2.getPokemon().getTipo() == "fuego") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "agua" && n2.getPokemon().getTipo() == "fuego") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "agua" && n2.getPokemon().getTipo() == "planta") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "agua" && n2.getPokemon().getTipo() == "electrico") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "electrico" && n2.getPokemon().getTipo() == "agua") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else{
                            System.err.println(n2.getPokemon().getNombre() + " a evitado el ataque de " + n1.getPokemon().getNombre());
                        }
                    }
                    else{
                        int sucORfail = n1.getPokemon().getHabilidad().Activartefecto();
                        System.out.println(n1.getNombre() + " va a usar la habilidad especial de su pokemon");
                        try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + sucORfail);
                        if (sucORfail != 0) {
                            System.out.println(n1.getPokemon().getNombre() + " a activado su habilidad especial " + "¡"+ n1.getPokemon().getHabilidad().getNombre() + "!");
                        }
                        else {
                            System.out.println(n1.getPokemon().getNombre() + " a fallado en activar su habilidad especial");
                        }
                    }
                int d4 = n.nextInt(100)+1;
                if (d4<51) {
                    System.out.println(n2.getNombre() + " va a atacar al pokemon de " + n1.getNombre());
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        if (n2.getPokemon().getTipo() == "fuego" && n1.getPokemon().getTipo() == "planta") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "fuego" && n1.getPokemon().getTipo() == "agua") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "planta" && n1.getPokemon().getTipo() == "agua") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "planta" && n1.getPokemon().getTipo() == "fuego") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "agua" && n1.getPokemon().getTipo() == "fuego") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "agua" && n1.getPokemon().getTipo() == "planta") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "agua" && n1.getPokemon().getTipo() == "electrico") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "electrico" && n1.getPokemon().getTipo() == "agua") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else{
                            System.err.println(n1.getPokemon().getNombre() + " a evitado el ataque de " + n2.getPokemon().getNombre());
                        }
                    }
                    else{
                        int sucORfail = n2.getPokemon().getHabilidad().Activartefecto();
                        System.out.println(n2.getNombre() + " va a usar la habilidad especial de su pokemon");
                        try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + sucORfail);
                        if (sucORfail != 0) {
                            System.out.println(n2.getPokemon().getNombre() + " a activado su habilidad especial " + "¡"+ n2.getPokemon().getHabilidad().getNombre() + "!");
                        }
                        else {
                            System.out.println(n2.getPokemon().getNombre() + " a fallado en activar su habilidad especial");
                        }
                    }
                    int TP3 = n1.getPokemon().getAtaque() + n1.getPokemon().getDefensa();
                    int TP4 = n2.getPokemon().getAtaque() + n2.getPokemon().getDefensa();
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    System.out.println("El poder total de " + n1.getPokemon().getNombre() + " es de " + TP3);
                    System.out.println("El poder total de " + n2.getPokemon().getNombre() + " es de " + TP4);
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    if(TP3 > TP4){
                        System.out.println("El ganor de la ronda es " + n1.getNombre());
                        N1ganado += 1 ;
                    }
                    else if (TP3 < TP4){
                        System.out.println("El ganor de la ronda es " + n2.getNombre());
                        N2ganado += 1;
                    }
                    else{
                        System.out.println("La ronda terminó en un empate");
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
                    try{Thread.sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(n2.getNombre()+ " a elegido a " + n2.getPokemon().getNombre());
                    try{Thread.sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    int d5 = n.nextInt(100)+1;
                    if (d5<51) {
                        System.out.println(n1.getNombre() + " va a atacar al pokemon de " + n2.getNombre());
                        try{Thread.sleep(1000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        if (n1.getPokemon().getTipo() == "fuego" && n2.getPokemon().getTipo() == "planta") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "fuego" && n2.getPokemon().getTipo() == "agua") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "planta" && n2.getPokemon().getTipo() == "agua") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "planta" && n2.getPokemon().getTipo() == "fuego") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "agua" && n2.getPokemon().getTipo() == "fuego") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "agua" && n2.getPokemon().getTipo() == "planta") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "agua" && n2.getPokemon().getTipo() == "electrico") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "electrico" && n2.getPokemon().getTipo() == "agua") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else{
                            System.err.println(n2.getPokemon().getNombre() + " a evitado el ataque de " + n1.getPokemon().getNombre());
                        }
                    }
                    else{
                        int sucORfail = n1.getPokemon().getHabilidad().Activartefecto();
                        System.out.println(n1.getNombre() + " va a usar la habilidad especial de su pokemon");
                        try{Thread.sleep(1000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + sucORfail);
                        if (sucORfail != 0) {
                            System.out.println(n1.getPokemon().getNombre() + " a activado su habilidad especial " + "¡"+ n1.getPokemon().getHabilidad().getNombre() + "!");
                        }
                        else {
                            System.out.println(n1.getPokemon().getNombre() + " a fallado en activar su habilidad especial");
                        }
                    }
                int d6= n.nextInt(100)+1;
                if (d6<51) {
                    System.out.println(n2.getNombre() + " va a atacar al pokemon de " + n1.getNombre());
                    try{Thread.sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                        if (n2.getPokemon().getTipo() == "fuego" && n1.getPokemon().getTipo() == "planta") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "fuego" && n1.getPokemon().getTipo() == "agua") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "planta" && n1.getPokemon().getTipo() == "agua") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "planta" && n1.getPokemon().getTipo() == "fuego") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "agua" && n1.getPokemon().getTipo() == "fuego") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "agua" && n1.getPokemon().getTipo() == "planta") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "agua" && n1.getPokemon().getTipo() == "electrico") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "electrico" && n1.getPokemon().getTipo() == "agua") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else{
                            System.err.println(n1.getPokemon().getNombre() + " a evitado el ataque de " + n2.getPokemon().getNombre());
                        }
                    }
                    else{
                        int sucORfail = n2.getPokemon().getHabilidad().Activartefecto();
                        System.out.println(n2.getNombre() + " va a usar la habilidad especial de su pokemon");
                        try{Thread.sleep(1000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + sucORfail);
                        if (sucORfail != 0) {
                            System.out.println(n2.getPokemon().getNombre() + " a activado su habilidad especial " + "¡"+ n2.getPokemon().getHabilidad().getNombre() + "!");
                        }
                        else {
                            System.out.println(n2.getPokemon().getNombre() + " a fallado en activar su habilidad especial");
                        }
                    }
                    int TP5 = n1.getPokemon().getAtaque() + n1.getPokemon().getDefensa();
                    int TP6 = n2.getPokemon().getAtaque() + n2.getPokemon().getDefensa();
                    try{Thread.sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("El poder total de " + n1.getPokemon().getNombre() + " es de " + TP5);
                    System.out.println("El poder total de " + n2.getPokemon().getNombre() + " es de " + TP6);
                    try{Thread.sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    if(TP5 > TP6){
                        System.out.println("El ganor de la ronda es " + n1.getNombre());
                        N1ganado += 1 ;
                    }
                    else if (TP5 < TP6){
                        System.out.println("El ganor de la ronda es " + n2.getNombre());
                        N2ganado += 1;
                    }
                    else{
                        System.out.println("La ronda terminó en un empate");
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
                    try{Thread.sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(n2.getNombre()+ " a elegido a " + n2.getPokemon().getNombre());
                    try{Thread.sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    int d7 = n.nextInt(100)+1;
                    if (d7<51) {
                        System.out.println(n1.getNombre() + " va a atacar al pokemon de " + n2.getNombre());
                        try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        if (n1.getPokemon().getTipo() == "fuego" && n2.getPokemon().getTipo() == "planta") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "fuego" && n2.getPokemon().getTipo() == "agua") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "planta" && n2.getPokemon().getTipo() == "agua") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "planta" && n2.getPokemon().getTipo() == "fuego") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "agua" && n2.getPokemon().getTipo() == "fuego") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "agua" && n2.getPokemon().getTipo() == "planta") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "agua" && n2.getPokemon().getTipo() == "electrico") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n1.getPokemon().getTipo() == "electrico" && n2.getPokemon().getTipo() == "agua") {
                            n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n1.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else{
                            System.err.println(n2.getPokemon().getNombre() + " a evitado el ataque de " + n1.getPokemon().getNombre());
                        }
                    }
                    else{
                        int sucORfail = n1.getPokemon().getHabilidad().Activartefecto();
                        System.out.println(n1.getNombre() + " va a usar la habilidad especial de su pokemon");
                        try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        n1.getPokemon().setAtaque(n1.getPokemon().getAtaque() + sucORfail);
                        if (sucORfail != 0) {
                            System.out.println(n1.getPokemon().getNombre() + " a activado su habilidad especial " + "¡"+ n1.getPokemon().getHabilidad().getNombre() + "!");
                        }
                        else {
                            System.out.println(n1.getPokemon().getNombre() + " a fallado en activar su habilidad especial");
                        }
                    }
                int d8 = n.nextInt(100)+1;
                if (d8<51) {
                    System.out.println(n2.getNombre() + " va a atacar al pokemon de " + n1.getNombre());
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        if (n2.getPokemon().getTipo() == "fuego" && n1.getPokemon().getTipo() == "planta") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "fuego" && n1.getPokemon().getTipo() == "agua") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "planta" && n1.getPokemon().getTipo() == "agua") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "planta" && n1.getPokemon().getTipo() == "fuego") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "agua" && n1.getPokemon().getTipo() == "fuego") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "agua" && n1.getPokemon().getTipo() == "planta") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "agua" && n1.getPokemon().getTipo() == "electrico") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() - 10);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido poco efectivo");
                        }
                        else if (n2.getPokemon().getTipo() == "electrico" && n1.getPokemon().getTipo() == "agua") {
                            n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + 20);
                            System.out.println("El ataque de " + n2.getPokemon().getNombre() + " a sido super efectivo");
                        }
                        else{
                            System.err.println(n1.getPokemon().getNombre() + " a evitado el ataque de " + n2.getPokemon().getNombre());
                        }
                    }
                    else{
                        int sucORfail = n2.getPokemon().getHabilidad().Activartefecto();
                        System.out.println(n2.getNombre() + " va a usar la habilidad especial de su pokemon");
                        try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        n2.getPokemon().setAtaque(n2.getPokemon().getAtaque() + sucORfail);
                        if (sucORfail != 0) {
                            System.out.println(n2.getPokemon().getNombre() + " a activado su habilidad especial " + "¡"+ n2.getPokemon().getHabilidad().getNombre() + "!");
                        }
                        else {
                            System.out.println(n2.getPokemon().getNombre() + " a fallado en activar su habilidad especial");
                        }
                    }
                    int TP7 = n1.getPokemon().getAtaque() + n1.getPokemon().getDefensa();
                    int TP8 = n2.getPokemon().getAtaque() + n2.getPokemon().getDefensa();
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    System.out.println("El poder total de " + n1.getPokemon().getNombre() + " es de " + TP7);
                    System.out.println("El poder total de " + n2.getPokemon().getNombre() + " es de " + TP8);
                    try{Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    if(TP7 > TP8){
                        System.out.println("El ganor de la ronda es " + n1.getNombre());
                        N1ganado += 1 ;
                    }
                    else if (TP7 < TP8){
                        System.out.println("El ganor de la ronda es " + n2.getNombre());
                        N2ganado += 1;
                    }
                    else{
                        System.out.println("La ronda terminó en un empate");
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
