package work_current_expenses;

import WorkWithFile.AddInFile;
import WorkWithFile.DeleteFile;
import WorkWithFile.FileConstants;
import WorkWithFile.FileReaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static current_expenses.CurrentExpensesInfo.*;
import static wallet.WalletInfo.ENTER_ACTION;
import static wallet.WalletInfo.INVALID_INPUT;

public class DepositCurrentExpenses {
    static String name = "";
    static double balance;

    public static void deposit() {
        System.out.println(ADD_ADDITIONAL_AMOUNT.getMassage());
        System.out.println(ENTER_CURRENT_EXPENSES.getMassage());
        Scanner scanner = new Scanner(System.in);
        name = scanner.next().trim();

        File[] files = new File(FileConstants.PATH_CURRENT_EXPENSES).listFiles();
        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                if (line != null && line.equals(name)) {
                    System.out.println(ENTER_SUM.getMassage());
                    balance = scanner.nextDouble();

                    String[] strings = FileReaders.reader(FileConstants.PATH_CURRENT_EXPENSES + name + ".txt").split("\n");
                    strings[1] = String.valueOf(balance + Double.parseDouble(strings[1]));
                    String text = strings[0] + "\n" + strings[1];
                    DeleteFile.deleteF(FileConstants.PATH_CURRENT_EXPENSES + name + ".txt");
                    AddInFile.writeFile(FileConstants.PATH_CURRENT_EXPENSES + name + ".txt", text);

                    System.out.println("Вы добавили к основной сумме " +
                            "\"" + balance + "\"" + " руб.");
                    return;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InputMismatchException e) {
                System.out.println(INVALID_INPUT.getMessage());
                return;
            }
        }
        System.out.println("Затраты с таким именем" + "\"" + name + "\"" + "не существует.");
        System.out.println(ENTER_ACTION.getMessage());


    }
}
