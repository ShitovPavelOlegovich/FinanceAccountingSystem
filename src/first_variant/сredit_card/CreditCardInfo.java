package first_variant.сredit_card;

public enum CreditCardInfo {
    ENTER_NEW_CREDIT_CARD(" === Добавление новой кредитной карты  === "),
    ENTER_NAME_CREDIT_CARD("Введите название кредитной карты: "),
    ENTER_BALANCE_CREDIT_CARD("Введите начальный баланс: "),
    ENTER_ACTION("\nВыберите действие (введите номер): "),
    INVALID_INPUT("Ошибка ввода данных. Пожалуйста, введите корректные значения."),
    EDITING_CREDIT_CARD_INFORMATION(" === Редактирование информации о кредитной карте === "),
    ENTER_CARD_EDIT_NAME("\nУкажите имя кредитной карты которую хотите отредактировать: "),
    ENTER_NEW_NAME_CARD("Введите новое имя для кредитной карты: "),
    ENTER_NEW_BALANCE_CARD("Введите новый начальный баланс: "),
    DELETE_CREDIT_CARD(" === Удаление кредитной карты === "),
    ENTER_NAME_CARD_DELETE("\nУкажите имя кредитной карты, которую хотите удалить: "),
    TOTAL_BALANCE_CREDIT_CARD(" === Получение общей суммы по всем кредитным картам === "),
    STATUS_SPECIFIC_CREDIT_CARD("=== Отображение состояния конкретной кредитной карты === "),
    ENTER_NAME_CARD_STATUS_SPECIFIC("\nВведите имя кредитной карты о которой хотите узнать информацию: "),
    LIST_ALL_CREDIT_CARD(" === Список всех кредитных карт === "),
    LIST_IS_EMPTY("Список пуст."),
    ENTER_NAME_CARD_DEPOSIT("Введите имя кредитной карты, на которую хотите внести дополнительные средства: "),
    ENTER_ADD_SUM("Укажите сумму которую хотите внести: "),
    ENTER_NAME_CARD_WITHDRAWAL("Введите имя кредитной карты, с которой хотите списать средства: "),
    ENTER_WITHDRAWAL_SUM("Укажите сумму которую хотите снять: ");

    private final String massage;

    CreditCardInfo(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }
}
