package dao;

import model.Aluno;
import model.Turma;

import java.util.List;

public interface ITurmaDAO {
    List<Turma> listarTodasTurmas();

    List<Aluno> listarAlunosPorTurmaId(int idTurma);
}
