/**
 * 
 */
package app;

import java.util.List;
import java.util.prefs.BackingStoreException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A demo class to use and demonstrate the ObjectCollection Utility.
 * 
 * @author admin
 *
 */
public class CollectionsApp {

	Logger logger = LoggerFactory.getLogger(CollectionsApp.class);

	private int topK = 0;
	private ObjectCollection<String> myStringCollection = null;

	/**
	 * @param i
	 *            The top K items to be returned
	 * 
	 */
	public CollectionsApp(int i) {
		if (i > 0)
			this.setTopK(i);
		else
			throw new IllegalArgumentException("Should be greater than zero");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int k = 0;
		if (args.length > 0 && StringUtils.isNumeric(args[0]))
			k = Integer.valueOf(args[0]);
		else
			throw new IllegalArgumentException("Invalid arguments. Must be a number.");

		CollectionsApp app = new CollectionsApp(k);
		app.initializeCollections();
		app.offerMyCollection();
		app.retriveMyCollection();

		return;

	}

	private void retriveMyCollection() {
		try {
			List<String> myCollections = getMyStringCollection().getTopK();
			for (String string : myCollections) {
				logger.info(string);
			}
		} catch (BackingStoreException e) {
			logger.error(e.toString(), e);
		}

	}

	private void offerMyCollection() {

		getMyStringCollection().offer("Cat");
		getMyStringCollection().offer("Dog");
		getMyStringCollection().offer("Cat");
		getMyStringCollection().offer("Giraffe");
		getMyStringCollection().offer("Cat");
		
	}

	private void initializeCollections() {
		setMyStringCollection(new ObjectCollection<String>(this.getTopK()));
	}

	/**
	 * @return the myStringCollection
	 */
	ObjectCollection<String> getMyStringCollection() {
		return myStringCollection;
	}

	/**
	 * @param myStringCollection
	 *            the myStringCollection to set
	 */
	void setMyStringCollection(ObjectCollection<String> myStringCollection) {
		this.myStringCollection = myStringCollection;
	}

	/**
	 * @return the topK
	 */
	private int getTopK() {
		return topK;
	}

	/**
	 * @param topK
	 *            the topK to set
	 */
	private void setTopK(int topK) {
		this.topK = topK;
	}

}
