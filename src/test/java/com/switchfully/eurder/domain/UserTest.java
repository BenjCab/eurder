package com.switchfully.eurder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void whenCreatingUser_ThenDoesntThrowException(){
        Executable exec = ()->new User("Bob","The Builder","bob@yopmail.com","some street 26, in a fiction town","0125987422");
        assertDoesNotThrow(exec);
    }

    @Test
    void whenCreatingUserWithoutName_ThenThrowException(){
        Executable exec = ()->new User(null,"The Builder","bob@yopmail.com","some street 26, in a fiction town","0125987422");
        assertThrows(IllegalArgumentException.class,exec);
    }

    @Test
    void whenCreatingUserWithoutLastName_ThenThrowException(){
        Executable exec = ()->new User("Bob","","bob@yopmail.com","some street 26, in a fiction town","0125987422");
        assertThrows(IllegalArgumentException.class,exec);
    }

    @Test
    void whenCreatingUserWithoutAddress_ThenThrowException(){
        Executable exec = ()->new User("Bob","The Builder","bob@yopmail.com","","0125987422");
        assertThrows(IllegalArgumentException.class,exec);
    }

    @Test
    void whenCreatingUserWithoutPhoneNumber_ThenThrowException(){
        Executable exec = ()->new User("Bob","The Builder","bob@yopmail.com","some street 26, in a fiction town",null);
        assertThrows(IllegalArgumentException.class,exec);
    }
}