package ru.netology;

public class CreditAccount extends Account implements AccountInterface {

    /*
    Кредитный не может иметь положительный баланс – если платить с него,
    то уходит в минус, чтобы вернуть в 0, надо пополнить его.
     */

    private int balance = 0;
    private String name;

    public CreditAccount(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public void pay(int amount) {
        if(amount > 0) {
            this.balance -= amount;
            System.out.println("Оплата суммы [" + amount + "] руб. со счета <" + this.getName() + ">, баланс : " + this.getBalance());
        } else {
            System.out.println("Укажите для оплаты со счета <" + this.getName() + "> сумму больше нуля!");
        }
    }

    @Override
    public void transfer(Account account, int amount) {
        System.out.println("\nПереводим сумму [" + amount + "] руб. на счет <" + account.getName() + "> ...");
        this.balance -= amount; // списание с текущего счета
        account.addMoney(amount); // зачисление на другой счет
        System.out.println("Списание [" + amount + "] руб. со счета <" + this.getName() + ">, баланс : " + this.getBalance());
    }

    @Override
    public void addMoney(int amount) {
        int nowBalance = this.getBalance();
        if((nowBalance + amount) > 0) {
            System.out.println("Вы пополнили счета <" + this.getName() + "> до нулевого балланса, задолжностей нет.");
            this.balance = 0;
        } else {
            this.balance += amount;
            System.out.println("Баланс счета <" + this.getName() + "> успешно пополнен на [" + amount + "] руб.");
            System.out.println("Текущий балланс счета <" + this.getName() + "> : " + this.balance + " руб.");
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
