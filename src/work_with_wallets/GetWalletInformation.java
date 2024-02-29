package work_with_wallets;

import WorkWithFile.FileConstants;
import WorkWithFile.FileReaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static wallet.WalletInfo.*;

public class GetWalletInformation {
    public static void getInformation() {
        System.out.println(STATUS_SPECIFIC_WALLET.getMessage());
        System.out.println(ENTER_NAME_WALLET_STATUS_SPECIFIC.getMessage());
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next().trim();;
        File[] files = new File(FileConstants.PATH_WALLET).listFiles();
        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                if (line != null && line.equals(name)) {
                    String[] strings = FileReaders.reader(FileConstants.PATH_WALLET + name + ".txt").split("\n");
                    strings[1] = String.valueOf(strings[1]);
                    System.out.println("Информация о кошельке под именем: " + "\"" + name + "\""
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
        System.out.println("Кошелек с таким именем" + "\"" + name + "\"" + "не существует.");
        System.out.println(ENTER_ACTION.getMessage());
    }
}
