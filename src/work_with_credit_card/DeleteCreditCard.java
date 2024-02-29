package work_with_credit_card;

import WorkWithFile.DeleteFile;
import WorkWithFile.FileConstants;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

import static wallet.WalletInfo.*;
import static wallet.WalletInfo.ENTER_ACTION;
import static сredit_card.CreditCardInfo.DELETE_CREDIT_CARD;
import static сredit_card.CreditCardInfo.ENTER_NAME_CARD_DELETE;

public class DeleteCreditCard {
    public static void delete(){
        String name = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println(DELETE_CREDIT_CARD.getMassage());
        System.out.println(ENTER_NAME_CARD_DELETE.getMassage());
        try {
            name = scanner.next().trim();
        } catch (Exception e) {
            System.out.println(INVALID_INPUT.getMessage());
        }
//        File folder = new File(FileConstantsWallet.PATH_WALLET + name + ".txt");
        File folder = new File(FileConstants.PATH_CREDIT_CARD);
        File[] files = folder.listFiles();
        boolean deleted = false;
        for (File file : Objects.requireNonNull(files)) {
            if (file.getName().contains(name) && file.getName().endsWith(".txt")) {
                DeleteFile.deleteF(file.getAbsolutePath());
                System.out.println("Вы удалили кредитную карту под именем " + "\"" + file.getName() + "\"");
                deleted = true;
                break;
            }
        }
        if (!deleted) {
            System.out.println("Кредитная карта с данным именем " + "\"" + name + "\"" + " не существует. ");
        }
        System.out.println(ENTER_ACTION.getMessage());
    }
}
