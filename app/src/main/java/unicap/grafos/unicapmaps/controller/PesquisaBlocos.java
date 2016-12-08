package unicap.grafos.unicapmaps.controller;


import unicap.grafos.unicapmaps.dao.InfoBlocos;
import java.util.ArrayList;
/**
 * Created by kilso on 23/11/2016.
 */

public class PesquisaBlocos {

    /**
     * Created by kilson on 20/11/2016.
     */
        private String entradaInfo;
        ArrayList<ResultadoPesquisa> resultado;
        String[] nomesBlocos;
        InfoBlocos dados;

        public Pesquisa() {
            nomesBlocos = infoBlocos.getNomesBlocos();
        }

        InfoBlocos info = new InfoBlocos();
        ArrayList<String[]> infoBlocos = info.getInfoBlocos();

        public ArrayList<ResultadoPesquisa> pesquisaInfo(String entradaInfo){
            int i,j;

            for(i = 0; i < nomesBlocos.length; i++){
                if(nomesBlocos[i].equalsIgnoreCase(entradaInfo)) {
                    ResultadoPesquisa pesquisa = new ResultadoPesquisa(nomesBlocos[i],i, null);
                    resultado.add(pesquisa);
                }
            }

            for (i = 0; i < infoBlocos.size(); i++){
                for(j = 0; j < infoBlocos.get(i)[j].length(); j++) {
                    if (infoBlocos.get(i)[j].contains(entradaInfo)) {
                        ResultadoPesquisa pesquisa = new ResultadoPesquisa(nomesBlocos[i], i, infoBlocos.get(i)[j]);
                        resultado.add(pesquisa);
                    }
                }
            }
            return resultado;
        }

}

