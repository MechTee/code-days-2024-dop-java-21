package com.example.healingservice.service;

import com.example.healingservice.model.dex.JohtoPokeDexEntry;
import com.example.healingservice.model.dex.KantoPokeDexEntry;
import com.example.healingservice.model.pokemon.DoubleTypePokemon;
import com.example.healingservice.model.pokemon.Pokemon;
import com.example.healingservice.model.pokemon.SingleTypePokemon;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public abstract class HealingService {

  private static final Logger log = Logger.getLogger(HealingService.class.getName());

  public static Set<Pokemon> healPokemon(Set<Pokemon> pokemon) {
    return pokemon.stream().map(HealingService::healPokemon).collect(Collectors.toSet());
  }

  public static Pokemon healPokemon(Pokemon pokemon) {
    return switch (pokemon.pokeDexEntry()) {
      case _ when pokemon.isHealed() -> {
        log.info(STR."Pokemon \{pokemon.name()} is already healed");
        yield pokemon;
      }
      case KantoPokeDexEntry _ -> healKantoPokemon(pokemon);
      case JohtoPokeDexEntry _ -> healJohtoPokemon(pokemon);
    };
  }

  private static Pokemon healJohtoPokemon(Pokemon pokemon) {
    // do some region specific healing here
    return switch (pokemon) {
      case SingleTypePokemon s -> {
        log.info(
            STR."Healed pokemon from Johto with PokeDexNumber: \{NationalPokeDexService.getNationalDexNumber(pokemon.pokeDexEntry())} with Name: \{pokemon.name()}");
        yield new SingleTypePokemon(s.pokeDexEntry(), s.name(), s.type(), s.type(),true);
      }
      case DoubleTypePokemon d -> {
        log.info(
            STR."Healed pokemon from Johto with PokeDexNumber: \{NationalPokeDexService.getNationalDexNumber(pokemon.pokeDexEntry())} with Name: \{pokemon.name()} and second type: \{ d.secondType()}");
        yield new DoubleTypePokemon(d.pokeDexEntry(), d.name(), d.type(), d.type(), true, d.secondType());
      }
    };
  }

  private static Pokemon healKantoPokemon(Pokemon pokemon) {
    // do some region specific healing here
    return switch (pokemon) {
      case SingleTypePokemon s -> {
        log.info(
            STR."Healed pokemon from kanto with PokeDexNumber: \{NationalPokeDexService.getNationalDexNumber(pokemon.pokeDexEntry())} with Name: \{pokemon.name()}");
        yield new SingleTypePokemon(s.pokeDexEntry(), s.name(), s.type(), s.type(),true);
      }
      case DoubleTypePokemon d -> {
        log.info(
            STR."Healed pokemon from kanto with PokeDexNumber: \{NationalPokeDexService.getNationalDexNumber(pokemon.pokeDexEntry())} with Name: \{pokemon.name()} and second type: \{ d.secondType()}");
        yield new DoubleTypePokemon(d.pokeDexEntry(), d.name(), d.type(), d.type(), true, d.secondType());
      }
    };
  }

}
