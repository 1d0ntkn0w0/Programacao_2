package com.company;

import java.util.LinkedList;

public class Seguranca extends Pessoa {
    //private String nome;
    //private long numero;
    private GabineteSeguranca gabinete;
    private LinkedList<Horario> horariosAtendimento;

    public Seguranca(String nome, long numero, GabineteSeguranca gabineteSeguranca) {
        super(nome, numero);
        setGabinete(gabineteSeguranca);
        horariosAtendimento = new LinkedList<>();
    }

/*
    public String getNome() {
        return nome;
    }

    public long getNumero() {
        return numero;
    }
*/

    public GabineteSeguranca getGabinete() {
        return gabinete;
    }

    public LinkedList<Horario> getHorariosAtendimento() {
        return new LinkedList<>(horariosAtendimento);
    }

/*    public void setNumero(long numero) {
        this.numero = numero;
    }*/

    public void setGabinete(GabineteSeguranca gabinete) {
        if(gabinete== null || this.gabinete == gabinete){
            return;
        }
        desassociarGabinete();
        this.gabinete = gabinete;
        gabinete.adicionar(this);
    }

    public void abrirGabinete(){
        this.abrir(this.gabinete);
    }

    public void fecharGabinete(){
        this.fechar(this.gabinete);
    }


    public void abrir(Divisao divisao){
        if(divisao==null || divisao.isAberta()){
            return;
        }

        divisao.abrir();
    }

    public void fechar(Divisao divisao){
        if(divisao==null || !divisao.isAberta()){
            return;
        }
        divisao.fechar();
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

        horariosAtendimento.remove(horario);

    }

    public void desassociarGabinete() {
        if(this.gabinete==null){
            return;
        }

        GabineteSeguranca gabineteSegurancaARemover= gabinete;
        gabinete = null;

        gabineteSegurancaARemover.remover(this);
    }
}
