package vn.ert45ty.coursemanagement.presentation.advice;

public class PasswordNotMatchException extends RuntimeException{
    public PasswordNotMatchException(){
        super("Re-password does not match");
    }
}
