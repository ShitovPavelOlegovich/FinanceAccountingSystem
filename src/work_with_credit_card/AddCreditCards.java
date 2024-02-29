package work_with_credit_card;

import WorkWithFile.AddInFile;
import WorkWithFile.FileConstants;
import сredit_card.CreditCard;

import java.util.Scanner;

import static сredit_card.CreditCardInfo.*;

public class AddCreditCards {
    static double balance;
    public static void addCreditCard() {
        System.out.println(ENTER_NEW_CREDIT_CARD.getMassage());
        System.out.println(ENTER_NAME_CREDIT_CARD.getMassage());

        CreditCard creditCard = new CreditCard();
        Scanner scanner = new Scanner(System.in);

        String name = scanner.next().trim();
        creditCard.setName(name);
            System.out.println(ENTER_BALANCE_CREDIT_CARD.getMassage());
        try {
            balance = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println(INVALID_INPUT.getMassage());
        }
        creditCard.setBalance(balance);
        AddInFile.writeFile(FileConstants.PATH_CREDIT_CARD + creditCard.getName() + ".txt", creditCard.toString());

        System.out.println(" === Вы добавили новую кредитную карту === " +
                    "\n⦁Название кошелька: " + name +
                    "\n⦁Баланс: " + balance + "$");
        System.out.println(ENTER_ACTION.getMassage());


    }
}
