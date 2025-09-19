import com.group.cliente.Pessoa;
import com.group.jogos.MortalKombat;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Kauan Kelvin", "Masculino", 19);
        MortalKombat mk = new MortalKombat();
        p1.comprarCredito(20);
        mk.jogar(p1);
    }
}