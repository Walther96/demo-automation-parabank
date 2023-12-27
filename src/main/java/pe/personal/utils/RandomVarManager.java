package pe.personal.utils;

import com.github.javafaker.Faker;

public class RandomVarManager {

    private RandomVarManager(){}
    public static String generateRandomValues() {
        Faker faker = Faker.instance();
        return faker.name().username();
    }

}