package components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import ir.debook.debook.R;

public class SpecialEditText extends RelativeLayout {
    int hintColor, textColor;
    String hintText;

    public SpecialEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SpecialEditText, 0, 0);
        hintColor = typedArray.getColor(R.styleable.SpecialEditText_hintColor, 0xff000000);
        textColor = typedArray.getColor(R.styleable.SpecialEditText_textColor, 0xff000000);
        hintText = typedArray.getString(R.styleable.SpecialEditText_hint);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_edittext, this, true);
        final CustomTextView hint = (CustomTextView) view.findViewById(R.id.hint);
        final CustomEditText editText = (CustomEditText) view.findViewById(R.id.edittext);

        hint.setTextColor(hintColor);
        hint.setText(hintText);
        editText.setTextColor(textColor);
        Log.d("################", "SpecialEditText: " + hintText);
        Log.d("################", "SpecialEditText: " + hintColor);
        Log.d("################", "SpecialEditText: " + hint.getText());


        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    hint.startAnimation(Animations.getEditTextOut());
                    hint.setVisibility(GONE);
                } else {
                    hint.startAnimation(Animations.getEditTextIn());
                    hint.setVisibility(VISIBLE);
                }
            }
        });
    }
}
