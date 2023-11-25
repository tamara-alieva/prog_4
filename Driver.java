import java.util.Scanner;

public class Driver extends Person {
    private int experience;
    private int orderAmount;

    public Driver() {
        super();
        this.experience = 0;
        this.orderAmount = 0;
    }

    public Driver(String name) {
        super(name);
        this.experience = 0;
        this.orderAmount = 0;
    }

    public Driver(int balance) {
        super(balance);
        this.experience = 0;
        this.orderAmount = 0;
    }

    public Driver(String name, int balance, int experience, int orderAmount) {
        super(name, balance);
        this.experience = experience;
        this.orderAmount = orderAmount;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getExperience() {
        return this.experience;
    }

    public int getOrderAmount() {
        return this.orderAmount;
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        String temp = ""; int flag;
        System.out.println("** Ввод данных водителя: " + this.getName() + " **");
        do {
            System.out.print("Введите количество лет опыта: ");
            temp = scanner.nextLine();
            flag = Checking.intCheck(temp);
            if (flag == 0) System.out.print("Попробуйте ещё раз. ");
        } while (flag == 0);
        this.experience = Integer.parseInt(temp);
        temp = "";
        do {
            System.out.print("Введите количество выполненных заказов: ");
            temp = scanner.nextLine();
            flag = Checking.intCheck(temp);
            if (flag == 0) System.out.print("Попробуйте ещё раз. ");
        } while (flag == 0);
        this.orderAmount = Integer.parseInt(temp);
        System.out.println("Данные успешно введены!\n");
    }

    @Override
    public void output() {
        System.out.println("Данные о водителе:");
        System.out.println("-Имя: " + this.getName());
        System.out.println("-Баланс: " + this.getBalance());
        System.out.println("-Количество лет опыта: " + this.getExperience());
        System.out.println("-Количество выполненных заказов: " + this.getOrderAmount() + "\n");
    }

    public void givePayment(int payment) {
        int old_balance = this.getBalance();
        this.setBalance(old_balance + payment);
    }

    public void increaseOrderAmount() {
        int old_amount = this.getOrderAmount();
        this.setOrderAmount(old_amount + 1);
    }
}
