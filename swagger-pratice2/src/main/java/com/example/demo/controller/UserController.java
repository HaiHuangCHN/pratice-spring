package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Controller to test Swagger <br>
 * Caution: the use of @ApiImplicitParam should be careful, if it is
 * inappropriate used, no message won't received by controller
 * 
 * @author h.a.huang
 */
@Controller
@RequestMapping("/user")
@Api(value = "Customer Controller")
public class UserController {

	@ResponseBody
	@RequestMapping(value = "/getUserName", method = RequestMethod.GET)
	@ApiOperation(value = "Get user by user id", notes = "test: return only when user id is 1 or 2")
	@ApiImplicitParam(paramType = "query", name = "userNumber", value = "user id", required = true, dataType = "Integer")
	public String getUserName(@RequestParam Integer userNumber) {
		if (userNumber == 1) {
			return "Huang, Hai";
		} else if (userNumber == 2) {
			return "Zeng, Zexuan";
		} else {
			return "Unknown user";
		}
	}

	@ResponseBody
	@RequestMapping("/updatePassword")
	@ApiOperation(value = "Update password", notes = "update password according to user id")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "userId", value = "user id", required = true, dataType = "Integer"),
			@ApiImplicitParam(paramType = "query", name = "pastPassword", value = "past password", required = true, dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "newPassword", value = "new password", required = true, dataType = "String") })
	public String updatePassword(@RequestParam(value = "userId") Integer userId,
			@RequestParam(value = "pastPassword") String pastPassword,
			@RequestParam(value = "newPassword") String newPassword) {
		if (userId <= 0 || userId > 2) {
			return "Unknown user";
		}
		if (StringUtils.isEmpty(pastPassword) || StringUtils.isEmpty(newPassword)) {
			return "Password cannot be null";
		}
		if (pastPassword.equals(newPassword)) {
			return "New password cannot be one of the past passwords";
		}
		return "Successfully update";
	}
}
