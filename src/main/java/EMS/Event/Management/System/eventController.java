package EMS.Event.Management.System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/list")
    public List<eventEntity> viewdata()
    {
        return service.showall();
    }

    @GetMapping("/readonly/{number}")
    public Optional<eventEntity> readingone(@PathVariable("number") int number)
    {
        return  service.readone(number);
    }

    @PutMapping("/update")
    public String updating(@RequestBody eventEntity eventdetails)
    {
        eventEntity temp=service.makecreate(eventdetails);

        return  temp.getEventName()+" event has been updated...!";
    }

    @DeleteMapping("/delete/{eventnumber}")
    public void deleting(@PathVariable("eventnumber")int eventnumber)
    {
        service.deleteone(eventnumber);
    }

    @DeleteMapping("/deleteid/{id}")
    public void delete(@PathVariable("id")int id)
    {
        service.deleteusingid(id);
    }




}
