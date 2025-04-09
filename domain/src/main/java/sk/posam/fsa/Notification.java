package sk.posam.fsa;

public class Notification {
    private Long id;
    private Long userId;
    private String message;
    private boolean read;

    public Notification(Long userId, String message,boolean read) {
        this.userId = userId;
        this.message = message;
        this.read = read;

    }
    public Notification() {
    }

    public void markAsRead() {
        this.read = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
