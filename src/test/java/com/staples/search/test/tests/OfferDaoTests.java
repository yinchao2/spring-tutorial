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
	
	private User user1 = new User("johnwpurcell", "John Purcell", "hellothere",
			"john@caveofprogramming.com", true, "ROLE_USER");
	private User user2 = new User("richardhannay", "Richard Hannay", "the39steps",
			"richard@caveofprogramming.com", true, "ROLE_ADMIN");
	private User user3 = new User("suetheviolinist", "Sue Black", "iloveviolins",
			"sue@caveofprogramming.com", true, "ROLE_USER");
	private User user4 = new User("rogerblake", "Rog Blake", "liberator",
			"rog@caveofprogramming.com", false, "user");


	private Offer offer1 = new Offer(user1, "This is a test offer.");
	private Offer offer2 = new Offer(user1, "This is another test offer.");
	private Offer offer3 = new Offer(user2, "This is yet another test offer.");
	private Offer offer4 = new Offer(user3, "This is a test offer once again.");
	private Offer offer5 = new Offer(user3, "Here is an interesting offer of some kind.");
	private Offer offer6 = new Offer(user3, "This is just a test offer.");
	private Offer offer7 = new Offer(user4, "This is a test offer for a user that is not enabled.");

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
	}
	
	@Test
	public void testCreate() {
		usersDao.create(user1);
		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);
		
		offersDao.create(offer1);
		
		List<Offer> offers1 = offersDao.getOffers();
		assertEquals("Should be one offer.", 1, offers1.size());
		
		assertEquals("Retrieved offer should equal inserted offer.", offer1, offers1.get(0));
		
		offersDao.create(offer2);
		offersDao.create(offer3);
		offersDao.create(offer4);
		offersDao.create(offer5);
		offersDao.create(offer6);
		offersDao.create(offer7);
		
		List<Offer> offers2 = offersDao.getOffers();
		assertEquals("Should be six offers for enabled users.", 6, offers2.size());
	}
	
	@Test
	public void testOffers() {
		
		User user = new User("johnwpurcell", "hellothere", "john@caveofprogramming.com", true, "ROLE_USER", "John Purcell");
		
		usersDao.create(user);

		Offer offer = new Offer(user, "This is a test offer.");
		
		offersDao.create(offer);
		
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
		
		offersDao.create(offer2);
		
		List<Offer> userOffers = offersDao.getOffers(user.getUsername());
		assertEquals("User should has two offers. ", 1, userOffers.size());
		
		List<Offer> offers2 = offersDao.getOffers();
		for(Offer o: offers2) {
			Offer retrieveOffer = offersDao.getOffer(o.getId());
			
			assertEquals("This should be the same ", o, retrieveOffer);
		}
		
		offersDao.delete(offer2.getId());
		
		List<Offer> offers3 = offersDao.getOffers();
		assertEquals("The number of offers should be 0 ", 0, offers3.size());
		
	}
	
}
