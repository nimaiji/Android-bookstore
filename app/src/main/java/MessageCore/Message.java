package MessageCore;

import android.content.Context;
import android.support.annotation.StringRes;

import java.util.List;

public abstract class Message {
    String title, text, buttonText, url, email;
    MessageType messageType;
    Context context;

    public MessageType getMessageType() {
        return messageType;
    }


    public Message(Context context1) {
        this.context = context1;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public abstract void readMessage();

    public abstract boolean deleteMessage();

    public abstract void pinMessage(List<Message> messages);

    public abstract void replyMessage();
}
