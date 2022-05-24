package com.company;

import java.util.LinkedList;

public class Professor extends PessoaComAulas implements funcionario {
    private GabineteProfessor gabinete;
    private LinkedList<Horario> horariosAtendimento;


    public Professor(String nome, long numero, GabineteProfessor gabinete) {
        super(nome, numero);
        setGabinete(gabinete);
        this.horariosAtendimento = new LinkedList<>();
    }

    @Override
    public LinkedList<Horario> getHorariosAtendimento() {
        return horariosAtendimento;
    }

    @Override
    public void preencherSumario(Aula aula){
        super.preencherSumario(aula);
    }

    @Override
    protected void escreverSumario(Aula aula) {
        aula.adicionarLinhaSumario(aula.getNome());
        //O melhor seria usar a segunda hipotese usando o LONG
        //aula.adicionarLinhaSumario(aula.getNumero() + "");
        aula.adicionarLinhaSumario(Long.toString(aula.getNumero()));
        super.escreverSumario(aula);

        for (Aluno aluno : aula.getAlunos()) {
            aluno.preencherSumario(aula);
        }
    }

/*    @Override
    public void adicionar(Aula aula) {

        //if (aula == null || this.aulas.contains(aula)) {
        //    return;
        //}

        //this.aulas.add(aula);
        super.adicionar(aula);
        aula.setProfessor(this);
    }*/

    @Override
    public void associar(Aula aula) {
        aula.setProfessor(this);
    }

    @Override
    public void desassociar(Aula aula) {
        aula.desassociarProfessor();
    }

    public GabineteProfessor getGabinete() {
        return gabinete;
    }

    public LinkedList<Horario> getHorarioAtendimento() {
        return new LinkedList<>(horariosAtendimento);
    }

    public void abrirGabinete(){

        if(this.gabinete != null && !this.gabinete.isAberta()){
            this.gabinete.abrir();
        }

    }

    public void fecharGabinete(){
        if(this.gabinete != null && this.gabinete.isAberta()){
            this.gabinete.fechar();
        }

    }

    public void abrir(Sala sala){
        if(sala != null && !sala.isAberta() ){
            sala.abrir();
        }
    }

    public void fechar(Sala sala){
        if(sala != null && sala.isAberta() ){
            sala.fechar();
        }
    }

    public void setGabinete(GabineteProfessor gabinete){
        if(gabinete == null || this.gabinete == gabinete){
            return;
        }

        desassociarGabinete();
        this.gabinete = gabinete;
        gabinete.adicionar(this);
    }

    public void desassociarGabinete(){
        if(this.gabinete == null){
            return;
        }

        GabineteProfessor gabineteProfessorRemover = this.gabinete;

        this.gabinete=null;

        gabineteProfessorRemover.remover(this);
    }

    public void adicionar(Horario horario){
        if(horario==null){
            return;
        }

        for (Horario horario1 : horariosAtendimento) {
            if(horario.isSobre(horario1)){
                return;
            }
        }
        horariosAtendimento.add(horario);
    }

    public void remover(Horario horario){
        if(horario==null){
            return;
        }

        horariosAtendimento.remove(horario);    }
}
