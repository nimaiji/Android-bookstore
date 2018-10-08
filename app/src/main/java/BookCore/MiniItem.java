package BookCore;

public class MiniItem {
    String imageUrl, metadata;

    public MiniItem(String imageUrl, String metadata) {
        this.imageUrl = imageUrl;
        this.metadata = metadata;
    }

    public MiniItem() {

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
}
