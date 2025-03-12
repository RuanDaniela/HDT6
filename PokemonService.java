import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PokemonService {
    private Map<String, Pokemon> pokemonMap = new HashMap<>();

    // Método para cargar Pokémon desde un archivo CSV
    public void loadPokemonsFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Saltar la cabecera

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Validar si hay suficientes datos
                if (data.length < 10) {
                    System.err.println("Fila inválida: " + line);
                    continue;
                }

                try {
                    // Crear el objeto Pokémon con validación de datos
                    Pokemon pokemon = new Pokemon(
                        data[0], // name
                        Integer.parseInt(data[1]), // pokedexNumber
                        data[2], // type1
                        data[3].isEmpty() ? "Desconocido" : data[3], // type2 (manejar vacío)
                        data[4], // classification
                        Double.parseDouble(data[5]), // height
                        Double.parseDouble(data[6]), // weight
                        data[7], // abilities
                        Integer.parseInt(data[8]), // generation
                        Boolean.parseBoolean(data[9]) // legendaryStatus
                    );

                    pokemonMap.put(pokemon.getName(), pokemon);
                } catch (NumberFormatException e) {
                    System.err.println("Error al convertir datos: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Obtener un Pokémon por nombre
    public Pokemon getPokemon(String name) {
        return pokemonMap.get(name);
    }

    // Mostrar todos los Pokémon
    public void showAllPokemons() {
        for (Pokemon pokemon : pokemonMap.values()) {
            System.out.println(pokemon.getName() + " - " + pokemon.getType1());
        }
    }

    // Mostrar Pokémon por tipo
    public void showPokemonsByType(String type) {
        for (Pokemon pokemon : pokemonMap.values()) {
            if (pokemon.getType1().equalsIgnoreCase(type) || pokemon.getType2().equalsIgnoreCase(type)) {
                System.out.println(pokemon.getName() + " - " + pokemon.getType1() + " / " + pokemon.getType2());
            }
        }
    }

    // Mostrar Pokémon por habilidad
    public void showPokemonsByAbility(String ability) {
        for (Pokemon pokemon : pokemonMap.values()) {
            if (pokemon.getAbilities().toLowerCase().contains(ability.toLowerCase())) {
                System.out.println(pokemon.getName() + " - " + pokemon.getAbilities());
            }
        }
    }
}
