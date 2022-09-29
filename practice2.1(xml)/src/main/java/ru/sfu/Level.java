package ru.sfu;

/**
 * Класс Уровня места
 */
public class Level implements Intelligence {
    private String ClassLevel;

    /**
     * Установить значение полю ClassLevel
     * @param ClassLevel - эконом или бизнес
     */
    public void setClassLevel(String ClassLevel) {
        this.ClassLevel = ClassLevel;
    }

    /**
     * Информация о уровне места
     * @return строка с информацией о уровне места
     */
    @Override
    public String getIntelligenceInfo() {
        return ClassLevel + " Class";
    }
}
