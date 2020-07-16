package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Doctor;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/v1")
@Api(value = "Doctor Controller")
public class DoctorController {

	/**
	 * Add doctor<br>
	 * 
	 * Take caution: Swagger use JSON to pass arguments, so that @RequestBody should
	 * be used here. Other format like form or URL will not be supported
	 * 
	 * @param doctor
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/addDoctor", method = RequestMethod.POST)
	@ApiOperation(value = "Add docotor information", notes = "")
	public String addDoctor(@RequestBody Doctor doctor) throws Exception {
		if (null == doctor || doctor.getId() == null) {
			throw new Exception("Add doctor information fails, unknown reason, please contract administator");
		}
		return "Successfully--------------->" + doctor.getName();
	}

	/**
	 * Delete doctor
	 * 
	 * @param doctorId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteDoctor", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete doctor information", notes = "")
	@ApiImplicitParam(paramType = "query", name = "doctorId", value = "Doctor ID", required = true, dataType = "Integer")
	public String deleteDoctor(@RequestParam Integer doctorId) {
		if (doctorId > 2) {
			return "Fail to delete";
		}
		return "Successfully delete";
	}

	/**
	 * Update doctor information
	 * 
	 * @param doctorId
	 * @param doctor
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateDoctor", method = RequestMethod.POST)
	@ApiOperation(value = "Update doctor information", notes = "")
	@ApiImplicitParam(paramType = "query", name = "doctorId", value = "Doctor ID", required = true, dataType = "Integer")
	public String updateDoctor(@RequestParam Integer doctorId, @RequestBody Doctor doctor) throws Exception {
		if (null == doctorId || null == doctor) {
			throw new Exception("Fail to update. ID can not be blank, please enter a valid ID");
		}
		if (doctorId > 5) {
			throw new Exception("Doctor isn't existed in our system, please choose another ID");
		}
		System.out.println(doctorId);
		System.out.println(doctor);
		return "Update successfully";
	}

	/**
	 * Get doctor information
	 * 
	 * @param doctorId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getDoctor", method = RequestMethod.GET)
	@ApiOperation(value = "Fetch doctor infomation", notes = "Only name will be returned...")
	@ApiImplicitParam(paramType = "query", name = "doctorId", value = "Doctor ID", required = true, dataType = "Integer")
	public Doctor getDoctor(@RequestParam Integer doctorId) throws Exception {
		System.out.println(doctorId);
		if (null == doctorId) {
			throw new Exception("Search doctor information fails. No ID is specified");
		}
		if (doctorId > 3) {
			throw new Exception("The doctor isn't existed in our system. Wrong ID, please use another ID");
		}
		Doctor doctor = new Doctor();
		doctor.setId(doctorId);
		doctor.setName("Tester");
		return doctor;
	}

}
