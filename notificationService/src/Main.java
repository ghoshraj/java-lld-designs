import com.notification.channel.EmailNotification;
import com.notification.channel.NotificationChannel;
import com.notification.channel.PushNotification;
import com.notification.channel.SMSNotification;
import com.notification.model.User;
import com.notification.service.NotificationService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<NotificationChannel> channels = new ArrayList<>();
        channels.add(new EmailNotification());
        channels.add(new SMSNotification());
        channels.add(new PushNotification());

        User user = new User(1, "rajesh@gmail.com", "9999999999", channels);

        NotificationService service = new NotificationService();

        service.sendNotification(user, "Hello Rajesh!");
        service.sendNotification(user, "Your order is shipped 🚀");

        // print history
        System.out.println("\n📜 Notification History:");
        user.getHistory().forEach(n ->
                System.out.println(n.getMessage() + " | " + n.getTimestamp())
        );
    }
}