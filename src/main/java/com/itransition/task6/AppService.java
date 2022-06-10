package com.itransition.task6;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static com.itransition.task6.Constants.CYRILLIC;
import static com.itransition.task6.Constants.LATIN;

/**
 * Abdulqodir Ganiev 6/9/2022 3:15 PM
 */

@Service
public class AppService {

    public List<User> generateUser(String country, double error, int seed) {

        Random random = new Random(seed);

        List<User> users = new ArrayList<>();

        Faker faker = new Faker(new Locale(country), random);
        for (int i = 1; i <= 20; i++) {
            User user = new User(
                    faker.number().numberBetween(100000, 999999),
                    faker.name().fullName(),
                    generateFullAddress(country, faker),
                    generatePhoneNumber(country, faker),
                    i
            );

            users.add(user);
        }
        if (error > 0)
            generateErrorData(users, error, seed, country);

        return users;
    }

    private String generateFullAddress(String country, Faker faker) {
        return country.equals("ru") ? faker.address().fullAddress().replaceFirst("###### ", "") : faker.address().fullAddress();
    }

    private String generatePhoneNumber(String country, Faker faker) {
        return country.equals("ru") ? faker.phoneNumber().phoneNumber() : faker.phoneNumber().cellPhone();
    }

    public List<User> generateNext10Data(int dataLength, String locale, double error, int seed) {

        Random random = new Random(seed);

        List<User> users = new ArrayList<>();

        Faker faker = new Faker(new Locale(locale), random);
        for (int i = 1; i < dataLength + 10; i++) {
            if (i >= dataLength) {
                User user = new User(
                        faker.number().numberBetween(100000, 999999),
                        faker.name().fullName(),
                        generateFullAddress(locale, faker),
                        generatePhoneNumber(locale, faker),
                        i
                );
                users.add(user);
            } else
                new User(
                        faker.number().numberBetween(100000, 999999),
                        faker.name().fullName(),
                        generateFullAddress(locale, faker),
                        generatePhoneNumber(locale, faker),
                        i
                );
        }

        if (error > 0)
            generateErrorData(users, error, seed, locale);

        return users;
    }

    private void generateErrorData(List<User> users, double error, int seed, String country) {

        Random random = new Random(seed);


        for (int i = 0; i < error; i++) {
            for (User fakeUser : users) {
                int selectField = random.nextInt(3);
                int method = random.nextInt(3);
                switch (selectField) {
                    case 0:
                        String fullName = fakeUser.getFullName();
                        fakeUser.setFullName(
                                method == 0 ?
                                        addChar(fullName, false, country.equals("ru"), random) : method == 1 ?
                                        changeChar(fullName, random) : deleteChar(fullName, random)
                        );
                        break;
                    case 1:
                        String address = fakeUser.getFullAddress();
                        fakeUser.setFullAddress(
                                method == 0 ?
                                        addChar(address, false, country.equals("ru"), random) : method == 1 ?
                                        changeChar(address, random) : deleteChar(address, random)
                        );
                        break;
                    case 2:
                        String phoneNumber = fakeUser.getPhoneNumber();
                        fakeUser.setPhoneNumber(
                                method == 0 ?
                                        addChar(phoneNumber, true, country.equals("ru"), random) : method == 1 ?
                                        changeChar(phoneNumber, random) : deleteChar(phoneNumber, random)
                        );
                        break;
                    default:
                        break;
                }
            }

        }

    }

    private String addChar(String data, boolean isNumber, boolean isCyrillic, Random random) {
        int index = random.nextInt(data.length());
        if (isCyrillic) {
            return addCharTo(data, isNumber, index, CYRILLIC, random);
        } else {
            return addCharTo(data, isNumber, index, LATIN, random);
        }

    }

    private String addCharTo(String data, boolean isNumber, int index, String characters, Random random) {
        if (index == data.length() - 1) return isNumber ? data.concat(String.valueOf(random.nextInt(10))) :
                data.concat(String.valueOf(characters.charAt(random.nextInt(52))));
        return isNumber ?
                data.substring(0, index).concat(String.valueOf(random.nextInt(10)).concat(data.substring(index + 1))) :
                data.substring(0, index).concat(String.valueOf(characters.charAt(random.nextInt(52)))) +
                        data.substring(index + 1);
    }

    private String deleteChar(String data, Random random) {
        int index = random.nextInt(data.length());
        return data.replace(data.charAt(index), ' ');
    }

    private String changeChar(String data, Random random) {
        int changeFromIndex = random.nextInt(data.length());
        int changeToIndex = random.nextInt(data.length());
        char[] chars = data.toCharArray();
        char changeFrom = chars[changeFromIndex];
        chars[changeFromIndex] = chars[changeToIndex];
        chars[changeToIndex] = changeFrom;
        StringBuilder result = new StringBuilder();
        for (char aChar : chars) {
            result.append(aChar);
        }
        return result.toString();
    }

}
