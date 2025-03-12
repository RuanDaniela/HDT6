public class Pokemon {
    private String name;
    private String type1;
    private String type2;
    private String abilities;

    public Pokemon(String name, String type1, String type2, String abilities) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.abilities = abilities;
    }

    // Getters y setters
    public String getName() { return name; }
    public String getType1() { return type1; }
    public String getType2() { return type2; }
    public String getAbilities() { return abilities; }
}