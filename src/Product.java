import java.util.Scanner;

public abstract class Product {
    Scanner input = new Scanner(System.in);

    private int id;
    private String name;
    private double price;
    private int discountRate;
    private int stock;
    private Brand brand;
    private double screenSize;
    private int ram;
    private int memory;

    public abstract void menu();
    public abstract void addItem();
    public abstract void getProducts();
    public abstract void deleteItem();


    public Product(){

    }

    public Product(int id, String name, double price, int discountRate, int stock, Brand brand, double screenSize, int ram, int memory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.brand = brand;
        this.screenSize = screenSize;
        this.ram = ram;
        this.memory = memory;
    }


    // Sadece ıd metodunun setter ı yok çünkü değiştirilemez olacak !
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}