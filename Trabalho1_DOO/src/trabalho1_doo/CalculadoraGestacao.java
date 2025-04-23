/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho1_doo;

import java.time.LocalDate;

abstract class CalculadoraGestacao implements ICalculadora {
    protected LocalDate dataBase;
    
    public CalculadoraGestacao(LocalDate dataBase) {
        this.dataBase = dataBase;
    }
}
