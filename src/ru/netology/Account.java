package ru.netology;

abstract class Account {

    // TODO Ovveride me!
    public abstract void pay(int amount);

    public abstract void transfer(Account account, int amount);

    public abstract void addMoney(int amount);

    public abstract int getBalance();

    public abstract String getName();

}
