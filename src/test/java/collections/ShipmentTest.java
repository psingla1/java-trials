package collections;

import static collections.ProductFixtures.door;
import static collections.ProductFixtures.floorPanel;
import static collections.ProductFixtures.window;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ShipmentTest {
	private Shipment shipment = new Shipment();
	
	@Test
	public void shouldAddItems() throws Exception {
		shipment.add(door);
		shipment.add(window);
		
		assertThat(shipment, containsInAnyOrder(door,window));
	}
	
	@Test
	public void shouldReplaceItems() throws Exception {
		shipment.add(door);
		shipment.add(window);
		shipment.replace(door, floorPanel); //never added door
		
		assertThat(shipment, containsInAnyOrder(window, floorPanel));
	}
	
	@Test
	public void shouldIdentifyVanRequirements() throws Exception {
		shipment.add(door);
		shipment.add(window);
		shipment.add(floorPanel);
		
		shipment.prepare();
		
		assertThat(shipment.getLightVanProducts(), contains(window));
		assertThat(shipment.getHeavyVanProducts(), contains(floorPanel, door));
	}
	
}
