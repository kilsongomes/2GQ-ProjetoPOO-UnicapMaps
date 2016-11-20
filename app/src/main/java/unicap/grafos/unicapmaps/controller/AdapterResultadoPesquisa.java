package unicap.grafos.unicapmaps.controller;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cais on 20/11/16.
 */
public class AdapterResultadoPesquisa extends ArrayAdapter{
    public AdapterResultadoPesquisa(Context context, int resource) {
        super(context, resource);
    }

    /*public AdapterResultadoPesquisa(Context context, ArrayList<BuscaDinamica.ResultadoPesquisa> resultados){
        super(context, R.layout.custom_lista, resultados);

    }*/

}
