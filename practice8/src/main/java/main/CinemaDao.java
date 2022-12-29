package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class CinemaDao {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Cinema> findAll() {
        List<Cinema> cinemas = jdbcTemplate.query("select * from cinema", new BeanPropertyRowMapper<>(Cinema.class));
        return cinemas;
    }

    public int update(Cinema cinema) {
        return jdbcTemplate.update("UPDATE cinema SET cost = ?, weight = ?, brand = ?, type = ?, color = ? "
                + "WHERE id = ?", new Object[] {
                cinema.getCost(), cinema.getWeight(), cinema.getBrand(), cinema.getType(), cinema.getColor(), cinema.getId()});
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM cinema WHERE id = ?", new Object[] {id});
    }

    public List<Cinema> findAllCostIncreaseThan(Double cost) {
        List<Cinema> cinemas = jdbcTemplate.query(
                "select * from cinema where cost>" + cost, new BeanPropertyRowMapper<>(Cinema.class)
        );
        return cinemas;
    }

    public int insert(Cinema cinema) {
        return jdbcTemplate.update("INSERT INTO cinema " + "(id, cost, weight, brand, type, color) "
        + "VALUES (?, ?, ?, ?, ?, ?)", new Object[] {
        cinema.getId(), cinema.getCost(), cinema.getWeight(), cinema.getBrand(), cinema.getType(), cinema.getColor()});
    }

}
