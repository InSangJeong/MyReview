package MyReview.Controller;

import MyReview.DTO.LoginDTO;
import MyReview.DTO.SignOnDTO;
import MyReview.Service.SignService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class SignController {
    private final SignService signService;
    public SignController(SignService signService){
        this.signService = signService;
    }

    @PostMapping("/signon")
    public String signOnProcess(SignOnDTO signOnDTO){

        if(signService.signOn(signOnDTO)){
            return "OK";
        }
        else {
            return "FAIL";
        }
    }

    @PostMapping("/login")
    public String loginProcess(LoginDTO loginDTO) {
        return "OK";
    }

}
