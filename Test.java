public class ProductTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ ===");
        boolean allTestsPassed = true;
        System.out.println("\nТест 1: Создание товара");
        Product p1 = new Product("Тест1", 100, 120);
        if (p1.getCurrentPrice() == 120) {
            System.out.println("Товар создан с корректной ценой");
        } else {
            System.out.println("Ошибка при создании товара");
            allTestsPassed = false;
        }

        System.out.println("\nТест 2: Цена ниже себестоимости");
        Product p2 = new Product("Тест2", 100, 80);
        if (p2.getCurrentPrice() == 100) {
            System.out.println("Цена скорректирована до себестоимости");
        } else {
            System.out.println("Ошибка коррекции цены");
            allTestsPassed = false;
        }

        System.out.println("\nТест 3: Наценка");
        Product p3 = new Product("Тест3", 100, 100);
        p3.addMargin(20); // 100 + 20% = 120
        if (Math.abs(p3.getCurrentPrice() - 120) < 0.01) {
            System.out.println("Наценка работает правильно");
        } else {
            System.out.println("Ошибка при наценке");
            allTestsPassed = false;
        }

        System.out.println("\nТест 4: Скидка");
        p3.applyDiscount(10); // 120 - 10% = 108
        if (Math.abs(p3.getCurrentPrice() - 108) < 0.01) {
            System.out.println("Скидка работает правильно");
        } else {
            System.out.println("Ошибка при скидке");
            allTestsPassed = false;
        }

        System.out.println("\nТест 5: История цен");
        Product p4 = new Product("Тест4", 100, 100);
        p4.setPrice(110);
        p4.setPrice(120);
        p4.setPrice(130);
        System.out.println("История цен (должно быть 4 записи):");
        p4.printPriceHistory();

        System.out.println("\nТест 6: Средняя цена");
        double avg = p4.getAveragePrice();
        System.out.println("Средняя цена: " + avg);

        System.out.println("\nТест 7: Расчет выручки");
        double revenue = p4.calculateRevenue(5); // 130 * 5 = 650
        if (Math.abs(revenue - 650) < 0.01) {
            System.out.println("Выручка рассчитана правильно: " + revenue);
        } else {
            System.out.println("Ошибка при расчете выручки");
            allTestsPassed = false;
        }

        System.out.println("\n====================");
        if (allTestsPassed) {
            System.out.println("ВСЕ ТЕСТЫ ПРОЙДЕНЫ!");
        } else {
            System.out.println("НЕКОТОРЫЕ ТЕСТЫ НЕ ПРОЙДЕНЫ");
        }
    }
}
