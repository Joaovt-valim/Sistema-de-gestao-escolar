package daoImplements;

import dao.IAlunoDAO;
import database.SqlConn;
import database.SqlConn;
import model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class alunoDAOImplements implements IAlunoDAO {
    @Override
    public void salvar(Aluno aluno) {

    }

    @Override
    public List<Aluno> listartodosAlunos() {
        List<Aluno>alunos=new ArrayList<>();
        String sql="SELECT * FROM aluno ORDER BY ASC";
        try (Connection conn = SqlConn.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                alunos.add(new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getDate("data_nascimeto").toLocalDate(),
                        rs.getString("telefone")
                ));
            }

        } catch (SQLException e){
            System.out.println("Erro ao listar os alunos: " + e.getMessage());
        }
        return alunos;
    }

    public static void main(String[] args) {
        
    }

    @Override
    public void atualizarAluno(Aluno aluno) {

    }

    @Override
    public void excluirAluno(int id) {

    }
}