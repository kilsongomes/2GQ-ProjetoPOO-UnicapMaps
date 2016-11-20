package unicap.grafos.unicapmaps.controller;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.R;
import unicap.grafos.unicapmaps.model.Vertice;

/**
 * Created by cais on 19/11/16.
 */

public class BuscaDinamica implements TextWatcher {

    private String stringInput;
    private Context context;
    private ListView listView;
    private EditText source;
    private ArrayList<ResultadoPesquisa> resultado;
    private AdapterResultadoPesquisa adapter;
    //private BuscaInfo buscador;


    public BuscaDinamica(Context context, ListView listView, EditText source) {
        this.context = context;
        this.listView = listView;
        this.source = source;
        //buscador = new BuscaInfo();
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
            //resultado = buscador.buscar(stringInput);
            if(resultado == null){
                //nenhum resultado encontrado
                //esconder listview
                resetListView();
            } else{
                //array
                //passar adapter com resultado para o listview
                startListView();

            }
        }
    }

    private void resetListView() {
        listView.setVisibility(View.INVISIBLE);
    }

    private void startListView() {
        //adapter = new AdapterResultadoPesquisa(context, resultado);
        listView.setAdapter(adapter);

        //posicionaListView();

        listView.setVisibility(View.VISIBLE);
    }

    /*private void posicionaListView() {
        int left, top;
        Vertice destino = grafo.getVertice(idVerticeFinal);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout balao = (RelativeLayout)findViewById(R.id.balao_local);

        left = (int) (destino.getCoordenadas().getX()*escalaInicial) - balao.getWidth() - 5;
        top = (int) (destino.getCoordenadas().getY()*escalaInicial) - balao.getHeight() - 5;
        balao.setLayoutParams(params);

        params.setMargins(left, top,0,0);

    }*/


    public class ResultadoPesquisa{
        private String nomeBloco;
        private String descricao;

        public ResultadoPesquisa(String nomeBloco, String descricao){
            this.nomeBloco = nomeBloco;
            this.descricao = descricao;
        }

        public String getNomeBloco() {
            return nomeBloco;
        }

        public String getDescricao() {
            return descricao;
        }
    }
}
