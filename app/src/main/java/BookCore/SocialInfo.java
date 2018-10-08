package BookCore;

import android.support.annotation.Nullable;

public class SocialInfo {
    @Nullable
    String telegramId,instagramId,facebookId,twitterId,website;

    @Nullable
    public String getTelegramId() {
        return telegramId;
    }

    public void setTelegramId(@Nullable String telegramId) {
        this.telegramId = telegramId;
    }

    @Nullable
    public String getInstagramId() {
        return instagramId;
    }

    public void setInstagramId(@Nullable String instagramId) {
        this.instagramId = instagramId;
    }

    @Nullable
    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(@Nullable String facebookId) {
        this.facebookId = facebookId;
    }

    @Nullable
    public String getTwitterId() {
        return twitterId;
    }

    public void setTwitterId(@Nullable String twitterId) {
        this.twitterId = twitterId;
    }

    @Nullable
    public String getWebsite() {
        return website;
    }

    public void setWebsite(@Nullable String website) {
        this.website = website;
    }
}
