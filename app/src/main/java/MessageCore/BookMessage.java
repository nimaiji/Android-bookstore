package MessageCore;

import android.content.Context;

import java.util.List;

public class BookMessage extends Message {

    public BookMessage(Context context1) {
        super(context1);
        messageType = MessageType.BOOK;
    }

    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Override
    public void setContext(Context context) {
        super.setContext(context);
    }

    @Override
    public String getUrl() {
        return super.getUrl();
    }

    @Override
    public void setUrl(String url) {
        super.setUrl(url);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public String getText() {
        return super.getText();
    }

    @Override
    public void setText(String text) {
        super.setText(text);
    }

    @Override
    public String getButtonText() {
        return super.getButtonText();
    }

    @Override
    public void setButtonText(String buttonText) {
        super.setButtonText(buttonText);
    }

    @Override
    public void readMessage() {
        // Todo: get Book data and send it to AddBookActivity.class
    }

    @Override
    public boolean deleteMessage() {
        return false;
    }

    @Override
    public void pinMessage(List<Message> messages) {

    }

    @Override
    public void replyMessage() {

    }
}
