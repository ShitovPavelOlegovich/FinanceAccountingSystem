package work_with_wallets;

import WorkWithFile.AddInFile;
import WorkWithFile.DeleteFile;
import WorkWithFile.FileConstants;
import WorkWithFile.FileReaders;


import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static wallet.WalletInfo.*;


public class DepositWallets {
    static String name = "";
    static double balance;

    public static void depositWallet() {
        System.out.println(ENTER_NAME_WALLET_DEPOSIT.getMessage());
        Scanner scanner = new Scanner(System.in);

        name = scanner.next().trim();
        File[] files = new File(FileConstants.PATH_WALLET).listFiles();
        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                if (line != null && line.equals(name)) {
                    System.out.println(ENTER_ADD_SUM.getMessage());
                    balance = scanner.nextDouble();

                    String[] strings = FileReaders.reader(FileConstants.PATH_WALLET + name + ".txt").split("\n");
                    strings[1] = String.valueOf(balance + Double.parseDouble(strings[1]));
                    String text = strings[0] + "\n" + strings[1];
                    DeleteFile.deleteF(FileConstants.PATH_WALLET + name + ".txt");
                    AddInFile.writeFile(FileConstants.PATH_WALLET + name + ".txt", text);

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
        System.out.println("Кошелек с таким именем" + "\"" + name + "\"" + "не существует.");
        System.out.println(ENTER_ACTION.getMessage());

    }
}
