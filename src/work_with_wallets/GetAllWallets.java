package work_with_wallets;

import WorkWithFile.GetAllWalletsToList;
import wallet.Wallet;

import java.util.ArrayList;

import static wallet.WalletInfo.LIST_ALL_WALLET;
import static сredit_card.CreditCardInfo.ENTER_ACTION;
import static сredit_card.CreditCardInfo.LIST_IS_EMPTY;

public class GetAllWallets {
    public static void listAllWallets() {
        System.out.println(LIST_ALL_WALLET.getMessage());
        ArrayList<Wallet> wallets = GetAllWalletsToList.list();
        if (wallets.isEmpty()) {
            System.out.println(LIST_IS_EMPTY.getMassage());
        } else {
            for (Wallet wallet : wallets) {
                System.out.println("\n⦁Имя кошелька: " + wallet.getName() + "\n" +
                        "⦁Баланс кошелька: " + wallet.getBalance());
            }
        }
        System.out.println(ENTER_ACTION.getMassage());
    }
}
