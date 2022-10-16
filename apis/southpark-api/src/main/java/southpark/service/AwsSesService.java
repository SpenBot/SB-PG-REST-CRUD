package southpark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
// import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.amazonaws.services.simpleemail.model.SendEmailResult;

@Service
public class AwsSesService {

    // @Autowired
    // private AmazonSimpleEmailService amazonSimpleEmailService;

    // public AwsSesService(AmazonSimpleEmailService amazonSimpleEmailService) {
    //     this.amazonSimpleEmailService = amazonSimpleEmailService;
    // }

    // @Value("${cloud.aws.credentials.access-key}")
    // private String accessKey;
    // @Value("${cloud.aws.credentials.secret-key}")
    // private String secretKey;
    // @Value("${cloud.aws.region.static}")
    // private String region;    
    
    // private String accessKey = "ses-smtp-user.20221016-083637";
    // private String accessKey = "AKIA3VOCG4HSEEECQKGA";
    // private String secretKey = "BGeHsSsbtL8caqHnF8muTnu6vfRvbz6BmT0V7AuPVdOZ";
    private String region = "us-east-1";
    
    private String accessKey = "ses-test-user";
    private String secretKey = "utbd+qztSXC6UaFbcQVavLLcg36MFVDK3VaKoH1N";

    public SendEmailResult sendEmail(SendEmailRequest sendEmailRequest) {
        System.out.println("###############################");
        System.out.println("sendEmail");

        System.out.println("$$$$$$$$$$$");
        System.out.println(accessKey);
        System.out.println(secretKey);

        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        AmazonSimpleEmailService amazonSimpleEmailService =  AmazonSimpleEmailServiceClientBuilder
            .standard()
            .withCredentials(new AWSStaticCredentialsProvider(credentials))
            .withRegion(region)
            .build();

        return amazonSimpleEmailService.sendEmail(sendEmailRequest);
    }



    public SendEmailRequest generateSesEmailRequest() {
        String charSet = "UTF-8";
        // int requestTimeout = 5000; // time for req/resp round trip to aws
        String CONFIGSET = "ConfigSet";

        String FROM = "spenser.holstein@gmail.com";

        Destination destination = new Destination()
            .withToAddresses("spenser.holstein@gmail.com");

        Content content = new Content()
            .withCharset(charSet)
            .withData("hello from jhipster");

        Content subject = new Content()
            .withCharset(charSet)
            .withData("email test");

        Body body = new Body()
            // .withHtml(null)
            .withText(content);

        Message message = new Message()
            .withBody(body)
            .withSubject(subject);

        System.out.println("###########################");
        System.out.println(destination);
        System.out.println(message);

        return new SendEmailRequest()
            .withDestination(destination)
            .withMessage(message)
            .withSource(FROM)
            .withConfigurationSetName(CONFIGSET);
    }

}
