import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Address;
import com.model.Bike;
import com.model.Book;
import com.model.Car;
import com.model.Company;
import com.model.UserDetails;
import com.model.Vehicle;

public class HibernateTest {
	
	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		Address homeAddress = new Address();
		Address officeAddress = new Address();
		Set<Car> car = new HashSet<>();
		Collection<Bike> bike = new ArrayList<Bike>();
		Book book1 = new Book();
		Book book2 = new Book();
		
		Vehicle vehicle = new Vehicle(1001,"Tesla");
		Company company1 = new Company(1001,"Comp1");
		Company company2 = new Company(1002,"Comp2");
		
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
		user.setVehicle(vehicle);
		user.getCompany().add(company1);
		user.getCompany().add(company2);
		user.getBooks().add(book1);
		user.getBooks().add(book2);
		company1.setUserDetails(user);
		company2.setUserDetails(user);
		book1.setBookId(100);
		book1.setBookName("Mathmatics");
		book1.setIsbn("ISBN10001");
		book1.getAuthors().add(user);
		book2.setBookId(101);
		book2.setBookName("Science");
		book2.setIsbn("ISBN10002");
		book2.getAuthors().add(user);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.save(company1);
		session.save(company2);
		session.getTransaction().commit();
		session.close();
		
	}

}
