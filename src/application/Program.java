package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner temp = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room Number: ");
		int roomNumber = temp.nextInt();
		
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(temp.next());
		
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(temp.next());
		
		if(!checkOut.after(checkIn)) {//Analisando se a data checkOut é depois de checkIn.
			System.out.println("Erro na reserva!");
			System.out.println("Data do final da reserva não pode ser antes da data do início!");
		}
		else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: "+reservation);
			
			System.out.println();
			System.out.println("Digite os dados para atualizar reserva: ");
									
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(temp.next());
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(temp.next());			
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva!");
				System.out.println("As datas para atualização da reserva, precisam ser futuras!");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva!");
				System.out.println("Data do final da reserva não pode ser antes da data do início!");
			}
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: "+reservation);
		}
		
		
		temp.close();

	}
  }	
}
