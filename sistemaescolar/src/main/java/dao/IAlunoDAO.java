package dao;
import model.Aluno;

import java.util.List;


public interface IAlunoDAO {
    //Crud
    //c->Create
    void salvar(Aluno aluno);

    //r->reade

    List<Aluno>listartodosAlunos();


    //u-update

    void atualizarAluno(Aluno aluno);

    //D->delete

    void excluirAluno(int id);

}