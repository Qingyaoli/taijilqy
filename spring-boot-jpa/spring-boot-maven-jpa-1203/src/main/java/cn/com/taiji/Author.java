package cn.com.taiji;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {
    @Id // ����
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ����������
    private Integer id; //id
    @Column(nullable = false, length = 20)
    private String name;//����
    @OneToMany(mappedBy = "author",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    //�������桢���¡�ɾ����ˢ��;�ӳټ��ء���ɾ���û����ἶ��ɾ�����û�����������
    //ӵ��mappedByע���ʵ����Ϊ��ϵ��ά����
     //mappedBy="author"�е�author��Article�е�author����
    private List<Article> articleList;//�����б�
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
	public List<Article> getArticleList() {
		return articleList;
	}
	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
    
    
}
