package com.github.dominaspl.pokemonrestapi.controllers;

import com.github.dominaspl.pokemonrestapi.dtos.TypeDTO;
import com.github.dominaspl.pokemonrestapi.services.TypeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(TypeController.BASE_URL)
public class TypeController {

    public static final String BASE_URL = "/api/v1/pokemons";

    private TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/types")
    @ResponseStatus(HttpStatus.OK)
    public List<TypeDTO> getAllTypes() {
        return typeService.findAllTypes();
    }



}
