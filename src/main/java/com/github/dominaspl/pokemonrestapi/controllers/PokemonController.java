package com.github.dominaspl.pokemonrestapi.controllers;

import com.github.dominaspl.pokemonrestapi.dtos.PokemonDTO;
import com.github.dominaspl.pokemonrestapi.services.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@Validated
@RequestMapping(PokemonController.BASE_URL)
public class PokemonController {

    public static final String BASE_URL = "/api/v1/pokemons";

    private PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping(produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public List<PokemonDTO> getAllPokemons() {
        return pokemonService.findAllPokemons();
    }

    @GetMapping(path ="/pokemon/{id}", produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public PokemonDTO getPokemonById(@PathVariable("id") @Positive Long id) {
        return pokemonService.findPokemonById(id);
    }

    @PostMapping(path = "/pokemon", produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public PokemonDTO addPokemon(@Valid @RequestBody PokemonDTO pokemonDTO) {

        return pokemonService.savePokemon(pokemonDTO);
    }

    @PutMapping(path = "/pokemon/{id}", produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public PokemonDTO updatePokemon(@PathVariable("id") @Positive Long id, @Valid @RequestBody PokemonDTO pokemonDTO) {

        return pokemonService.updatePokemon(id, pokemonDTO);
    }

    @DeleteMapping(path = "/pokemon/{id}", produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public PokemonDTO deletePokemon(@PathVariable("id") @Positive Long id) {
        return pokemonService.deletePokemonFromRestApi(id);
    }
}
