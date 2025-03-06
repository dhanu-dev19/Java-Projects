package models;

public class Account
{
    private final Integer accountNumber;
    private Double balance;

    public Account(Integer accountNumber, Double balance)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Integer getAccountNumber()
    {
        return accountNumber;
    }

    public Double getBalance()
    {
        return balance;
    }

    public void deposit(Double amount)
    {
        balance += amount;
        System.out.println("Deposited: $"+ amount);
    }

    public void withdraw(Double amount)
    {
        if(amount > balance)
        {
            System.out.println("Insufficient funds!");
        }
        else
        {
          balance -= amount;
          System.out.println("Withdrawn: $"+ amount);
        }
    }

    @Override
    public String toString()
    {
        return "Account Number: "+accountNumber+", Balance: $"+balance;
    }
}
