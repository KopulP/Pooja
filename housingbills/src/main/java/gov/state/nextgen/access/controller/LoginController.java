/*
 * package gov.state.nextgen.access.controller;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import gov.state.nextgen.access.business.model.User; import
 * gov.state.nextgen.access.security.JwtUtil;
 * 
 * @RestController public class LoginController {
 * 
 * @Autowired JwtUtil jwtUtil;
 * 
 * @Autowired private AuthenticationManager authenticationManager;
 * 
 * @PostMapping("/authenticate") public String generateToken(@RequestBody User
 * authRequest) throws Exception { try { authenticationManager.authenticate( new
 * UsernamePasswordAuthenticationToken(authRequest.getUserName(),
 * authRequest.getPassword()) ); } catch (Exception ex) { throw new
 * Exception("inavalid username/password"); } return
 * jwtUtil.generateToken(authRequest.getUserName()); }
 * 
 * }
 */