package components;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import util.FontName;

public class CustomTitleView extends AppCompatTextView {

    public CustomTitleView(Context context) {
        super(context);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(),FontName.IranSansBold);
        this.setTypeface(typeface);
    }

    public CustomTitleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), FontName.IranSansBold);
        this.setTypeface(typeface);
    }


}
