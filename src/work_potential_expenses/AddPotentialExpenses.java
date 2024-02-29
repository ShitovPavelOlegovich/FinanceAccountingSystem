package work_potential_expenses;

import WorkWithFile.AddInFile;
import WorkWithFile.FileConstants;
import potential_expenses.PotentialExpenses;

import java.util.InputMismatchException;
import java.util.Scanner;

import static potential_expenses.PotentialExpensesInfo.*;

public class AddPotentialExpenses {
    static String name;
    static double balance;
   public static void addPotentialExpenses() {
       PotentialExpenses potentialExpenses = new PotentialExpenses();
        System.out.println(ADD_NEW_POTENTIAL_EXPENSES.getMassage());
        System.out.println(ENTER_POTENTIAL_EXPENSES.getMassage());
        Scanner scanner = new Scanner(System.in);
        try {
            name = scanner.next().trim();
            potentialExpenses.setName(name);
            System.out.println(ENTER_BALANCE_POTENTIAL_EXPENSES.getMassage());
            balance = scanner.nextDouble();
            potentialExpenses.setBalance(balance);
        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT.getMassage());
        }
        AddInFile.writeFile(FileConstants.PATH_POTENTIAL_EXPENSES + potentialExpenses.getName() + ".txt", potentialExpenses.toString());
        System.out.println("=== Вы добавили новую затрату ===" +
                "\n⦁Название затраты: " + name +
                "\n⦁Сумма затраты: " + balance);
        System.out.println(ENTER_ACTION.getMassage());
    }
}
