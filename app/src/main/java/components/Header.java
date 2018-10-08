package components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import ir.debook.debook.R;

public class Header extends RelativeLayout {
    String titleSt;

    public String getTitleSt() {
        return titleSt;
    }

    public void setTitleSt(String titleSt) {
        this.titleSt = titleSt;
    }

    public Header(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs ,R.styleable.Header,0,0);
        titleSt = typedArray.getString(R.styleable.Header_headerTitle);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_header,this,true);
        CustomTitleView title = (CustomTitleView) view.findViewById(R.id.header_title);
        title.setText(titleSt);
    }
}
