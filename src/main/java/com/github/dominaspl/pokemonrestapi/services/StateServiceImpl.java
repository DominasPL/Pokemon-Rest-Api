package com.github.dominaspl.pokemonrestapi.services;

import com.github.dominaspl.pokemonrestapi.models.State;
import com.github.dominaspl.pokemonrestapi.repositories.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {

    private StateRepository stateRepository;

    public StateServiceImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public List<State> findAllStates() {

        List<State> allStates = stateRepository.findAll();

        if (allStates.isEmpty()) {
            throw new IllegalStateException("States not found!");
        }

        return allStates;
    }
}
