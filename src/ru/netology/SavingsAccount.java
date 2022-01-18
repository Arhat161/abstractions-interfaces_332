package ru.netology;

public class SavingsAccount extends Account implements AccountInterface {

    /*
    Со сберегательного счета нельзя платить, только переводить и пополнять.
    Также сберегательный не может уходить в минус.
     */

    private int balance;
    private String name;

    public SavingsAccount(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
    @Override
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
        System.out.println("Нельзя производить оплату со счета <" + this.getName() + "> !!!");
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

    // пополнение счета
    @Override
    public void addMoney(int amount) {
        this.balance += amount;
        System.out.println("Пополнение на сумму [" + amount + "] руб., счета <" + this.getName() + ">, баланс : " + this.getBalance() + " руб.");
    }

    @Override
    public String getName() {
        return this.name;
    }

}
