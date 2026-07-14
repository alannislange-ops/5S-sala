import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBD {

    private static final String URL = "jdbc:mysql://sa-banco-de-dados-estudante-a8e2.d.aivencloud.com:24499/wegannosdb";
    private static final String USUARIO = "avnadmin";
    private static final String SENHA = "AVNS_k7w9ygfrSBwgWlsRSoP";

    public static Connection conectar() throws SQLException {
        try {
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão realizada com sucesso!");
            return conexao; 
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            throw e; 
        }
    }
    public static void main(String[] args) {
        try {
            Connection teste = conectar();
            if (teste != null) {
                teste.close(); 
                System.out.println("Teste de conexão concluído com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Falha no teste do main.");
        }
    }


}
