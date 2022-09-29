package ru.sfu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(SpringConfig.class);

        Cinema cinema = context.getBean("cinema", Cinema.class);
        cinema.showAllIntelligences();

        context.close();
    }
}
