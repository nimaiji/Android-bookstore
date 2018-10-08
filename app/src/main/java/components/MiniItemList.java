package components;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import java.util.List;

import BookCore.MiniItem;
import ir.debook.debook.CardListAdapter;
import ir.debook.debook.R;

public class MiniItemList extends RelativeLayout {

    private String url;
    private int spanCount;
    private List<MiniItem> miniItems;

    public MiniItemList(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MiniItemList, 0, 0);
        url = typedArray.getString(R.styleable.MiniItemList_miniitemUrl);
        spanCount = typedArray.getInt(0, R.styleable.MiniItemList_miniitemSpanCount);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.list_miniitem, this, true);
        RecyclerView recyclerView = (RecyclerView) getChildAt(0);
        CardListAdapter cardListAdapter = new CardListAdapter();
        cardListAdapter.MiniItemListAdapter(miniItems, R.layout.layout_miniitem, context);
        recyclerView.setAdapter(cardListAdapter);
        StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.HORIZONTAL);
        sgm.setReverseLayout(true);
        recyclerView.setLayoutManager(sgm);


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

    public List<MiniItem> getMiniItems() {
        return miniItems;
    }

    public void setMiniItems(List<MiniItem> miniItems) {
        this.miniItems = miniItems;
    }
}
