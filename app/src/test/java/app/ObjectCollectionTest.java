package app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.BackingStoreException;

import org.junit.Test;

@SuppressWarnings("unused")
public class ObjectCollectionTest {

	@Test
	public void testOffer() {
		ObjectCollection<String> myCollections = new ObjectCollection<String>(1);
		assertTrue(myCollections.offer("cat"));
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullOffer() {
		ObjectCollection<String> myCollections = new ObjectCollection<String>(1);
		assert(myCollections.offer(null));
	}	
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyOffer() {
		ObjectCollection<String> myCollections = new ObjectCollection<String>(1);
		assert(myCollections.offer(""));
	}	
	
	@Test
	public void testExactlyOneOneOffer() throws BackingStoreException {
		ObjectCollection<String> myCollections = new ObjectCollection<String>(1);
		myCollections.offer("Cat");
		assertEquals(1, myCollections.getTopK().size());
	}
	
	@Test
	public void testExactlyOneOneOfferCat() throws BackingStoreException {
		ObjectCollection<String> myCollections = new ObjectCollection<String>(1);
		myCollections.offer("Cat");
		assertEquals("Cat", myCollections.getTopK().get(0));
	}	
	
	@Test
	public void testExactlyManyOneOffer() throws BackingStoreException {
		ObjectCollection<String> myCollections = new ObjectCollection<String>(1);
		myCollections.offer("Cat");
		myCollections.offer("Dog");
		myCollections.offer("Giraffe");
		assertEquals(1, myCollections.getTopK().size());
		assertEquals("Cat", myCollections.getTopK().get(0));
	}	
	
	@Test
	public void testExactlyManyOneOfferTopList() throws BackingStoreException {
		ObjectCollection<String> myCollections = new ObjectCollection<String>(1);
		myCollections.offer("Cat");
		myCollections.offer("Dog");
		myCollections.offer("Giraffe");
		assertEquals("Cat", myCollections.getTopK().get(0));
	}	
	
	@Test
	public void testExactlyManyOneOfferGetGiraffe() throws BackingStoreException {
		ObjectCollection<String> myCollections = new ObjectCollection<String>(1);
		myCollections.offer("Cat");
		myCollections.offer("Dog");
		myCollections.offer("Giraffe");
		assertEquals("Cat", myCollections.getTopK().get(0));
	}
	
	@Test
	public void testExactlyManyManyOfferGetMany() throws BackingStoreException {
		
		List<String> expected = new ArrayList<String>();
		expected.add("Cat");
		expected.add("Dog");
		ObjectCollection<String> myCollections = new ObjectCollection<String>(2);
		myCollections.offer("Cat");
		myCollections.offer("Dog");
		myCollections.offer("Giraffe");
		assertEquals(expected, myCollections.getTopK());
	}	
	
	@Test
	public void testExactlyManyManyOfferGetManyInOrder() throws BackingStoreException {
		
		List<String> expected = new ArrayList<String>();
		expected.add("Dog");
		expected.add("Cat");
		ObjectCollection<String> myCollections = new ObjectCollection<String>(2);
		myCollections.offer("Cat");
		myCollections.offer("Dog");
		myCollections.offer("Giraffe");
		assertNotEquals(expected, myCollections.getTopK());
	}	
	
	@Test
	public void testExactlyManyManyOffer() throws BackingStoreException {
		
		List<String> expected = new ArrayList<String>();
		expected.add("Cat");
		expected.add("Dog");
		expected.add("Giraffe");
		ObjectCollection<String> myCollections = new ObjectCollection<String>(2);
		myCollections.offer("Cat");
		myCollections.offer("Dog");
		myCollections.offer("Giraffe");
		assertNotEquals(expected, myCollections.getTopK());
	}		
	
	@Test
	public void testExactlyOneManyOffer() throws BackingStoreException {
		ObjectCollection<String> myCollections = new ObjectCollection<String>(2);
		myCollections.offer("Cat");
		assertEquals(1, myCollections.getTopK().size());
	}	
	
	@Test
	public void testUniqueOffer() throws BackingStoreException {
		ObjectCollection<String> myCollections = new ObjectCollection<String>(2);
		myCollections.offer("Cat");
		myCollections.offer("Cat");
		myCollections.offer("Cat");
		assertEquals(1, myCollections.getTopK().size());
	}	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCollectionConstr() {
		ObjectCollection<String> myCollections = new ObjectCollection<String>(0);
	}	
	 
	@Test(expected = IllegalArgumentException.class)
	public void testCollectionConstrNeg() {		
		ObjectCollection<String> myCollections = new ObjectCollection<String>(-1);
	}	
	
	@Test
	public void testCollectionOffer() {
		ObjectCollection<String> myCollections = new ObjectCollection<String>(2);
		assertTrue(myCollections.offer("world"));
		assertFalse(myCollections.offer("world"));
	}	
}
