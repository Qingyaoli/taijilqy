package cn.com.taiji.ceshi;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import antlr.collections.List;
import cn.com.taiji.domain.Customer;
import cn.com.taiji.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AppTest {
	@Inject
	CustomerService customerService;
	
	@Inject
	private ObjectMapper objectMapper;
	@Ignore
	@Test
	public void test1() {
		for(int i = 0;i<9;i++) {
			Customer customer = new Customer();
			customer.setName("name"+i);
			customer.setAge(i);
			customerService.saveCustomer(customer);
		}
		java.util.List<Customer> list = customerService.findAllCustomers();
		System.out.println(list.size());
	}
	@Ignore
	@Test
	public void test2() {
		Customer customer = customerService.findByName("lili");
		
		System.out.println(customer.toString());
	}
	@Ignore
	@Test
	public void test3() {
		Customer customer = customerService.findCustomerById(2);
		
		System.out.println(customer.toString());
	}
	
	@Ignore
	@Test
	public void test4() {
		java.util.List<Customer> customer = customerService.findall();
		
		System.out.println(customer.toString());
	}
	
	@PersistenceContext
	EntityManager em;
	
	//未果
	@Ignore
	@Test
	public void test5() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Customer> c = cb.createQuery(Customer.class);
		Root<Customer> customer = c.from(Customer.class);

		CriteriaQuery query = c.select(customer).where(cb.equal(customer.get("name"), "lili"));

		TypedQuery query1 = em.createQuery(query);

		List list = (List) query1.getResultList();

		System.out.println(query1.getResultList());

	}
	
	
	private static final Logger log = LoggerFactory.getLogger(AppTest.class);
	
	
	/*@Test
	public void testPage() {
		String map = "{\"page\" : 1,\"pageSize\" : 5, \"filter\":{ \"filters\":[{ \"field\" : \"customerName\", \"value\":\"name2\"}]}}";
		Map searchParameters = new HashMap();
		try {
			searchParameters = objectMapper.readValue(map, new TypeReference<Map>() {
			});
		} catch (JsonParseException e) {
			log.error("JsonParseException{}:", e.getMessage());
		} catch (JsonMappingException e) {
			log.error("JsonMappingException{}:", e.getMessage());
		} catch (IOException e) {
			log.error("IOException{}:", e.getMessage());
		}

		Map mapCustomer = customerService.getPage(searchParameters);

//		System.out.println(mapCustomer.get("total"));

		System.out.println(mapCustomer.get("customers"));
	}
	*/
	
	

}
