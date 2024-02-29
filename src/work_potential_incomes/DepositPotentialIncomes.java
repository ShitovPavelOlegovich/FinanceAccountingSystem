package work_potential_incomes;

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

import static potential_Incomes.PotentialIncomesInfo.*;
import static wallet.WalletInfo.ENTER_ACTION;
import static wallet.WalletInfo.INVALID_INPUT;

public class DepositPotentialIncomes {
    static String name;
    static double balance;
    public static void depositPotentialIncomes() {
        System.out.println(ADD_ADDITIONAL_AMOUNT.getMassage());
        System.out.println(ENTER_NAME.getMassage());
        Scanner scanner = new Scanner(System.in);
        name = scanner.next().trim();

        File[] files = new File(FileConstants.PATH_POTENTIAL_INCOMES).listFiles();
        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                if (line != null && line.equals(name)) {
                    System.out.println(ENTER_SUM.getMassage());
                    balance = scanner.nextDouble();

                    String[] strings = FileReaders.reader(FileConstants.PATH_POTENTIAL_INCOMES + name + ".txt").split("\n");
                    strings[1] = String.valueOf(balance + Double.parseDouble(strings[1]));
                    String text = strings[0] + "\n" + strings[1];
                    DeleteFile.deleteF(FileConstants.PATH_POTENTIAL_INCOMES + name + ".txt");
                    AddInFile.writeFile(FileConstants.PATH_POTENTIAL_INCOMES + name + ".txt", text);
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
        System.out.println("Дохода с таким названием " + "\"" + name + "\"" + "не существует.");
        System.out.println(ENTER_ACTION.getMessage());

    }
}
