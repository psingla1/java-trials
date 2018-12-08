package restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {

	private final String resturantNumber;
	private final String restaurantName;
	private final String restaurantContact;
	private final Address address;
	private final Menu menu;
	private final List<Reservation> reservations;
	private final List<Table> tables;
	private final Map<Integer, Table> reservationTableRelation;

	public Restaurant(String resturantNumber, String restaurantName, String restaurantContact, Address address,
			Menu menu, List<Table> tables) {
		this.resturantNumber = resturantNumber;
		this.restaurantName = restaurantName;
		this.restaurantContact = restaurantContact;
		this.address = address;
		this.menu = menu;
		this.tables = tables;
		this.reservations = new ArrayList<>();
		this.reservationTableRelation = new HashMap<>();
	}

	public String getResturantNumber() {
		return resturantNumber;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public String getRestaurantContact() {
		return restaurantContact;
	}

	public Address getAddress() {
		return address;
	}

	public Menu getMenu() {
		return menu;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public List<Table> getTables() {
		return tables;
	}

	/**
	 * Book a table for a given
	 * 
	 * @param reservation
	 * @return
	 */
	public boolean addReservation(Reservation reservation) {
		if (reservationTableRelation.containsKey(reservation.getReservationId())) {
			return false;
		}

		for (Table table : tables) {
			if (table.tryReserveTable(reservation)) {
				reservationTableRelation.put(reservation.getReservationId(), table);
				reservations.add(reservation);
				return true;
			}
		}
		return false;
	}

	/**
	 * Finds the reserved table by firstName and lastName.
	 * 
	 * @param firstName First name the reservation is under.
	 * @param lastName  Last name the reservatio is under.
	 * @return The reserved table, or null if no table is reserved.
	 */
	public Table getReservedTable(String firstName, String lastName) {
		Reservation reservation = getReservationByName(firstName, lastName);
		if (reservation == null) {
			return null;
		}
		return reservationTableRelation.get(reservation.getReservationId());
	}

	// Add functionality to get a reservation.
	public Reservation getReservationById(int id) {
		for (Reservation reservation : reservations) {
			int reservationId = reservation.getReservationId();
			if (id == reservationId) {
				return reservation;
			}
		}
		System.out.println("Sorry we didnt find any reservation");
		return null; // TODO: We can use Optional
	}

	public Reservation getReservationByName(String firstname, String lastName) {
		for (Reservation reservation : reservations) {
			String reservationFirstName = reservation.getReservationFirstName();
			String reservationLastName = reservation.getReservationLastName();
			if (firstname.equals(reservationFirstName) && lastName.equals(reservationLastName)) {
				return reservation;
			}
		}
		System.out.println("Sorry we didnt find any reservation");
		return null;
	}

	// Add functionality to checkout -- basically delete a reservation.
}
