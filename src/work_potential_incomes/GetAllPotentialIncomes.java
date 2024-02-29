package work_potential_incomes;

import WorkWithFile.GetAllPotentialIncomesToList;
import potential_Incomes.PotentialIncomes;
import java.util.ArrayList;

import static potential_Incomes.PotentialIncomesInfo.LIST_POTENTIAL_INCOMES;
import static сredit_card.CreditCardInfo.ENTER_ACTION;
import static сredit_card.CreditCardInfo.LIST_IS_EMPTY;

public class GetAllPotentialIncomes {
    public static void listPotentialIncomes() {
        System.out.println(LIST_POTENTIAL_INCOMES.getMassage());
        ArrayList<PotentialIncomes> potentialIncomes = GetAllPotentialIncomesToList.list();
        if (potentialIncomes.isEmpty()) {
            System.out.println(LIST_IS_EMPTY.getMassage());
        } else {
            for (int i = 0; i < potentialIncomes.size(); i++) {
                PotentialIncomes incomes = potentialIncomes.get(i);
                System.out.println("\n~" + incomes.getName() + " - " +
                        incomes.getBalance() + " руб.");
            }
        }
        System.out.println(ENTER_ACTION.getMassage());
    }



}
