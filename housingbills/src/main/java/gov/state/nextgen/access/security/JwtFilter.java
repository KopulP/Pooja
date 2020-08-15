/*
 * package gov.state.nextgen.access.security;
 * 
 * import java.io.IOException; import java.util.ArrayList; import
 * java.util.Arrays;
 * 
 * import javax.servlet.FilterChain; import javax.servlet.ServletException;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.web.authentication.
 * WebAuthenticationDetailsSource; import
 * org.springframework.stereotype.Component; import
 * org.springframework.web.context.request.RequestAttributes; import
 * org.springframework.web.context.request.RequestContextHolder; import
 * org.springframework.web.filter.OncePerRequestFilter;
 * 
 * import gov.state.nextgen.access.business.services.CustomerDetailsService;
 * import io.jsonwebtoken.ExpiredJwtException; import
 * io.jsonwebtoken.SignatureException;
 * 
 * @Component public class JwtFilter extends OncePerRequestFilter {
 * 
 * @Autowired private JwtUtil jwtTokenUtil;
 * 
 * @Autowired private CustomerDetailsService userDetailsService;
 * 
 * private String HEADER_STRING = "Authorization"; private String TOKEN_PREFIX =
 * "Bearer ";
 * 
 * @Override protected void doFilterInternal(HttpServletRequest req,
 * HttpServletResponse res, FilterChain chain) throws IOException,
 * ServletException { String header = req.getHeader(HEADER_STRING); String
 * username = null; String authToken = null; if (header != null &&
 * header.startsWith(TOKEN_PREFIX)) { authToken =
 * header.replace(TOKEN_PREFIX,""); try { username =
 * jwtTokenUtil.extractUsername(authToken); } catch (IllegalArgumentException e)
 * { logger.error("an error occured during getting username from token", e);
 * //res.sendError(1001, "123"); req.setAttribute("IllegalArgumentException",
 * "4003"); } catch (ExpiredJwtException e) {
 * logger.warn("the token is expired and not valid anymore", e);
 * req.setAttribute("ExpiredJwtException", "4002"); //res.sendError(1001,
 * "123"); } catch(SignatureException e){
 * logger.error("Authentication Failed. Username or Password not valid.");
 * req.setAttribute("SignatureException", "4001"); // res.sendError(1001,
 * "123"); } } else {
 * logger.warn("couldn't find bearer string, will ignore the header");
 * req.setAttribute("bearerexception", "4004"); } if (username != null &&
 * SecurityContextHolder.getContext().getAuthentication() == null) {
 * 
 * UserDetails userDetails = userDetailsService.loadUserByUsername(username);
 * 
 * if (jwtTokenUtil.validateToken(authToken, userDetails)) {
 * //UsernamePasswordAuthenticationToken authentication = new
 * UsernamePasswordAuthenticationToken(authToken,
 * SecurityContextHolder.getContext().getAuthentication(), userDetails);
 * UsernamePasswordAuthenticationToken authentication = new
 * UsernamePasswordAuthenticationToken(userDetails, null, Arrays.asList(new
 * SimpleGrantedAuthority("ROLE_ADMIN"))); authentication.setDetails(new
 * WebAuthenticationDetailsSource().buildDetails(req));
 * logger.info("authenticated user " + username + ", setting security context");
 * SecurityContextHolder.getContext().setAuthentication(authentication);
 * logger.info("time now {} retrived username from token " +username );
 * RequestContextHolder.getRequestAttributes().setAttribute("ACCESS_USER_NAME",
 * username, RequestAttributes.SCOPE_REQUEST);
 * logger.info("time now {} retrived username RequestContextHolder {} " +
 * RequestContextHolder.getRequestAttributes().getAttribute("ACCESS_USER_NAME",
 * RequestAttributes.SCOPE_REQUEST)); } }
 * 
 * chain.doFilter(req, res); } }
 */