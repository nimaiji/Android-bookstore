package ir.debook.debook;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import java.util.List;

import BookCore.Category;
import components.CategoryList;
import components.Header;

public class AddCategory extends Activity {
    LinearLayout linearLayout;
    LayoutInflater inflater;
    List<Category> categories;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        linearLayout = (LinearLayout) findViewById(R.id.layout);
        inflater = LayoutInflater.from(this);
        for (Category category : categories) {
            Header header = (Header) inflater.inflate(R.layout.layout_header, linearLayout, true);
            header.setTitleSt(category.getName());
            CategoryList categoryList = (CategoryList) inflater.inflate(R.layout.list_chips, linearLayout, true);

            // Todo: Fix this
            categoryList.setUrl(category.getSubCategory().toString());
        }

    }
}
