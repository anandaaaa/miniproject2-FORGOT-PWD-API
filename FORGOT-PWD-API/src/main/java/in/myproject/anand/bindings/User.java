package in.myproject.anand.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {
	
	private Integer userId;
	private String userFName;
	private String userLName;
	private String userEmail;
	private Integer userphone;
	private LocalDate userDOB;
	private String userGender;
	private Integer userContry;
	private Integer userState;
	private Integer userCity;
	private String userPwd;
	private String userAccStatus;
	private LocalDate createdDate;
	private LocalDate UpdatedDate;
	


}
