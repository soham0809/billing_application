package in.sohamjoshi.billingsoftware.controller;


import in.sohamjoshi.billingsoftware.io.AuthRequest;
import in.sohamjoshi.billingsoftware.io.AuthResponse;
import in.sohamjoshi.billingsoftware.service.UserService;
import in.sohamjoshi.billingsoftware.service.impl.AppUserDetailsService;
import in.sohamjoshi.billingsoftware.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {


    private final PasswordEncoder passwordEncoder ;
    private final AuthenticationManager authenticationManager;
    private final AppUserDetailsService appUserDetailsService;
    private final JwtUtil jwtUtil ;
    private final UserService userService;


    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request){
        authenticate(request.getEmail() , request.getPassword());
        final UserDetails userDetails = appUserDetailsService.loadUserByUsername(request.getEmail());
        final String jwtToken = jwtUtil.generateToken(userDetails);
        String role = userService.getUserRole(request.getEmail());

        //to do fetch the role from repository; currently hardcoded ;
        return new AuthResponse(request.getEmail(),jwtToken,role );
        //JWT Token creation pending


    }

//    private void authenticate(String email , String password) throws Exception {
//        try{
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
//        }catch(DisabledException e){
//            throw new Exception("User Disabled");
//        }catch (BadCredentialsException e){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Email or password is incorrect ");
//        }
//    }

    private void authenticate(String email, String password) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
        } catch (DisabledException e) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "User is disabled"
            );
        } catch (BadCredentialsException e) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Email or password is incorrect"
            );
        }
    }


    @PostMapping("/encode")
    public String encodePassword(@RequestBody Map<String , String > request){
        return passwordEncoder.encode(request.get("password"));
    }

}
