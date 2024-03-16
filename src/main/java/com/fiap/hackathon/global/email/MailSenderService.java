package com.fiap.hackathon.global.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class MailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ResourceLoader resourceLoader;

    public void sendNewMail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    public void sendEmailFromTemplate(String startDate, String endDate, String idReserva, String mailTo) throws MessagingException, IOException {
        MimeMessage message = mailSender.createMimeMessage();

        message.setFrom(new InternetAddress("fiap.ecomerce.hackathon@gmail.com"));
        message.setRecipients(MimeMessage.RecipientType.TO, mailTo);
        message.setSubject("GLKM Hackapp | Confirmação da reserva " + idReserva);

        Resource resource = resourceLoader.getResource("classpath:example.html");

        byte[] bytes = Files.readAllBytes(Paths.get(resource.getURI()));
        String htmlTemplate = new String(bytes, StandardCharsets.UTF_8);

        htmlTemplate = htmlTemplate.replace("[Data de Check-in]", startDate);
        htmlTemplate = htmlTemplate.replace("[Data de Check-out]", endDate);
        htmlTemplate = htmlTemplate.replace("[ID da reserva]", idReserva);

        message.setContent(htmlTemplate, "text/html; charset=utf-8");
        mailSender.send(message);
    }
}
