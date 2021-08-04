package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.MemberEntity;
import com.example.crud.repository.MemberRepository;
import com.example.model.request.MemberInsertRequest;
import com.example.model.request.MemberUpdateRequest;
import com.example.model.response.GenericResponse;

@Service
public class MemberService {

	@Autowired
	MemberRepository repository;
	
	public GenericResponse addMember(MemberInsertRequest request) throws Exception{
		GenericResponse response = new GenericResponse();
		boolean flag = false;
		MemberEntity entity = new MemberEntity();
		entity.setMembername(request.getMembername());
		entity.setMemberemail(request.getMemberemail());
		entity.setMembermobile(request.getMembermobile());
		entity.setGender(request.getGender());
		entity.setPassword(request.getPassword());
		entity = repository.save(entity);
		flag = true;
		if(flag) {
			response.setMessage("Successfully Inserted");
			response.setStatus("1");
			response.setResponsebody(entity);
		}else {
			response.setMessage("Failed");
			response.setStatus("0");
			response.setResponsebody(null);
		}
		return response;
	}
	
	public GenericResponse allMember() throws Exception{
		GenericResponse response = new GenericResponse();
		List<MemberEntity> members = new ArrayList<>();
		members = repository.findAll();
		if(members.size()==0) {
			response.setMessage("No records found");
			response.setStatus("0");
			response.setResponsebody(members);
		}else {
			response.setMessage("Success");
			response.setStatus("1");
			response.setResponsebody(members);
		}
		return response;
	}
	
	public GenericResponse memberUpdate(MemberUpdateRequest request,Integer id) throws Exception{
		GenericResponse response = new GenericResponse();
		boolean flag = false;
		MemberEntity entity = new MemberEntity();
		entity = repository.findByMemberid(id);
		if(entity == null) {
			response.setMessage("Not found");
			response.setStatus("0");
			response.setResponsebody(null);
		}else {
			entity.setMembername(request.getMembername());
			entity.setMemberemail(request.getMemberemail());
			entity.setMembermobile(request.getMembermobile());
			entity.setGender(request.getGender());
			entity.setPassword(request.getPassword());
			entity = repository.save(entity);
			flag = true;
			if(flag) {
				response.setMessage("Successfully Updated");
				response.setStatus("1");
				response.setResponsebody(entity);
			}else {
				response.setMessage("Failed");
				response.setStatus("0");
				response.setResponsebody(null);
			}
		}
		
		return response;
	}
	
	
	public GenericResponse memberDelete(Integer id) throws Exception{
		GenericResponse response = new GenericResponse();
		boolean flag = false;
		MemberEntity entity = new MemberEntity();
		entity = repository.findByMemberid(id);
		if(entity == null) {
			response.setMessage("Not found");
			response.setStatus("0");
			response.setResponsebody(null);
		}else {
			repository.delete(entity);
			flag = true;
			if(flag) {
				response.setMessage("Successfully Deleted");
				response.setStatus("1");
			}else {
				response.setMessage("Failed");
				response.setStatus("0");
			}
		}
		
		return response;
	}
}
