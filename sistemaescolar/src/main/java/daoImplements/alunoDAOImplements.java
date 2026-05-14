package daoImplements;

import dao.IAlunoDAO;
import database.SqlConn;
import model.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class alunoDAOImplements implements IAlunoDAO {
    @Override
    public void salvar(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, cpf, email, data_nascimento, telefone) VALUES (?,?,?,?,?) ";

        try (Connection conn = SqlConn.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getEmail());
            stmt.setDate(4, Date.valueOf(aluno.getData_nascimento()));
            stmt.setString(5, aluno.getTelefone());


            ResultSet chavepk = stmt.getGeneratedKeys();

            if (chavepk.next()){
                aluno.setId(chavepk.getInt(1));
            }

            stmt.executeUpdate();
            System.out.println("Aluno cadastrado com sucesso");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar aluno" + e.getMessage());
        }


    }

    @Override
    public List<Aluno> listartodosAlunos() {
        List<Aluno>alunos=new ArrayList<>();
        String sql="SELECT * FROM aluno ";
        try (Connection conn = SqlConn.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                alunos.add(new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("telefone")
                ));
            }

        } catch (SQLException e){
            System.out.println("Erro ao listar os alunos: " + e.getMessage());
        }
        return alunos;
    }

    @Override
    public Optional<Aluno> bucarPorId(int id) {
        String sql = "SELECT * FROM aluno WHERE id = ?";


        try (Connection conn = SqlConn.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                Aluno aluno = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("telefone")

                );
            }
        } catch (SQLException ex){
            System.out.println("Erro ao buscar aluno" + ex.getMessage());
        }return Optional.empty();
    }



    @Override
    public void atualizarAluno(Aluno aluno) {
        String sql = "UPDATE aluno SET nome = ?, email = ? , telefone = ? WHERE id = ?";

        try (Connection conn = SqlConn.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1,aluno.getNome());
            stmt.setString(2,aluno.getEmail());
            stmt.setString(3,aluno.getTelefone());
            stmt.setInt(4,aluno.getId());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void excluirAluno(int id) {
        String sql = "DELETE FROM aluno WHERE id = ?";

        try (Connection conn = SqlConn.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1,id);


            if (stmt.executeUpdate() == 0){
                System.out.println("Erro ao deletar aluno");
            }

            stmt.executeUpdate();

            System.out.println("Aluno excluido com sucesso! ");

        }catch (SQLException ex){
            System.err.println("Erro ao excluir aluno" + ex.getMessage());
        }

    }

    @Override
    public Optional<Aluno> busvarPorID(int id) {
        return Optional.empty();
    }
}