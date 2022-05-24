package com.company;

import java.util.LinkedList;

public class Aula extends Identificador {

    private StringBuilder sumario;
    private Professor professor;
    private LinkedList<Aluno> alunos;
    private Horario horario;
    private Sala sala;

    public Aula(String nome,long numero,Horario horario,Sala sala){
        this(nome,numero, horario,sala ,null ,new LinkedList<>());

    }

    public Aula(String nome, long numero, Horario horario,Sala sala, Professor professor, LinkedList<Aluno> alunos){
        super(nome, numero);

        setProfessor(professor);
        this.alunos = new LinkedList<>();

        for(Aluno aluno : alunos){
            adicionar(aluno);

        }

        sumario = new StringBuilder();
        this.horario = horario;
        this.setSala(sala);
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        if(sala == null || this.sala == sala){
            return;
        }

        this.desassociarSala();

        this.sala = sala;

        sala.adicionar(this);
    }

    public String getSumario() {

        return sumario.toString();
    }

    public Professor getProfessor() {
        return professor;
    }

    public LinkedList<Aluno> getAlunos() {
        return new LinkedList<>(alunos);
    }

    public void setProfessor(Professor professor) {
        if(professor == null || this.professor == professor){
            return;
        }

        this.desassociarProfessor();

        this.professor = professor;

        professor.adicionar(this);
    }

//    ---
    public void desassociarProfessor(){

        if(this.professor == null){
            return;
        }

        Professor profRemover= this.professor;
        this.professor=null;
        profRemover.remover(this);
    }

    public void adicionar(Aluno aluno){

        if (aluno == null || this.alunos.contains(aluno)) {
            return;
        }

        this.alunos.add(aluno);
        aluno.adicionar(this);

    }

    public void remover(Aluno aluno){

        if(!this.alunos.contains(aluno)){
            return;
        }
        this.alunos.remove(aluno);
        aluno.remover(this);
    }

    public void adicionarLinhaSumario(String linhaSumario){

        //PROBLEMA: estar sempre a gerar strings novas (cerca de tres )
        //sumario += linhaSumario + '\n';

        sumario.append(linhaSumario).append('\n');

    }

    public Horario getHorario() {
        return horario;
    }

    public void desassociarSala() {
        if(this.sala == null){
            return;
        }

        Sala salaRemovida= this.sala;
        this.sala = null;
        salaRemovida.remover(this);
    }
}