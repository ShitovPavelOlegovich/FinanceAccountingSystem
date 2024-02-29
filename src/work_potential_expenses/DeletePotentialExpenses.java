package work_potential_expenses;

import WorkWithFile.DeleteFile;
import WorkWithFile.FileConstants;
import java.io.File;
import java.util.Objects;
import java.util.Scanner;

import static potential_expenses.PotentialExpensesInfo.DELETE_POTENTIAL_EXPENSES;
import static potential_expenses.PotentialExpensesInfo.ENTER_NAME_POTENTIAL_EXPENSES_DELETE;
import static wallet.WalletInfo.*;
import static wallet.WalletInfo.ENTER_ACTION;

public class DeletePotentialExpenses {
    public static void delete(){
        String name = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println(DELETE_POTENTIAL_EXPENSES.getMassage());
        System.out.println(ENTER_NAME_POTENTIAL_EXPENSES_DELETE.getMassage());
        try {
            name = scanner.next().trim();
        } catch (Exception e) {
            System.out.println(INVALID_INPUT.getMessage());
        }
        File folder = new File(FileConstants.PATH_POTENTIAL_EXPENSES);
        File[] files = folder.listFiles();
        boolean deleted = false;
        for (File file : Objects.requireNonNull(files)) {
            if (file.getName().contains(name) && file.getName().endsWith(".txt")) {
                DeleteFile.deleteF(file.getAbsolutePath());
                System.out.println("Вы удалили затрату под назавнием " + "\"" + file.getName() + "\"");
                deleted = true;
                break;
            }
        }
        if (!deleted) {
            System.out.println("Затраты с данным именем " + "\"" + name + "\"" + " не существует. ");
        }
        System.out.println(ENTER_ACTION.getMessage());
    }
}
