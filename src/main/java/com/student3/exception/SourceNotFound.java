package com.student3.exception;

public class SourceNotFound extends RuntimeException{

    public SourceNotFound(String str){
        super(str);
    }
}
