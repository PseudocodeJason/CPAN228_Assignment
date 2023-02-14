package JasonTieu.Assignment01.repository.impl;

import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import JasonTieu.Assignment01.model.Item;
import JasonTieu.Assignment01.repository.ItemRepositroy;


@Repository
public class JdbcItemRepository implements ItemRepositroy{
    private JdbcTemplate jdbcTemplate;

    public JdbcItemRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Item> findAll(){
        return jdbcTemplate.query("SELECT * FROM item", new ItemRowMapper());
    }

    @Override
    public Optional<Item> findById(long id){
        Item item = jdbcTemplate.queryForObject("SELECT * FROM item WHERE id = ?", new ItemRowMapper(), id);
        return Optional.ofNullable(item);
    }

    @Override
    public void save(Item item){
        var insertItem = "INSERT INTO item (name, brandForm, yearOfCreation, price) VALUES (?,?,?,?)";
        var keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
                var ps = con.prepareStatement(insertItem);
                ps.setString(1, item.getName());
                ps.setString(2, item.getBrandForm().name());
                ps.setInt(3, item.getYearOfCreation());
                ps.setDouble(4, item.getPrice());
                return ps;
        }, keyholder);
    }
}

