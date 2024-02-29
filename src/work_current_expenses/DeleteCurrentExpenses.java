package work_current_expenses;

import WorkWithFile.DeleteFile;
import WorkWithFile.FileConstants;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

import static current_expenses.CurrentExpensesInfo.*;
import static first_variant.сredit_card.current_expenses.CurrentExpensesInfo.INVALID_INPUT;
import static wallet.WalletInfo.ENTER_ACTION;

public class DeleteCurrentExpenses {
    public static void delete(){
        String name = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println(DELETE_CURRENT_EXPENSES.getMassage());
        System.out.println(ENTER_NAME_CURRENT_EXPENSES_DELETE.getMassage());
        try {
            name = scanner.next().trim();
        } catch (Exception e) {
            System.out.println(INVALID_INPUT.getMassage());
        }
        File folder = new File(FileConstants.PATH_CURRENT_EXPENSES);
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
            System.out.println("Затраты с таким именем " + "\"" + name + "\"" + " не существует. ");
        }
        System.out.println(ENTER_ACTION.getMessage());
    }
}
