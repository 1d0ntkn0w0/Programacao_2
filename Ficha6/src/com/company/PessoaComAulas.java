package com.company;

import java.util.LinkedList;

public abstract class PessoaComAulas extends Pessoa implements RepositorioAulas,AssociavelAulas {

    //protected LinkedList<Aula> aulas;

    private GestorAulas gestorAulas;

    public PessoaComAulas(String nome, long numero) {
        super(nome, numero);
        //this.aulas = new LinkedList<>();
        gestorAulas = new GestorAulas(this);
    }

    @Override
    public LinkedList<Aula> getAulas() {

        return gestorAulas.getAulas();
    }

    @Override
    public LinkedList<Aula> getAulas(Horario horario) {

        return gestorAulas.getAulas(horario);
    }


    public void preencherSumario(Aula aula) {
        if (aula == null || !gestorAulas.contem(aula)) {
            return;
        }

        escreverSumario(aula);
    }

    protected void escreverSumario(Aula aula){
        aula.adicionarLinhaSumario(this.nome);

    }

    @Override
    public void adicionar(Aula aula) {

        gestorAulas.adicionar(aula);
        //associar(aula);
    }

    @Override
    public void remover(Aula aula){

        gestorAulas.remover(aula);
        //desassociar(aula);
    }

    public abstract void associar(Aula aula);

    public abstract void desassociar(Aula aula);

}
