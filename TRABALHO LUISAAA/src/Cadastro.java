

import java.sql.ClientInfoStatus;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    Scanner scanner = new Scanner(System.in);
    BancoDeDados bancoDeDados = new BancoDeDados();
    Produtos produtos = new Produtos();
    Funcionarios funcionarios = new Funcionarios();


    void adicionarProduto(){
        List<String[]> lista = new ArrayList<>();
        bancoDeDados.connect();
        produtos.createTable();
        produtos.inserirProdutos(lista);

        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Digite o valor do produto:");
        int valor = scanner.nextInt();
        System.out.println("Digite a quantidade de produto:");
        int quantidade = scanner.nextInt();


        bancoDeDados.close();
    }

    void lerProduto(){
        bancoDeDados.connect();
        produtos.lerProduto("lerProd");
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Digite o valor do produto:");
        int valor = scanner.nextInt();
        System.out.println("Digite a quantidade do produto:");
        int quantidade = scanner.nextInt();


        bancoDeDados.close();
    }
    void deletarProduto(){
        bancoDeDados.connect();
        produtos.deletarProduto("deletProd");

        System.out.println("Digite o produto que deseja deletar :");
        String nome = scanner.nextLine();


        bancoDeDados.close();
    }

    void adicionarFuncionario(){
        List<String[]> lista = new ArrayList<>();
        bancoDeDados.connect();
        funcionarios.createTable();
        funcionarios.inserirFuncionario(lista);

        System.out.println("Digite o nome do funcionário:");
        String nome = scanner.nextLine();
        System.out.println("Digite o telefone do funcionário:");
        int telefone = scanner.nextInt();
        System.out.println("Digite a data de contratação do funcionário:");
        int contratacao = scanner.nextInt();

        bancoDeDados.close();
    }

    void lerFuncionario(){
        bancoDeDados.connect();
        funcionarios.lerFuncionario("lerFunc");
        System.out.println("Digite o funcionário que deseja ler:");
        String nome = scanner.nextLine();

        bancoDeDados.close();
    }
    void deletarFuncionário(){
        bancoDeDados.connect();
        funcionarios.createTable();
        funcionarios.deletarFuncionario("DeletFunc");
        System.out.println("Digite o funcionário que deseja deletar:");
        String nome = scanner.nextLine();


        bancoDeDados.close();
    }

    void imprimirMenu(){
        System.out.println("Escolha uma opção:");
        System.out.println("1- Inserir produto");
        System.out.println("2- Deletar produto");
        System.out.println("3- Consultar produto");
        System.out.println("4- Inserir funcionário");
        System.out.println("5- Consultar funcionário");
        System.out.println("6- Deletar funcionário");
        System.out.println("7- Sair");
    }
}

