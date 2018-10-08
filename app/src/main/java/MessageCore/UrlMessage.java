package MessageCore;

import android.content.Context;
import android.content.Intent;

import java.util.List;

import ir.debook.debook.WebViewActivity;

public class UrlMessage extends Message {

    public UrlMessage(Context context1) {
        super(context1);
        messageType = MessageType.URL;
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
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra("url",getUrl());
        intent.putExtra("title",getTitle());
        context.startActivity(intent);
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
