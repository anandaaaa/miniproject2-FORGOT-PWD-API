package in.myproject.anand.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.myproject.anand.bindings.User;
import in.myproject.anand.constants.MyAppConstants;
import in.myproject.anand.entities.UserEntity;
import in.myproject.anand.prop.AppProperties;
import in.myproject.anand.repositires.UserRepository;
import in.myproject.anand.util.EmailUtil;

@Service
public class ForgotpassServiceImpl implements ForgotPassService {

	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private EmailUtil emailutil; 
	
	@Autowired
	private AppProperties appProp;
	

	@Override
	public String forgotpass(String email) {
		Map<String, String> messages = appProp.getMessages();

		UserEntity userEntity = userrepo.findByUserEmail(email);
		if(userEntity==null)
		{
			return messages.get(MyAppConstants.INVALID_MAIL_MESSAGE);
		}
		boolean sendForgotEmail = sendForgotEmail(userEntity);
		if(sendForgotEmail)
		{
			return  messages.get(MyAppConstants.EMAIL_SUCC_MSG);
		}
		return null;
	}
	

	public boolean sendForgotEmail(UserEntity user)
	{
		String to=user.getUserEmail();
	   // String firstName=user.getUserFName();	
		Map<String, String> messages = appProp.getMessages();

		String subject= messages.get(MyAppConstants.FORGOT_MAIL_SUBJECT);
		String forgotBodyFileName=messages.get(MyAppConstants.FORGOT_MAIL_BODY_FILE_NAME); 
		User user1=new User();
		BeanUtils.copyProperties(user, user1);
		String body=readMailBody(forgotBodyFileName,user1);
		boolean sendEmail = emailutil.sendEmail(subject, to, body);
		return sendEmail;
				
	}
	
	
	public String readMailBody(String Filename,User user)
	{
		String mailBody="";
		StringBuffer buffer =new StringBuffer();
		
		Path path =Paths.get(Filename);
		try {
			Stream<String> stream= Files.lines(path);
			stream.forEach(line->{
				buffer.append(line);
			});

			mailBody = buffer.toString();
			mailBody=mailBody.replace(MyAppConstants.FNAME, user.getUserFName());
			mailBody=mailBody.replace(MyAppConstants.TEMP_PWD, user.getUserPwd());

		}catch(IOException e)
		{
			e.printStackTrace();
		}
		return mailBody;
	}



}
