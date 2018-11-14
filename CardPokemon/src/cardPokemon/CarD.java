/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardPokemon;

/**
 *
 * @author jessi
 */
public class CarD {
    
    private static int id = 0;
    private int idCard;
    private int sPCard;
    private Pokemon pk;

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getsPCard() {
        return sPCard;
    }

    public void setsPCard(int sPCard) {
        this.sPCard = sPCard;
    }

    public Pokemon getPk() {
        return pk;
    }

    public void setPk(Pokemon pk) {
        this.pk = pk;
    }


    public CarD(String nome,String tipo) {
        
        
        if("Planta".equals(tipo))
            pk = new PkPlanta(nome);
        
        if("Agua".equals(tipo))
            pk = new PkAgua(nome);
        
        if("Fogo".equals(tipo))
            pk = new PkFogo(nome);
        
        if("Eletrico".equals(tipo))
            pk = new PkEletrico(nome);
        

        id++;
        
        this.idCard = id;
    }
    
    
    
}
