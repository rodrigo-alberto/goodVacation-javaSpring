package good.vacation.models;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContact;
	
	@Column(nullable = false, length = 20)
	private String subject;
	
	@Column(nullable = false, columnDefinition = "TEXT", length = 500)
	private String message;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "message_time")
	private LocalDateTime messageTime;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "fk_user_idUser")
	private User user;

	public Contact() {
	}

	public Contact(String subject, String message, LocalDateTime messageTime) {
		this.subject = subject;
		this.message = message;
		this.messageTime = messageTime;
	}

	public int getIdContact() {
		return idContact;
	}

	public void setIdContact(int idContact) {
		this.idContact = idContact;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(LocalDateTime messageTime) {
		this.messageTime = messageTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}