public class Main {
    public static void main(String[] args) {
        System.out.println("=== УПРАВЛЕНИЕ ТОВАРАМИ ===");

        System.out.println("\n1. СОЗДАНИЕ ТОВАРОВ:");
        System.out.println("----------------------");
        Product laptop = new Product("Ноутбук", 500, 600);
        laptop.getInfo();
        Product phone = new Product("Телефон", 300, 250);
        phone.getInfo();
        Product tablet = new Product("Планшет", 400);
        tablet.getInfo();

        System.out.println("\n2. ИЗМЕНЕНИЕ ЦЕН:");
        System.out.println("------------------");
        laptop.setPrice(650);
        laptop.getInfo();

        System.out.println("\n3. НАЦЕНКА И СКИДКА:");
        System.out.println("---------------------");
        laptop.addMargin(20);
        laptop.applyDiscount(10);

        System.out.println("\n4. ИЗМЕНЕНИЕ НА ФИКСИРОВАННОЕ ЗНАЧЕНИЕ:");
        System.out.println("-----------------------------------------");
        laptop.changePriceByFixed(-50);
        laptop.getInfo();

        System.out.println("\n5. ИСТОРИЯ ЦЕН:");
        System.out.println("----------------");
        laptop.printPriceHistory();

        System.out.println("\n6. РАСЧЕТЫ:");
        System.out.println("------------");
        System.out.println("Средняя цена ноутбука: " + String.format("%.2f", laptop.getAveragePrice()));
        System.out.println("Средняя наценка: " + String.format("%.2f", laptop.getAverageMargin()) + "%");
        System.out.println("Выручка за 10 ноутбуков: " + String.format("%.2f", laptop.calculateRevenue(10)));

        System.out.println("\n7. ТЕСТИРОВАНИЕ:");
        System.out.println("-----------------");
        Product testProduct = new Product("Тестовый товар", 100, 120);
        testProduct.setPrice(130);
        testProduct.setPrice(140);
        testProduct.setPrice(110);
        testProduct.setPrice(125);
        testProduct.setPrice(135);
        testProduct.printPriceHistory();
    }
}
