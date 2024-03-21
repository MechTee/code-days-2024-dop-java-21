package com.example.healingservice.model.pokemon;

import com.example.healingservice.model.dex.PokeDexEntry;

public record SingleTypePokemon(PokeDexEntry pokeDexEntry, String name, String ability, String type, boolean isHealed)
    implements Pokemon {}
