package daoImplements;

import dao.ITurmaDAO;
import database.SqlConn;
import model.Aluno;
import model.Turma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class turmaDAOimplements implements ITurmaDAO {
    @Override
    public List<Turma> listarTodasTurmas() {
        String sql = "SELECT * FROM turma ORDER BY turno DESC, nome ASC";
        List<Turma> turmasEncontradas = new ArrayList<>();

        try(Connection conn = SqlConn.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);

                    ResultSet rs = stmt.executeQuery();

                    while (rs.next()){
                        turmasEncontradas.add(new Turma(
                                rs.getInt("id"),
                                rs.getInt("insituicao_id"),
                                rs.getInt("professor_id"),
                                rs.getString("nome"),
                                rs.getInt("ano_letivo"),
                                rs.getString("turno"),
                                rs.getInt("vagas")
                        ));
                    }

        }catch (SQLException ex){
            System.err.println("Erro ao listar todas as turmas: " + ex.getMessage());
        }
        return turmasEncontradas;
    }

    @Override
    public List<Aluno> listarAlunosPorTurmaId(int idTurma) {
        String sql = "Select a.*" +
                "FROM matricula m" +
                "INNER JOIN a ON m.idAluno = a.idAluno" +
                "WHERE m.turma_id = ?" +
                "ORDER BY a.nome ASC";

        List<Aluno> alunosEncontrados = new ArrayList<>();

        try(Connection conn = SqlConn.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,idTurma);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                alunosEncontrados.add(new Aluno(
                                rs.getInt("idAluno"),
                                rs.getString("nome"),
                                rs.getString("cpf"),
                                rs.getString("email"),
                                rs.getDate("data_nascimento").toLocalDate(),
                                rs.getString("turno")


                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todos os alunos: " + e.getMessage());

        }
        return alunosEncontrados;
    }
}

