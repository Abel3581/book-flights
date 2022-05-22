package com.staff.flight.service.abstraction;

import com.sendgrid.Response;
import com.sendgrid.helpers.mail.objects.Content;
import com.staff.flight.model.request.PassengerRegisterRequest;


public interface EmailService {

    Response sendEmail(String email, String subject, Content content);

    Response sendWelcomeEmail(PassengerRegisterRequest passengerRegisterRequest);

}
