package ru.netology;

public class CheckingAccount extends Account implements AccountInterface {

    /*
    Расчетный может выполнять все три операции (платить, переводить, пополнять),
    но не может уходить в минус.
     */

    private String name;
    private int balance;

    public CheckingAccount(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isNull(int amount) {
        if(amount > 0 && (this.getBalance() - amount) < 0) {
            return true;
        }
        return false;
    }

    @Override
    public void pay(int amount) {
        System.out.println("\nОплата суммы [" + amount + "] руб. со счета <" + this.getName() + "> ...");
        if(amount > 0) {
            if(this.isNull(amount)) {
                System.out.println("Недостаточно денег на счету <" + this.getName() + "> для оплаты!");
            } else {
                System.out.println("Оплата выполнена успешно!");
            }
        } else {
            System.out.println("Укажите сумму больше, чем ноль!");
        }
    }

    @Override
    public void transfer(Account account, int amount) {
        System.out.println("\nПереводим сумму [" + amount + "] руб. на счет <" + account.getName() + "> ...");
        if(amount > 0) {
            if(this.isNull(amount)) {
                System.out.println("Недостаточно денег на счету <" + this.getName() + "> для перевода на счет <" + account.getName() + "> !");
            } else {
                this.balance -= amount; // списание с текущего счета
                account.addMoney(amount); // зачисление на другой счет
                System.out.println("Перевод суммы [" + amount + "] руб. на счет <" + account.getName() + "> выполнен успешно!");
            }
        } else {
            System.out.println("Укажите сумму больше, чем ноль!");
        }
    }

    @Override
    public void addMoney(int amount) {
        this.balance += amount;
        System.out.println("Пополнение на сумму [" + amount + "] руб. счета <" + this.getName() + ">, баланс : " + this.getBalance() + " руб.");
    }

    @Override
    public String getName() {
        return this.name;
    }
}
