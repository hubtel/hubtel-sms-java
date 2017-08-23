SMSGH HTTP API JAVA SDK (Release 2)
===================================

## **Overview**

The SMSGH HTTP API JAVA SDK is a wrapper built to assist java-driven applications developers to interact in a more friendly way with the HTTP API.
Its goal is also to provide an easy way for those who do not have much knowledge about the whole HTTP Restful technology to interact with the HTTP API.
In that direction there is no need to go and grab a knowledge about HTTP and REST technology. 
All one needs is to have the basic knowledge about the JAVA language. We mean the basics not advanced knowledge.

## **Notice**
* This is the source code for the current release.
* The source code of the previous release can be found [here](https://github.com/smsgh/smsghapi-java/tree/release-1) .

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

## **Some Quick Start**

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
                MessageResponse response = messagingApi.sendQuickMessage("+233245657867", "+233245098456", "Hello THe JAVA SDK R2 Test is ongoing... ", "123");

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
                message.setFrom("Arsene");
                message.setTo("+233247063817");
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