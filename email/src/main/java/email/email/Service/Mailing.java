package email.email.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import email.email.Config.ConfigProperties;
import email.email.model.Mail;

@Component
public class Mailing {
	
	@Autowired
	EmailService service;
	@Autowired
	ConfigProperties config;
	
	public void sendingMail()
	{
		System.out.println("hiii");
		Mail mail=new Mail();
		mail.setMailFrom(config.getMailSendFrom());
		
		mail.setMailSubject(config.getMailSendSubject());
		mail.setMailTo(config.getMailSendTo());
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("name", "Shubham");
		mail.setModel(model);
		try {
			service.sendEmail(mail);
			System.out.println("done");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	

}
