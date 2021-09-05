package flows;

public class Status {
    private boolean isError;
    private String message;

    public Status() {
    }

    public Status(boolean isError, String message){
        this.isError = isError;
        this.message = message;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
