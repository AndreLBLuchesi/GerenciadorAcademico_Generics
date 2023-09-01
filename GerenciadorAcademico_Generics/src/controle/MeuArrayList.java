package controle;

import java.util.ArrayList;
import modelo.IConsulta;
import modelo.IExibirInformacoes;

/**
 *
 * @author ANDRE.LUCHESI
 * @param <E>
 */
public class MeuArrayList<E extends IExibirInformacoes & IConsulta> extends ArrayList<E>{
    
    public void exibirLista(){
        System.out.println("");
        for (E elemento : this) {  
            elemento.exibirInformacoes();
        }
        System.out.println("Total de registros: "+size());
    }
    
    public E pesquisar(String chaveBusca){
        chaveBusca = chaveBusca.toLowerCase();
        for (E elemento : this) {
            if(elemento.getChavePrincipal() instanceof String && 
                    elemento.getChaveSecundaria() instanceof String){
                String chaveP = (String) elemento.getChavePrincipal();
                String chaveS = (String) elemento.getChaveSecundaria();
                
                if(chaveP.equalsIgnoreCase(chaveBusca) ||
                        chaveS.equalsIgnoreCase(chaveBusca)){
                    return elemento;
                }
            }
            else if(elemento.getChavePrincipal().equals(chaveBusca)
                    || elemento.getChaveSecundaria().equals(chaveBusca)){
                return elemento;
            }
        }
        return null;
    }
}