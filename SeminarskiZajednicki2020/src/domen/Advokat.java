/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rados
 */
public class Advokat extends OpstiDomenskiObjkat implements Serializable {

    private int advokatID;
    private String jmbg;
    private String ime;
    private String prezime;
    private String ulica;
    private String broj;
    private String kontaktTelefon;
    private String korisnickoIme;
    private String lozinka;
    private Prebivaliste prebivaliste;
   

    public Advokat() {
    }


    public Advokat(int advokatID, String jmbg, String ime, String prezime, String ulica, String broj, String kontaktTelefon, String korisnickoIme, String lozinka, Prebivaliste prebivaliste) {
        this.advokatID = advokatID;
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.ulica = ulica;
        this.broj = broj;
        this.kontaktTelefon = kontaktTelefon;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.prebivaliste = prebivaliste;
        
    }


   

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Prebivaliste getPrebivaliste() {
        return prebivaliste;
    }

    public void setPrebivaliste(Prebivaliste prebivaliste) {
        this.prebivaliste = prebivaliste;
    }

    @Override
    public String vratiImeTabele() {
        return "advokat";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%d','%s','%s','%s','%s','%s','%s','%s','%s','%d'", advokatID, jmbg, ime, prezime, ulica, broj, kontaktTelefon, korisnickoIme, lozinka, prebivaliste.getPrebivalisteID());
    }

    @Override
    public String vratiPk() {
        return "advokatID";
    }

    @Override
    public int vratiVrednostPK() {
        return advokatID;
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getAdvokatID() {
        return advokatID;
    }

    public void setAdvokatID(int advokatID) {
        this.advokatID = advokatID;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public ArrayList<OpstiDomenskiObjkat> RSuTabelu(ResultSet rs) {
        ArrayList<OpstiDomenskiObjkat> advokati = new ArrayList<>();
        try {
            while (rs.next()) {
                int advokatID = rs.getInt("AdvokatID");
                String jmbg = rs.getString("JMBG");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                String ulica = rs.getString("Ulica");
                String broj = rs.getString("Broj");
                String kontaktTelefon = rs.getString("KontaktTelefon");
                String korisnickoIme = rs.getString("KorisnickoIme");
                String lozinka = rs.getString("Lozinka");

                Prebivaliste prebivaliste = new Prebivaliste();
                prebivaliste.setPrebivalisteID(rs.getInt("PrebivalisteID"));

              

                Advokat advokat = new Advokat(advokatID, jmbg, ime, prezime, ulica, broj, kontaktTelefon, korisnickoIme, lozinka, prebivaliste);
                advokati.add(advokat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Advokat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return advokati;
    }

    @Override
    public OpstiDomenskiObjkat vratiObjekat(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String alijas() {
        return "a";
    }

    @Override
    public String update() {
       return String.format("Ime='%s',Prezime='%s',Ulica='%s', Broj='%s', KontaktTelefon='%s',PrebivalisteID='%d'", ime, prezime, ulica, broj, kontaktTelefon, prebivaliste.getPrebivalisteID());
    }

    @Override
    public String vratiKriterijumPretrage() {
        return "";
    }

    @Override
    public String vratiJoinUslov() {
        return "";
    }

    @Override
    public String vratiWhereUslov(String pretraga) {
        return "";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.advokatID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Advokat other = (Advokat) obj;
        if (this.advokatID != other.advokatID) {
            return false;
        }
        return true;
    }

}
