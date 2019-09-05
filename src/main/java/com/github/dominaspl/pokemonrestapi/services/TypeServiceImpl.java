package com.github.dominaspl.pokemonrestapi.services;

import com.github.dominaspl.pokemonrestapi.converters.TypeConverter;
import com.github.dominaspl.pokemonrestapi.dtos.TypeDTO;
import com.github.dominaspl.pokemonrestapi.models.Type;
import com.github.dominaspl.pokemonrestapi.repositories.StateRepository;
import com.github.dominaspl.pokemonrestapi.repositories.TypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TypeServiceImpl implements TypeService {

    private TypeRepository typeRepository;
    private StateRepository stateRepository;

    public TypeServiceImpl(TypeRepository typeRepository, StateRepository stateRepository) {
        this.typeRepository = typeRepository;
        this.stateRepository = stateRepository;
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

    @Override
    @Transactional
    public TypeDTO saveType(TypeDTO typeDTO) {

        if (typeDTO == null) {
            throw new IllegalArgumentException("Type must be given!");
        }

        Type type = TypeConverter.convertToType(typeDTO);

        if (!checkIfTypeIsAvailable(type)) {
            throw new IllegalStateException("Type is not available!");
        }

        typeRepository.save(type);

        return typeDTO;
    }

    @Override
    @Transactional
    public TypeDTO updateType(Long id, TypeDTO typeDTO) {

        if (id == null || typeDTO == null) {
            throw new IllegalArgumentException("Id and type must be given!");
        }

        Optional<Type> optionalType = typeRepository.findById(id);
        Type type = optionalType.orElse(null);

        if (type == null) {
            return saveType(typeDTO);
        }

        type.setTypeName(typeDTO.getTypeName());
        typeRepository.save(type);

        return typeDTO;

    }

    @Override
    public TypeDTO deleteType(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("Id must be given!");
        }

        Optional<Type> optionalType = typeRepository.findById(id);
        Type type = optionalType.orElseThrow(() -> new IllegalStateException("Type not found"));

        type.setState(stateRepository.findAll().get(1));
        typeRepository.save(type);

        return TypeConverter.convertToTypeDTO(type);
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

    public boolean checkIfTypeIsAvailable(Type type) {

        List<Type> allTypes = typeRepository.findAll();

        if (allTypes.stream()
                .filter(type1 -> type1.getTypeName().equalsIgnoreCase(type.getTypeName()))
                .collect(Collectors.toList()).isEmpty()) {
            return true;
        }

        return false;
    }


}
