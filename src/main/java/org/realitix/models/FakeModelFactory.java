package org.realitix.models;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public abstract class FakeModelFactory {

    private static Faker faker;

    private static FakeQuote getFakeQuoteInstance() {
        if (faker == null) faker = new Faker();
        return new FakeQuote(faker.harryPotter().quote());
    }

    private static FakeUser getFakeUserInstance() {
        if (faker == null) faker = new Faker();
        return new FakeUser(faker.name().name(), faker.address().fullAddress(), faker.programmingLanguage().name());
    }

    public static FakerModel getFakerModelInstance() {
        int i = ThreadLocalRandom.current().nextInt(1, 3);

        return i % 2 == 0 ? getFakeUserInstance() : getFakeQuoteInstance();

    }

}
