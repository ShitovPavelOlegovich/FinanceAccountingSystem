package work_potential_expenses;

import WorkWithFile.FileConstants;
import WorkWithFile.FileReaders;

import java.io.File;

import static potential_expenses.PotentialExpensesInfo.TOTAL_BALANCE_POTENTIAL_EXPENSES;
import static wallet.WalletInfo.ENTER_ACTION;


public class GetTotalBalancePotentialExpenses {
    public static void getTotalBalance() {
        System.out.println(TOTAL_BALANCE_POTENTIAL_EXPENSES.getMassage());
        double totalBalance = 0;
        File folder = new File(FileConstants.PATH_POTENTIAL_EXPENSES);
        File[] potentialFiles = folder.listFiles();
        for (File files : potentialFiles) {
            String file = FileReaders.reader(files.getAbsolutePath());
            String[] strings = file.split("\n");
            totalBalance += Double.parseDouble(strings[1]);
        }
        System.out.println("Общая сумма по затратам: " + totalBalance + " руб.");
        System.out.println(ENTER_ACTION.getMessage());

    }
}
