package model;

import java.time.LocalDate;

public class Aluno {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private LocalDate data_nascimento;
    private String telefone;

    //construtor para criar novo aluno
    public Aluno(String nome, String cpf, String email, LocalDate data_nascimento, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
    }


    //Construtor para leitura o banco(id ja exitente)
    public Aluno(int id, String nome, String cpf, String email, LocalDate data_nascimento, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString(){
        return String.format(
                "Aluno: id=%d - nome=%s - cpf=%s - email=%s - nascimento =%s - telefone =%s",
                id,nome, cpf, email, data_nascimento, telefone
        );
    }
}