package com.hibernate.mapping.exceptionInstructor;


public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message)
    {
        super(message);
    }
}
