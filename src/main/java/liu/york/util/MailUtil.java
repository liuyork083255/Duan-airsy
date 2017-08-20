package liu.york.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/8/19.
 */
@Component
public class MailUtil {
    @Autowired
    private static  JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private static String sender;

    public static void sendMail(String target){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(target);
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
    }

}
