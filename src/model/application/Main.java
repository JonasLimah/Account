package model.application;

import model.entities.Account;
import model.exception.DomainException;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter Account Data");
            System.out.print("Number: ");
            Integer number = input.nextInt();
            System.out.print("Holder: ");
            input.nextLine();
            String holder = input.nextLine();
            System.out.print("Initial Balance: ");
            Double balance = input.nextDouble();
            System.out.print("Withdraw Limit: ");
            Double withdraw = input.nextDouble();
            Account account = new Account(number,holder,balance,withdraw);
            System.out.print("Enter with a withdraw: ");
            Double amountWithdraw = input.nextDouble();
            account.withdraw(amountWithdraw);
            System.out.print("New balance: ");
            System.out.print("R$"+String.format("%.2f",account.getBalance()));
        }
        catch (InputMismatchException e){
            System.out.println("Error data format");
        }
        catch (DomainException e){
            System.out.println(e.getMessage());
        }

    }
}