package ir.debook.debook;

import android.content.Context;
import android.support.annotation.CheckResult;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;

import java.util.List;

import BookCore.Book;
import BookCore.Category;
import BookCore.MiniItem;
import components.CustomTextView;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.ViewHolder> {
    private LayoutInflater inflater;
    List<Category> categories;
    List<Book> books;
    List<MiniItem> miniItems;
    Context context;

    public enum State {CATEGORY, BOOK, MINIITEM}

    State state;
    int layoutId;


    public CardListAdapter() {

    }

    public void CategoryListAdapter(List<Category> categories, int layoutId, Context context) {
        state = State.CATEGORY;
        this.categories = categories;
        this.layoutId = layoutId;
        this.context = context;
    }


    public void MiniItemListAdapter(List<MiniItem> miniItems, int layoutId, Context context) {
        state = State.MINIITEM;
        this.miniItems = miniItems;
        this.layoutId = layoutId;
        this.context = context;
    }

    public void BookListAdapter(List<Book> books, int layoutId, Context context) {
        state = State.BOOK;
        this.books = books;
        this.layoutId = layoutId;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(layoutId, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (state) {
            case BOOK:
                Book bookCu = books.get(position);
                holder.name.setText(bookCu.getName());
                holder.location.setText(bookCu.getAddress().getState() + " ،" + bookCu.getAddress().getCity());
                holder.price.setText(bookCu.getPrice().getPrice().toString() + context.getResources().getString(R.string.currency));
                holder.originalPrice.setText(bookCu.getPrice().getOriginalPrice().toString() + context.getResources().getString(R.string.currency));
                // Todo: get imageURL from BookInfo.Class
                holder.image.setImageUrl("");
                break;
            case CATEGORY:
                Category catCu = categories.get(position);
                holder.name.setText(catCu.getName());
                break;
            case MINIITEM:
                MiniItem miniCu = miniItems.get(position);
                holder.image.setImageUrl(miniCu.getImageUrl());
                break;
        }
    }


    @Override
    public int getItemCount() {
        switch (state) {
            case MINIITEM:
                return miniItems.size();
            case BOOK:
                return books.size();
            case CATEGORY:
                return categories.size();
        }
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public SmartImageView image;
        public CustomTextView name, location, price, originalPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            try {
                image = (SmartImageView) itemView.findViewById(R.id.image);
            } catch (Exception e) {
            }
            try {
                name = (CustomTextView) itemView.findViewById(R.id.name);
            } catch (Exception e) {
            }
            try {
                location = (CustomTextView) itemView.findViewById(R.id.location);
                price = (CustomTextView) itemView.findViewById(R.id.price);
                originalPrice = (CustomTextView) itemView.findViewById(R.id.originalPrice);
            } catch (Exception e) {

            }

        }
    }

}
