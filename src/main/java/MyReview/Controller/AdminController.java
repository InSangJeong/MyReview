package MyReview.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Iterator;

@RestController
@ResponseBody
public class AdminController {

    @GetMapping("/admin")
    public String main() {

        //접근 세션 정보 확인
        //String name =  SecurityContextHolder.getContext().getAuthentication().getName();
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        //Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        //GrantedAuthority auth = iter.next();
        //String role = auth.getAuthority();

        return "Hello Admin Page ";
    }


}
