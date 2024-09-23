package com.in.inventory.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException (){
        super("Resource not found on server!!");
    }
}
