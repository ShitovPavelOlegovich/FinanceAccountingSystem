package work_with_wallets;

import WorkWithFile.FileConstants;
import WorkWithFile.FileReaders;
import java.io.File;


import static wallet.WalletInfo.ENTER_ACTION;
import static wallet.WalletInfo.TOTAL_BALANCE_WALLET;

public class GetTotalBalanceWallets {
    public static void getTotalBalance() {
        System.out.println(TOTAL_BALANCE_WALLET.getMessage());
        double totalBalance = 0;
        File folder = new File(FileConstants.PATH_WALLET);
        File[] walletFiles = folder.listFiles();
        for (File walletFile : walletFiles) {
            String file = FileReaders.reader(walletFile.getAbsolutePath());
            String[] strings = file.split("\n");
            totalBalance += Double.parseDouble(strings[1]);
        }
        System.out.println("\nОбщая сумма по кошелькам: " + totalBalance + " руб.");
        System.out.println(ENTER_ACTION.getMessage());
    }
    public static void getTotalBalanceWallets() {
        System.out.println("=== Общая сумма по кошелькам и кредитным картам ===");
        System.out.println();
        double totalBalance = 0;
        File folder = new File(FileConstants.PATH_WALLET);
        File[] files = folder.listFiles();
        for (File file : files) {
            String fileWallet = FileReaders.reader(file.getAbsolutePath());
            String[] strings = fileWallet.split("\n");
            totalBalance += Double.parseDouble(strings[1]);
        }
        System.out.println("Общая сумма по кошелькам: " + totalBalance + " руб.");
    }
}

