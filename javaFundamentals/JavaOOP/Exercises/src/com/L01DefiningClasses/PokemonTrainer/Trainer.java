package com.L01DefiningClasses.PokemonTrainer;

import java.util.ArrayList;
import java.util.Objects;

public class Trainer {
    private String name;
    private int badgeCount;
    private ArrayList<Pokemon> pokemons;

    public Trainer(String name) {
        setName(name);
        setBadgeCount(0);
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getPokemonCount(){
        return this.pokemons.size();
    }

    public int getBadgeCount() {
        return badgeCount;
    }

    public void setBadgeCount(int badgeCount) {
        this.badgeCount = badgeCount;
    }

    public void awardBadge(){
        this.badgeCount++;
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    public void updateTrainer(String element){

        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(element)) {
                awardBadge();
                return;
            }
        }

        ArrayList<Pokemon> pokemonToDelete = new ArrayList<>();
        for (Pokemon pokemon : pokemons) {
            if(pokemon.decrementHealth(10)){
                pokemonToDelete.add(pokemon);
            }
        }

        for (Pokemon pokemon : pokemonToDelete) {
            pokemons.remove(pokemon);
        }
    }
}
