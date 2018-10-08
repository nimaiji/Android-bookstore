package components;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.util.TypedValue;

import ir.debook.debook.R;
import util.FontName;

public class CustomEditText extends AppCompatEditText {

    public CustomEditText(Context context) {
        super(context);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), FontName.IranSans);
        this.setTypeface(typeface);
        this.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.editTextSize));
        int padding = (int) context.getResources().getDimension(R.dimen.editTextPadding);
        this.setPadding(padding, padding, padding, padding);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), FontName.IranSans);
        this.setTypeface(typeface);
        this.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.editTextSize));
        int padding = (int) context.getResources().getDimension(R.dimen.editTextPadding);
        this.setPadding(padding, padding, padding, padding);
    }


}
