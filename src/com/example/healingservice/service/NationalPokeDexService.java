package com.example.healingservice.service;

import com.example.healingservice.model.dex.JohtoPokeDexEntry;
import com.example.healingservice.model.dex.KantoPokeDexEntry;
import com.example.healingservice.model.dex.PokeDexEntry;

public abstract class NationalPokeDexService {

  private static final int KANTO_MAX_DEX_NO = 151;
  private static final int JOHTO_MAX_DEX_NO = 251;
  private static final int HOENN_MAX_DEX_NO = 386;

  public static int getNationalDexNumber(PokeDexEntry dexEntry) {
    return switch (dexEntry) {
      case KantoPokeDexEntry _ -> dexEntry.number();
      case JohtoPokeDexEntry _ -> dexEntry.number() + KANTO_MAX_DEX_NO;
    };
  }

}
