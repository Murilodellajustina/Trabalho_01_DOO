
package trabalho1_doo;

// Importaçoes de classes existentes na biblioteca do Java, para poder fazer os calculos.
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculadoraPorDUM extends CalculadoraGestacao {

    //construtor
    public CalculadoraPorDUM(LocalDate dum) {
        super(dum);
    }
    
    //esta implemetando a funçao que vem como obrigatoriedade da Interface, e aplicando polimorfismo
@Override
public String calcular() {
    LocalDate hoje = LocalDate.now();

    // Valida se a DUM é no futuro
    if (dataBase.isAfter(hoje)) {
        throw new DataInvalidaException("Data da última menstruação não pode ser no futuro!");
    }

    // Valida se a gestação ultrapassa 50 semanas (350 dias)
    long dias = ChronoUnit.DAYS.between(dataBase, hoje);
    if (dias > 350) {
        throw new DataInvalidaException("A gestação não pode ultrapassar 50 semanas!");
    }
    // caso esteja tudo certo, calcula as semanas
    else{
    long semanas = dias / 7;
    long diasRestantes = dias % 7;

    return "Gestação atual: " + semanas + " semana(s) e " + diasRestantes + " dia(s).";
        }
    }

}

