package com.staff.flight.service;

import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.objects.Content;
import com.staff.flight.model.request.PassengerRegisterRequest;
import com.staff.flight.service.abstraction.EmailService;
import com.staff.flight.service.abstraction.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

@Service
public class EmailServiceImpl implements EmailService {

    private final String endpoint = "mail/send";

    private static final String TEXT_HTML  = "text/html";

    @Value("${emailSettings.senderEmail}")
    private String senderEmail;

    @Autowired
    private Environment env;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private SendGrid sendGrid;

    @Autowired
    private PassengerService passengerService;

    @Override
    public Response sendEmail(String email, String subject, Content content) {
        return null;
    }

    @Override
    public Response sendWelcomeEmail(PassengerRegisterRequest passengerRegisterRequest) {
        return null;
    }
}
