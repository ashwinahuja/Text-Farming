package textfarming.sms;

import static textfarming.Translator.translate;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSSender {

    private SMSSender() {}

    private static final String ACCOUNT_SID = "account-sid";
    private static final String AUTH_TOKEN = "account-token";
    private static final PhoneNumber SOURCE = new PhoneNumber("phone_number");

    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public static void sendSMS(String tel, String englishText, String textToVoiceCode) {
        Message.creator(new PhoneNumber(tel), SOURCE, 
                translate(englishText, textToVoiceCode)).create();
    }

}
