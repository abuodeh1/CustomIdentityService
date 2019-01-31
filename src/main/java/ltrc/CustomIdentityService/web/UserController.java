package ltrc.CustomIdentityService.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ltrc.CustomIdentityService.domain.User;
import ltrc.CustomIdentityService.service.UserService;

/**
 * Created by ashlah on 31/07/17.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    User postUser(@RequestBody User user) {
        return userService.save(user);
    }
}
