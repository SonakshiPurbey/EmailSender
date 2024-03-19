package email.email;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import email.email.Config.AppConfiguration;
import email.email.Config.ConfigProperties;
import email.email.Service.Mailing;


/**
 * Hello world!
 *
 */


public class App {

	private static AnnotationConfigApplicationContext applicationContext=null;	   
	
	public static void main(String[] args) {
		
	applicationContext=new AnnotationConfigApplicationContext(AppConfiguration.class);
	Mailing mail=applicationContext.getBean(Mailing.class);
	mail.sendingMail();
//	ConfigProperties config=applicationContext.getBean(ConfigProperties.class);
//	System.out.println(config.getMailModel());

	
	
		
	}
}
