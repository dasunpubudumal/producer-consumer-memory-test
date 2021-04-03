package org.realitix.models;

import com.github.javafaker.Faker;

/**
 * A factory which creates fake users.
 */
public abstract class FakeQuoteFactory {

    private static final Faker faker = new Faker();

    public static FakeQuote getFakeQuoteInstance() {
        return new FakeQuote(faker.harryPotter().quote());
    }

}
