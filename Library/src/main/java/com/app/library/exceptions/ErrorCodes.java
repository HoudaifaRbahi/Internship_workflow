package com.app.library.exceptions;

public enum ErrorCodes {
    CLIENT_NOT_FOUND(1000),
    CLIENT_NOT_VALID(1001),
    ApartmentBlock_NOT_FOUND(2000),
    ApartmentBlock_NOT_VALID(2001),
    VillaBlock_NOT_FOUND(3000),
    VillaBlock_NOT_VALID(3001),
    ApartmentComplex_NOT_FOUND(4000),
    ApartmentComplex_NOT_VALID(4001),
    VillaComplex_NOT_VALID(5000),
    VillaComplex_NOT_FOUND(5001),
    COMMERCIAL_NOT_FOUND(6000),
    COMMERCIAL_NOT_VALID(6001),
    COMMERCIAL_CLIENT_NOT_VALID(7000),
    APARTMENT_NOT_FOUND(8000),
    APARTMENT_NOT_VALID(8001),
    VILLA_NOT_VALID(9000),
    VILLA_NOT_FOUND(9001),
    CPROPERTY_NOT_VALID(6001),
    CPROPERTY_NOT_FOUND(7000),
    ;
    private int code;
    ErrorCodes(int code){
        this.code=code;
    }

    public int getCode() {
        return code;
    }
}
