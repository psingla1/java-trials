package restaurant;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Table {
	private final String tableType;
	private final int numOfSeatings;
	private final List<Reservation> reservations;
	
	public Table(String tableType, int numOfSeatings) {
		this.tableType = tableType;
		this.numOfSeatings = numOfSeatings;
		this.reservations = new ArrayList<>();
	}
	
	public String getTableType() {
		return tableType;
	}

	public int getNumOfSeatings() {
		return numOfSeatings;
	}
	
	public boolean tryReserveTable(Reservation reservation) {
		if (numOfSeatings < reservation.getPartyOf()) {
			return false;
		}
		
		Instant newReservationTime = reservation.getReservationTime();
		Instant conflictStartTime = newReservationTime.minus(59, ChronoUnit.MINUTES);
		Instant conflictEndTime = newReservationTime.plus(59, ChronoUnit.MINUTES);
		
		for (Reservation r : reservations) {
			Instant reservationTime = r.getReservationTime();
			if (reservationTime.isBefore(conflictEndTime) && reservationTime.isAfter(conflictStartTime)) {
				return false;
			}
		}
		reservations.add(reservation);
		return true;
	}
}
