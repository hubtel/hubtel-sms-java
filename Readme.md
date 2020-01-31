Hubtel HTTP API JAVA SDK 
===================================

## **Overview**
This is an open source JAVA SDK that allows you to access the Hubtel [REST SMS API](https://developers.hubtel.com) from your application. You need to create a Hubtel account [here](https://unity.hubtel.com/) in order to use this API.

## **Notice**
* This is the source code for the Hubtel release.
* The source code of the previous release can be found [here](https://github.com/hubtel/smsghapi-csharp-legacy) .

## **Installation**

The SDK can smoothly run on a platform running **JDK 1.1** and above. There are currently two ways of using it:
 
* To use the SDK all you have to do is to download the **com.smsgh** folder from the repository and all of its contents and add it to your project. Also you can download the source code and build it with your preferred IDE. 
* Download the binaries from the **binaries** folder, unzip it and add it to your project build path and your are good to go.

## **How-To**

The SDK currently is organized around four main classes:

* *MessagingApi.java* : 
    It handles sending and receiving messages, NumberPlans, Campaigns, Keywords, Sender IDs and Message Templates management.(For more information about these terms refer to [Our developer site](http://developers.smsgh.com/).)
* *ContactApi.java* : 
        It handles all contacts related tasks. 
* *AccountApi.java* : 
        It handles the API Account Holder data.
* *SupportApi.java* : 
        It helps any developer to interact with our support platform via his application.
* *ContentApi.java* : 
        It handles all content related tasks.

## **Examples**

* **How to Send a Message**

To send a message just copy this code snippet and do the necessary modifications:
```java
    import com.smsgh.ApiHost;
    import com.smsgh.BasicAuth;
    import com.smsgh.HttpRequestException;
    import com.smsgh.MessageResponse;
    import com.smsgh.MessagingApi;

    /**
     *
     * @author Arsene
     */
    public class Demo {

        public static void main(String[] args) {

            BasicAuth auth = new BasicAuth("user233", "password23");
            ApiHost host = new ApiHost(auth);
            // Instance of the Messaging API
            MessagingApi messagingApi = new MessagingApi(host);

            try {
                //set billing to an empty string for non-premium billing
                 MessageResponse response = messagingApi.sendQuickMessage("+233245657867", "+233245098456", "Hello THe JAVA SDK R2 Test is ongoing... ", "",true);

                System.out.println("Server Response Status " + response.getStatus());
            } catch (HttpRequestException ex) {
                System.out.println("Exception Server Response Status " + ex.getHttpResponse().getStatus());
                System.out.println("Exception Server Response Body " + ex.getHttpResponse().getBodyAsString());
            }

        }
    }
```
* **How to Schedule a Message**

To schedule a message just copy this code snippet and do the necessary modifications.
```java
    import com.smsgh.ApiHost;
    import com.smsgh.BasicAuth;
    import com.smsgh.HttpRequestException;
    import com.smsgh.MessageResponse;
    import com.smsgh.MessagingApi;

    /**
     *
     * @author Arsene
     */
    public class Demo {

        public static void main(String[] args) {

            BasicAuth auth = new BasicAuth("user233", "password23");
            ApiHost host = new ApiHost(auth);

            // Instance of the Messaging API
            MessagingApi messagingApi = new MessagingApi(host);

            try {
                // Here we will send the message next week
                Message message = new Message();
                message.setContent("Hello Arsene...");
                message.setFrom("John Doe");
                message.setTo("+233547075818");
                message.setRegisteredDelivery(true);
                message.setBillingInfo("123");

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DAY_OF_WEEK, 1);
                message.setTime(cal.getTime());
                MessageResponse response = messagingApi.sendMessage(message);

                System.out.println("Server Response Status " + response.getStatus());
            } catch (HttpRequestException ex) {
                System.out.println("Exception Server Response Status " + ex.getHttpResponse().getStatus());
                System.out.println("Exception Server Response Body " + ex.getHttpResponse().getBodyAsString());
            }

        }
    }
```
*Please do explore the MessagingApi class for more functionalities.*

* **How to view Account Details**

To send a message just copy this code snippet and do the necessary modifications:
```java
    import com.smsgh.ApiHost;
    import com.smsgh.BasicAuth;
    import com.smsgh.HttpRequestException;
    import com.smsgh.MessageResponse;
    import com.smsgh.MessagingApi;

    /**
     *
     * @author Arsene
     */
    public class Demo {

        public static void main(String[] args) {

            BasicAuth auth = new BasicAuth("user233", "password23");
            ApiHost host = new ApiHost(auth);

            // Instance of the Messaging API
            AccountApi accountApi = new AccountApi(host);

            try {
                AccountProfile profile = accountApi.getProfile();
                System.out.println("Profile AccountId " + profile.getAccountId());

            } catch (HttpRequestException ex) {
                System.out.println("Exception Server Response Status " + ex.getHttpResponse().getStatus());
                System.out.println("Exception Server Response Body " + ex.getHttpResponse().getBodyAsString());
            }

        }
    }
```
*Please do explore the AccountApi class for more functionalities.*

* **Notes**
The ContactApi, SupportApi and ContentApi classes follow almost the same pattern of functionalities, please do explore them to grab their capabilities.
