package library.web.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

	@Entity
	@Table(name = "books")
	public class Books {
	    @Id
	    @Column(name = "id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    
	    @Column(name = "title")
	    @NotNull(message="is reqired")
		@Size(min=1, message="is reqired")
	    private String title;
	    
	    @Column(name = "author_last_name")
	    @NotNull(message="is reqired")
		@Size(min=1, message="is reqired")
	    private String authorLastName;
	    
	    @Column(name = "author_first_name")
	    @NotNull(message="is reqired")
		@Size(min=1, message="is reqired")
	    private String authorFirstName;
	    
	    @Column(name = "publisher")
	    @NotNull(message="is reqired")
		@Size(min=1, message="is reqired")
	    private String publisher;
	    
	    @Column(name = "publishing_year")
	    @NotNull(message="is reqired")
		@Size(min=1, message="is reqired")
	    private String publishingYear;
	    
	    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	    @JoinColumn(name = "id_member")
	    private Members members;

	    public Books() {
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthorLastName() {
			return authorLastName;
		}

		public void setAuthorLastName(String authorLastName) {
			this.authorLastName = authorLastName;
		}

		public String getAuthorFirstName() {
			return authorFirstName;
		}

		public void setAuthorFirstName(String authorFirstName) {
			this.authorFirstName = authorFirstName;
		}

		public String getPublisher() {
			return publisher;
		}

		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}

		public String getPublishingYear() {
			return publishingYear;
		}

		public void setPublishingYear(String publishingYear) {
			this.publishingYear = publishingYear;
		}

		public Members getMembers() {
			return members;
		}

		public void setMembers(Members members) {
			this.members = members;
		}

		@Override
		public String toString() {
			return "Books [title=" + title + "]";
		}

		
	



}