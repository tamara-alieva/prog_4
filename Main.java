import java.util.Scanner;

public class Main {
    public static void order(boolean rate, boolean congestion, Passenger passenger, Driver driver, Car car) {
        System.out.println("ЗАКАЗ");
        int payment;
        int status = 0;
        if (rate) {
            payment = 500; // Класс поездки - Комфорт
        } else {
            payment = 200; // Класс поездки - Эконом
        }
        if (congestion) {
            payment *= 2; // Если дороги загруженны
        }
        if (passenger.getBalance() < payment) {
            System.out.println("На балансе пассажира недостаточно средств! (Сумма поездки: " + payment + ")");
        } else {
            if (car.fuel.getCapacity() == false) {
                System.out.println("У выбранной машины не заполнен топливный бак!");
            } else {
                if (rate) { // Класс поездки - Комфорт
                    if (driver.getExperience() < 10 || driver.getOrderAmount() < 30) {
                        System.out.println("У выбранного водителя недостаточно лет опыта или завершённых заказов для выполнения заказа уровня К��мфорт!");
                    } else {
                        if (car.getRate() == false) {
                            System.out.println("Выбранный автомобиль недостаточно высокого класса для выполнения заказа уровня Комфорт!");
                        } else {
                            status = 1;
                        }
                    }
                } else { // Класс поездки - Эконом
                    status = 1;
                }
            }
        }
        if (status == 1) {
            passenger.takePayment(payment);
            driver.givePayment(payment);
            driver.increaseOrderAmount();
            car.fuel.empty();
            System.out.println("Заказ выполнен успешно! Информация на момент завершения заказа:\n");
            System.out.println("Класс поездки: " + (rate ? "Комфорт" : "Эконом"));
            System.out.println("Загруженность дорог: " + (congestion ? "Есть" : "Нет"));
            System.out.println("Стоимость поездки: " + payment + "\n");
            passenger.output();
            driver.output();
            car.output();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String buffer;
        System.out.println("ТЕСТЫ:");
        System.out.println("---------------------- Человек -----------------------------\n");
        Person[] person_array = new Person[2];
        buffer = "Ivan";
        person_array[0] = new Person(buffer);
        System.out.println("--- Тест setName (установлено значение \"Ivan\") и getName: имя - " + person_array[0].getName());
        person_array[0].setBalance(500);
        System.out.println("--- Тест setBalance (установлено значение 500) и getBbalance: баланс = " + person_array[0].getBalance());
        System.out.println("--- Тест input (ввести данные):");
        person_array[1] = new Person();
        person_array[1].input();
        System.out.println("--- Тест output (вывести данные):");
        person_array[1].output();
        System.out.println("\n---------------------- Пассажир ----------------------------\n");
        Passenger passenger = new Passenger(buffer, 200, true);
        System.out.println("--- Тест getMethod (установлено значение 1 - Банковская карта): способ оплаты - " + passenger.getMethod());
        System.out.println("--- Тест input (ввести данные):");
        passenger.input();
        System.out.println("--- Тест output (вывести данные):");
        passenger.output();
        System.out.println("---------------------- Водитель ----------------------------\n");
        Driver driver = new Driver(person_array[1].getName());
        driver.setBalance(3000);
        driver.setExperience(5);
        System.out.println("--- Тест setExperience (установлено значение 5) и getExperience: опыт вождения (лет) = " + driver.getExperience());
        driver.setOrderAmount(15);
        System.out.println("--- Тест setOrderAmount (установлено значение 15) и geOrderAmount: кол-во выполненных заказов = " + driver.getOrderAmount());
        System.out.println("--- Тест input (ввести данные):");
        driver.input();
        System.out.println("--- Тест output (вывести данные):");
        driver.output();
        System.out.println("---------------------- Топливный бак -----------------------\n");
        Fuel fuel = new Fuel();
        fuel.setCapacity(true);
        System.out.println("--- Тест setCapacity (установлено значение 1 - Полный) и getCapacity: заполненность = " + fuel.getCapacity());
        System.out.println("--- Тест input_fuel (ввести данные):");
        fuel.input();
        System.out.println("--- Тест output_fuel (вывести данные):");
        fuel.output();
        fuel.empty();
        System.out.println("--- Тест empty (опустошить бак): заполненность = " + fuel.getCapacity());
        fuel.fill();
        System.out.println("--- Тест fill (заполнить бак): заполненность = " + fuel.getCapacity() + "\n");
        System.out.println("---------------------- Автомобиль --------------------------\n");
        buffer = "Toyota";
        Car[] car_array = new Car[3];
        car_array[0] = new Car();
        car_array[1] = new Car(buffer);
        car_array[2] = new Car("Volvo", true);
        car_array[2].fuel.fill();
        System.out.println("--- Тест setBrand (установлено значение \"Toyota\") и getBrand: " + car_array[1].getBrand());
        car_array[1].setRate(false);
        System.out.println("--- Тест setRate (установлено значение 0 - Эконом) и getRate: класс автомобиля - " + car_array[1].getRate());
        System.out.println("--- Тест input (ввести данные):");
        car_array[0].input();
        System.out.println("--- Тест output_car (вывести данные об автомобиле):");
        car_array[0].output();
        car_array[1].fuel.fill();
        System.out.println("--- Тест fill (заполнить бак, через дочерний объект Fuel): заполненность = " + car_array[1].fuel.getCapacity() + "\n");
        System.out.println("---------------------- Заказ -------------------------------");
        boolean rate = false;
        boolean congestion = false;
        System.out.println("--- Тест 1 (Эконом): заказ успешно выполняется");
        order(rate, congestion, passenger, driver, car_array[1]);
        System.out.println("--- Тест 2 (Эконом): на балансе пассажира недостаточно средств");
        passenger.setBalance(100);
        order(rate, congestion, passenger, driver, car_array[1]);
        System.out.println("--- Тест 3 (Эконом): топливный бак автомобиля не заполнен");
        passenger.setBalance(300);
        order(rate, congestion, passenger, driver, car_array[1]);
        System.out.println("--- Тест 4 (Комфорт): у водителя недостаточно лет опыта вождения");
        rate = true;
        congestion = true;
        car_array[1].fuel.fill();
        passenger.setBalance(1500);
        order(rate, congestion, passenger, driver, car_array[1]);
        System.out.println("--- Тест 5 (Комфорт): у водителя недостаточно выполненных заказов");
        driver.setExperience(17);
        order(rate, congestion, passenger, driver, car_array[1]);
        System.out.println("--- Тест 6 (Комфорт): автомобиль недостаточно высокого класса");
        driver.setOrderAmount(50);
        order(rate, congestion, passenger, driver, car_array[1]);
        System.out.println("--- Тест 7 (Комфорт): заказ успешно выполняется");
        car_array[0].fuel.fill();
        order(rate, congestion, passenger, driver, car_array[2]);
    }
}
