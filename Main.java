import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String buffer;
        System.out.println("ТЕСТЫ:");
        System.out.println("1) Массив объектов");
        buffer = "Toyota";
        Car[] car_array = new Car[3];
        car_array[0] = new Car("Kia Rio");
        car_array[1] = new Car(buffer);
        car_array[2] = new Car("Volvo", true);
        for (int i = 0; i < 3; i++)
            car_array[i].output();
        System.out.println();

        System.out.println("2) Статическое поле numberOfCars и метод getNumberOfCars");
        System.out.println("Количество созданных объектов Car: " + Car.getNumberOfCars());
        System.out.println();

        System.out.println("3) Метод intCheck вспомогательного класса Checking");
        Driver driver = new Driver();
        driver.input(); // Вызов intCheck

        System.out.println("4) Использование оператора this (во всех конструкторах классов)");
        Fuel fuel = new Fuel();
        fuel.output();

        System.out.println("5) Обработка строк");
        buffer = "Volvo";
        car_array[1].setBrand(buffer);
        System.out.println("Возврат String: " + car_array[1].getBrand());
    }
}
