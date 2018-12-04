package cn.com.manytoOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="T_USER")
@Entity
public class User {

    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(name="NAME")
    private String name;

    @Column(name="EMAIL")
    private String email;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
    }


}
