package reservadehotel.Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import reservadehotel.Aplicacao.Model.Reserva;




public class ReservaDeHotel {

    public static void main(String[] args) throws ParseException {
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("numero do quarto: ");
        int num = sc.nextInt();
        System.out.print("digite a data de check in : ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("digite a data de check out : ");
        Date checkOut = sdf.parse(sc.next());
        
        if(!checkOut.after(checkIn)){
            System.out.println("erro na reserva: data de check out inferior a data de check in");
        } else {
            Reserva reserva = new Reserva(num, checkIn, checkOut);
            System.out.println("reserva : "+reserva.toString());
            
            System.out.println("\nentre com as datas da atualizacao da reserva");
            System.out.print("data de check in (dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("data de check out (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());
            
            Date now = new Date();
            
            if(checkIn.before(now) || checkOut.before(now)){
                System.out.println("as datas de atualizacao devem ser posterior a data atual");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("erro na reserva: data de check out inferior a data de check in");
            } else {
                reserva.atualizarData(checkIn, checkOut);
                System.out.println("reserva : "+reserva.toString());
            }         
        }
        
        sc.close();
    }
    
}
