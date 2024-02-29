package first_variant.сredit_card.wallet;

public enum WalletInfo {

    ENTER_WALLET_NAME("Введите название кошелька: "),
    ENTER_WALLET_NEW_NAME("Укажите новое имя кошелька: "),
    ENTER_WALLET_BALANCE("Введите начальный баланс: "),
    ENTER_WALLET_NEW_BALANCE("Укажите новый начальный баланс: "),
    ENTER_ACTION("\nВыберите действие (введите номер): "),
    INVALID_INPUT("Ошибка ввода данных. Пожалуйста, введите корректные значения."),
    ENTER_WALLET_EDIT_NAME("\nУкажите имя кошелька, который хотите отредактировать: "),
    ENTER_WALLET_DELETE_NAME("\nУкажите имя кошелька, который хотите удалить: "),
    ENTER_NEW_WALLET(" === Добавление нового кошелька === "),
    EDITING_WALLET_INFORMATION(" === Редактирование информации о кошельке === "),
    DELETE_WALLET(" === Удаление кошелька === "),
    TOTAL_BALANCE_WALLET(" === Получение общей суммы по всем кошелькам === "),
    LIST_ALL_WALLET(" === Список всех кошельков === "),
    STATUS_SPECIFIC_WALLET("=== Отображение состояния конкретного кошелька === "),
    ENTER_NAME_WALLET_STATUS_SPECIFIC("\nВведите имя кошелька по которому хотите узнать информацию: "),
    LIST_IS_EMPTY("\nВ списке нет кошельков!"),
    ENTER_NAME_WALLET_DEPOSIT("Укажите имя кошелька, ктороый хотите пополнить: "),
    ENTER_ADD_SUM("Укажите сумму которую хотите внести: "),
    ENTER_NAME_WALLET_WITHDRAWAL("Укажите имя кошелька, с которого хотите снять средства: "),
    ENTER_WITHDRAWAL_SUM("Укажите сумму которую хотите снять: ");



    private final String massage;

    WalletInfo(String massage) {
        this.massage = massage;
    }
    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String getMessage() {
        return massage;
    }


}
