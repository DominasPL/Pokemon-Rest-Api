package com.github.dominaspl.pokemonrestapi.controllers;

import com.github.dominaspl.pokemonrestapi.dtos.PokemonDTO;
import com.github.dominaspl.pokemonrestapi.models.Pokemon;
import com.github.dominaspl.pokemonrestapi.services.PokemonServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PokemonController.BASE_URL)
public class PokemonController {

    public static final String BASE_URL = "/api/v1/pokemons";

    private PokemonServiceImpl pokemonService;

    public PokemonController(PokemonServiceImpl pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<PokemonDTO> getAllPokemons() {
        return pokemonService.findAllPokemons();
    }

    @GetMapping("/pokemon/{id}")
    public PokemonDTO getPokemonById(@PathVariable("id") Long id) {
        return pokemonService.findPokemonById(id);
    }

    @PostMapping("/pokemon")
    public void addPokemon(@RequestBody PokemonDTO pokemonDTO) {

        pokemonService.savePokemon(pokemonDTO);
    }

    @PutMapping("/pokemon/{id}")
    public void updatePokemon(@PathVariable("id") Long id, @RequestBody PokemonDTO pokemonDTO) {

        pokemonService.updatePokemon(id, pokemonDTO);
    }

    @DeleteMapping("/pokemon/{id}")
    public void deletePokemon(@PathVariable("id") Long id) {
        pokemonService.deletePokemonFromRestApi(id);
    }

}
