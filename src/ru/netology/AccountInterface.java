package ru.netology;

public interface AccountInterface {

    public void pay(int amount);

    public void transfer(Account account, int amount);

    public void addMoney(int amount);
}
