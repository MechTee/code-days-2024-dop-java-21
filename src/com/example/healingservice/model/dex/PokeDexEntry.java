package com.example.healingservice.model.dex;

public sealed interface PokeDexEntry permits KantoPokeDexEntry, JohtoPokeDexEntry {

  String description();
  int number();

  String name();
}
