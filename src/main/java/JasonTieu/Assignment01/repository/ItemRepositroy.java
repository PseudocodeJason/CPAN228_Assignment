package JasonTieu.Assignment01.repository;


import java.util.Optional;

import JasonTieu.Assignment01.model.Item;

public interface ItemRepositroy {
    Iterable<Item> findAll();

    Optional<Item> findById(long id);

    void save(Item item);

}


