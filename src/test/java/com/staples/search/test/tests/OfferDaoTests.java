package com.staples.search.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.staples.search.dao.Offer;
import com.staples.search.dao.OffersDao;
import com.staples.search.dao.User;
import com.staples.search.dao.UsersDao;


@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:com/staples/search/config/dao-context.xml",
		"classpath:com/staples/search/config/security-context.xml",
		"classpath:com/staples/search/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferDaoTests {
	
	@Autowired
	private OffersDao offersDao;
	
	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
	}
	
	@Test
	public void testOffers() {
		
		User user = new User("johnwpurcell", "hellothere", "john@caveofprogramming.com", true, "ROLE_USER", "John Purcell");
		
		assertTrue("User creation should return true", usersDao.create(user));

		Offer offer = new Offer(user, "This is a test offer.");
		
		assertTrue("Offer creation should return true", offersDao.create(offer));
		
		List<Offer> offers = offersDao.getOffers();
		
		assertEquals("Should be one offer in database.", 1, offers.size());
		
		assertEquals("Retrieved offer should match created offer.", offer, offers.get(0));
		
		// Get the offer with ID filled in.
		offer = offers.get(0);
		
		offer.setText("Updated offer text.");
		assertTrue("Offer update should return true", offersDao.update(offer));
		
		Offer updated = offersDao.getOffer(offer.getId());
		
		assertEquals("Updated offer should match retrieved updated offer", offer, updated);
		
		offersDao.delete(offer.getId());
		
		List<Offer> empty = offersDao.getOffers();
		
		assertEquals("Offers lists should be empty.", 0, empty.size());
		
		// get offer with id
		Offer offer2 = new Offer(user, "this is another test offer");
		
		assertTrue("Offer creation should return true", offersDao.create(offer2));
		
		List<Offer> offers2 = offersDao.getOffers();
		for(Offer o: offers2) {
			Offer retrieveOffer = offersDao.getOffer(o.getId());
			
			assertEquals("This should be the same ", o, retrieveOffer);
		}
		
		offersDao.delete(offer2.getId());
		
		List<Offer> offer3 = offersDao.getOffers();
		assertEquals("The number of offers should be 1 ", 1, offer3.size());
		
	}
	
}
