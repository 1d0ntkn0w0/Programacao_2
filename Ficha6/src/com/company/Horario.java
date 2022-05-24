package com.company;

public class Horario {
    private final DiaSemana diaSemana;
    private final int horaInicio;
    private final int duracao;


    public Horario(DiaSemana diaSemana, int horaInicio, int duracao) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.duracao = duracao;
    }


    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public int getDuracao() {
        return duracao;
    }

    public boolean isSobre(Horario horario){

//        if(h.getDiaSemana() == this.diaSemana && !(h.getHoraInicio() + h.getDuracao() <= this.getHoraInicio() || h.horaInicio >= this.getHoraInicio() + this.getDuracao())){
//
//            return true;
//
//        }
//
//        return false;


        if(horario == null){
            return false;
        }


        int horaFimThis = this.horaInicio + this.duracao;
        int horaFimHorario = horario.horaInicio + horario.duracao;


        if(this.diaSemana != horario.diaSemana){
            return false;
        }

        if(this.horaInicio >= horaFimHorario ){

            return false;
        }

        if(horaFimThis <= horario.horaInicio){
            return false;
        }

        //System.out.println("Os dias da semana são iguais!");

        return true;

    }
}
