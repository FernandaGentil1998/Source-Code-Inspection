package br.calebe.ticketmachine.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 31620221
 */
class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        {
        papeisMoeda = new PapelMoeda[6];
        int count = 0;
        while (valor % 100 != 0) {
            count++;
        }
        papeisMoeda[5] = new PapelMoeda(100, count);
        count = 0;  
        while (valor % 50 != 0) {
            count++;
        }
        papeisMoeda[4] = new PapelMoeda(50, count);
        count = 0;
        while (valor % 20 != 0) {
            count++;
        }
        papeisMoeda[3] = new PapelMoeda(20, count);
        count = 0;
        while (valor % 10 != 0) {
            count++;
        }
        papeisMoeda[2] = new PapelMoeda(10, count);
        count = 0;
        while (valor % 5 != 0) {
            count++;
        }
        papeisMoeda[1] = new PapelMoeda(5, count);
        count = 0;
        while (valor % 2 != 0) {
            count++;
        }
        papeisMoeda[1] = new PapelMoeda(2, count);
        }
        this.setPapeisMoeda(papeisMoeda);
    }
    
    public List<PapelMoeda> getValorQtd() {
        PapelMoeda ret = null;
        List<PapelMoeda> listQtdValor = new ArrayList();
        for (int i = 5; i >= 0; i--) {
            if (this.papeisMoeda[i] != null) {
                ret = new PapelMoeda(this.papeisMoeda[i].getValor(), this.papeisMoeda[i].getQuantidade());
                listQtdValor.add(ret);
                ret = null;
            }
        }
        return listQtdValor;
    }

    private void setPapeisMoeda(PapelMoeda[] papeisMoeda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}