package com.kryha.timetrack.controllers;

import com.kryha.timetrack.payload.request.LoginRequest;
import com.kryha.timetrack.payload.request.SignupRequest;
import com.kryha.timetrack.security.services.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {


	@Autowired
	private UserAuthService userAuthService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		return ResponseEntity.ok(userAuthService.authUser(loginRequest));
	}


	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

		return userAuthService.registerUser(signUpRequest);
	}
}
