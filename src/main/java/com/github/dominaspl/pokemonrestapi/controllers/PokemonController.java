package com.github.dominaspl.pokemonrestapi.controllers;

import com.github.dominaspl.pokemonrestapi.dtos.PokemonDTO;
import com.github.dominaspl.pokemonrestapi.services.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(PokemonController.BASE_URL)
public class PokemonController {

    public static final String BASE_URL = "/api/v1/pokemons";

    private PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PokemonDTO> getAllPokemons() {
        return pokemonService.findAllPokemons();
    }

    @GetMapping("/pokemon/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PokemonDTO getPokemonById(@PathVariable("id") Long id) {
        return pokemonService.findPokemonById(id);
    }

    @PostMapping("/pokemon")
    @ResponseStatus(HttpStatus.CREATED)
    public PokemonDTO addPokemon(@Valid @RequestBody PokemonDTO pokemonDTO) {

        return pokemonService.savePokemon(pokemonDTO);
    }

    @PutMapping("/pokemon/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public PokemonDTO updatePokemon(@PathVariable("id") Long id, @Valid @RequestBody PokemonDTO pokemonDTO) {

        return pokemonService.updatePokemon(id, pokemonDTO);
    }

    @DeleteMapping("/pokemon/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PokemonDTO deletePokemon(@PathVariable("id") Long id) {
        return pokemonService.deletePokemonFromRestApi(id);
    }

}
