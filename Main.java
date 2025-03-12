import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PokemonService pokemonService = new PokemonService();

        System.out.println("Ingrese la ruta del archivo CSV:");
        String filePath = scanner.nextLine();

        // Cargar Pokémon desde el archivo CSV
        pokemonService.loadPokemonsFromCSV(filePath);
        System.out.println("¡Pokémon cargados exitosamente!\n");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Buscar Pokémon por nombre");
            System.out.println("2. Mostrar todos los Pokémon");
            System.out.println("3. Buscar Pokémon por tipo");
            System.out.println("4. Buscar Pokémon por habilidad");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nombre del Pokémon:");
                        String name = scanner.nextLine();
                        Pokemon pokemon = pokemonService.getPokemon(name);
                        if (pokemon != null) {
                            mostrarInformacionPokemon(pokemon);
                        } else {
                            System.out.println("⚠️ El Pokémon no se encuentra en la colección.");
                        }
                        break;

                    case 2:
                        System.out.println("Listado de todos los Pokémon:");
                        pokemonService.showAllPokemons();
                        break;

                    case 3:
                        System.out.println("Ingrese el tipo de Pokémon:");
                        String type = scanner.nextLine();
                        pokemonService.showPokemonsByType(type);
                        break;

                    case 4:
                        System.out.println("Ingrese la habilidad del Pokémon:");
                        String ability = scanner.nextLine();
                        pokemonService.showPokemonsByAbility(ability);
                        break;

                    case 5:
                        System.out.println("Saliendo del programa. ¡Hasta luego!");
                        continuar = false;
                        break;

                    default:
                        System.out.println("⚠️ Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Error: Ingrese un número válido.");
            }
        }
        scanner.close();
    }

    // Método auxiliar para mostrar la información completa de un Pokémon
    private static void mostrarInformacionPokemon(Pokemon pokemon) {
        System.out.println("\n--- Información del Pokémon ---");
        System.out.println("Nombre: " + pokemon.getName());
        System.out.println("Número en la Pokédex: " + pokemon.getPokedexNumber());
        System.out.println("Tipo 1: " + pokemon.getType1());
        System.out.println("Tipo 2: " + pokemon.getType2());
        System.out.println("Clasificación: " + pokemon.getClassification());
        System.out.println("Altura: " + pokemon.getHeight() + " m");
        System.out.println("Peso: " + pokemon.getWeight() + " kg");
        System.out.println("Habilidades: " + pokemon.getAbilities());
        System.out.println("Generación: " + pokemon.getGeneration());
        System.out.println("Legendario: " + (pokemon.isLegendaryStatus() ? "Sí" : "No"));
    }
}
