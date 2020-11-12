package com.ul.aos.pokemoncardmanager.model.controllers;

import com.ul.aos.pokemoncardmanager.model.dao.PokemonCardDAOInterface;
import com.ul.aos.pokemoncardmanager.model.objects.PokemonCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokemonCardController {

    @Autowired
    private PokemonCardDAOInterface dao;

    @GetMapping(value="/Pokemoncards")
    public List<PokemonCard> getCards() {
        return dao.findAll();
    }

    @GetMapping(value="/Pokemoncards/{name}/{type}")
    public List<PokemonCard> getCard(@PathVariable String name, @PathVariable String type) {
        if (name.equals("")) {
            name = "pikachu";
        }
        if (type.equals("")) {
            type = "electric";
        }
        return dao.find(name.toLowerCase(), type.toLowerCase());
    }

    @PostMapping(value="/Pokemoncards")
    public int addCard(@RequestBody PokemonCard c) {
        c.setName(c.getName().toLowerCase());
        c.setType(c.getType().toLowerCase());
        return dao.save(c);
    }



}
