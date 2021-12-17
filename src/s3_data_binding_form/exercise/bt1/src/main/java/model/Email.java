package model;

public class Email {

    private String language;
    private String pageSize;
    private String spamFiler;
    private String signature;

    public Email(String language, String pageSize, String spamFiler, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamFiler = spamFiler;
        this.signature = signature;
    }

    public Email() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getSpamFiler() {
        return spamFiler;
    }

    public void setSpamFiler(String spamFiler) {
        this.spamFiler = spamFiler;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
