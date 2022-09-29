package ru.sfu;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");

        Cinema cinema = context.getBean("cinema", Cinema.class);
        cinema.showAllIntelligences();

        context.close();
    }
}
