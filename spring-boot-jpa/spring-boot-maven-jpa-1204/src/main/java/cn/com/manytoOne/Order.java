package cn.com.manytoOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="T_ORDER")
@Entity
public class Order {

    @Column(name="ID")
    @GeneratedValue
    @Id
    private Integer id;

    @Column(name="ORDER_NAME")
    private String orderName;

    //映射多对一的关联关系
    @JoinColumn(name="USER_ID")//关联user表的字段
    @ManyToOne
    private User user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", orderName=" + orderName + ", user="
                + user + "]";
    }


}
