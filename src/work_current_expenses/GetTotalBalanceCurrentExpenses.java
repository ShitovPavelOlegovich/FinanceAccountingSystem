package work_current_expenses;

import WorkWithFile.FileConstants;
import WorkWithFile.FileReaders;

import java.io.File;

import static current_expenses.CurrentExpensesInfo.TOTAL_BALANCE;
import static wallet.WalletInfo.ENTER_ACTION;

public class GetTotalBalanceCurrentExpenses {
    public static void getTotalBalance() {
        System.out.println(TOTAL_BALANCE.getMassage());
        double totalBalance = 0;
        File folder = new File(FileConstants.PATH_CURRENT_EXPENSES);
        File[] currentFiles = folder.listFiles();
        for (File files : currentFiles) {
            String file = FileReaders.reader(files.getAbsolutePath());
            String[] strings = file.split("\n");
            totalBalance += Double.parseDouble(strings[1]);
        }
        System.out.println("Общая сумма по затратам: " + totalBalance + " руб.");
        System.out.println(ENTER_ACTION.getMessage());

    }
}
