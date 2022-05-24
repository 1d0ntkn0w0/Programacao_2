package com.company;

public abstract class Divisao extends Descritor{
    protected boolean aberta;

    public Divisao(String nome, boolean aberta) {
        super(nome);
        this.aberta = aberta;
    }

    public Divisao(String nome){
        this(nome, false);
    }

    public boolean isAberta() {
        return aberta;
    }

    public void abrir(){
        aberta = true;
    }

    public void fechar(){
        aberta = false;
    }
}
