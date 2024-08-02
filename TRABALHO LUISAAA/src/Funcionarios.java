import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Funcionarios {

    public void createTable() {
        try (Statement statement = BancoDeDados.connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Funcionario ( Nome VARCHAR, telefone INTEGER, cadastro INTEGER )");

            BancoDeDados.connection.commit();
            System.out.println("Tabela criada ou já existe.");

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public void inserirFuncionario(List<String[]> lista) {
        try (PreparedStatement insertStatement = BancoDeDados.connection.prepareStatement("INSERT INTO Funcionarios(Nome, telefone, contratacao) VALUES(?, ?, ?) ")) {

            for (String[] s : lista) {
                insertStatement.setString(1, s[0]);
                insertStatement.setInt(2, Integer.parseInt(s[1]));
                insertStatement.executeUpdate();
            }
            BancoDeDados.connection.commit();
            System.out.println("Funcionário inserido.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir Funcionario: " + e.getMessage());
        }
    }

    public void lerFuncionario(String nomeQuery) {
        try (PreparedStatement selectStatement = BancoDeDados.connection.prepareStatement("SELECT * FROM Funcionario WHERE nome , telefone , contratacao  ")) {

            ResultSet resultSet = selectStatement.executeQuery();
            System.out.println("Funcionário:");
            while (resultSet.next()) {
                String nome = resultSet.getString("Nome");
                int telefone = resultSet.getInt("telefone");
                int contratacao = resultSet.getInt("contratacao");
                System.out.println("Nome: " + nome + "telefone" + telefone + "contratacao" + contratacao);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao ler Funcionario: " + e.getMessage());
        }
    }
    public void deletarFuncionario(String nome) {
        try (PreparedStatement deleteStatement = BancoDeDados.connection.prepareStatement("DELETE FROM Funcionario WHERE")) {

            deleteStatement.executeUpdate();
            BancoDeDados.connection.commit();
            System.out.println("Cliente deletado.");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar Funcionario: " + e.getMessage());
        }
    }


    }
