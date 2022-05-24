package com.company;

import java.util.LinkedList;

public class GabineteProfessor extends Divisao{
    private LinkedList<Professor> professores;
    //private boolean aberta;

    public GabineteProfessor(String nome, boolean aberta) {
        super(nome,aberta);
        professores = new LinkedList<>();
    }

    public LinkedList<Professor> getProfessores() {
        return new LinkedList<>(professores);
    }

    /*public boolean isAberta() {
        return aberta;
    }

    public void abrir(){
        //todo
    }

    public void fechar(){
        //todo
    }
*/

    public void adicionar(Professor professor){
        if(professor == null || professores.contains(professor)){
            return;
        }
        professores.add(professor);
        professor.setGabinete(this);
    }

    public void remover(Professor professor){
        if(!professores.contains(professor)){
            return;
        }
        professores.remove(professor);
        professor.desassociarGabinete();
    }

}
