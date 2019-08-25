package com.github.dominaspl.pokemonrestapi.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pokemons")
@Data
@RequiredArgsConstructor
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pokemon_id")
    private Long pokemonID;

    @Column(nullable = false, unique = true)
    private String pokemonName;

    @ManyToMany(mappedBy = "pokemons")
    private List<Type> types = new ArrayList<>();


}
