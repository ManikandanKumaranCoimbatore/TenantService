package com.readleaf.tenantdomainservice.exception;

public class IdNotFoundException extends Exception{
    public IdNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
