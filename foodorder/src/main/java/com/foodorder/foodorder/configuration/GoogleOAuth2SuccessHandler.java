// package com.foodorder.foodorder.configuration;

// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
// import org.springframework.security.web.DefaultRedirectStrategy;
// import org.springframework.security.web.RedirectStrategy;
// import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
// import org.springframework.stereotype.Component;

// import com.foodorder.foodorder.entity.Role;
// import com.foodorder.foodorder.entity.User;
// import com.foodorder.foodorder.repository.RoleRespository;
// import com.foodorder.foodorder.repository.UserRepository;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @Component
// public class GoogleOAuth2SuccessHandler implements AuthenticationSuccessHandler{
//     @Autowired
//     RoleRespository roleRespository;

//     @Autowired
//     UserRepository userRepository;

//     private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    
//     @Override
//     public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//         OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
//         String email = token.getPrincipal().getAttributes().get("email").toString();
//         if(userRepository.findUserByEmail(email).isPresent()){
            
//         }else{
//             User user = new User();
//             user.setUsername(token.getPrincipal().getAttributes().get("username").toString());
//             user.setEmail(email); 
//             List<Role> roles = new ArrayList<>();
//             roles.add(roleRespository.findById(2).get());
//             user.setRoles(roles);
//             userRepository.save(user);

//         }

//         redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/");


//     }


// }
