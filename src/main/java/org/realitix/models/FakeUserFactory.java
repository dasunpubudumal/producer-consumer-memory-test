package org.realitix.models;

import com.github.javafaker.Faker;

/**
 * A factory which creates fake users.
 */
public abstract class FakeUserFactory  {

    private static final Faker faker = new Faker();

    public static FakeUser getFakeUserInstance() {
        return new FakeUser(faker.name().name(), faker.address().fullAddress(), faker.programmingLanguage().name());
    }

}
