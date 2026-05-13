package dao;
import model.Aluno;

import java.util.List;
import java.util.Optional;


public interface IAlunoDAO {
    //Crud
    //c->Create
    void salvar(Aluno aluno);

    //r->reade

    List<Aluno>listartodosAlunos();


    //u-update

    Optional<Aluno> bucarPorId(int id);

    void atualizarAluno(Aluno aluno);

    //D->delete

    void excluirAluno(int id);
    Optional<Aluno> busvarPorID (int id);
}