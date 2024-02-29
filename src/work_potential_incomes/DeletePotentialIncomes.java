package work_potential_incomes;

import WorkWithFile.DeleteFile;
import WorkWithFile.FileConstants;
import java.io.File;
import java.util.Objects;
import java.util.Scanner;

import static potential_Incomes.PotentialIncomesInfo.*;
import static potential_Incomes.PotentialIncomesInfo.ENTER_ACTION;
import static wallet.WalletInfo.INVALID_INPUT;

public class DeletePotentialIncomes {
    public static void deletePotentialIncomes() {
        String name = "";
        System.out.println(DELETE_POTENTIAL_INCOMES.getMassage());
        System.out.println(ENTER_NAME.getMassage());
        Scanner scanner = new Scanner(System.in);
        try {
            name = scanner.next().trim();
        } catch (Exception e) {
            System.out.println(INVALID_INPUT.getMessage());
        }
        File folder = new File(FileConstants.PATH_POTENTIAL_INCOMES);
        File[] files = folder.listFiles();
        boolean deleted = false;
        for (File file : Objects.requireNonNull(files)) {
            if (file.getName().contains(name) && file.getName().endsWith(".txt")) {
                DeleteFile.deleteF(file.getAbsolutePath());
                System.out.println("Вы удалили доход под назавнием " + "\"" + file.getName() + "\"");
                deleted = true;
                break;
            }
        }
        if (!deleted) {
            System.out.println("Дохода с данным названием " + "\"" + name + "\"" + " не существует. ");
        }
        System.out.println(ENTER_ACTION.getMassage());
    }
}
