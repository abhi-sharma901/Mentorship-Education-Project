package org.paychex.mentorshipeducationproject.utils;

public enum UserType {
    ADMIN("ADMIN"), TRAINER("TRAINER"), STUDENT("STUDENT");

    private final String type;

    UserType(String string) {
        type = string;
    }

    @Override
    public String toString() {
        return type;
    }

}
