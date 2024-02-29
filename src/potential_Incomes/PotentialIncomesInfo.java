package potential_Incomes;

public enum PotentialIncomesInfo {
    ENTER_POTENTIAL_INCOMES("Введите название потенциальной затраты: "),
    ADD_NEW_POTENTIAL_INCOMES("=== Добавление нового потенциального дохода ==="),
    ENTER_BALANCE_POTENTIAL_INCOMES("Введите начальную сумму затраты: "),
    INVALID_INPUT("Ошибка ввода данных. Пожалуйста, введите корректные значения."),
    ENTER_ACTION("\nВыберите действие (введите номер): "),
    ENTER_SUM("Введите сумму: "),
    ENTER_NAME("Укажите название дохода: "),
    ADD_ADDITIONAL_AMOUNT("=== Внесение дополнительной суммы к потенциальному доходу ==="),
    WITHDRAWAL_SUM("=== Снятие средств с потенциального дохода ==="),
    EDITING_POTENTIAL_INCOMES_INFORMATION("=== Редактирование информации о потенциальном доходе ==="),
    ENTER_POTENTIAL_INCOMES_EDIT_NAME("\nУкажите название дохода, который хотите отредактировать: "),
    ENTER_NEW_NAME("Введите новое название дохода: "),
    ENTER_NEW_SUM("Введите новую сумму дохода: "),
    DELETE_POTENTIAL_INCOMES("=== Удаление потенциального дохода ==="),
    ENTER_NAME_POTENTIAL_INCOMES_DELETE("Укажите название затраты, которую хотите удалить: "),
    INFORMATION_POTENTIAL_INCOMES("=== Информация по конкретному доходу ==="),
    LIST_POTENTIAL_INCOMES("=== Список всех доходов ==="),
    TOTAL_BALANCE_POTENTIAL_INCOMES(" === Получение общей суммы по всем потенциальным затратам === "),
    LIST_IS_EMPTY("Список пуст. ");


    private final String massage;

    PotentialIncomesInfo(String name) {
        this.massage = name;
    }

    public String getMassage() {
        return massage;
    }

}
