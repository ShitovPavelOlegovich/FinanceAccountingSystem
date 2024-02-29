package work_current_expenses;

import WorkWithFile.FileConstants;
import WorkWithFile.FileReaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static current_expenses.CurrentExpensesInfo.ENTER_CURRENT_EXPENSES;
import static current_expenses.CurrentExpensesInfo.INFORMATION_CURRENT_EXPENSES;
import static wallet.WalletInfo.*;

public class GetCurrentExpensesInformation {
    public static void getInformation() {
        System.out.println(INFORMATION_CURRENT_EXPENSES.getMassage());
        System.out.println(ENTER_CURRENT_EXPENSES.getMassage());
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next().trim();
        File[] files = new File(FileConstants.PATH_CURRENT_EXPENSES).listFiles();
        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                if (line != null && line.equals(name)) {
                    String[] strings = FileReaders.reader(FileConstants.PATH_CURRENT_EXPENSES + name + ".txt").split("\n");
                    strings[1] = String.valueOf(strings[1]);
                    System.out.println("Информация о затрате под названием: " + "\"" + name + "\""
                            + "\n~" + strings[0] + " - " + strings[1] + " руб.");
                    System.out.println(ENTER_ACTION.getMessage());
                    return;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InputMismatchException e) {
                System.out.println(INVALID_INPUT.getMessage());
                return;
            }
        }
        System.out.println("Затраты с таким названием" + "\"" + name + "\"" + "не существует.");
        System.out.println(ENTER_ACTION.getMessage());
    }
}
