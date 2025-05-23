package AST;

public class ThrowStatement {
    private String exceptionName;
    private String message;

    public String getExceptionName() {
        return exceptionName;
    }
    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return "ThrowStatement{" +
                "exceptionName='" + exceptionName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
