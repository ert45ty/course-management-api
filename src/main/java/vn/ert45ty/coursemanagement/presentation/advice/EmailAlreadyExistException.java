package vn.ert45ty.coursemanagement.presentation.advice;

public class EmailAlreadyExistException extends RuntimeException{
    public EmailAlreadyExistException(){
        super("Email already exist!");
    }
}
