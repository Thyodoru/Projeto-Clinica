import java.util.ArrayList;
import java.util.List;

public class CadastroPessoas {
    private List<Pessoa> pessoas;

    public CadastroPessoas() {
        this.pessoas = new ArrayList<>();
    }

    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public Pessoa encontrarPessoaPorId(int id) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    public boolean removerPessoa(int id) {
        Pessoa pessoa = encontrarPessoaPorId(id);
        if (pessoa != null) {
            pessoas.remove(pessoa);
            return true;
        }
        return false;
    }

    public void listarPessoas() {
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }
}
