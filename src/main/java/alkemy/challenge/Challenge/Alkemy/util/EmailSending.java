package alkemy.challenge.Challenge.Alkemy.util;

import java.io.IOException;

import org.springframework.core.env.Environment;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

public class EmailSending {
	
public EmailSending (Email receiver) throws IOException {
	String apiKey = "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";
    Email from = new Email("britosj30@gmail.com");
    String subject = "Sending with SendGrid is not Fun";
    Email to = new Email();
    to = receiver;
    Content content = new Content("text/plain", "I'm crying");
    Mail mail = new Mail(from, subject, to, content);
    
	// System.out.println("API Key is " + System.getenv("SENDGRID_API_KEY"));

    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    Request request = new Request();
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
	}
  }
}
