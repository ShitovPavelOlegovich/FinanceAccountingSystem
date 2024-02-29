package work_with_wallets;


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

import static wallet.WalletInfo.*;

public class EditWallets {
    static double balance;
    public static void edit() {
        System.out.println(ENTER_NAME_WALLET_WITHDRAWAL.getMessage());
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next().trim();

        File[] files = new File(FileConstants.PATH_WALLET).listFiles();
        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                if (line != null && line.equals(name)) {
                    System.out.println(ENTER_WITHDRAWAL_SUM.getMessage());
                    balance = scanner.nextDouble();

                    String[] strings = FileReaders.reader(FileConstants.PATH_WALLET + name + ".txt").split("\n");
                    strings[1] = String.valueOf(balance);
                    String text = strings[0] + "\n" + strings[1];
                    DeleteFile.deleteF(FileConstants.PATH_WALLET + name + ".txt");
                    AddInFile.writeFile(FileConstants.PATH_WALLET + name + ".txt", text);
                    System.out.println("Вы успешно отредактировали кошелек под именем: " + "\"" + name + "\"");
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
        System.out.println("Кошелек с таким именем" + "\"" + name + "\"" + "не существует.");
        System.out.println(ENTER_ACTION.getMessage());
    }
}
