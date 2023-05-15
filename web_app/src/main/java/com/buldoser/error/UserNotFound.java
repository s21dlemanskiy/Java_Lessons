package com.buldoser.error;


// user not found because incorrect password or login
public class UserNotFound extends Exception{
    String user_will_see;
    public UserNotFound(String errorMessage, String user_will_see) {
        super(errorMessage);
        this.user_will_see = user_will_see;
    }

    // there can be anything that user will see as a cause of error
    public String getUser_will_see() {
        return user_will_see;
    }
}
