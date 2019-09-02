package com.github.dominaspl.pokemonrestapi.services;

import com.github.dominaspl.pokemonrestapi.converters.TypeConverter;
import com.github.dominaspl.pokemonrestapi.dtos.TypeDTO;
import com.github.dominaspl.pokemonrestapi.models.Type;
import com.github.dominaspl.pokemonrestapi.repositories.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TypeServiceImpl implements TypeService {

    private TypeRepository typeRepository;

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public List<TypeDTO> findAllTypes() {

        List<Type> typeList = typeRepository.findAll();

        return TypeConverter.convertToTypeDTOList(typeList);
    }

    @Override
    public TypeDTO findTypeById(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("Id must be given!");
        }

        Optional<Type> optionalType = typeRepository.findById(id);
        Type type = optionalType.orElseThrow(() -> new IllegalStateException("Type not found!"));

        return TypeConverter.convertToTypeDTO(type);
    }

    @Override
    public Set<TypeDTO> checkTypesInDatabase(List<TypeDTO> typesDTO) {

        if (typesDTO == null) {
            throw new IllegalArgumentException("Types must be given!");
        }

        return chooseCorrectTypes(findAllTypes(), typesDTO);
    }

    public Set<TypeDTO> chooseCorrectTypes(List<TypeDTO> allTypes, List<TypeDTO> typesToCheck) {

        Set<TypeDTO> correctTypes = new HashSet<>();

        for (int i = 0; i < allTypes.size(); i++) {

            for (int j = 0; j < typesToCheck.size() ; j++) {

                if (allTypes.get(i).getTypeName().equalsIgnoreCase(typesToCheck.get(j).getTypeName())) {
                    correctTypes.add(allTypes.get(i));
                }
            }
        }

        return correctTypes;
    }


}
