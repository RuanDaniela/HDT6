class Pokemon {
    String name, type1, type2, ability;
    int total, hp, attack, defense, spAtk, spDef, speed;
    
    public Pokemon(String name, String type1, String type2, String ability, int total, int hp, int attack, int defense, int spAtk, int spDef, int speed) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.ability = ability;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.speed = speed;
    }
    
    @Override
    public String toString() {
        return name + " (" + type1 + ", " + type2 + ", Ability: " + ability + ")";
    }
}

