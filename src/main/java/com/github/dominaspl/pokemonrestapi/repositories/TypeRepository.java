package com.github.dominaspl.pokemonrestapi.repositories;

import com.github.dominaspl.pokemonrestapi.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {

}
