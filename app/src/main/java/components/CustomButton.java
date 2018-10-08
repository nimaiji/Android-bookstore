package components;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.widget.Button;

import util.FontName;

public class CustomButton extends AppCompatButton {
    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), FontName.IranSans);
        this.setTypeface(typeface);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            this.setStateListAnimator(null);
    }

    public CustomButton(Context context) {
        super(context);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), FontName.IranSans);
        this.setTypeface(typeface);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            this.setStateListAnimator(null);
    }
}
