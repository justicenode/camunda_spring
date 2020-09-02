package ch.noseryoung.workflow.service.mail;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("mail")
public class MailProperties {

    private String user;

    private String displayName;

    private String password;

    private String smtpHost;

    private String imapHost;

    private int smtpPort;

    private int imapPort;

    private boolean debug;

    private boolean starttls;

    private boolean auth;

    public String getUser() {
        return user;
    }

    public MailProperties setUser(String user) {
        this.user = user;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public MailProperties setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public MailProperties setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
        return this;
    }

    public String getImapHost() {
        return imapHost;
    }

    public MailProperties setImapHost(String imapHost) {
        this.imapHost = imapHost;
        return this;
    }

    public boolean isDebug() {
        return debug;
    }

    public MailProperties setDebug(boolean debug) {
        this.debug = debug;
        return this;
    }

    public boolean isStarttls() {
        return starttls;
    }

    public MailProperties setStarttls(boolean starttls) {
        this.starttls = starttls;
        return this;
    }

    public boolean isAuth() {
        return auth;
    }

    public MailProperties setAuth(boolean auth) {
        this.auth = auth;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(int smtpPort) {
        this.smtpPort = smtpPort;
    }

    public int getImapPort() {
        return imapPort;
    }

    public void setImapPort(int imapPort) {
        this.imapPort = imapPort;
    }
}
