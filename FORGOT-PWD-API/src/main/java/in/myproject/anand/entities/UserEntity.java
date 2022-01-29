package in.myproject.anand.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="USER_ENTITY")
public class UserEntity {
	
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="USER_FIRST_NAME")
	private String userFName;
	
	@Column(name="USER_LAST_NAME")
	private String userLName;
	
	@Column(name="USER_EMAIL",unique=true)
	private String userEmail;
	
	@Column(name="USER_PHNO")
	private Integer userphone;

	@Column(name="USER_DOB")
	private LocalDate userDOB;
	
	@Column(name="USER_GENDER")
	private String userGender;
	
	@Column(name="USER_COUNTRY")
	private Integer userContry;
	
	@Column(name="USER_STATE")
	private Integer userState;
	
	@Column(name="USER_CITY")
	private Integer userCity;

	@Column(name="USER_PWD")
	private String userPwd;
	
	@Column(name="USER_ACC_STS")
	private String userAccStatus;
	
	@Column(name="CREATED_DATE")
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name="UPDATE_DATE")
	@UpdateTimestamp
	private LocalDate UpdatedDate;
	

}
