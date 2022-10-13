package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class FridgeX {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void   setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void   insert(Fridge  Fridge)
    {
        jdbcTemplate.update("insert into Fridge" +
                        "(seria, Views, brand, country, height, width, depth) " +
                        "values (?, ?, ?, ?, ?, ?, ?)",
                Fridge.getseria(),
                Fridge.getViews(),
                Fridge.getBrand(),
                Fridge.getCountry(),
                Fridge.getHeight(),
                Fridge.getWidth(),
                Fridge.getWidth());
    }

    public List<Fridge> findAll()
    {
        return jdbcTemplate.query("SELECT * FROM Fridge",
                new BeanPropertyRowMapper<>(Fridge.class));
    }

    public void   update(int seria, Fridge  Fridge)
    {
        jdbcTemplate.update("UPDATE Fridge SET " +
                "Views=?, brand=?, country=?, height=?, width=?, depth=? " +
                "WHERE seria=?",
                Fridge.getViews(),
                Fridge.getBrand(),
                Fridge.getCountry(),
                Fridge.getHeight(),
                Fridge.getWidth(),
                Fridge.getDepth(),
                seria
        );
    }

    public void   delete(int seria)
    {
        jdbcTemplate.update("DELETE FROM Fridge WHERE seria=?", seria);
    }

    public Fridge show(int height)
    {
        return jdbcTemplate.query("SELECT * FROM Fridge WHERE height<?",
                new Object[]{height}, new BeanPropertyRowMapper<>(Fridge.class))
                .stream().findAny().orElse(null);
    }
}
