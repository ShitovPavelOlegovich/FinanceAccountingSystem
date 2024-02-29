package potential_expenses;

public enum PotentialExpensesInfo {
    ENTER_POTENTIAL_EXPENSES("Введите название потенциальной затраты: "),
    ADD_NEW_POTENTIAL_EXPENSES("=== Добавление новой потонцеальной затраты ==="),
    ENTER_BALANCE_POTENTIAL_EXPENSES("Введите начальную сумму затраты: "),

    INVALID_INPUT("Ошибка ввода данных. Пожалуйста, введите корректные значения."),

    ENTER_ACTION("\nВыберите действие (введите номер): "),
    ENTER_SUM("Введите сумму: "),
    ENTER_NAME("Укажите название затраты: "),
    ADD_ADDITIONAL_AMOUNT("=== Добавление дополнительной суммы к затрате ==="),
    WITHDRAWAL_SUM("=== Снятие суммы с затраты ==="),
    EDITING_POTENTIAL_EXPENSES_INFORMATION("=== Редактирование информации о потонцеальной затрате ==="),
    ENTER_POTENTIAL_EXPENSES_EDIT_NAME("\nВведите имя затраты, которую хотите отредактировать: "),
    ENTER_NEW_NAME("Введите новое название затраты: "),
    ENTER_NEW_SUM("Введите новую сумму затраты: "),
    DELETE_POTENTIAL_EXPENSES("=== Удаление потонцеальной затраты ==="),
    ENTER_NAME_POTENTIAL_EXPENSES_DELETE("Укажите название затраты, которую хотите удалить: "),
    INFORMATION_POTENTIAL_EXPENSES("=== Информация по конкретной затрате ==="),
    LIST_POTENTIAL_EXPENSES("=== Список текущих затрат ==="),
    TOTAL_BALANCE_POTENTIAL_EXPENSES(" === Получение общей суммы по всем потенциальным затратам === "),
    LIST_IS_EMPTY("Список пуст. ");



    private final String massage;

    PotentialExpensesInfo(String name) {
        this.massage = name;
    }

    public String getMassage() {
        return massage;
    }
}
