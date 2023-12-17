package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class UserData {
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private long phoneNumber;
    private char gender;

    public UserData(String lastName, String firstName, String middleName, String birthDate, long phoneNumber, char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String toString() {
        return lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender;
    }
}

public class UserDataParser {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите данные (Фамилия Имя Отчество датарождения номертелефона пол):");
            String input = scanner.nextLine();

            String[] inputArray = input.split(" ");
            if (inputArray.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных. Введите все данные.");
            }

            String lastName = inputArray[0];
            String firstName = inputArray[1];
            String middleName = inputArray[2];
            String birthDate = inputArray[3];
            long phoneNumber = Long.parseLong(inputArray[4]);
            char gender = inputArray[5].charAt(0);

            UserData userData = new UserData(lastName, firstName, middleName, birthDate, phoneNumber, gender);

            // Создание файла с именем, равным фамилии
            String fileName = lastName + ".txt";
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(userData.toString() + "\n");
            fileWriter.close();

            System.out.println("Данные успешно записаны в файл: " + fileName);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Неверный формат номера телефона.");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Ошибка при записи в файл.");
        }
    }
}