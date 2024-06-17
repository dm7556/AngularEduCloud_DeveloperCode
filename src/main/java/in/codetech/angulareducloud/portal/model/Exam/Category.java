package in.codetech.angulareducloud.portal.model.Exam;


import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cid;
	
	private String title;
	
	private String description;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Quiz> quizess = new LinkedHashSet<>();
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return cid;
	}

	public void setId(Long id) {
		this.cid = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Set<Quiz> getQuizess() {
		return quizess;
	}

	public void setQuizess(Set<Quiz> quizess) {
		this.quizess = quizess;
	}

	public Category(Long cid, String title, String description, Set<Quiz> quizess) {
		super();
		this.cid = cid;
		this.title = title;
		this.description = description;
		this.quizess = quizess;
	}
	
	
	
}
