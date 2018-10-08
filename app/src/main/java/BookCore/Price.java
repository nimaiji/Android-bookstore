package BookCore;

public class Price {
    Float price, originalPrice;

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getPriceSt(){
        return this.price.toString();
    }

    public String getOrgPriceSt(){
        return this.originalPrice.toString();
    }
}
