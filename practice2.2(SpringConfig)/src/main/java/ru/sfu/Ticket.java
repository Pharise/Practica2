package ru.sfu;

import org.springframework.beans.factory.annotation.Value;

/**
 * Класс Билет
 */
public class Ticket implements Intelligence {
    private String name;
    private String surname;

    /**
     * Установить значение полю name
     * @param name - Имя пользователя
     */
    @Value("${IntelligenceTicket.name}")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Установить значение полю surname
     * @param surname - Фамилия пользователя
     */
    @Value("${IntelligenceTicket.surname}")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Информация о пользователе
     * @return строка с информацией о пользователе
     */
    @Override
    public String getIntelligenceInfo() {
        return name + " " + surname;
    }
}

