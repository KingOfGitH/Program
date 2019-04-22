package cn.edu.dhu.exception;

/**
 * @author zhbr
 * @date 2019/4/21 16:15
 */
public class SysException extends Exception{
    private String message;

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
