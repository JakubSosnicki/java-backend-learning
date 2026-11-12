import java.time.LocalDate;

void main(String[] args) {

    ReservationSystem reservationSystem = new ReservationSystem();
    reservationSystem.addRoom(1,"Sala konferencyjna A1", 100);
    reservationSystem.addRoom(2, "Sala konferencyjna A2", 50);
    reservationSystem.addRoom(3, "Sala konferencyjna A3", 30);

    if(reservationSystem.isAvailable(1, LocalDate.of(2026,11,20))){
        System.out.println("Room is available");
    } else {
        System.out.println("Room is taken");
    }

    reservationSystem.reserveRoom(1, LocalDate.of(2026,11,20));
    if(reservationSystem.isAvailable(1, LocalDate.of(2026,11,20))){
        System.out.println("Room is available");
    } else {
        System.out.println("Room is taken");
    }

    reservationSystem.cancelReservation(1, LocalDate.of(2026,11,20));
    if(reservationSystem.isAvailable(1, LocalDate.of(2026,11,20))){
        System.out.println("Room is available");
    } else {
        System.out.println("Room is taken");
    }
 }
