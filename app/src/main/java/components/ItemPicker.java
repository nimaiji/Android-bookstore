package components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.List;

import ir.debook.debook.R;

public class ItemPicker extends RelativeLayout {
    String title;
    List<Object> objects;
    public ItemPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ItemPicker, 0, 0);
        title = typedArray.getString(R.styleable.ItemPicker_itemPickerTitle);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_item_picker, this, true);
        final CustomEditText editText = (CustomEditText) view.findViewById(R.id.edittext);
        ImageView add = (ImageView) view.findViewById(R.id.add);
        ListView list = (ListView) view.findViewById(R.id.list);
        editText.setHint(title);
        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText();
            }
        });

    }

    public void addList(List<Object> objectList){
        this.objects = objectList;
    }
}
