package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();
        Date checkInDate;
        Date checkOutDate;


            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkInDate = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOutDate = sdf.parse(sc.next());

            if (!checkOutDate.after(checkInDate)){
                System.out.println("Error in reservation: Check-out date must be after check-in date");

            } else {
                Reservation reservation = new Reservation(roomNumber, checkInDate, checkOutDate);
                System.out.println(reservation);

                System.out.println("\nEnter data to update the reservation:");
                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkInDate = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy): ");
                checkOutDate = sdf.parse(sc.next());

                Date now = new Date();
                if (checkInDate.before(now) || checkOutDate.before(now)){
                    System.out.println("Error in reservation: Reservation dates for update must be future dates");
                } else if (!checkOutDate.after(checkInDate)){
                    System.out.println("Error in reservation: Check-out date must be after check-in date");
                } else {
                    checkOutDate = sdf.parse(sc.next());
                    reservation.updateDates(checkInDate, checkOutDate);
                    System.out.println(reservation);
                }


            }





    }
}
