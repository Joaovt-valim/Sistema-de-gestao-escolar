package org.example;

import daoImplements.alunoDAOImplements;
import database.SqlConn;
import database.SqlConn;
import model.Aluno;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
        SqlConn.testarContection();

        alunoDAOImplements alunoDaoMethods = new alunoDAOImplements();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Cadastrar Aluno ");
            System.out.println("2. Atualizar Aluno ");
            System.out.println("3. Excluir Aluno ");
            System.out.println("4. Listar Aluno");
            System.out.println("5. Procurar Aluno por Id");
            System.out.println("0. Sair do programa ");

            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Cadastro de Aluno");

                    System.out.println("Nome Aluno: ");
                    String nome = scanner.next();

                    System.out.println("cpf");
                    String cpf = scanner.next();

                    System.out.println("Email");
                    String email = scanner.next();

                    System.out.println("Data de nacimento");
                    LocalDate dataNascimento;
                    try {
                        dataNascimento = LocalDate.parse(scanner.next());
                    } catch (Exception e) {
                        throw new RuntimeException("Erro de data. Tente novamente no formato: aaaa-mm-dd");
                    }

                    System.out.println("Telefone: ");
                    String telefone= scanner.next();
                    Aluno alunoNovo = new Aluno(nome, cpf, email, dataNascimento, telefone);

                    alunoDaoMethods.salvar(alunoNovo);

                    break;
                case 2:
                    System.out.println("Informe o id para atualizar o aluno");

                    for (Aluno listaAluno : alunoDaoMethods.listartodosAlunos()){
                        System.out.println(listaAluno);
                    }
                    int alunoid = scanner.nextInt();

                    Optional<Aluno> alunoEncontrado = alunoDaoMethods.bucarPorId(alunoid);

                    if (alunoEncontrado.isPresent()){
                        System.out.println("Novo nome: ");
                        String novoNome = scanner.next();
                        alunoEncontrado.get().setNome(novoNome);

                        System.out.println("Novo Email: ");

                        System.out.println("Novo telefone: ");

                        System.out.println("Aluno atualizado com sucesso");
                       
                    }





                    break;
                case 3:
                    System.out.println("Excluir Aluno");
                    for (Aluno listaAluno : alunoDaoMethods.listartodosAlunos()){
                        System.out.println(listaAluno);
                    }

                    System.out.println("Qual id deseja excluir? ");
                    int id = scanner.nextInt();

                    alunoDaoMethods.excluirAluno(id);
                    break;
                case 4:
                    System.out.println("Listar Alunos");

                    List<Aluno> todosAlunos = alunoDaoMethods.listartodosAlunos();

                    if (todosAlunos.isEmpty()){
                        System.out.println("Nenhum aluno encontrado");

                    } else {
                        for (Aluno aluno : todosAlunos){
                            System.out.println(aluno);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Procurar por aluno por id");

            }
        } while (opcao != 0);




    }
}
