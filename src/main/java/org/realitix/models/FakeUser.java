package org.realitix.models;

import java.io.Serializable;

/**
 * A faker user model type.
 */
public class FakeUser extends FakerModel implements Serializable {

    private String name;
    private String address;
    private String programmingLanguage;

    public FakeUser(String name, String address, String programmingLanguage) {
        this.name = name;
        this.address = address;
        this.programmingLanguage = programmingLanguage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "FakeUser{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", programmingLanguage='" + programmingLanguage + '\'' +
                '}';
    }
}
