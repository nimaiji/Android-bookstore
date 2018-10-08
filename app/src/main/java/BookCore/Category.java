package BookCore;

import java.util.List;

public class Category {

    String name;
    String ImageUrl;
    int id;
    List<Category> subCategory;


    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public Category() {

    }

    public Category(String name, int id, List<Category> subCategory) {
        this.name = name;
        this.id = id;
        this.subCategory = subCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Category> getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(List<Category> subCategory) {
        this.subCategory = subCategory;
    }
}
