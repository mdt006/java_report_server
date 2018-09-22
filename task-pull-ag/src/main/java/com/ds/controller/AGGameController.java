package com.ds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ds.service.ftp.AGGameFtpService;

@RestController
@RequestMapping(value="game")
public class AGGameController implements InterController{
	@Autowired
	private AGGameFtpService agFtpServ;
	@Override
	@RequestMapping(value="manGetRecord")
	public @ResponseBody Object manualExec(String date) {
		long start = System.currentTimeMillis();
		agFtpServ.execpull(date);
		long end = System.currentTimeMillis();
		return "ok,time："+(end - start);
	}
}
