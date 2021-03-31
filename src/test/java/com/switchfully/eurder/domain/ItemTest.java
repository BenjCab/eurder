package com.switchfully.eurder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    void whenCreatingItem_thenDoesntThrowException(){
        Executable exec = ()-> new Item(UUID.randomUUID(),"a","a",25f,50);
        assertDoesNotThrow(exec);
    }
    @Test
    void whenCreatingItemWithoutName_ThenThrowException(){
        Executable exec = ()-> new Item(UUID.randomUUID(),"","a",25f,50);
        assertThrows(IllegalArgumentException.class,exec);
    }
    @Test
    void whenCreatingItemWithoutDescription_ThenThrowException(){
        Executable exec = ()-> new Item(UUID.randomUUID(),"a",null,25f,50);
        assertThrows(IllegalArgumentException.class,exec);
    }
    @Test
    void whenCreatingItemWithoutPrice_ThenThrowException(){
        Executable exec = ()-> new Item(UUID.randomUUID(),"a","a",null,50);
        assertThrows(IllegalArgumentException.class,exec);
    }
    @Test
    void whenCreatingItemWithPriceTo0_ThenThrowException(){
        Executable exec = ()-> new Item(UUID.randomUUID(),"a","a",0f,50);
        assertThrows(IllegalArgumentException.class,exec);
    }
    @Test
    void whenCreatingItemWithoutAmountInStock_ThenThrowException(){
        Executable exec = ()-> new Item(UUID.randomUUID(),"a","a",25f,null);
        assertThrows(IllegalArgumentException.class,exec);
    }

}