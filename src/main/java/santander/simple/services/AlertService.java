package santander.simple.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import santander.simple.DTOs.NotificationDTO;
import santander.simple.entitys.User;


@Service
public class AlertService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws  Exception{
        String email = user.getEmail();

        NotificationDTO notificationRequest = new NotificationDTO(email, message);

         ResponseEntity<String>  notificationResponse = restTemplate.postForEntity("http://o4d9z.mocklab.io/notify",
                 notificationRequest, String.class);
         if (!(notificationResponse.getStatusCode() == HttpStatus.OK)){
             throw  new Exception("sorry the notification service is down");
         }
    }

}

