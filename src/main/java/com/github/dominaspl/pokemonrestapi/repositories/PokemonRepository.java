package com.github.dominaspl.pokemonrestapi.repositories;

import com.github.dominaspl.pokemonrestapi.models.Pokemon;
import com.github.dominaspl.pokemonrestapi.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    List<Pokemon> findPokemonByState(State state);

    @Query(value = "SELECT pokemons.pokemon_id, pokemon_name, base_stats_id, state_id \n" +
            "FROM pokemons \n" +
            "JOIN pokemons_types \n" +
            "ON pokemons.pokemon_id = pokemons_types.pokemon_id \n" +
            "WHERE type_id = ?1", nativeQuery = true)
    List<Pokemon> findPokemonsByTypeId(Long typeId);
}
