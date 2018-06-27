package com.xyauto.interact.broker.zuul.controller;
import com.xyauto.interact.broker.zuul.util.Result;
import org.springframework.web.bind.annotation.*;


/**
 * Created by shiqm on 2018-03-16.
 */

@RestController
@RequestMapping(value = "/dealer")
public class DealerController extends BaseController{

    @RequestMapping(value = "/{dealer_id}", method = RequestMethod.GET)
    public Result get(
            @PathVariable(value = "dealer_id", required = true) long dealerId
    ) {
        return brokerServerCloud.dealerGet(dealerId);
    }

    @RequestMapping(value = "/city/brands", method = RequestMethod.GET)
    public Result getCityBrands() {
        return brokerServerCloud.dealerBrandList(this.getParameterMap());
    }

    @RequestMapping(value = "/city/series", method = RequestMethod.GET)
    public Result getCitySeries(){
        return brokerServerCloud.dealerSeriesList(this.getParameterMap());
    }


}
