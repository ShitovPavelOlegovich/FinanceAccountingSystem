package work_with_credit_card;

import WorkWithFile.GetAllCreditCardsToList;
import сredit_card.CreditCard;
import java.util.ArrayList;

import static сredit_card.CreditCardInfo.*;

public class GetAllCreditCard {
    public static void listAllCreditCard() {
        System.out.println(LIST_ALL_CREDIT_CARD.getMassage());
        ArrayList<CreditCard> creditCards = GetAllCreditCardsToList.list();
        if (creditCards.isEmpty()) {
            System.out.println(LIST_IS_EMPTY.getMassage());
        } else {
            for (int i = 0; i < creditCards.size(); i++) {
                CreditCard creditCard = creditCards.get(i);
                System.out.println("\n⦁Имя кредитной карты: " + creditCard.getName() + "\n" +
                        "⦁Баланс кредитной карты: " + creditCard.getBalance() + "$");
            }
        }
        System.out.println(ENTER_ACTION.getMassage());
    }
}
