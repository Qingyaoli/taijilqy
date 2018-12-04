package cn.com.taiji;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;


@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ����������
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(nullable = false, length = 50) // ӳ��Ϊ�ֶΣ�ֵ����Ϊ��
    private String title;
    @Lob  // �����ӳ�� MySQL �� Long Text ����
    @Basic(fetch = FetchType.LAZY) // ������
    @Column(nullable = false) // ӳ��Ϊ�ֶΣ�ֵ����Ϊ��
    private String content;//����ȫ������
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)//��ѡ����optional=false,��ʾauthor����Ϊ�ա�ɾ�����£���Ӱ���û�
    @JoinColumn(name="author_id")//������article���еĹ����ֶ�(���)
    private Author author;//��������
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
    
    
}
