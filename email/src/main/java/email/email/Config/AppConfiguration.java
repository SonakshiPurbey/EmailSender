package email.email.Config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

@Configuration
@ComponentScan("email.email")
@PropertySource(value={"classpath:application.properties"})
public class AppConfiguration {
	@Bean
	public JavaMailSender getMailSender()
	{
		JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
        mailSender.setUsername("sonakshi56purbey@gmail.com");
        mailSender.setPassword("bohi anxy thei axcl");
		Properties javaMailProperties=new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable", "true");
		javaMailProperties.put("mail.smtp.auth", "true");
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.debug", "true");
		javaMailProperties.put("default-encoding","UTF-8");
		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
	}
	@Bean
	public FreeMarkerConfigurationFactoryBean freeMarkerConfiguration()

	{
		FreeMarkerConfigurationFactoryBean freeBean=new FreeMarkerConfigurationFactoryBean();
		freeBean.setTemplateLoaderPath("classpath:/templates");
		freeBean.setPreferFileSystemAccess(true);
		freeBean.setDefaultEncoding("UTF-8");
		return freeBean;
	}

}
