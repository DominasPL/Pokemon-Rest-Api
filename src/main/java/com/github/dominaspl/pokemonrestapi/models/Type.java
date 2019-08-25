package com.github.dominaspl.pokemonrestapi.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "types")
@Data
@RequiredArgsConstructor
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long typeID;

    @Column(nullable = false, unique = true)
    private String typeNm;

    @ManyToMany
    @JoinTable(name = "pokemons_types", joinColumns = @JoinColumn(name = "type_id"),
    inverseJoinColumns = @JoinColumn(name = "pokemon_id"))
    private List<Pokemon> pokemons = new ArrayList<>();


}
