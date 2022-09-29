package ru.sfu;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Класс Уровня места
 */
public class Level implements Intelligence {
    private String ClassLevel;

    /**
     * init-метод
     */
    @PostConstruct
    public void postConstruct() {
        System.out.println("Class is ready to use");
    }

    /**
     * destroy-метод
     */
    @PreDestroy
    public void preDestroy() {
        System.out.println("The Class has run out of economy");
    }

    /**
     * Установить значение полю ClassLevel
     * @param ClassLevel - бизнес или эконом
     */
    @Value("${IntelligenceLevel.ClassLevel}")
    public void setClassLevel(String ClassLevel) {
        this.ClassLevel = ClassLevel;
    }

    /**
     * Информация о посадочном месте
     * @return строка с информацией о посадочном месте
     */
    @Override
    public String getIntelligenceInfo() {
        return ClassLevel + " Class";
    }
}
