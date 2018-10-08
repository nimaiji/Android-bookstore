package components;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import java.util.List;

import BookCore.Category;
import ir.debook.debook.CardListAdapter;
import ir.debook.debook.R;

public class CategoryList extends RelativeLayout {

    private String url;
    private int spanCount;
    public List<Category> categories;

    public CategoryList(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CategoryList, 0, 0);
        url = typedArray.getString(R.styleable.CategoryList_categoryUrl);
        spanCount = typedArray.getInt(0, R.styleable.CategoryList_categorySpanCount);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.list_chips, this, true);
        RecyclerView recyclerView = (RecyclerView) getRootView().findViewById(R.id.recycler);
        CardListAdapter cardListAdapter = new CardListAdapter();
        cardListAdapter.CategoryListAdapter(categories, R.layout.layout_chips, context);
        recyclerView.setAdapter(cardListAdapter);
        StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.HORIZONTAL);
        sgm.setReverseLayout(true);
        recyclerView.setLayoutManager(sgm);

        // Todo: get Data from url and import to recyclerView as List<Category>
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSpanCount() {
        return spanCount;
    }

    public void setSpanCount(int spanCount) {
        this.spanCount = spanCount;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
