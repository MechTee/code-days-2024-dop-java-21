package com.example.healingservice;

import com.example.healingservice.model.dex.JohtoPokeDexEntry;
import com.example.healingservice.model.dex.KantoPokeDexEntry;
import com.example.healingservice.model.pokemon.Pokemon;
import com.example.healingservice.model.trainer.Trainer;
import com.example.healingservice.service.HealingService;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

class Main {

  private static final Logger log = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {
    Trainer trainer1 = new Trainer("Ash Ketchum", new HashSet<>(generateAshPokemon()));
    log.info(STR."Pokemon before: \{trainer1.pokemon()}");
    Set<Pokemon> healedPokemon = HealingService.healPokemon(trainer1.pokemon());
    Trainer newTrainer1 = new Trainer(trainer1.name(), healedPokemon);
    log.info(STR."Pokemon after: \{newTrainer1.pokemon()}");
  }


  private static Set<Pokemon> generateAshPokemon() {
    return new HashSet<>(
        Set.of(
            new Pokemon.SingleTypePokemon(new KantoPokeDexEntry("Pikachu is very cute", 25, "Pikachu"),
                "Pikaaa", "Static", "Electric", false),
            new Pokemon.SingleTypePokemon(new JohtoPokeDexEntry("Don't touch it burns", 5, "Quilava"),
                "HotSonic", "Blaze",
                "Fire", false),
            new Pokemon.DoubleTypePokemon(new JohtoPokeDexEntry("Wooper even cuter than Pickachu (fight me after my Talk)", 56, "Wooper"),
                "WoopDiDoo", "Water Absorb", "Water", false, "Ground"),
            new Pokemon.SingleTypePokemon(new JohtoPokeDexEntry("Feraligatr is a Big Jaw Pokemon", 9, "Feraligatr"),
                "CrocoDoc", "Torrent", "Water", false),
            new Pokemon.DoubleTypePokemon(new KantoPokeDexEntry("Venusaur is big and healthy", 3, "Venusaur"),
                "Venusaur", "Overgrow", "Grass", true, "Poison")
        )
    );
  }

}