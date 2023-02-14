package JasonTieu.Assignment01.repository.impl;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import JasonTieu.Assignment01.model.Item;

public class ItemRowMapper implements RowMapper<Item>{
    @Override
    public Item mapRow(ResultSet rs, int row) throws SQLException{
        return Item.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .brandForm(Item.Brand.valueOf(rs.getString("brandForm")))
                    .yearOfCreation(rs.getInt("yearOfCreation"))
                    .price(rs.getDouble("price"))
                    .build();
    }
    
}

