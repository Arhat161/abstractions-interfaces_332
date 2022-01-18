package ru.netology;

public class Main {

    public static void main(String[] args) {

        Account savingsAccount = new SavingsAccount("Сберегательный", 1000);
        Account creditAccount = new CreditAccount("Кредитный", 0);
        Account checkingAccount = new CheckingAccount("Рассчетный", 1000);

        // СБЕРЕГАТЕЛЬНЫЙ счет
        System.out.println("\n" + savingsAccount.getName() + ", на счету " + savingsAccount.getBalance() + " руб.\n");
        savingsAccount.pay(100); // ОШИБКА !!! Нельзя платить со сберегательного счета!
        savingsAccount.addMoney(100); // пополнение сберегательного счета
        savingsAccount.transfer(checkingAccount, 100); // перевод со сберегательного счета
        // КРЕДИТНЫЙ счет
        System.out.println("\n" + creditAccount.getName() + ", на счету " + creditAccount.getBalance() + " руб.");
        creditAccount.transfer(checkingAccount, 1000); // списание с кредитного счета
        creditAccount.addMoney(50); // пополнение кредитного счета
        creditAccount.pay(1250); // оплата с кредитного счета
        // РАСЧЕТНЫЙ счет
        System.out.println("\n" + checkingAccount.getName() + ", на счету " + checkingAccount.getBalance() + " руб.");
        checkingAccount.transfer(savingsAccount, 100);
        System.out.println("Балланс счета <" + checkingAccount.getName() + "> : " + checkingAccount.getBalance() + " руб.");
        checkingAccount.addMoney(1000);
        checkingAccount.pay(500);
        System.out.println("Балланс счета <" + checkingAccount.getName() + "> : " + checkingAccount.getBalance() + " руб.");

    }
}
