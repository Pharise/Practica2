package ru.sfu;

import java.util.List;

/**
 * Класс Кинотеатр
 */
public class Cinema {
    private List<Intelligence> Intelligences;

    /**
     * Конструктор
     * @param Intelligences - список сведения
     */
    public Cinema(List<Intelligence> Intelligences) {
        this.Intelligences = Intelligences;
    }

    /**
     * Установить значение полю Intelligence
     * @param Intelligence - сведения
     */
    public void setIntelligence(Intelligence Intelligence) {
        Intelligences.add(Intelligence);
    }

    /**
     * Вывод всех сведений в кинотеатре
     */
    public void showAllIntelligences() {
        if (Intelligences.isEmpty())
            System.out.println("Ticket empty");
        else {
            StringBuilder allIntelligences = new StringBuilder("Ticket contains:");
            for (Intelligence Intelligence: Intelligences) {
                allIntelligences.append("\n").append(Intelligence.getIntelligenceInfo());
            }
            System.out.println(allIntelligences);
        }
    }
}
