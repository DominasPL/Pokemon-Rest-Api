package com.github.dominaspl.pokemonrestapi.controllers;

import com.github.dominaspl.pokemonrestapi.dtos.PokemonDTO;
import com.github.dominaspl.pokemonrestapi.services.PokemonServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
