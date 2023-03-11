package JasonTieu.Assignment01.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import JasonTieu.Assignment01.model.Item;
import JasonTieu.Assignment01.model.Item.Brand;

public interface ItemRepository extends CrudRepository<Item, Long>{
    List<Item> findByBrandForm(Brand brand);

    //List<Item> findByBrandAndYear(String name, int year);

}


