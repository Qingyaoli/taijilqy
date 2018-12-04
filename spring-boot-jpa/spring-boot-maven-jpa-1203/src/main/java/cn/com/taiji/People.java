package cn.com.taiji;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class People {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;// id
	@Column(name = "name", nullable = true, length = 20)
	private String name;// ����
	@Column(name = "sex", nullable = true, length = 1)
	private String sex;// �Ա�
	@OneToOne(cascade = CascadeType.ALL) // People�ǹ�ϵ��ά���ˣ���ɾ�� people���ἶ��ɾ�� address
	@JoinColumn(name = "address_id", referencedColumnName = "id") // people�е�address_id�ֶβο�address���е�id�ֶ�
	private Address address;// ��ַ

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
