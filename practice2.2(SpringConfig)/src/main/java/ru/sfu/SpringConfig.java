package ru.sfu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;

/**
 * Класс-конфигурации
 */
@Configuration
@PropertySource("classpath:cinema.properties")
public class SpringConfig {
    /**
     * Создание bean уровня
     * @return уровень
     */
    @Bean
    public Level level() {

        return new Level();
    }

    /**
     * Создание посадочного места
     * @return посадочное место
     */
    @Bean
    public Place place() {
        return Place.getPlace();
    }

    /**
     * Создание bean билета
     * @return билет
     */
    @Bean
    public Ticket ticket() {

        return new Ticket();
    }

    /**
     * Создание bean кинотеатр
     * @return кинотеатр
     */
    @Bean
    public Cinema cinema() {
        return new Cinema(Arrays.asList(place(), level(), ticket()));
    }
}
