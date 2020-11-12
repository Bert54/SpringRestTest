package com.ul.aos.pokemoncardmanager.model.dao;

import com.ul.aos.pokemoncardmanager.model.objects.PokemonCard;

import java.util.List;

public interface PokemonCardDAOInterface {

    public List<PokemonCard> findAll();

    public List<PokemonCard> find(String name, String type);

    public int save(PokemonCard card);

}
