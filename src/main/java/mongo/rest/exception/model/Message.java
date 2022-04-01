package mongo.rest.exception.model;

public class Message {
    private String message;
    private String textException;

    public Message(String message, String textException) {
        this.message = message;
        this.textException = textException;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTextException() {
        return textException;
    }

    public void setTextException(String textException) {
        this.textException = textException;
    }
}
