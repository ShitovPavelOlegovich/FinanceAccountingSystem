package verification;

import WorkWithFile.AddInFile;
import WorkWithFile.FileReaders;
import start_program.StartManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class VerificationLoginPassword {
    private int randomNumber() {
        int number = new Random().nextInt(900_000) + 100_000;
        return number;
    }

    public boolean verification() {
         if (login()) {
             return true;
         }
        return false;
    }
    private boolean login() {
        int newRandomPassword = randomNumber();
        System.out.println("Для входа в систему учета финансов введите логин и пароль в формате(ххх):");
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int userPassword = 0;


        while (attempts < 3) {
            System.out.println("Введите логин:");
            String login = scanner.nextLine().trim();
            try {
                System.out.println("Введите пароль:");
                userPassword = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Пароль должен состоять из цифр! ");
                scanner.nextLine();
            }

            String[] strings = FileReaders.readerSecond("src/users/" + login + ".txt").split("\n");
            if (login.equals(strings[0]) && userPassword == Integer.parseInt(strings[1])) {
                System.out.println("Логин и пароль верны.\n=== Добро пожаловать ===");
                return true;
            }

            attempts++;
            if (attempts < 3) {
                System.out.println("Логин или пароль введен не верно! \nПопробуйте снова.");
            } else {
                System.out.println("Вы ввели неверный пароль 3 раза. Генерирую новый пароль...");

                // Запрашиваем ввод нового пароля
                System.out.println("Новый пароль: " + newRandomPassword);
                System.out.println("Введите логин:");
                String login1 = scanner.nextLine().trim();
                System.out.println("Введите новый пароль:");
                int newPass = scanner.nextInt();
                scanner.nextLine();

                try (FileWriter writer = new FileWriter("data/random_password.txt")) {
                    writer.write(newRandomPassword);
                } catch (IOException e) {
                    System.out.println("Не удалось сохранить новый пароль в файл.");
                }

                if (newPass != newRandomPassword && !login1.equals(strings[0])) {
                    System.out.println("Неверный пароль. Вход заблокирован на 24 часа.");
                    return false;
                } else {
                    System.out.println("Логин и пароль верны.\n=== Добро пожаловать ===");
                    System.out.println("Создайте новый пароль: ");
                    String newPassword = scanner.nextLine();
                    AddInFile.writeFile("src/users/" + login1 + ".txt", login1 + "\n" + newPassword);
                    return true;
                }
            }
        }
        System.out.println("Превышено количество попыток. Попробуйте позднее.");
        return false;
    }
    public void register() {
        Scanner scanner = new Scanner(System.in);
        String name;
        int password;
        System.out.println("Введите логин: ");
        name = scanner.nextLine().trim();
        System.out.println("Введдите пароль: ");
        password = scanner.nextInt();

        AddInFile.writeFile("src/users/" + name + ".txt", name + "\n" + password);
        StartManager.start();

    }
}
