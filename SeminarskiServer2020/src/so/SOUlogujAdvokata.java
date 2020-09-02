/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Advokat;
import domen.OpstiDomenskiObjkat;
import exception.ServerskiException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.Kontroler;

/**
 *
 * @author Rados
 */
public class SOUlogujAdvokata extends OpstaSistemskaOperacija {

    private OpstiDomenskiObjkat od;
    private Advokat advokat;
    private Advokat parametar;

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        try {
            advokat = db.ulogujAdvokata(parametar);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ServerskiException((ex.getMessage()));
        }
    }

    @Override
    protected void izvrsiValidaciju() {
        //TODO validacija
    }

    public Advokat getAdvokat() {
        return advokat;
    }

    public void setAdvokat(Advokat advokat) {
        this.advokat = advokat;
    }

    public Advokat getParametar() {
        return parametar;
    }

    public void setParametar(Advokat parametar) {
        this.parametar = parametar;
    }

}
