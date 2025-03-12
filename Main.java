import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de mapa: 1) HashMap 2) TreeMap 3) LinkedHashMap");
        String mapType = scanner.nextLine();

        // Convertir la entrada del usuario a la cadena esperada
        switch (mapType) {
            case "1":
                mapType = "HashMap";
                break;
            case "2":
                mapType = "TreeMap";
                break;
            case "3":
                mapType = "LinkedHashMap";
                break;
            default:
                System.out.println("Opción no válida. Usando HashMap por defecto.");
                mapType = "HashMap";
                break;
        }

        PokemonService pokemonService = new PokemonService(mapType);

        // Agregar algunos Pokémon a la colección
        pokemonService.addPokemon(new Pokemon("Pikachu", "Electric", null, "Static"));
        pokemonService.addPokemon(new Pokemon("Charmander", "Fire", null, "Blaze"));
        pokemonService.addPokemon(new Pokemon("Bulbasaur", "Grass", "Poison", "Overgrow"));

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar un Pokémon a la colección del usuario");
            System.out.println("2. Mostrar los datos de un Pokémon");
            System.out.println("3. Mostrar los Pokémon del usuario ordenados por tipo1");
            System.out.println("4. Mostrar todos los Pokémon existentes ordenados por tipo1");
            System.out.println("5. Mostrar los Pokémon con una habilidad específica");
            System.out.println("6. Salir");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.println("Ingrese el nombre del Pokémon para agregar a la colección del usuario:");
                    String nameToAdd = scanner.nextLine();
                    pokemonService.addUserPokemon(nameToAdd);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del Pokémon para mostrar sus datos:");
                    String nameToShow = scanner.nextLine();
                    Pokemon pokemon = pokemonService.getPokemon(nameToShow);
                    if (pokemon != null) {
                        System.out.println("Nombre: " + pokemon.getName() + ", Tipo1: " + pokemon.getType1() + ", Tipo2: " + pokemon.getType2() + ", Habilidades: " + pokemon.getAbilities());
                    } else {
                        System.out.println("El Pokémon no se encuentra en los datos leídos.");
                    }
                    break;
                case 3:
                    System.out.println("Pokémon del usuario ordenados por tipo1:");
                    pokemonService.showUserPokemons();
                    break;
                case 4:
                    System.out.println("Todos los Pokémon existentes ordenados por tipo1:");
                    pokemonService.showAllPokemons();
                    break;
                case 5:
                    System.out.println("Ingrese la habilidad del Pokémon para mostrar:");
                    String ability = scanner.nextLine();
                    pokemonService.showPokemonsByAbility(ability);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}