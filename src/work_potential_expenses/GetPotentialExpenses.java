package work_potential_expenses;

import WorkWithFile.GetAllPotentialExpensesToList;

import potential_expenses.PotentialExpenses;


import java.util.ArrayList;

import static potential_expenses.PotentialExpensesInfo.LIST_POTENTIAL_EXPENSES;
import static сredit_card.CreditCardInfo.ENTER_ACTION;
import static сredit_card.CreditCardInfo.LIST_IS_EMPTY;

public class GetPotentialExpenses {
    public static void listPotentialExpenses() {
        System.out.println(LIST_POTENTIAL_EXPENSES.getMassage());
        ArrayList<PotentialExpenses> potentialExpenses = GetAllPotentialExpensesToList.list();
        if (potentialExpenses.isEmpty()) {
            System.out.println(LIST_IS_EMPTY.getMassage());
        } else {
            for (int i = 0; i < potentialExpenses.size(); i++) {
                PotentialExpenses potentialExpenses1 = potentialExpenses.get(i);
                System.out.println("\n~" + potentialExpenses1.getName() + " - " +
                        potentialExpenses1.getBalance() + " руб.");
            }
        }
        System.out.println(ENTER_ACTION.getMassage());
    }
}
