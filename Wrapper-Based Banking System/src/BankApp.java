import models.Account;

import java.util.Scanner;

public class BankApp
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Account Number: ");
        Integer accNum = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Initial Balance: ");
        Double balance = Double.parseDouble(scanner.nextLine());

        Account account = new Account(accNum , balance);

        while (true)
        {
            System.out.println("\n 1. Desposit 2.Withdraw 3. Check Balance 4.Exit");
            int choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter Deposit Amount: ");
                    account.deposit(scanner.nextDouble());
                    break;
                case 2:
                    System.out.println("Enter Withdrawal Amount: ");
                    account.withdraw(scanner.nextDouble());
                    break;
                case 3:
                    System.out.println(account);
                    break;
                case 4:
                     System.out.println("Exiting...");
                     scanner.close();
                     return;
                default:
                    System.out.println("Invalid choice!");

            }
        }
    }
}