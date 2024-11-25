import javax.swing.JOptionPane;

public class ExcluirCadastro {
    public static void excluirPessoa(CadastroPessoas cadastro, int id) {
        boolean removida = cadastro.removerPessoa(id);
        if (removida) {
            JOptionPane.showMessageDialog(null, "Pessoa removida com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Pessoa não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
