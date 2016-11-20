package unicap.grafos.unicapmaps.controller;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by cais on 19/11/16.
 */

public class BuscaDinamica implements TextWatcher {

    private String stringInput;
    private Context context;
    private ListView listView;
    private EditText source;


    public BuscaDinamica(Context context, ListView listView, EditText source) {
        this.context = context;
        this.listView = listView;
        this.source = source;

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        stringInput = (String) s;
    }

    @Override
    public void afterTextChanged(Editable s) {
        if(!stringInput.isEmpty()){

        }
    }
}
