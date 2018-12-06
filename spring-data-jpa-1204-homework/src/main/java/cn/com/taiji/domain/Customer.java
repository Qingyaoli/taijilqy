package cn.com.taiji.domain;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
    @Entity
    @Component
    @Table(name = "customer_work")
    public class Customer {
        private int id;
        private String name;
        private int age;
        
        
        
        @Override
		public String toString() {
			return "Customer [id=" + id + ", name=" + name + ", age=" + age + "]";
		}

		//private Set<Order> orderSet = new HashSet();
        @GeneratedValue
        @Id
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }





        public int getAge() {
            return age;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

