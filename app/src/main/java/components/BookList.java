package components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.loopj.android.image.SmartImageView;

import java.util.List;

import BookCore.Book;
import ir.debook.debook.CardListAdapter;
import ir.debook.debook.R;

public class BookList extends RelativeLayout {

    private int spanCount;
    private String url, title, more;
    List<Book> books;
    SmartImageView icon;

    public BookList(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BookList, 0, 0);
        spanCount = typedArray.getInt(0, R.styleable.BookList_bookSpanCount);
        url = typedArray.getString(R.styleable.BookList_bookUrl);
        title = typedArray.getString(R.styleable.BookList_title);
        more = typedArray.getString(R.styleable.BookList_more);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.list_book, this, true);
        icon = (SmartImageView) getRootView().findViewById(R.id.icon);
        RecyclerView recyclerView = (RecyclerView) getRootView().findViewById(R.id.recycler);
        CardListAdapter cardListAdapter = new CardListAdapter();
        cardListAdapter.BookListAdapter(books, R.layout.layout_card, context);
        StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.HORIZONTAL);
        sgm.setReverseLayout(true);
        recyclerView.setLayoutManager(sgm);

        // Todo: get Data from url and import to recyclerView as List<Book>
    }
}
