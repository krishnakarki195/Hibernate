import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Address;
import com.model.Bike;
import com.model.Car;
import com.model.UserDetails;

public class HibernateTest {
	
	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		Address homeAddress = new Address();
		Address officeAddress = new Address();
		Set<Car> car = new HashSet<>();
		Collection<Bike> bike = new ArrayList<>();
		
		car.add(new Car("Camry", "Toyota"));
		car.add(new Car("Corrola", "Toyota"));
		car.add(new Car("RAV4", "Toyota"));
		
		bike.add(new Bike("Moutain Bike0","ABC0"));
		bike.add(new Bike("Moutain Bike1","ABC1"));
		bike.add(new Bike("Moutain Bike2","ABC2"));
		
		homeAddress.setStreet("2411 Finley Road");
		homeAddress.setCity("Irving");
		homeAddress.setState("TX");
		homeAddress.setZip("75062");
		homeAddress.setCountry("United States of America");
		
		officeAddress.setStreet("11339 Newkirk St.");
		officeAddress.setCity("Dallas");
		officeAddress.setState("TX");
		officeAddress.setZip("75229");
		officeAddress.setCountry("United States of America");
		
		
		//user.setUserId(1);
		user.setUserName("Krishna Karki");
		user.setHomeAddress(homeAddress);
		user.setOfficeAddress(officeAddress);
		user.setCars(car);
		user.setBikes(bike);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//session.save(user);
		//session.getTransaction().commit();
		user = null;
		user = (UserDetails) session.get(UserDetails.class, 1);
		session.close();
		System.out.println(user.getBikes().size());
		
	}

}
