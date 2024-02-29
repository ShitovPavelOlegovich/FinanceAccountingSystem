package work_with_credit_card;

import WorkWithFile.AddInFile;
import WorkWithFile.DeleteFile;
import WorkWithFile.FileConstants;
import WorkWithFile.FileReaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static wallet.WalletInfo.ENTER_ACTION;
import static wallet.WalletInfo.INVALID_INPUT;
import static сredit_card.CreditCardInfo.*;

public class EditCreditCard {
    static double balance;
    public static void edit() {
        System.out.println(EDITING_CREDIT_CARD_INFORMATION.getMassage());
        System.out.println(ENTER_CARD_EDIT_NAME.getMassage());
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next().trim();

        File[] files = new File(FileConstants.PATH_CREDIT_CARD).listFiles();
        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                if (line != null && line.equals(name)) {
                    System.out.println(ENTER_NEW_BALANCE_CARD.getMassage());
                    balance = scanner.nextDouble();

                    String[] strings = FileReaders.reader(FileConstants.PATH_CREDIT_CARD + name + ".txt").split("\n");
                    strings[1] = String.valueOf(balance);
                    String text = strings[0] + "\n" + strings[1];
                    DeleteFile.deleteF(FileConstants.PATH_CREDIT_CARD + name + ".txt");
                    AddInFile.writeFile(FileConstants.PATH_CREDIT_CARD + name + ".txt", text);
                    System.out.println("Вы успешно отредактировали кредитную карту под именем: " + "\"" + name + "\"");
                    return;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InputMismatchException e) {
                System.out.println(INVALID_INPUT.getMessage());
                return;
            }
        }
        System.out.println("Кредитной карты с таким именем" + "\"" + name + "\"" + "не существует.");
        System.out.println(ENTER_ACTION.getMessage());
    }
}
