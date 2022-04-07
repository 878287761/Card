package com.lilei.card.utils;

public class FileException extends RuntimeException{
    public FileException(String message){
        super(message);
    }

    public FileException(String message,Throwable cause){
        super(message,cause);
    }
}
