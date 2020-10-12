package com.sv.main.serviceImpl;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.sv.main.service.IRequestService;

import util.ProcessHttp;

@Service
public class RequestServiceImpl implements IRequestService {
	;

	@Override
	public int firebase(int tipo, int valor) throws IOException {

		ProcessHttp http = new ProcessHttp();

		String json = "{\"tipo\":" + tipo + ",\"valor\":" + valor + "}";

		http.runShellCommand("https://utp-distribuido.firebaseio.com/sensor.json", json);

		return 1;
	}

}
