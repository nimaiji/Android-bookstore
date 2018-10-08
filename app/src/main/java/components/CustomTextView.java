package components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import util.FontName;

public class CustomTextView extends AppCompatTextView {

    public CustomTextView(Context context) {
        super(context);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), FontName.IranSans);
        this.setTypeface(typeface);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), FontName.IranSans);
        this.setTypeface(typeface);
    }

    public boolean isLong() {
        String txt = this.getText().toString();
        if (txt.length() >250)
            return true;
        return false;
    }

    public String getShortText(){
        char[] charArray = this.getText().toString().toCharArray();
        String shortText = "";
        for (char ch:charArray){
            if(ch == ' ' && shortText.length()>250)
                return shortText + "...";
            shortText += ch;
        }
        return shortText;
    }

}
