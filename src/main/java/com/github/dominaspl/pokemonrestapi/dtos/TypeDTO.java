package com.github.dominaspl.pokemonrestapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Size;


@Data
@RequiredArgsConstructor
//@XmlRootElement
public class TypeDTO {

    @JsonIgnore
    private Long id;

    @Size(min = 1, max = 30, message = "Type should have 1 to 30 characters!")
    private String typeName;

}
