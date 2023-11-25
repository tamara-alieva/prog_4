package src;
import java.util.Scanner;

import Checking;
import Fuel;

public class Car {
    private String brand;
    private boolean rate;
    protected Fuel fuel;

    public Car() {
        this.fuel = new Fuel();
        this.brand = "";
        this.rate = false;
    }

    public Car(String brand) {
        this.fuel = new Fuel();
        this.brand = brand;
        this.rate = false;
    }

    public Car(boolean rate) {
        this.fuel = new Fuel();
        this.brand = "";
        this.rate = rate;
    }

    public Car(String brand, boolean rate) {
        this.fuel = new Fuel();
        this.brand = brand;
        this.rate = rate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setRate(boolean rate) {
        this.rate = rate;
    }

    public String getBrand() {
        return this.brand;
    }

    public boolean getRate() {
        return this.rate;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        String temp; boolean flag;
        System.out.println("** Ввод данных автомобиля **");
        do {
            System.out.print("Введите марку: ");
            this.brand = scanner.nextLine();
            flag = Checking.nameCheck(this.brand);
            if (!flag) System.out.print("Попробуйте ещё раз. ");
        } while (!flag);
        do {
            System.out.print("Введите класс автомобиля (0 - Эконом, 1 - Комфорт): ");
            temp = scanner.nextLine();
            flag = Checking.booleanCheck(temp);
            if (!flag) System.out.print("Попробуйте ещё раз. ");
        } while (!flag);
        if (temp.equals("1"))
            this.rate = true;
        else
            this.rate = false;
        System.out.println("Данные успешно введены!\n");
    }

    public void output() {
        if (this.brand.isEmpty()) {
            System.out.println("Данные об автомобиле отсутствуют!");
        } else {
            System.out.println("Данные об автомобиле:");
            System.out.println("-Марка: " + this.brand);
            System.out.print("-Класс: ");
            if (this.rate) {
                System.out.println("Комфорт");
            } else {
                System.out.println("Эконом");
            }
        }
    }
}
