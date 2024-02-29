package work_with_credit_card;

import WorkWithFile.FileConstants;
import WorkWithFile.FileReaders;

import java.io.File;

import static wallet.WalletInfo.ENTER_ACTION;
import static сredit_card.CreditCardInfo.TOTAL_BALANCE_CREDIT_CARD;

public class GetTotalBalanceCreditCard {
    public static void getTotalBalance() {
        System.out.println(TOTAL_BALANCE_CREDIT_CARD.getMassage());
        double totalBalance = 0;
        File folder = new File(FileConstants.PATH_CREDIT_CARD);
        File[] creditFiles = folder.listFiles();
        for (File walletFile : creditFiles) {
            String file = FileReaders.reader(walletFile.getAbsolutePath());
            String[] strings = file.split("\n");
            totalBalance += Double.parseDouble(strings[1]);
        }
        System.out.println("\nОбщая сумма по кредитным картам: " + totalBalance + "$");
        System.out.println(ENTER_ACTION.getMessage());
    }
    public static void getTotalBalanceCreditCard() {
        double totalBalance = 0;
        File folder = new File(FileConstants.PATH_CREDIT_CARD);
        File[] creditFiles = folder.listFiles();
        for (File walletFile : creditFiles) {
            String file = FileReaders.reader(walletFile.getAbsolutePath());
            String[] strings = file.split("\n");
            totalBalance += Double.parseDouble(strings[1]);
        }
        System.out.println("\nОбщая сумма по кредитным картам: " + totalBalance + "$");
        System.out.println(ENTER_ACTION.getMessage());
    }
}
