package current_expenses;

public enum CurrentExpensesInfo {
    ENTER_CURRENT_EXPENSES("Введите название текущей затраты: "),
    ADD_NEW_CURRENT_EXPENSES("=== Добавление новой текущей затраты ==="),
    ENTER_BALANCE_CURRENT_EXPENSES("Введите начальную сумму затраты: "),

    INVALID_INPUT("Ошибка ввода данных. Пожалуйста, введите корректные значения."),

    ENTER_ACTION("\nВыберите действие (введите номер): "),
    ENTER_SUM("Введите сумму: "),
    ENTER_NAME("Укажите название затраты: "),
    ADD_ADDITIONAL_AMOUNT("=== Добавление дополнительной суммы к затрате ==="),
    WITHDRAWAL_SUM("=== Снятие суммы с текущей затраты ==="),
    EDITING_CURRENT_EXPENSES_INFORMATION("=== Редактирование информации о текущей затрате ==="),
    ENTER_CURRENT_EXPENSES_EDIT_NAME("\nВведите имя затраты, которую хотите отредактировать: "),
    ENTER_NEW_NAME("Введите новое название затраты: "),
    ENTER_NEW_SUM("Введите новую сумму затраты: "),
    DELETE_CURRENT_EXPENSES("=== Удаление текущей затраты ==="),
    ENTER_NAME_CURRENT_EXPENSES_DELETE("Укажите название затраты, которую хотите удалить: "),
    INFORMATION_CURRENT_EXPENSES("=== Информация по конкретной затрате ==="),
    LIST_CURRENT_EXPENSES("=== Список текущих затрат ==="),
    TOTAL_BALANCE("=== Общий баланс текущих затрат ==="),
    LIST_IS_EMPTY("Список пуст. ");



    private final String massage;

    CurrentExpensesInfo(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }
}
