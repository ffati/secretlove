package com.ff.controller.individuation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IndividuationController
 * @Description TODO
 * @Author ff
 * @Date 2020/1/31 11:11
 * @ModifyDate 2020/1/31 11:11
 * @Version 1.0
 */

@Controller
@RequestMapping("/individuation")
public class IndividuationController {

    @RequestMapping("/individuationPage")
    public String allCommodity(){

        return "individuation/individuation";
    }

}
