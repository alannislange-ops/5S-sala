import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ColegaDAO {

    // CREATE
    public void cadastrar(Colega colega) throws SQLException {
        String sql = "INSERT INTO colega (nome, dia_limpeza) VALUES (?, ?)";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, colega.getNome());
            stmt.setString(2, colega.getDiaLimpeza());
            stmt.executeUpdate();

            try (ResultSet chaves = stmt.getGeneratedKeys()) {
                if (chaves.next()) {
                    colega.setId(chaves.getInt(1));
                }
            }
        }
    }

    // READ (todos)
    public List<Colega> listarTodos() throws SQLException {
        String sql = "SELECT id, nome, dia_limpeza FROM colega ORDER BY dia_limpeza";
        List<Colega> colegas = new ArrayList<>();

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                colegas.add(new Colega(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("dia_limpeza")
                ));
            }
        }
        return colegas;
    }

    

    // DELETE
    public boolean remover(int id) throws SQLException {
        String sql = "DELETE FROM colega WHERE id = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}
