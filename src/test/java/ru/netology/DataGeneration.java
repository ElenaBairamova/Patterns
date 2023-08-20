package ru.netology;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
public class DataGeneration {
    private DataGeneration() {
    }

    public static String dataGenerate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String nameGenerate(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().fullName();
    }

    public static String cityGenerate() {
        var cities = new String[]{"Уфа", "Москва", "Челябинск", "Магадан", "Саратов", "Владивосток", "Грозный"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String phoneGenerate(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(cityGenerate(), nameGenerate(locale), phoneGenerate(locale));
        }
    }
    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
