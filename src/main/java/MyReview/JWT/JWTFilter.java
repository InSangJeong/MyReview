package MyReview.JWT;

import MyReview.DTO.CustomUserDetails;
import MyReview.Entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class JWTFilter extends OncePerRequestFilter {
    private JWTUtil jwtUtil;
    public JWTFilter(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }
    private static final List<String> EXCLUDED_PATH_PATTERNS = List.of(
        "/",
        "/login",
        "/signon",
        "/review/getReviews"
    );
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // PermitALL 패스는 필터링을 하지 않음
        String path = request.getRequestURI();
        if (EXCLUDED_PATH_PATTERNS.stream().anyMatch(pattern -> path.matches(pattern))) {
            filterChain.doFilter(request, response);
            return;
        }

        String authorization = request.getHeader("Authorization");
        if (authorization == null || authorization.isBlank()) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwtToken = authorization.split(" ")[1]; //TODO Test
        if (jwtUtil.isExpired(jwtToken)) {
            return;
        }
        User user = new User();
        user.setID(jwtUtil.getUserID(jwtToken));
        user.setPW("");
        user.setAuth(jwtUtil.getRole(jwtToken));

        //인가정보 추출 및 객체화
        CustomUserDetails customUserDetails =  new CustomUserDetails(user);
        Authentication authToken = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());

        //Spring Security 에 인가정보 세팅해주고
        SecurityContextHolder.getContext().setAuthentication(authToken);

        //다음 필터를 돌게끔 호출해준다.
        filterChain.doFilter(request, response);
    }
}
