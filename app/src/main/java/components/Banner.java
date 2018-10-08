package components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.loopj.android.image.SmartImageView;

import ir.debook.debook.R;

public class Banner extends RelativeLayout {
    public enum Position {RIGHT,LEFT,CENTER}
    private String url;
    private Color background;
    Position position;
    SmartImageView imageView;

    public Banner(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(R.styleable.Banner);
        url = typedArray.getString(R.styleable.Banner_bannerUrl);
        imageView.setImageUrl(url);
        //background = typedArray.getColor(0,R.styleable.Banner_background);

    }

    public void setPosition(Position position1){
        this.position = position1;
    }

    public Position getPosition() {
        return position;
    }

    public void changePosition(Position position1){
        LayoutParams centerParams = new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT);
        switch (position1){
            case LEFT:
                break;
            case RIGHT:
                break;
            case CENTER:
                break;
        }
    }

}
