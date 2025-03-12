import java.util.Map;
import java.util.TreeMap;

public class PokemonService {
    private Map<String, Pokemon> pokemonMap;
    private Map<String, Pokemon> userCollection;

    public PokemonService(String mapType) {
        this.pokemonMap = PokemonFactory.getMap(mapType);
        this.userCollection = new TreeMap<>(); // Usamos TreeMap para mantener el orden por tipo1
    }

    public void addPokemon(Pokemon pokemon) {
        if (pokemonMap.containsKey(pokemon.getName())) {
            System.out.println("El Pokémon ya está en la colección.");
        } else {
            pokemonMap.put(pokemon.getName(), pokemon);
        }
    }

    public void addUserPokemon(String name) {
        Pokemon pokemon = pokemonMap.get(name);
        if (pokemon == null) {
            System.out.println("El Pokémon no se encuentra en los datos leídos.");
        } else if (userCollection.containsKey(name)) {
            System.out.println("El Pokémon ya está en la colección del usuario.");
        } else {
            userCollection.put(name, pokemon);
            System.out.println("Pokémon agregado a la colección del usuario.");
        }
    }

    public Pokemon getPokemon(String name) {
        return pokemonMap.get(name);
    }

    public void showAllPokemons() {
        for (Pokemon pokemon : pokemonMap.values()) {
            System.out.println(pokemon.getName() + " - " + pokemon.getType1());
        }
    }

    public void showUserPokemons() {
        for (Pokemon pokemon : userCollection.values()) {
            System.out.println(pokemon.getName() + " - " + pokemon.getType1());
        }
    }

    public void showPokemonsByType(String type) {
        boolean found = false;
        for (Pokemon pokemon : userCollection.values()) {
            if (type.equalsIgnoreCase(pokemon.getType1())) {
                System.out.println(pokemon.getName() + " - " + pokemon.getType1());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No hay Pokémon disponibles con el tipo especificado.");
        }
    }

    public void showPokemonsByAbility(String ability) {
        boolean found = false;
        for (Pokemon pokemon : pokemonMap.values()) {
            if (pokemon.getAbilities().contains(ability)) {
                System.out.println(pokemon.getName() + " - " + pokemon.getAbilities());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No hay Pokémon disponibles con la habilidad especificada.");
        }
    }
}