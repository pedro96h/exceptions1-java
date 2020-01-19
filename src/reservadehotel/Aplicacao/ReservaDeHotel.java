package reservadehotel.Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import reservadehotel.Aplicacao.Model.Reserva;
import reservadehotel.Aplicacao.execao.DomainException;

public class ReservaDeHotel {

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            System.out.print("numero do quarto: ");
            int num = sc.nextInt();
            System.out.print("digite a data de check in : ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("digite a data de check out : ");
            Date checkOut = sdf.parse(sc.next());


            Reserva reserva = new Reserva(num, checkIn, checkOut);
            System.out.println("reserva : "+reserva.toString());

            System.out.println("\nentre com as datas da atualizacao da reserva");
            System.out.print("data de check in (dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("data de check out (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reserva.atualizarData(checkIn, checkOut);
            System.out.println("reserva : "+reserva.toString());
        } 
        catch(ParseException e){
            System.out.println("formato de dada invalido");
        }
        catch(DomainException e){
            System.out.println("Erro na reserva : "+e.getMessage());
        }
        catch(InputMismatchException e){
            System.out.println("dados de entrada invalidos ");
        } 
        catch (RuntimeException e){
            System.out.println("Erro inesperado ");
        }
        
        sc.close();
    }
    
}
