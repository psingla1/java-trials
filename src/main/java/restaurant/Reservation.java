package restaurant;

import java.time.Instant;

public class Reservation {
	
	private final int reservationId;
	private final String reservationFirstName;
	private final String reservationLastName;
	private final Instant reservationTime;
	private final int partyOf;
	
	public Reservation(int reservationId, String reservationFirstName, String reservationLastName,
			// A table is reserved for 1 hr after being reserved.
			Instant reservationTime, int partyOf) {
		super();
		this.reservationId = reservationId;
		this.reservationFirstName = reservationFirstName;
		this.reservationLastName = reservationLastName;
		this.reservationTime = reservationTime;
		this.partyOf = partyOf;
	}
	
	public int getReservationId() {
		return reservationId;
	}

	public Instant getReservationTime() {
		return reservationTime;
	}

	public String getReservationFirstName() {
		return reservationFirstName;
	}

	public String getReservationLastName() {
		return reservationLastName;
	}

	public int getPartyOf() {
		return partyOf;
	}
	
}
