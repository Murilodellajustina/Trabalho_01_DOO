/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho1_doo;

public class DataInvalidaException extends RuntimeException {
    // tratamento de excessao
    public DataInvalidaException(String mensagem) {
        super(mensagem);
    }
}