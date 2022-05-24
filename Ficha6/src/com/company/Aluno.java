package com.company;

public class Aluno extends PessoaComAulas {

    //private LinkedList<Aula> aulas;

    public Aluno(String nome, long numero) {
        super(nome, numero);
    }

/*    @Override
    public void preencherSumario(Aula aula) {

        *//*if (aula == null || !aulas.contains(aula)) {
            return;
        }*//*
        super.preencherSumario(aula);
        aula.adicionarLinhaSumario(nome);
    }*/


    /*    @Override
    public void adicionar(Aula aula) {

*//*        if (aula == null || this.aulas.contains(aula)) {
            return;
        }*//*
        super.adicionar(aula);

        for (Aula al: this.aulas){

            if(al==aula && al.getHorario().isSobre(aula.getHorario())){
                this.aulas.add(aula);
                aula.adicionar(this);
                break;
            }
        }

    }*/

    @Override
    public void associar(Aula aula) {
        aula.adicionar(this);
    }

/*    @Override
    public void remover(Aula aula) {

        //if (!this.aulas.contains(aula)) {
        //    return;
        //}
        super.remover(aula);
        aula.remover(this);

    }*/

    @Override
    public void desassociar(Aula aula) {
        aula.remover(this);
    }

    /*    public LinkedList<Aula> getAulas() {

        return new LinkedList<>(aulas);
    }*/


  /*  public LinkedList<Aula> getAulas(Horario horario) {

        LinkedList<Aula> aulasAuxiliar = new LinkedList<>();

        int horaInicio = horario.getHoraInicio();
        int horarioFim = horaInicio + horario.getDuracao();
        DiaSemana diaSemana = horario.getDiaSemana();

        for (Aula aula : aulas) {
            */
/*if(aula.getHorario().getDiaSemana() == diaSemana){

                if(!(horarioFim <= aula.getHorario().getHoraInicio() || horaInicio >= aula.getHorario().getHoraInicio() + aula.getHorario().getDuracao())){
                    aulasAuxiliar.add(aula);

                }
            }*//*


            if (aula.getHorario().isSobre(horario)) {
                aulasAuxiliar.add(aula);
            }

            //CTRL * ALT + L -> formatar codigo
        }

        return aulasAuxiliar;
    }
*/

}
