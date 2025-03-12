import java.io.*;
import java.util.*;

public class PokemonManager {
    private Map<String, Pokemon> pokemonMap;
    private List<Pokemon> userCollection = new ArrayList<>();
    
    public PokemonManager(String mapType) {
        this.pokemonMap = MapFactory.getMap(mapType);
    }
    
    // Método para leer el archivo CSV y llenar el Map
    public void loadPokemons(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        br.readLine(); // Saltar encabezado
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            Pokemon p = new Pokemon(data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]), Integer.parseInt(data[8]), Integer.parseInt(data[9]), Integer.parseInt(data[10]), Integer.parseInt(data[11]));
            pokemonMap.put(p.name, p);
        }
        br.close();
    }
    
    // 1. Agregar un Pokémon a la colección del usuario
    public String addPokemonToCollection(String name) {
        if (!pokemonMap.containsKey(name)) return "Error: Pokémon no encontrado";
        Pokemon p = pokemonMap.get(name);
        if (userCollection.contains(p)) return "Este Pokémon ya está en tu colección";
        userCollection.add(p);
        return "Pokémon agregado: " + p;
    }
    
    // 2. Mostrar datos de un Pokémon
    public String getPokemonInfo(String name) {
        return pokemonMap.getOrDefault(name, null) != null ? pokemonMap.get(name).toString() : "Pokémon no encontrado";
    }
    
    // 3. Mostrar colección del usuario ordenada por Type1
    public void showUserCollectionByType() {
        userCollection.stream().sorted(Comparator.comparing(p -> p.type1)).forEach(System.out::println);
    }
    
    // 4. Mostrar todos los Pokémon ordenados por Type1
    public void showAllPokemonsByType() {
        pokemonMap.values().stream().sorted(Comparator.comparing(p -> p.type1)).forEach(System.out::println);
    }
    
    // 5. Mostrar Pokémon con una habilidad específica
    public void showPokemonsByAbility(String ability) {
        pokemonMap.values().stream().filter(p -> p.ability.equalsIgnoreCase(ability)).forEach(System.out::println);
    }
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de Map: hashmap, treemap, linkedhashmap");
        String mapType = scanner.nextLine();
        PokemonManager manager = new PokemonManager(mapType);
        
        manager.loadPokemons("pokemon.csv");
        
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar Pokémon a la colección");
            System.out.println("2. Mostrar datos de un Pokémon");
            System.out.println("3. Mostrar colección ordenada por tipo1");
            System.out.println("4. Mostrar todos los Pokémon ordenados por tipo1");
            System.out.println("5. Buscar Pokémon por habilidad");
            System.out.println("6. Salir");
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 1 -> {
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    System.out.println(manager.addPokemonToCollection(scanner.nextLine()));
                }
                case 2 -> {
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    System.out.println(manager.getPokemonInfo(scanner.nextLine()));
                }
                case 3 -> manager.showUserCollectionByType();
                case 4 -> manager.showAllPokemonsByType();
                case 5 -> {
                    System.out.print("Ingrese la habilidad: ");
                    manager.showPokemonsByAbility(scanner.nextLine());
                }
                case 6 -> System.exit(0);
                default -> System.out.println("Opción no válida");
            }
        }
    }
}