import java.util.ArrayList;
public class Product {
    private String name;
    private double costPrice;
    private double currentPrice;
    private ArrayList<Double> priceHistory;
    private final int MAX_HISTORY_SIZE = 10;

    public Product(String name, double costPrice, double initialPrice) {
        this.name = name;
        this.costPrice = costPrice;
        if (initialPrice < costPrice) {
            System.out.println("Цена " + initialPrice + " ниже себестоимости " + costPrice + ". Установлена себестоимость.");
            this.currentPrice = costPrice;
        } else {
            this.currentPrice = initialPrice;
        }
        priceHistory = new ArrayList<>();
        addToHistory(this.currentPrice);
    }

    public Product(String name, double costPrice) {
        this(name, costPrice, costPrice);
    }

    private void addToHistory(double price) {
        priceHistory.add(price);
        if (priceHistory.size() > MAX_HISTORY_SIZE) {
            priceHistory.remove(0);
        }
    }

    public void getInfo() {
        System.out.println("Товар: " + name);
        System.out.println("Себестоимость: " + costPrice);
        System.out.println("Текущая цена: " + currentPrice);
        System.out.println("------------------------");
    }

    public void setPrice(double newPrice) {
        if (newPrice < costPrice) {
            System.out.println("Ошибка: Цена " + newPrice + " ниже себестоимости " + costPrice);
            return;
        }
        currentPrice = newPrice;
        addToHistory(newPrice);
        System.out.println("Цена установлена: " + currentPrice);
    }

    public void addMargin(double percent) {
        if (percent < 0) {
            System.out.println("Ошибка: Процент не может быть отрицательным");
            return;
        }
        double newPrice = currentPrice * (1 + percent / 100);
        if (newPrice < costPrice) {
            System.out.println("Ошибка: Новая цена будет ниже себестоимости");
            return;
        }
        currentPrice = newPrice;
        addToHistory(newPrice);
        System.out.println("Наценка " + percent + "% применена. Новая цена: " + currentPrice);
    }

    public void applyDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Ошибка: Некорректный процент скидки");
            return;
        }
        double newPrice = currentPrice * (1 - percent / 100);
        if (newPrice < costPrice) {
            System.out.println("Ошибка: Новая цена будет ниже себестоимости");
            return;
        }
        currentPrice = newPrice;
        addToHistory(newPrice);
        System.out.println("Скидка " + percent + "% применена. Новая цена: " + currentPrice);
    }

    public void changePriceByFixed(double amount) {
        double newPrice = currentPrice + amount;
        if (newPrice < costPrice) {
            System.out.println("Ошибка: Новая цена будет ниже себестоимости");
            return;
        }
        currentPrice = newPrice;
        addToHistory(newPrice);
        if (amount > 0) {
            System.out.println("Цена увеличена на " + amount + ". Новая цена: " + currentPrice);
        } else {
            System.out.println("Цена уменьшена на " + Math.abs(amount) + ". Новая цена: " + currentPrice);
        }
    }

    public double getAveragePrice() {
        if (priceHistory.isEmpty()) {
            return currentPrice;
        }
        double sum = 0;
        for (double price : priceHistory) {
            sum += price;
        }
        return sum / priceHistory.size();
    }

    public double getAverageMargin() {
        if (priceHistory.isEmpty() || costPrice == 0) {
            return 0;
        }
        double totalMargin = 0;
        for (double price : priceHistory) {
            double margin = ((price - costPrice) / costPrice) * 100;
            totalMargin += margin;
        }
        return totalMargin / priceHistory.size();
    }

    public double calculateRevenue(int quantity) {
        if (quantity < 0) {
            System.out.println("Ошибка: Количество не может быть отрицательным");
            return 0;
        }
        return currentPrice * quantity;
    }

    public void printPriceHistory() {
        System.out.println("История цен товара '" + name + "':");
        if (priceHistory.isEmpty()) {
            System.out.println("История пуста");
            return;
        }
        for (int i = 0; i < priceHistory.size(); i++) {
            String mark = (priceHistory.get(i) == currentPrice) ? " (текущая)" : "";
            System.out.println((i + 1) + ". " + priceHistory.get(i) + mark);
        }
        System.out.println("Средняя цена: " + String.format("%.2f", getAveragePrice()));
        System.out.println("Средняя наценка: " + String.format("%.2f", getAverageMargin()) + "%");
    }

    public String getName() {
        return name;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }
}
