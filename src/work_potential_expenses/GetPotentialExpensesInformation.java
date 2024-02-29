package work_potential_expenses;

import WorkWithFile.FileConstants;
import WorkWithFile.FileReaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static potential_expenses.PotentialExpensesInfo.ENTER_NAME;
import static potential_expenses.PotentialExpensesInfo.INFORMATION_POTENTIAL_EXPENSES;
import static wallet.WalletInfo.ENTER_ACTION;
import static wallet.WalletInfo.INVALID_INPUT;

public class GetPotentialExpensesInformation {

    public static void getInformation() {
        System.out.println(INFORMATION_POTENTIAL_EXPENSES.getMassage());
        System.out.println(ENTER_NAME.getMassage());
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next().trim();
        File[] files = new File(FileConstants.PATH_POTENTIAL_EXPENSES).listFiles();
        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                if (line != null && line.equals(name)) {
                    String[] strings = FileReaders.reader(FileConstants.PATH_POTENTIAL_EXPENSES + name + ".txt").split("\n");
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
        System.out.println("Затраты с названием " + "\"" + name + "\"" + " не найдено. ");
        System.out.println(ENTER_ACTION.getMessage());
    }
}
