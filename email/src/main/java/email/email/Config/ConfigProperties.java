package email.email.Config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("config")
public class ConfigProperties {
	@Value("${mail.send.from}")
	private String mailSendFrom;
   
	@Value("${mail.send.to}")
	private String mailSendTo;
	@Value("${mail.send.subject}")
	private String mailSendSubject;

	
	private Map<String,Object> mailModel;

	public String getMailSendTo() {
		return mailSendTo;
	}

	public void setMailSendTo(String mailSendTo) {
		this.mailSendTo = mailSendTo;
	}

	public String getMailSendSubject() {
		return mailSendSubject;
	}

	public void setMailSendSubject(String mailSendSubject) {
		this.mailSendSubject = mailSendSubject;
	}

	

	public Map<String, Object> getMailModel() {
		return mailModel;
	}

	public void setMailModel(Map<String, Object> mailModel) {
		this.mailModel = mailModel;
	}

	public String getMailSendFrom() {
		return mailSendFrom;
	}

	public void setMailSendFrom(String mailSendFrom ) {
		this.mailSendFrom = mailSendFrom;
	}
	
	

}
