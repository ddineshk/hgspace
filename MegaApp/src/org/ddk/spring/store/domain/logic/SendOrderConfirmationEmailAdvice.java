package org.ddk.spring.store.domain.logic;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ddk.spring.store.domain.Account;
import org.ddk.spring.store.domain.Order;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SendOrderConfirmationEmailAdvice implements AfterReturningAdvice, InitializingBean {
    private static final String DEFAULT_MAIL_FROM = "dinesh13284@gmail.com";
    
    private static final String DEFAULT_SUBJECT = "Thank you for your order!";
    
    private final Log logger = LogFactory.getLog(getClass());
    
    private MailSender mailSender;
    
    private String mailFrom = DEFAULT_MAIL_FROM;
    
    private String subject = DEFAULT_SUBJECT;
    
    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public void afterPropertiesSet() throws Exception {
        if (this.mailSender == null) {
            throw new IllegalStateException("mailSender is required");
        }
    }
    
    public void afterReturning(Object returnValue, Method m, Object[] args, Object target) throws Throwable {
        Order order = (Order) args[0];
        Account account = ((StoreFacade) target).getAccount(order.getUser().getUsername());
        
        if (account.getEmail() == null || account.getEmail().length() == 0) {
            return;
        }
        
        StringBuffer text = new StringBuffer();
        text.append("Dear ").append(account.getFirstname()).append(' ').append(account.getLastname());
        text.append(", thank your for your order from Store. Please note that your order number is ");
        text.append(order.getId());
        
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(account.getEmail());
        mailMessage.setFrom(this.mailFrom);
        mailMessage.setSubject(this.subject);
        mailMessage.setText(text.toString());
        try {
            this.mailSender.send(mailMessage);
        } catch (MailException ex) {
            logger.warn("An exception occured when trying to send email", ex);
            ex.printStackTrace();
        }
    }
    
}
