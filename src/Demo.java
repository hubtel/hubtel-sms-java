
import java.util.Calendar;

import com.hubtel.ApiHost;
import com.hubtel.BasicAuth;
import com.hubtel.HttpRequestException;
import com.hubtel.Message;
import com.hubtel.MessageResponse;
import com.hubtel.MessagingApi;

/**
 *
 * @author Arsene
 */
public class Demo {

    public static void main(String[] args) throws Exception {

        BasicAuth auth = new BasicAuth("clientId", "clientSecret");
        ApiHost host = new ApiHost(auth);

        // Instance of the Messaging API
        MessagingApi messagingApi = new MessagingApi(host);

        try {
        	MessageResponse response = messagingApi.sendQuickMessage("DevUniverse", "+233207110652", "Welcome to planet Hubtel!", "",true);

            System.out.println("Server " + response.getMessageId());
        } catch (HttpRequestException ex) {
            System.out.println("Exception Server Response Status " + ex.getHttpResponse().getStatus());
            System.out.println("Exception Server Response Body " + ex.getHttpResponse().getBodyAsString());
        }

    }
}
