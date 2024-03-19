package email.email.Service;

import java.io.IOException;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import email.email.model.Mail;


@Service
public class EmailService {
	@Autowired
	JavaMailSender mailSender;
	@Autowired
	Configuration configuration;
	
	public void sendEmail(Mail mail) throws Exception
	{
		MimeMessage mimeMessage=mailSender.createMimeMessage();
		
		MimeMessageHelper mimeHelper=new MimeMessageHelper(mimeMessage,true);
		mimeHelper.setSubject(mail.getMailSubject());
		mimeHelper.setFrom(mail.getMailFrom());
		mimeHelper.setTo(mail.getMailTo());
		mail.setMailContent(getContentFromTemplate(mail.getModel()));
		mimeHelper.setText(mail.getMailContent(),true);
		mailSender.send(mimeHelper.getMimeMessage());
		
	}

	private String getContentFromTemplate(Map<String, Object> map) {
		// TODO Auto-generated method stub
		StringBuffer content=new StringBuffer();
		try {
			content.append(FreeMarkerTemplateUtils.processTemplateIntoString(configuration.getTemplate("template.txt"), map));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Exit");
		return content.toString();
	}

}
