package com.company;

import java.util.LinkedList;

public class GabineteSeguranca extends Divisao {
    private LinkedList<Seguranca> segurancas;
    //private boolean aberta;

    public GabineteSeguranca(String nome, boolean aberta) {
        super(nome,aberta);
        segurancas = new LinkedList<>();
    }

    public LinkedList<Seguranca> getSegurancas() {
        return new LinkedList<>(segurancas);
    }

/*
    public boolean isAberta() {
        return aberta;
    }

    public void abrir(){
        //todo
    }

    public void fechar(){
        //todo
    }
*/

    public void adicionar(Seguranca seguranca){
        if (seguranca == null || this.segurancas.contains(seguranca)) {
            return;
        }

        this.segurancas.add(seguranca);
        seguranca.setGabinete(this);
    }

    public void remover(Seguranca seguranca){
        if(!this.segurancas.contains(seguranca)){
            return;
        }
        this.segurancas.remove(seguranca);
        seguranca.desassociarGabinete();
    }

}
