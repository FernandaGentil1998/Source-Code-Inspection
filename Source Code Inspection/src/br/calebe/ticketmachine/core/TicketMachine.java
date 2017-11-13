package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author 31620221
 */
public class TicketMachine {

    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[i] == quantia) {
                achou = true;
            }
        }
        if (!achou) {
            JOptionPane.showMessageDialog(null,"Não encontrou");
        } else {
            this.saldo += quantia;

        }
    }

    public int getValor() {
        return valor;
    }

    public int getSaldo() {
        return saldo;
    }

    public Iterator<Integer> getTroco() {
        return null;
    }

    public String imprimir() throws SaldoInsuficienteException {
        String result = "*****************\n";
        if (saldo < valor) {
            return "erro. \n O valor do TICKET (10) está menor do que o saldo inserido. Favor validar.";
        } else {
            this.saldo = saldo - valor;
            result += "\n *** R$ " + saldo + ",00 ****\n";
            result += "*****************\n";
            return result;
        }
        
    }
    
    public void retirar (int quantia) throws PapelMoedaInvalidaException{
           this.saldo = 0;
    }
}
