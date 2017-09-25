package controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description:
 * author:      Yangrunkang
 * DateTime:  2017/9/25 12:33
 */
@CrossOrigin(origins = "*",methods={RequestMethod.POST, RequestMethod.GET})
public class BaseController {
}
