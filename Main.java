public class Main {
    public static void main(String[] args) {
        Entrenador n1 = new Entrenador("Pal", null);
        Entrenador n2 = new Entrenador("Alex", null);

        Habilidad h1 = new Habilidad("Torrente", 10);
        Habilidad h2 = new Habilidad("Llama incandescente", 15);
        Habilidad h3 = new Habilidad("Fertilizante", 10);
        Habilidad h4 = new Habilidad( "Sobre carga", 20);

        Monstruos p1 = new Monstruos("Tepig", h2, "fuego", 15, 0);
        Monstruos p2 = new Monstruos("Pikachu", h4, "electrico", 15, 0);
        Monstruos p3 = new Monstruos("Bulbasaur", h3, "planta", 10, 5);
        Monstruos p4 = new Monstruos("Charmander", h2, "fuego", 15, 0);
        Monstruos p5 = new Monstruos("Squirtle", h1, "agua", 10, 5);
        Monstruos p6 = new Monstruos("Poliwag", h1, "agua", 10, 5);
        Monstruos p7 = new Monstruos("Pichu", h4, "electrico", 10, 0);
        Monstruos p8 = new Monstruos("Treecko", h3, "planta", 5, 10);


        for (int i = 0; i<5; i++){
            
        }
    }
}
