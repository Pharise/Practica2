package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class TestSpring {

    static final int LOWER_CHOICE = 0;
    static final int UPPER_CHOICE_MENU = 5;
    static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(SpringConfig.class);

        FridgeX FridgeX = context.getBean("FridgeX", FridgeX.class);

        int seria = 1;

        boolean flag = true;
        int userChoice;
        while (flag)
        {
            System.out.println(
                    "Нажмите на одну из клавиш:\n"+
                    "0. Добавить новый холодильник\n" +
                    "1. Показать все холодильники\n" +
                    "2. Изменить параметры холодильника (по seria)\n" +
                    "3. Удалить холодильник (по seria)\n" +
                    "4. Поиск\n" +
                    "5. Выход"
            );
            userChoice = getInt();
            while ((userChoice < LOWER_CHOICE) || (userChoice > UPPER_CHOICE_MENU))
            {
                System.out.println("Ошибка. Попробуйте еще раз");
                userChoice = getInt();
            }
            Menu menu = Menu.values()[userChoice];
            switch (menu) {
                case ADD ->
                {
                    System.out.println("Введите комплектацию холодильника:");
                    String views = scan.nextLine();

                    System.out.println("Введите брэнд холодильника:");
                    String brand = scan.nextLine();

                    System.out.println("Введите страну изготовителя холодильника:");
                    String country = scan.nextLine();

                    System.out.println("Введите высоту холодильника:");
                    int height = getInt();

                    System.out.println("Введите высоту ширину:");
                    int width = getInt();

                    System.out.println("Введите высоту объём:");
                    int depth = getInt();

                    Fridge fridge = new Fridge(
                            seria,
                            views,
                            brand,
                            country,
                            height,
                            width,
                            depth
                    );
                    seria++;
                    FridgeX.insert(fridge);
                }
                case OUTPUT ->
                {
                    List<Fridge> fridges = FridgeX.findAll();
                    for (Fridge fridge: fridges) {
                        System.out.println(fridge);
                    }
                }
                case UPDATE ->
                {
                    System.out.println("Введите seria холодильника, который хотите изменить:");
                    int fridge_seria = getInt();

                    System.out.println("Введите комплектацию холодильника:");
                    String views = scan.nextLine();

                    System.out.println("Введите бренд холодильника:");
                    String brand = scan.nextLine();

                    System.out.println("Введите страну изготовителя холодильника:");
                    String country = scan.nextLine();

                    System.out.println("Введите высоту холодильника:");
                    int height = getInt();

                    System.out.println("Введите высоту ширину:");
                    int width = getInt();

                    System.out.println("Введите высоту объём:");
                    int depth = getInt();

                    Fridge fridge = new Fridge(
                            seria,
                            views,
                            brand,
                            country,
                            height,
                            width,
                            depth
                    );
                    FridgeX.update(fridge_seria, fridge);
                }
                case REMOVE ->
                {
                    System.out.println("Введите seria холодильника, который хотите удалить:");
                    int fridge_id = getInt();
                    FridgeX.delete(fridge_id);
                }
                case SEARCH -> {
                    System.out.println("Введите максимальную высоту холодильника:");
                    int maxHigh = getInt();
                    Fridge fridge = FridgeX.show(maxHigh);
                    if (fridge.equals(null)) {
                        System.out.println("Нет холодильника данной высоты");
                    } else {
                        System.out.println("Один из холодильников, который вам подходит: " + fridge);
                    }
                }
                case SHUT_DOWN -> flag = false;
            }
        }
        context.close();
    }

    /**
     * Функция для получения числа от пользователя
     * @return число
     */
    static int getInt()
    {
        int number;

        while (true)
        {
            if (scan.hasNextInt()) {
                number = scan.nextInt();
                scan.nextLine();

                if (number < 0) {
                    System.out.println("Введите положительное число!");
                } else break;
            } else {
                scan.nextLine();
                System.out.println("Введите число!");
            }
        }

        return number;
    }
}

/**
 * Меню
 */
enum Menu {
    ADD,
    OUTPUT,
    UPDATE,
    REMOVE,
    SEARCH,
    SHUT_DOWN
}
