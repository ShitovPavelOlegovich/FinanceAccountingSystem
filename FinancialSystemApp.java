import java.util.List;

public class FinancialSystemApp {
    private List<Wallet> wallets;
    private List<CreditCard> creditCards;
    private List<Expense> currentExpenses;//текущие затраты
    private List<Expense> potentialExpenses;//потонциальные затраты
    private List<Income> potentialIncomes;//потонцеальные доходы

    public FinancialSystemApp() {
        // Инициализация списков и других переменных
    }

    public void run() {
        // Главный метод приложения, запускающий его работу
    }

    public void displayWalletState() {
        // Отображение состояния кошелька
    }

    public double getTotalWalletAmount() {
        // Получение суммы по всем кошелькам
        return 0.0;
    }

    public void displayCreditCardState() {
        // Отображение состояния кредитной карты
    }

    public double getTotalCreditCardAmount() {
        // Получение суммы по всем кредитным картам
        return 0.0;
    }

    public double getTotalAmount() {
        // Получение общей суммы по всем кошелькам и картам
        return 0.0;
    }

    public void addWallet(Wallet wallet) {
        // Добавление информации о кошельке
    }

    public void removeWallet(Wallet wallet) {
        // Удаление информации о кошельке
    }

    public void editWallet(Wallet wallet) {
        // Редактирование информации о кошельке
    }

    public void addCreditCard(CreditCard creditCard) {
        // Добавление информации о кредитной карте
    }

    public void removeCreditCard(CreditCard creditCard) {
        // Удаление информации о кредитной карте
    }

    public void editCreditCard(CreditCard creditCard) {
        // Редактирование информации о кредитной карте
    }

    public void managePotentialExpenses() {
        // Работа со списком потенциальных затрат
    }

    public void manageCurrentExpenses() {
        // Работа со списком текущих затрат
    }

    public void managePotentialIncomes() {
        // Работа со списком потенциальных доходов
    }
}
