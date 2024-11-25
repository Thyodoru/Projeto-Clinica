import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        CadastroPessoas cadastro = new CadastroPessoas();

        while (true) {
            String opcaoStr = JOptionPane.showInputDialog(
                null,
                "Escolha uma opção:\n1. Adicionar Pessoa\n2. Listar Pessoas\n3. Editar Pessoa\n4. Excluir Pessoa\n5. Sair",
                "Sistema de Cadastro",
                JOptionPane.QUESTION_MESSAGE
            );

            if (opcaoStr == null) {
                JOptionPane.showMessageDialog(null, "Saindo...");
                break;
            }

            int opcao;
            try {
                opcao = Integer.parseInt(opcaoStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            switch (opcao) {
                case 1:
                    String nomeBebe = JOptionPane.showInputDialog("Nome do Bebê: ");
                    String nomeMae = JOptionPane.showInputDialog("Nome da Mãe: ");
                    String endereco = JOptionPane.showInputDialog("Endereço: ");
                    String telefone = JOptionPane.showInputDialog("Telefone: ");
                    String dataNascimento = JOptionPane.showInputDialog("Data de Nascimento (dd/MM/yyyy): ");

                    if (nomeBebe != null && nomeMae != null && endereco != null && telefone != null && dataNascimento != null) {
                        Pessoa pessoa = new Pessoa(nomeBebe, nomeMae, endereco, telefone, dataNascimento);
                        cadastro.adicionarPessoa(pessoa);
                        JOptionPane.showMessageDialog(null, "Pessoa adicionada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Operação cancelada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 2:
                    StringBuilder listaPessoas = new StringBuilder();
                    for (Pessoa pessoa : cadastro.getPessoas()) { // Acessa a lista de pessoas através do método getPessoas()
                        listaPessoas.append(pessoa).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, listaPessoas.length() > 0 ? listaPessoas.toString() : "Nenhuma pessoa cadastrada.");
                    break;

                case 3:
                    String idEditarStr = JOptionPane.showInputDialog("Digite o ID da pessoa que deseja editar:");
                    try {
                        int idEditar = Integer.parseInt(idEditarStr);
                        EditarCadastro.editarPessoa(cadastro, idEditar);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "ID inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 4:
                    String idExcluirStr = JOptionPane.showInputDialog("Digite o ID da pessoa que deseja excluir:");
                    try {
                        int idExcluir = Integer.parseInt(idExcluirStr);
                        ExcluirCadastro.excluirPessoa(cadastro, idExcluir);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "ID inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }
}
