/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservadehotel.Aplicacao.Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import reservadehotel.Aplicacao.execao.DomainException;

/**
 *
 * @author pedro
 */
public class Reserva {
    private Integer numeroDoQuarto;
    private Date checkIn;
    private Date CheckOut;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numeroDoQuarto, Date checkIn, Date checkOut) throws DomainException {
         if (!checkOut.after(checkIn)) {
            throw new DomainException ("erro na reserva: data de check out inferior a data de check in");
        } 
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
    
    public void atualizarData (Date checkIn, Date checkOut) throws DomainException{
        Date now = new Date();
            
        if(checkIn.before(now) || checkOut.before(now)){
            throw new DomainException("as datas de atualizacao devem ser posterior a data atual");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException ("erro na reserva: data de check out inferior a data de check in");
        } 
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
