package ru.sfu;

/**
 * Класс Посадочное место
 */
public class Place implements Intelligence {
    private int spots;

    /**
     * Установить значение полю spots
     * @param spots - место
     */
    public void setspots(int spots) {
        this.spots = spots;
    }

    /**
     * Информация о посадочном месте
     * @return строка с информацией о посадочном месте
     */
    @Override
    public String getIntelligenceInfo() {
        return "Place " + spots + " ";
    }
}
