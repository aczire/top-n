/**
 * 
 */
package app;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author admin
 *
 */
public class CollecctionsAppTest {

	/**
	 * Test method for {@link app.CollectionsApp#CollecctionsApp(int)}.
	 */
	@Test
	public void testCollecctionsApp() {
		CollectionsApp app = new CollectionsApp(1);
		assertNotNull(app);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCollecctionsAppExcpt() {
		CollectionsApp app = new CollectionsApp(0);
		assertNotNull(app);
	}

	/**
	 * Test method for {@link app.CollectionsApp#main(java.lang.String[])}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testMainExcpt() {
		String[] args = { "0" };
		CollectionsApp.main(args);
	}

	/**
	 * Test method for {@link app.CollectionsApp#main(java.lang.String[])}.
	 */
	@Test
	public void testMain() {
		String[] args = { "1" };
		CollectionsApp.main(args);
	}

	/**
	 * Test method for {@link app.CollectionsApp#main(java.lang.String[])}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testMainExcept() {
		String[] args = { "Cat" };
		CollectionsApp.main(args);
	}

	/**
	 * Test method for {@link app.CollectionsApp#getMyStringCollection()}.
	 */
	@Test
	public void testGetMyStringCollection() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link app.CollectionsApp#setMyStringCollection(app.ObjectCollection)}.
	 */
	@Test
	public void testSetMyStringCollection() {
		// fail("Not yet implemented");
	}

}
