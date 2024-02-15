package EMS.Event.Management.System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//http://localhost:8080
public class eventController
{
    @Autowired
    eventService service;

//    http://localhost:8080/create
    @PostMapping("/create")
    public String createmethod(@RequestBody eventEntity myevent)
    {
        return  service.makecreate(myevent).getEventName()+"has been added" +
                "successfully";
    }



}
