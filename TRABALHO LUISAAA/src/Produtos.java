import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Produtos {

    public void createTable() {
        try (Statement statement = BancoDeDados.connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Produto (Nome VARCHAR, valor INTEGER, quantidade INTEGER) ");

            BancoDeDados.connection.commit();
            System.out.println("Tabela criada ou já existe.");

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public void inserirProdutos(List<String[]> lista) {
        try (PreparedStatement insertStatement = BancoDeDados.connection.prepareStatement("INSERT INTO produtos (nome, valor, quantidade) VALUES(?, ?, ?)")) {

            for (String[] s : lista) {
                insertStatement.setString(1, s[0]);
                insertStatement.setInt(2, Integer.parseInt(s[1]));
                insertStatement.executeUpdate();
            }
            BancoDeDados.connection.commit();
            System.out.println("produto inserido.");


        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

    public void lerProduto(String nomeQuery) {
        try (PreparedStatement selectStatement = BancoDeDados.connection.prepareStatement("SELECT * FROM Produto... //Insira seu código aqui")) {

            ResultSet resultSet = selectStatement.executeQuery();
            System.out.println("Produtos");
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                int valor = resultSet.getInt("valor");
                int quantidade = resultSet.getInt("quantidade");
                System.out.println("Nome: " + nome + "valor" + valor + "quantidade" + quantidade);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar produto: " + e.getMessage());
        }
    }

    public void deletarProduto(String nome) {
        try (PreparedStatement deleteStatement = BancoDeDados.connection.prepareStatement("DELETE FROM Produto... //Insira seu código aqui")) {

            deleteStatement.executeUpdate();
            BancoDeDados.connection.commit();
            System.out.println("Produto deletado.");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar produtos: " + e.getMessage());
        }
    }
}
