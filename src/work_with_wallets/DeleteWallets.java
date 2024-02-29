package work_with_wallets;

import WorkWithFile.DeleteFile;
import WorkWithFile.FileConstants;
import java.io.File;
import java.util.Objects;
import java.util.Scanner;

import static wallet.WalletInfo.*;
import static wallet.WalletInfo.ENTER_ACTION;

public class DeleteWallets {
    public static void deleteW(){
        String name = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println(DELETE_WALLET.getMessage());
        System.out.println(ENTER_WALLET_DELETE_NAME.getMessage());
        try {
            name = scanner.nextLine().trim();
        } catch (Exception e) {
            System.out.println(INVALID_INPUT.getMessage());
        }

        File folder = new File(FileConstants.PATH_WALLET);
        File[] files = folder.listFiles();
        boolean deleted = false;
        for (File file : Objects.requireNonNull(files)) {
            if (file.getName().contains(name) && file.getName().endsWith(".txt")) {
                DeleteFile.deleteF(file.getAbsolutePath());
                System.out.println("Вы удалили кошелек под именем: " + "\"" + file.getName() + "\"");
                deleted = true;
                break;
            }
        }
        if (!deleted) {
            System.out.println("Кошелек с данным именем " + "\"" + name + "\"" + " не существует. ");
        }
        System.out.println(ENTER_ACTION.getMessage());
    }
}

