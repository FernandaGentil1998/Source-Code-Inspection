package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.core.PapelMoeda;
import br.calebe.ticketmachine.core.TicketMachine;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 31620221
 */
public class index {

    public static void main(String[] args) throws PapelMoedaInvalidaException, SaldoInsuficienteException {
        TicketMachine ticketMachine = new TicketMachine(10);
        JOptionPane.showMessageDialog(null,"Selecione uma opcao do Ticket Machine:\n"+
        "1)Inserir\n"+
       "2)Imprimir\n"+
        "3)Troco\n"+
        "4)Sair");
        int x = Integer.parseInt(JOptionPane.showInputDialog("MENU"));
        do {
            switch (x) {
                case 1:
                    int valor = 0;
                    JOptionPane.showMessageDialog(null,"Quanto deseja inserir?" + valor);
                    valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor da nota a ser inserido: "));
                    ticketMachine.inserir(valor);
                    JOptionPane.showMessageDialog(null,ticketMachine.getSaldo());
                    if(ticketMachine.getSaldo() == 0){
                        JOptionPane.showMessageDialog(null,"Insira uma nota existente");
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,"Imprimir ticket:" + ticketMachine.getValor());
                    if(ticketMachine.getSaldo() != 0){
                    JOptionPane.showMessageDialog(null,ticketMachine.imprimir());
                    }else{
                        JOptionPane.showMessageDialog(null,"Voce nao tem saldo");
                    }
                    break;
                case 3:
                    int trocoValor = 0;
                    JOptionPane.showMessageDialog(null,"Troco da compra:" + trocoValor);
                    trocoValor = Integer.parseInt(JOptionPane.showInputDialog("Troco: "));
                    ticketMachine.getTroco();
                    JOptionPane.showMessageDialog(null,ticketMachine.getTroco());
                    break;
                case 4:
                    break;
            }
            if (x != 4) {
                JOptionPane.showMessageDialog(null, "Selecione uma opcao do Ticket Machine: \n"+
                  "1)Inserir\n"+
                "2)Imprimir\n"+
                "3)Troco\n"+
                "4)Sair");
                x = Integer.parseInt(JOptionPane.showInputDialog("MENU"));
            }
        } while (x != 4);
    }
}
