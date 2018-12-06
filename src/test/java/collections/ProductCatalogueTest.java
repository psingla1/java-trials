package collections;

import static collections.ProductFixtures.bobs;
import static collections.ProductFixtures.door;
import static collections.ProductFixtures.floorPanel;
import static collections.ProductFixtures.kates;
import static collections.ProductFixtures.window;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ProductCatalogueTest {
	
	@Test
	public void shouldOnlyHoldUniqueProducts() throws Exception {
		ProductCatalogue catalogue = new ProductCatalogue();
		catalogue.isSuppliedBy(bobs);
		catalogue.isSuppliedBy(kates);
		
		assertThat(catalogue, containsInAnyOrder(door, floorPanel, window));
	}
	
	@Test
	public void shouldFindLightVanProducts() throws Exception {
		ProductCatalogue catalogue = new ProductCatalogue();
		catalogue.isSuppliedBy(bobs);
		catalogue.isSuppliedBy(kates);	
		
		assertThat(catalogue.lightVanProducts(), contains(window));
	}
	
	@Test
	public void shouldFindHeavyVanProducts() throws Exception {
		ProductCatalogue catalogue = new ProductCatalogue();
		catalogue.isSuppliedBy(bobs);
		catalogue.isSuppliedBy(kates);	
		
		assertThat(catalogue.heavyVanProducts(), containsInAnyOrder(door, floorPanel));
	}
}
