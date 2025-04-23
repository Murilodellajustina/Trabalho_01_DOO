/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalho1_doo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Lista para armazenar o histórico
        List<String> historico = new ArrayList<>();
        String input = null;
        do{
        System.out.println("Escolha o tipo de cálculo:");
        System.out.println("1 - Por DUM");
        System.out.println("2 - Por Data de Referência");

        int opcao = entrada.nextInt();
        entrada.nextLine(); // Consumir o \n

        ICalculadora calculadora; /* está declarando uma variável chamada calculadora do tipo ICalculadora. 
        Essa variável será usada mais tarde para referencia um objeto que implementa a interface ICalculadora.
        */
        
        // Define o formato de data esperado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        if (opcao == 1) {
            System.out.println("Informe a DUM (DD-MM-AAAA):");
            String dumStr = entrada.nextLine();
            LocalDate dum = LocalDate.parse(dumStr, formatter);  // Converte a data para o formato dd-mm-yyyy
            calculadora = new CalculadoraPorDUM(dum);
        } else if (opcao == 2) {
            System.out.println("Informe a data de referência (DD-MM-AAAA):");
            String dataRefStr = entrada.nextLine();
            LocalDate dataRef = LocalDate.parse(dataRefStr, formatter);  // Converte a data para o formato dd-mm-aaaa
            System.out.println("Informe as semanas:");
            int semanas = entrada.nextInt();
            System.out.println("Informe os dias:");
            int dias = entrada.nextInt();
            entrada.nextLine(); // Consome o \n que ficou no buffer
            calculadora = new CalculadoraPorReferencia(dataRef, semanas, dias);
        } else {
            System.out.println("Opção inválida.");
            entrada.close();
            return;
        }

        try {
            String resultado = calculadora.calcular();
            System.out.println(resultado);

            // Adiciona o resultado ao histórico
            historico.add(resultado);

            // Exibe o histórico
            System.out.println("\nHistórico de cálculos:");
            for (String registro : historico) {
                System.out.println(registro);
            }
            System.out.println("Deseja calcular a IG de uma nova paciente? ");
            input = entrada.nextLine();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        }while(input.equalsIgnoreCase("sim"));
    }
}
