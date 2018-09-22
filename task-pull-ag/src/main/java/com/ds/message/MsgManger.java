package com.ds.message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ds.msg.TelegramMessage;
@Component
public class MsgManger {
	@Value("${telegram.message.groupid}")
	private String msgGourpId;
	@Value("${telegram.message.bot}")
	private String bot;
	private TelegramMessage telegramMessage = TelegramMessage.getInstance();
	public void sendMessage(String msgGroup,String msg) {
		telegramMessage.sendMessage(bot, msgGourpId, msgGroup, msg);
	}
	
}
