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

	// Void Constructor
	public EmailSending() {

	}

	// Test Email

	public void sending(Email to, String subject, Content content) throws IOException {
		String apiKey = "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";
		Email from = new Email("britosj30@gmail.com");
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid(apiKey);
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

	// Registration Email

	public void registerEmail(Email to) throws IOException {
		String apiKey = "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";
		Email from = new Email("britosj30@gmail.com");
		String subject = "Email Registration";
		Content content = new Content("text/plain", "You've registered succesfully");

		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid(apiKey);
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
