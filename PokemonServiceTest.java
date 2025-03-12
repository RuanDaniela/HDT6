import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PokemonServiceTest {
    @Test
    public void testAddPokemon() {
        PokemonService service = new PokemonService("HashMap");
        Pokemon pikachu = new Pokemon("Pikachu", "Electric", null, "Static");
        service.addPokemon(pikachu);
        assertEquals(pikachu, service.getPokemon("Pikachu"));
    }

    @Test
    public void testGetPokemon() {
        PokemonService service = new PokemonService("HashMap");
        Pokemon charmander = new Pokemon("Charmander", "Fire", null, "Blaze");
        service.addPokemon(charmander);
        assertEquals(charmander, service.getPokemon("Charmander"));
    }
}