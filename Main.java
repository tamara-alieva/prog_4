import java.util.Scanner;

public class Main {
<<<<<<< HEAD
=======
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
                        System.out.println("У выбранного водителя недостаточно лет опыта или завершённых заказов для выполнения заказа уровня Комфорт!");
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

>>>>>>> faeb28039348f59665d9aa467c3855e4af457640
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String buffer;
        System.out.println("ТЕСТЫ:");
        
    }
}
