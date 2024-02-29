//package first_variant.сredit_card;

//public class StartProgram {
//    private final static Scanner scanner = new Scanner(System.in);
//
//    public void start() {
//
////        AddWallets.addWallet();
////        DepositWallets.depositWallet();
////        WithdrawalWallets.withdrawal();
////        List<Wallet> list = GetAllWalletsToList.list();
////        System.out.println(list);
////        EditWallets.edit();
////        list = GetAllWalletsToList.list();
////        System.out.println(list);
//
//        WalletManager walletManager = new WalletManager();
//        Wallet wallet = new Wallet();
//        CreditManager creditManager = new CreditManager();
//        CreditCard creditCard = new CreditCard();
//        PotentialExpensesManager potentialExpensesManager = new PotentialExpensesManager();
//        PotentialIncomesManager potentialIncomesManager = new PotentialIncomesManager();
//        CurrentExpensesManager currentExpensesManager = new CurrentExpensesManager();
//        VerificationLoginPassword verificationLoginPassword = new VerificationLoginPassword();
//
//
//        if (verificationLoginPassword.verification()) {
//            System.out.println("=== Система учета финансов ===" +
//                    "\n1) Работа с кошельками. " +
//                    "\n2) Работа с кредитными картами. " +
//                    "\n3) Получение общей суммы по кошелькам и картам. " +
//                    "\n4) Работа со списком потенциальных затрат. " +
//                    "\n5) Работа со списком текущих затрат. " +
//                    "\n6) Работа со списком потенциальных доходов. " +
//                    "\n7) Выход из приграммы. " +
//                    "\n --- Выберите действие: ");
//
//
//            boolean isRunning = true;
//            while (isRunning) {
//                try {
//                    int input = scanner.nextInt();
//                    switch (input) {
//                        case 1 -> walletManager.runWallet();
//                        case 2 -> creditManager.runCreditCard();
//                        case 3 -> {
//                            wallet.getWalletBalance();
//                            creditCard.getCardBalance();
//                        }
//                        case 4 -> potentialExpensesManager.runPotentialExpensesManager();
//                        case 5 -> currentExpensesManager.runCurrentExpensesManager();
//                        case 6 -> potentialIncomesManager.renPotentialIncomes();
//                        case 7 -> isRunning = false;
//                        default -> System.out.println("Введите номер из списка: ");
//                    }
//                    if (input == 7) {
//                        System.out.println("=== Выход === " +
//                                "\n" + "\nСпасибо за использование системы учета финансов!");
//                    }
//                } catch (InputMismatchException e) {
//                    System.out.println("Введите номер из списка: ");
//                    scanner.next();
//                }
//            }
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "=== Система учета финансов ===" +
//                "\n1) Работа с кошельками. " +
//                "\n2) Работа с кредитными картами. " +
//                "\n --- Выберите действие: ";
//    }
//}
