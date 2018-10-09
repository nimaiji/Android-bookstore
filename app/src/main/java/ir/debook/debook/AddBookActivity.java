package ir.debook.debook;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import components.CustomButton;
import components.CustomEditText;
import components.CustomTextView;
import components.SpecialEditText;

public class AddBookActivity extends Activity {
    SpecialEditText bookName,
            author,
            translator,
            publisher,
            editor,
            yearOfPrint,
            edition;
    CustomButton addCategory;
    CustomEditText price,originalPrice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);


    }
}
