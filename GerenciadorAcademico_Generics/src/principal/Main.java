package principal;

import controle.CadastroAluno;
import controle.CadastroCoordenador;
import controle.CadastroCurso;
import controle.CadastroFuncionario;
import controle.CadastroFuncionarioTerceirizado;
import controle.CadastroProfessor;
import controle.MenuCadastro;
import controle.MeuArrayList;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.Curso;
import modelo.Endereco;
import util.DialogBoxUtils;
/**
 *
 * @author Andre
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CadastroCurso cadCurso = new CadastroCurso();
        CadastroAluno cadAluno =  new CadastroAluno(cadCurso);
        CadastroProfessor cadProfessor =  new CadastroProfessor();
        CadastroCoordenador cadCoordenador =  new CadastroCoordenador(cadCurso);
        CadastroFuncionario cadFuncionario =  new CadastroFuncionario();
        CadastroFuncionarioTerceirizado cadFuncionarioTercerizado =  new CadastroFuncionarioTerceirizado();
        JOptionPane.getRootFrame();
        
        Aluno al = new Aluno("Jonas", "11111", LocalDate.now(),
                new Endereco("Cascavel", "Av. Tito Mufatto", "1233"), 
                "123", new Curso("Tads", 2500, 6, null),
                LocalDate.now(), "Em Andamento");
        Aluno al2 = new Aluno("Ana", "22222", LocalDate.now(),
                new Endereco("Cascavel", "Av. Tito Mufatto", "1233"), 
                "123", new Curso("Tads", 2500, 6, null),
                LocalDate.now(), "Em Andamento");
        
        MeuArrayList<Aluno> listaAlunos = new MeuArrayList<>();
        listaAlunos.add(al);
        listaAlunos.add(al2);
        listaAlunos.exibirLista();
        
        System.out.println("Pesquisa:");
        Aluno alunoPesquisa = listaAlunos.pesquisar("ana");
        if(alunoPesquisa != null){
            alunoPesquisa.exibirInformacoes();
        }
        else{
            System.out.println("Aluno não encontrado!");
        }
        
        
        int op;
        do {
            op = MenuCadastro.selecionarOpcaoMenuPrincipal();
            switch (op) {
                case 1 -> cadAluno.menuAluno();
                case 2 -> cadFuncionario.menuFuncionario();
                case 3 -> cadProfessor.menuProfessor();
                case 4 -> cadCoordenador.menuCoordenador();
                case 5 -> cadCurso.menuControleCurso();
                case 6 -> cadFuncionarioTercerizado.menuFuncionarioTerceirizado();
                case 0 -> {
                    System.out.println("Saindo do sistema...");
                }
                default -> DialogBoxUtils.exibirMensagemDeErro("Opção inválida!", "Erro! Opção inválida!");
            }
        } while (op != 0);
    }
    
}
