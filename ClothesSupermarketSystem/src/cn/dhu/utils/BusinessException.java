package cn.dhu.utils;

public class BusinessException extends RuntimeException{

    public BusinessException() {
        super();

    }

    public BusinessException(String message) {
        super(message);
    }
}
