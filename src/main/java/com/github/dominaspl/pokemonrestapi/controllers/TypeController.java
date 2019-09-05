package com.github.dominaspl.pokemonrestapi.controllers;

import com.github.dominaspl.pokemonrestapi.dtos.TypeDTO;
import com.github.dominaspl.pokemonrestapi.services.TypeService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@Validated
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

    @GetMapping("/types/type/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TypeDTO getTypeById(@PathVariable("id") @Positive Long id) {
        return typeService.findTypeById(id);
    }

    @PostMapping("/types/type")
    @ResponseStatus(HttpStatus.CREATED)
    public TypeDTO addNewType(@Valid @RequestBody TypeDTO typeDTO) {

        return typeService.saveType(typeDTO);
    }

    @PutMapping("/types/type/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TypeDTO updateType(@PathVariable("id") @Positive Long id, @Valid @RequestBody TypeDTO typeDTO) {
        return typeService.updateType(id, typeDTO);
    }

    @DeleteMapping("/types/type/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TypeDTO deleteType(@PathVariable("id") @Positive Long id) {
        return typeService.deleteType(id);
    }
}
