package com.ul.aos.pokemoncardmanager.model.dao;

import com.ul.aos.pokemoncardmanager.model.objects.PokemonCard;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PokemonCardDAO implements PokemonCardDAOInterface{

    private List<PokemonCard> cards = new ArrayList<>();

    @Override
    public List<PokemonCard> findAll() {
        return new ArrayList<>(cards);
    }

    @Override
    public List<PokemonCard> find(String name, String type) {
        List<PokemonCard> pclist = new ArrayList<>();
        for (PokemonCard pc: this.cards) {
            if (pc.getName().equals(name) && pc.getType().equals(type)) {
                pclist.add(pc);
            }
        }
        return pclist;
    }

    @Override
    public int save(PokemonCard card) {
        this.cards.add(card);
        return 201;
    }
}
