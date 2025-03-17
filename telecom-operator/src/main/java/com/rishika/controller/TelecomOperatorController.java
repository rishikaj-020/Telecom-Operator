package com.rishika.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rishika.model.SmsResponse;

@RestController
@RequestMapping("/telco")
public class TelecomOperatorController {


	@GetMapping("/smsc")
	public ResponseEntity<SmsResponse> operate(@RequestParam(name = "account_id") Integer accountId,
			@RequestParam(name = "mobile") String mobile, @RequestParam(name = "message") String message) {
		
		/*--Generates a unique acknowledgment ID--*/
		String ack_ID = UUID.randomUUID().toString();
		
		/*--Validates the mobile number and message content--*/
		
		if (mobile == null || message == null || message.length() > 160) {
			return ResponseEntity.ok(new SmsResponse("REJECTED", "FAILUIRE", null));
		}
		/*--Returns a successful response with the generated acknowledgment ID--*/
		return ResponseEntity.ok(new SmsResponse("ACCEPTED", "SUCCESS", ack_ID));

	}


}
