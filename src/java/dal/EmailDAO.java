/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author Minh Bui
 */
public class EmailDAO {
    /*
    Done
    */
    private final String ACCOUNT_SID = "AC0e6c6e180775a105518d6e1914caac6e";
    private final String AUTH_TOKEN = "38cee8eb9fed37280e1993e4d8dfce57";

    public void sendSMS(String phone_number, String msg) {
        // Twilio phone number
        PhoneNumber fromNumber = new PhoneNumber("+15674431992");

        if (phone_number.charAt(0) == '0') {
            phone_number = "+84" + phone_number.substring(1);
        }
        // Destination phone number in Vietnam
        PhoneNumber toNumber = new PhoneNumber(phone_number); // replace with actual phone number

        // Message content
        String messageBody = msg;

        // Initialize Twilio client
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Send SMS message
        Message message = Message.creator(toNumber, fromNumber, messageBody).create();

        // Print message SID on success
        System.out.println("Message SID: " + message.getSid());
    }
}
