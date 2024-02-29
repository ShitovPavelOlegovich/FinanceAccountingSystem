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

public class WithdrawalPotentialExpenses {
    static double balance;
    public static void withdrawal() {
        System.out.println(WITHDRAWAL_SUM.getMassage());
        System.out.println(ENTER_NAME.getMassage());
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next().trim();

//        String file = FileReaders.reader(FileConstantsWallet.PATH_POTENTIAL_EXPENSES + name + ".txt");
//        String[] strings = file.split("\n");
//        System.out.println(ENTER_SUM.getMassage());
//        try {
//            balance = scanner.nextDouble();
//        } catch (InputMismatchException e) {
//            System.out.println(INVALID_INPUT.getMessage());
//            return;
//        }
//
//        strings[1] = String.valueOf(Double.parseDouble(strings[1]) - balance);
//        String text = strings[0] + "\n" + strings[1];
//        DeleteFile.deleteF(FileConstantsWallet.PATH_POTENTIAL_EXPENSES + name + ".txt");
//        AddInFile.writeFile(FileConstantsWallet.PATH_POTENTIAL_EXPENSES + name + ".txt", text);
//        System.out.println("Вы сняли с основной суммы " +
//                "\"" + balance + "\"" + " руб.");
//
//        System.out.println(ENTER_ACTION.getMassage());

        File[] files = new File(FileConstants.PATH_POTENTIAL_EXPENSES).listFiles();
        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                if (line != null && line.equals(name)) {
                    System.out.println(ENTER_SUM.getMassage());
                    balance = scanner.nextDouble();

                    String[] strings = FileReaders.reader(FileConstants.PATH_POTENTIAL_EXPENSES + name + ".txt").split("\n");
                    strings[1] = String.valueOf(Double.parseDouble(strings[1]) - balance);
                    String text = strings[0] + "\n" + strings[1];
                    DeleteFile.deleteF(FileConstants.PATH_POTENTIAL_EXPENSES + name + ".txt");
                    AddInFile.writeFile(FileConstants.PATH_POTENTIAL_EXPENSES + name + ".txt", text);
                    System.out.println("Вы сняли с основной суммы " +
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
