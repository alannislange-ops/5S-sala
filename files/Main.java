import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        ColegaDAO dao = new ColegaDAO();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== ESCALA DE LIMPEZA =====");
            System.out.println("1 - Cadastrar colega");
            System.out.println("2 - Listar todos");
            System.out.println("4 - Remover colega");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(sc.nextLine());

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        LocalDate dataI = LocalDate.now();

                        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        String dataFormatada = dataI.format(formatar);

                        dao.cadastrar(new Colega(nome, dataFormatada));
                        System.out.println("Colega cadastrado!");
                        break;

                    case 2:
                        List<Colega> colegas = dao.listarTodos();
                        if (colegas.isEmpty()) {
                            System.out.println("Nenhum colega cadastrado.");
                        }
                        for (Colega c : colegas) {
                            System.out.println("#" + c.getId() + " - " + c.getNome()
                                    + " -> limpa em " + c.getDiaLimpeza());
                        }
                        break;


                    case 4:
                        System.out.print("ID do colega a remover: ");
                        int idRemover = Integer.parseInt(sc.nextLine());
                        boolean removido = dao.remover(idRemover);
                        System.out.println(removido ? "Removido!" : "Colega não encontrado.");
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (SQLException e) {
                System.err.println("Erro no banco de dados: " + e.getMessage());
            } catch (DateTimeParseException e) {
                System.err.println("Data inválida. Use o formato dd/MM/yyyy.");
            }

        } while (opcao != 0);

        sc.close();
    }

   
}
