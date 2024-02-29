package work_potential_incomes;

import WorkWithFile.FileConstants;
import WorkWithFile.FileReaders;

import java.io.File;

import static potential_Incomes.PotentialIncomesInfo.TOTAL_BALANCE_POTENTIAL_INCOMES;
import static wallet.WalletInfo.ENTER_ACTION;

public class GetTotalBalancePotentialIncomes {
    public static void getTotalBalancePotentialIncomes() {
        System.out.println(TOTAL_BALANCE_POTENTIAL_INCOMES.getMassage());
        double totalBalance = 0;
        File folder = new File(FileConstants.PATH_POTENTIAL_INCOMES);
        File[] incomesFiles = folder.listFiles();
        for (File walletFile : incomesFiles) {
            String file = FileReaders.reader(walletFile.getAbsolutePath());
            String[] strings = file.split("\n");
            totalBalance += Double.parseDouble(strings[1]);
        }
        System.out.println("\nОбщая сумма по доходам: " + totalBalance + " руб.");
        System.out.println(ENTER_ACTION.getMessage());

    }
}
