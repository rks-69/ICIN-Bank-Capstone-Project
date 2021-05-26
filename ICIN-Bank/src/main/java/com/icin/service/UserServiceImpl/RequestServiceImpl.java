package com.icin.service.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.dao.RequestDao;
import com.icin.domain.Request;
import com.icin.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	private RequestDao requestDoa;

	@Override
	public Request createRequest(Request request) {
		return requestDoa.save(request);
	}

	@Override
	public List<Request> findAll() {
		return requestDoa.findAll();
	}

	@Override
	public Request findRequest(Long id) {
		return requestDoa.findById(id).get();
	}

	@Override
	public void confirmRequest(Long id) {
		Request request = findRequest(id);
		request.setConfirmed(true);
		requestDoa.save(request);
		
	}

}
