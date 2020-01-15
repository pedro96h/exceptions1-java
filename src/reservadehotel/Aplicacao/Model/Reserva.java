/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservadehotel.Aplicacao.Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author pedro
 */
public class Reserva {
    private Integer numeroDoQuarto;
    private Date checkIn;
    private Date CheckOut;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numeroDoQuarto, Date checkIn, Date CheckOut) {
        this.numeroDoQuarto = numeroDoQuarto;
        this.checkIn = checkIn;
        this.CheckOut = CheckOut;
    }

    public Integer getNumeroDoQuarto() {
        return numeroDoQuarto;
    }

    public void setNumeroDoQuarto(Integer numeroDoQuarto) {
        this.numeroDoQuarto = numeroDoQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return CheckOut;
    }
        
    public Long duracao(){
        long dif = CheckOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
        //essa classe "TimeUnit" converte tempos //
    }
    
    public void atualizarData (Date checkIn, Date checkOut){
        this.checkIn = checkIn;
        this.CheckOut = checkOut;
    }

    @Override
    public String toString() {
        return "quarto "
                + numeroDoQuarto
                +", check-in "
                +sdf.format(checkIn)
                +", check-out "
                +sdf.format(CheckOut)
                +", por "
                +duracao()
                +" dias ";
    }
    
}
