package work_potential_expenses;

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

import static potential_expenses.PotentialExpensesInfo.*;
import static wallet.WalletInfo.ENTER_ACTION;
import static wallet.WalletInfo.INVALID_INPUT;

public class EditPotentialExpenses {
    static double balance;
    public static void edit() {
        System.out.println(EDITING_POTENTIAL_EXPENSES_INFORMATION.getMassage());
        System.out.println(ENTER_POTENTIAL_EXPENSES_EDIT_NAME.getMassage());
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next().trim();

//        String file = FileReaders.reader(FileConstantsWallet.PATH_POTENTIAL_EXPENSES + name + ".txt");
//        String[] strings = file.split("\n");
//        System.out.println(ENTER_NEW_SUM.getMassage());
//
//        try {
//            balance = scanner.nextDouble();
//        } catch (InputMismatchException e) {
//            System.out.println(INVALID_INPUT.getMessage());
//            return;
//        }
//        strings[1] = String.valueOf(balance);
//        String text = strings[0] + "\n" + strings[1];
//        DeleteFile.deleteF(FileConstantsWallet.PATH_POTENTIAL_EXPENSES + name + ".txt");
//        AddInFile.writeFile(FileConstantsWallet.PATH_POTENTIAL_EXPENSES + name + ".txt", text);
//        System.out.println("Вы успешно отредактировали затрату под названием " + "\"" + name + "\"");
//        System.out.println(PotentialExpensesInfo.ENTER_ACTION.getMassage());
        File[] files = new File(FileConstants.PATH_POTENTIAL_EXPENSES).listFiles();
        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                if (line != null && line.equals(name)) {
                    System.out.println(ENTER_NEW_SUM.getMassage());
                    balance = scanner.nextDouble();

                    String[] strings = FileReaders.reader(FileConstants.PATH_POTENTIAL_EXPENSES + name + ".txt").split("\n");
                    strings[1] = String.valueOf(balance);
                    String text = strings[0] + "\n" + strings[1];
                    DeleteFile.deleteF(FileConstants.PATH_POTENTIAL_EXPENSES + name + ".txt");
                    AddInFile.writeFile(FileConstants.PATH_POTENTIAL_EXPENSES + name + ".txt", text);
                    System.out.println("Вы успешно отредактировали затрату под названием " + "\"" + name + "\"");
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
        System.out.println("Затраты с таким именем" + "\"" + name + "\"" + "не существует.");
        System.out.println(ENTER_ACTION.getMessage());
    }
}
