package ir.debook.debook;

import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    View view;
    List<String> searchList = new ArrayList<String>();
    EditText searchEditText;
    ImageView searchIcon;

    public enum IconState {VOICE, CLEAR,NONE}

    IconState iconState = IconState.VOICE;
    private final int REQ_CODE_SPEECH_INPUT = 100;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        searchEditText = (EditText) view.findViewById(R.id.search_et);
        searchIcon = (ImageView) view.findViewById(R.id.search_icon);

        // search icon:keyboard voice regonizing
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (iconState) {
                    case CLEAR:
                        searchEditText.getText().clear();
                        changeIconState(IconState.VOICE);
                        break;
                    case VOICE:
                        promptSpeechInput();
                        break;
                }
            }
        });

        // adding search button to keyboard
        searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    return true;
                }
                return false;
            }
        });


        // Todo: save searchList in JSON
        // Todo: load searchList in JSON
        // Todo: Handle Non-Searched Image
        return view;
    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "fa");
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "دنبال چه کتابی هستید؟");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            changeIconState(IconState.NONE);
            //st.st(getActivity(), "متاسفانه دستگاه از این قابلیت پشتیبانی نمی کند.", R.drawable.warningtoast);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == getActivity().RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    searchEditText.setText(result.get(0));
                    if (!searchEditText.getText().toString().isEmpty())
                        changeIconState(IconState.CLEAR);
                }
                break;
            }

        }
    }

    public void changeIconState(IconState iconState1){
        switch (iconState1) {
            case CLEAR:
                iconState = iconState1;
                searchIcon.setImageResource(R.drawable.ic_close_black_48dp);
                break;
            case VOICE:
                iconState = iconState1;
                searchIcon.setImageResource(R.drawable.ic_keyboard_voice_black_48dp);
                break;
            case NONE:
                searchIcon.setVisibility(View.INVISIBLE);
                break;
        }
    }

}
