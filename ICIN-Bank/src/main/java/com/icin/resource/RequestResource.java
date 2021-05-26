package com.icin.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icin.domain.Request;
import com.icin.service.RequestService;


@RestController
@RequestMapping("/api/request")
@PreAuthorize("hasRole('ADMIN')")
public class RequestResource {

    @Autowired
    private RequestService requestService;

    @RequestMapping("/all")
    public List<Request> findAppointmentList() {
        List<Request> requestList = requestService.findAll();

        return requestList;
    }

    @RequestMapping("/{id}/confirm")
    public void confirmAppointment(@PathVariable("id") Long id) {
        requestService.confirmRequest(id);
    }
}
