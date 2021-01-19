package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner temp = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room Number: ");
			int roomNumber = temp.nextInt();		
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(temp.next());		
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(temp.next());
			
		
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: "+reservation);
			
			System.out.println();
			System.out.println("Digite os dados para atualizar reserva: ");								
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(temp.next());		
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(temp.next());			
			
			
			reservation.updateDates(checkIn, checkOut);		
			System.out.println("Reservation: "+reservation);
		}
		catch(ParseException e) {//Para tratar o erro do trecho: Date checkOut = sdf.parse(temp.next());
			System.out.println("Data inválida!");
		}
		catch(DomainException e) {
			System.out.println(e.getMessage());//Mostrando a mensagem lançada pelo método updateDates()
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		
		temp.close();

	}
 }	

