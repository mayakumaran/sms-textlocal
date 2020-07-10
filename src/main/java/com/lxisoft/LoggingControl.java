package com.lxisoft;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import com.twilio.rest.api.v2010.account.OutgoingCallerId;
import com.twilio.type.PhoneNumber;



//import com.twilio.rest.lookups.v1.PhoneNumber;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.base.ResourceSet;
import com.twilio.http.HttpMethod;

import com.twilio.rest.api.v2010.account.availablephonenumbercountry.Local;

import com.twilio.rest.api.v2010.account.ValidationRequest;
import com.twilio.rest.notify.v1.service.Binding;
import com.twilio.rest.notify.v1.service.Notification;

@RestController
public class LoggingControl {
	
	 public static final String ACCOUNT_SID = "ACe2adfc226cc049174d3acfd9de4ba51b";
	  public static final String AUTH_TOKEN = "a4defe3894c8c029aba490f00f431ffd";
	  public static final String SERVICE_SID = "ISd332140c484f171613165e4a46ee4c43";
	
	@RequestMapping("/sms/{phoneNumberTo}")
	public String getSet(@PathVariable String phoneNumberTo){
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		
	    Message message = Message.creator(new PhoneNumber(phoneNumberTo),
	        new PhoneNumber("+14153600389"), 
	        "maya twilio msg test").create();
	    
	    return message.getSid();
	
	}
	
	
	/*@RequestMapping("/register")
	public String rating(){
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	
		 IncomingPhoneNumber number = IncomingPhoneNumber.creator(new PhoneNumber("+919745483240"))
			        .setFriendlyName("My Company Line").setVoiceUrl("http://demo.twilio.com/docs/voice.xml")
			        .setVoiceMethod(HttpMethod.GET).create();

			//    System.out.println(number.getSid());
	  return number.getSid();
	}
	*/
	@RequestMapping("/validate")
	public Integer Validate(){
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	
		 ValidationRequest validationRequest = ValidationRequest.creator(new PhoneNumber("+919846997765"))
			        .setFriendlyName("Mom Number")
			        .create();
		 
			 return  validationRequest.getValidationCode();
	}
	
	//not working
	@RequestMapping("/smsVerification")
	public void verificationOfPhViaSms(){
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		int i=1;
		   System.out.println("oooooooooooooooo");
		ResourceSet<OutgoingCallerId> callerIds = OutgoingCallerId.reader()
		        .setPhoneNumber(new PhoneNumber("+918907097783"))
		        .read();
		   System.out.println(",mmmmmmmmmmmmm"+callerIds.iterator().next().getPhoneNumber());
		    // Loop over callerIds and print out a property for each one.
		    for (OutgoingCallerId callerId : callerIds) {
		    	  System.out.println("nnnnnnnnnnnnnnnn");
		      System.out.println(">>>>>>>>>>>>>>  "+i+"    :"+callerId.getPhoneNumber());
		      i++;
		    }
	
		    
	}
	
 @RequestMapping("/smsNotification")
	public void bindingNotification(){
		
/*
	    Binding binding = Binding.creator
	    (
	      SERVICE_SID,
	      "00000001", // We recommend using a GUID or other anonymized identifier for Identity.
	      Binding.BindingType.SMS,
	      "+1651000000000"
	    ).create();

	    System.out.println(binding.getSid());*/
	
			    // Initialize the client
			    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

			    Binding binding = Binding.creator
			    	    (
			    	      SERVICE_SID,
			    	      "00000001", // We recommend using a GUID or other anonymized identifier for Identity.
			    	      Binding.BindingType.SMS,
			    	      "+919846997765"
			    	    ).create();

			    	    System.out.println(binding.getSid());
			    Notification notification = Notification
			        .creator(SERVICE_SID)
			        .setBody("Knok-Knok! This is your first Notify SMS")
			        .setToBinding("{\"binding_type\":\"sms\",\"address\":\"+919846997765\"}")
			        .create();
			    System.out.println(notification.getSid());
			    Notification notification1 = Notification
			            .creator(SERVICE_SID)
			            .setBody("Knok-Knok! This is your first Notify SMS")
			            .setIdentity( "00000001")
			            .create();

			      
			    System.out.println(notification1.getSid());
	}
	
}

