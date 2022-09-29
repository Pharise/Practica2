package ru.sfu;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Класс Посадочное место
 */
public class Place implements Intelligence{
    private int spots;

    /**
     * init-метод
     */
    @PostConstruct
    public void postConstruct() {System.out.println("Place is empty");}

    /**
     * destroy-метод
     */
    @PreDestroy
    public void preDestroy() {
        System.out.println("Place is over");
    }

    // Конструктор приватный, чтобы не создавать объект с помощью new
    private Place() {}

    /**
     * Фабричный метод
     * @return объект посадочного места
     */
    public static Place getPlace() {
        return new Place();
    }

    /**
     * Установить значение полю spots
     * @param spots - место
     */
    @Value("${IntelligencePlace.spots}")
    public void setSpots(int spots) {
        this.spots = spots;
    }

    /**
     * Информация о посадочном месте
     * @return строка с информацией о посадочном месте
     */
    @Override
    public String getIntelligenceInfo() {return "Place " + spots + " ";}
}
