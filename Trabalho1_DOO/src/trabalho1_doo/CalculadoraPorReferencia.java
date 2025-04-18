/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho1_doo;

// Importaçoes de classes existentes na biblioteca do Java, para poder fazer os calculos.
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculadoraPorReferencia extends CalculadoraGestacao {
    private int semanasInformadas;
    private int diasInformados;
    
    // construtor
    public CalculadoraPorReferencia(LocalDate dataReferencia, int semanas, int dias) {
        super(dataReferencia);
        this.semanasInformadas = semanas;
        this.diasInformados = dias;
    }
//esta implemetando a funçao que vem como obrigatoriedade da Interface, e aplicando polimorfismo
@Override
public String calcular() {
    LocalDate hoje = LocalDate.now();

    // Calcula a data estimada da DUM
    int totalDias = (semanasInformadas * 7) + diasInformados;
    LocalDate dumEstimada = dataBase.minusDays(totalDias);

    // Valida se a gestação ultrapassa 50 semanas (350 dias)
    long dias = ChronoUnit.DAYS.between(dumEstimada, hoje);
    if (dias > 350) {
        throw new DataInvalidaException("A gestação não pode ultrapassar 50 semanas!");
    }
    // caso esteja tudo certo, calcula as semanas
    else{
    long semanas = dias / 7;
    long diasRestantes = dias % 7;

    return "Gestação atual baseada na referência: " + semanas + " semana(s) e " + diasRestantes + " dia(s).";
    }
    }
}

