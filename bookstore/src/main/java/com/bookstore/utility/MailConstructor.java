package com.bookstore.utility;

import java.util.Locale;

import com.bookstore.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import com.bookstore.domain.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Component
public class MailConstructor {
    @Autowired
    private Environment env;

    @Autowired
    private TemplateEngine templateEngine;
    public SimpleMailMessage constructResetTokenEmail(
            String contextPath, Locale locale, String token, User user, String password
    ) {
        String url = contextPath+"/newUser?token="+token;
        String message = "\nPlease click on this link to verify your email and edit your personal information. Your password is: \n"+password;
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("G&G - New User");
        email.setText(url+message);
        email.setFrom(env.getProperty("support.email"));
        return email;
    }
    
    public SimpleMailMessage constructResetToken(
            String contextPath, Locale locale, String token, User user, String password
    ) {
        String url = contextPath+"/newUser?token="+token;
        String message = "\nPlease click on this link to change your password. Your password is: \n"+password;
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("G&G - New Password");
        email.setText(url+message);
        email.setFrom(env.getProperty("support.email"));
        return email;
    }

    public MimeMessagePreparator constructOrderConfirmationEmail(User user, Order order,Locale locale){
        Context context=new Context();
        context.setVariable("order",order);
        context.setVariable("user",user);
        context.setVariable("cartItemList",order.getCartItemList());
        String text =templateEngine.process("orderConfirmationEmailTemplate",context);

        MimeMessagePreparator messagePreparator=new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper email=new MimeMessageHelper(mimeMessage);
                email.setTo(user.getEmail());
                email.setSubject("Order Confirmation -"+order.getId());
                email.setText(text,true);
                email.setFrom(new InternetAddress("hengarturo@gmail.com"));
            }
        };
        return messagePreparator;
    }


	
}
