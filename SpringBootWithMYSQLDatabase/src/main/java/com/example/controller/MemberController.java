package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.request.MemberInsertRequest;
import com.example.model.request.MemberUpdateRequest;
import com.example.model.response.GenericResponse;
import com.example.service.MemberService;

@RestController
@RequestMapping(value = "rest")
public class MemberController {
	
	@Autowired
	MemberService service;

	//Create API
	
	@RequestMapping(value = "member",method = RequestMethod.POST, headers = "Content-type=application/json")
	public GenericResponse addMember(@RequestBody MemberInsertRequest request) {
		GenericResponse response = null;
		try {
			response = service.addMember(request);
		}catch (Exception e) {
			e.printStackTrace();
			response.setStatus("0");
			response.setMessage("Exception!");
			response.setResponsebody(null);
		}
		return response;
		
	}
	
	//Read API
	@RequestMapping(value = "member-all",method = RequestMethod.GET, headers = "Content-type=application/json")
	public GenericResponse allMember() {
		GenericResponse response = null;
		try {
			response = service.allMember();
		}catch (Exception e) {
			e.printStackTrace();
			response.setStatus("0");
			response.setMessage("Exception!");
			response.setResponsebody(null);
		}
		return response;
	}
	
	//Update API
	@RequestMapping(value = "member-update",method = RequestMethod.PUT, headers = "Content-type=application/json")
	public GenericResponse memberUpdate(@RequestBody MemberUpdateRequest request,@RequestParam Integer id) {
		GenericResponse response = null;
		try {
			response = service.memberUpdate(request,id);
		}catch (Exception e) {
			e.printStackTrace();
			response.setStatus("0");
			response.setMessage("Exception!");
			response.setResponsebody(null);
		}
		return response;
	}
	
	//Delete API
	@RequestMapping(value = "member-delete/{id}",method = RequestMethod.DELETE, headers = "Content-type=application/json")
	public GenericResponse memberDelete(@PathVariable int id) {
		GenericResponse response = null;
		try {
			response = service.memberDelete(id);
		}catch (Exception e) {
			e.printStackTrace();
			response.setStatus("0");
			response.setMessage("Exception!");
			response.setResponsebody(null);
		}
		return response;
	}
}
