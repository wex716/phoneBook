public class Phone {
    private String model;
    private String color;
    private int price;
    private int balance;

    public Phone(String model, String color, int price, int balance) {
        this.model = model;
        this.color = color;
        this.price = price;
        this.balance = balance;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", balance=" + balance +
                '}';
    }

    public void setModel(String model) throws Exception {
        if (model.length() < 3 || model.length() > 30) {
            throw new Exception("Ошибка устновки названия модели телефона. Длина должна быть от 3 до 30 символов");
        }
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(int price) throws Exception {
        if (price <= 0 || price > 1000000) {
            throw new Exception("Ошибка установки цены телефона.Цена должна быть от 0 до 1000000 рублей");
        }
        this.price = price;
    }

    public void setBalance(int balance) throws Exception {
        if(balance < 0 || balance > 100){
            throw new Exception("Ошибка установки кол-ва телефона на складе.Оно должно быть от 0 до 100");
        }
        this.balance = balance;
    }
}



