package controle;

import modelo.Endereco;
import util.Input;

public class CadastroEndereco {
    
    protected static void setarDadosEndereco(Endereco end){
        System.out.print("Cidade: ");
        end.setCidade(Input.nextLine());
        System.out.print("Rua: ");
        end.setRua(Input.nextLine());
        System.out.print("Número: ");
        end.setNumero(Input.nextLine());
    }
}
