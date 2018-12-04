package cn.com.taiji;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import antlr.collections.List;

public class Test {

	@PersistenceContext
	EntityManager em;

	public static void main(String[] args) {
		// 1. 创建EntityManagerFactory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("spring-boot-maven-jpa-1203");

		// 2. 创建EntityManager
		EntityManager entityManager = factory.createEntityManager();

		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		// 4. 持久化操作
		
		/*User user = new User();
		user.setUsername("tom");
		user.setPassword("123456");

		// 添加user到数据库，相当于hibernate的save();
		entityManager.persist(user);*/
		
		int id = 1;
		String name  = "lqy";
		User user = entityManager.createQuery(
    			"SELECT u FROM User u WHERE u.id = ?1 AND u.username=?2", User.class)
    			.setParameter(1, id)
    			.setParameter(2, name)
    			.getSingleResult();
		System.out.println(user.toString());

		// 5. 提交事务
		transaction.commit();

		// 6. 关闭EntityManager
		entityManager.close();

		// 7. 关闭EntityManagerFactory
		factory.close();
	}

 

}
