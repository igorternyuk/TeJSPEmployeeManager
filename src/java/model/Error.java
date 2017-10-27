package model;

/**
 *
 * @author igor
 * Last edited 27-10-2017
 */

public enum Error {
    LOGIN_INCORRECT(101, "Login is incorrect!"),
    PASSWORD_INCORRECT(201, "Password is incorrect!"),
    LOGIN_AND_PASSWORD_INCORRECT(301, "Login and password are incorrect!"),
    LOGIN_AND_PASSWORD_FROM_DIFFERENT_ACCOUNTS(401,
            "Login and password from different accounts!"),
    SESSION_IS_NOT_STARTED(501, "You have to start session!");
    
    private final int code;
    private final String description;
    
    private Error(int code, String description){
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Error{" + "code=" + code + ", description=" + description + '}';
    }
}
