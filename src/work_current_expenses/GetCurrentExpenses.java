package work_current_expenses;

import WorkWithFile.GetAllCurrentExpensesToList;
import current_expenses.CurrentExpenses;
import java.util.ArrayList;

import static current_expenses.CurrentExpensesInfo.LIST_CURRENT_EXPENSES;
import static сredit_card.CreditCardInfo.ENTER_ACTION;
import static сredit_card.CreditCardInfo.LIST_IS_EMPTY;

public class GetCurrentExpenses {
    public static void listAllCurrentExpenses() {
        System.out.println(LIST_CURRENT_EXPENSES.getMassage());
        ArrayList<CurrentExpenses> currentExpenses = GetAllCurrentExpensesToList.list();
        if (currentExpenses.isEmpty()) {
            System.out.println(LIST_IS_EMPTY.getMassage());
        } else {
            for (int i = 0; i < currentExpenses.size(); i++) {
                CurrentExpenses current = currentExpenses.get(i);
                System.out.println("\n⦁Название затраты: " + current.getName() + "\n" +
                        "⦁Сумма: " + current.getBalance() + " руб.");
            }
        }
        System.out.println(ENTER_ACTION.getMassage());
    }
}
