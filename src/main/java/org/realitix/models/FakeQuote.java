package org.realitix.models;

import java.io.Serializable;

public class FakeQuote extends FakerModel implements Serializable {

    private String quote;

    public FakeQuote(String quote) {
        this.quote = quote;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "FakeQuote{" +
                "quote='" + quote.substring(0, 40) + '\'' +
                '}';
    }
}
