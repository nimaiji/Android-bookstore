package ir.debook.debook;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.image.SmartImageView;

import java.util.List;

import BookCore.Category;
import components.CustomTextView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    List<Category> categories;
    LayoutInflater inflater;

    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_category, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.ViewHolder holder, int position) {
        Category catCu = categories.get(position);
        holder.name.setText(catCu.getName());
        holder.image.setImageUrl(catCu.getImageUrl());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Todo: clear data and this.notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CustomTextView name;
        SmartImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (CustomTextView) itemView.findViewById(R.id.name);
            image = (SmartImageView) itemView.findViewById(R.id.image);
        }
    }

}
