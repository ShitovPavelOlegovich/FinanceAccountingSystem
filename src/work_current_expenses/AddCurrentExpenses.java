package work_current_expenses;

import WorkWithFile.AddInFile;
import WorkWithFile.FileConstants;
import current_expenses.CurrentExpenses;

import java.util.InputMismatchException;
import java.util.Scanner;

import static current_expenses.CurrentExpensesInfo.*;

public class AddCurrentExpenses {
    static String name;
    static double balance;
    public static void addCurrentExpenses() {
        CurrentExpenses currentExpenses = new CurrentExpenses();
        System.out.println(ADD_NEW_CURRENT_EXPENSES.getMassage());
        System.out.println(ENTER_CURRENT_EXPENSES.getMassage());
        Scanner scanner = new Scanner(System.in);
        try {
            name = scanner.next().trim();
            currentExpenses.setName(name);
            System.out.println(ENTER_BALANCE_CURRENT_EXPENSES.getMassage());
            balance = scanner.nextDouble();
            currentExpenses.setBalance(balance);
        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT.getMassage());
        }
        AddInFile.writeFile(FileConstants.PATH_CURRENT_EXPENSES +
                currentExpenses.getName() + ".txt", currentExpenses.toString());
        System.out.println("=== Вы добавили новую затрату ===" +
                "\n⦁Название затраты: " + name +
                "\n⦁Сумма затраты: " + balance);
        System.out.println(ENTER_ACTION.getMassage());
    }
}
