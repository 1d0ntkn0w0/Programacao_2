package com.company;

import java.util.LinkedList;

public interface funcionario {
    LinkedList<Horario>getHorariosAtendimento();
    void abrirGabinete();
    void fecharGabinete();
    void desassociarGabinete();

    void adicionar(Horario horario);

    void remover(Horario horario);
}
