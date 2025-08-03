Testing
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
            for(int x = 0; x < pokemond.size(); x++){
                if (equipo1.size()< 4) {
                    equipo1.add(pokemond.get(x));
                }
                else{
                    equipo2.add(pokemond.get(x));
                }
            }
            //Ronda 1
            for(int a = 0; a<equipo1.size(); a++){
                if (n1.getPokemon() == null) {
                    n1.setPokemon(equipo1.get(a));
                    equipo1.remove(a);
                }
            }
            System.out.println(equipo1.size());
                System.out.println(equipo2.size());