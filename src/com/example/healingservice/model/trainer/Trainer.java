package com.example.healingservice.model.trainer;

import com.example.healingservice.model.pokemon.Pokemon;
import java.util.Set;

public record Trainer(String name, Set<Pokemon> pokemon) {
}
