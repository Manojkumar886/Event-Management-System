package EMS.Event.Management.System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventmanagement")
//http://localhost:8080/eventmanagement
public class eventController
{
    @Autowired
    eventService service;

//    http://localhost:8080/eventmanagement/create
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

    @GetMapping("/findevent/{eventname}")
    public List<eventEntity> findsameevent(@PathVariable("eventname")String eventname)
    {
        return service.findsameeventname(eventname);
    }

    @GetMapping("/twoprices/{startingvalue}/{endingvalue}")
    public List<eventEntity> findtwotypeofprices(@PathVariable("startingvalue")int startingvalue,@PathVariable("endingvalue")int endingvalue)
    {
        return  service.findbybetweenvalues(startingvalue, endingvalue);
    }

//    @PutMapping("/updateentryprice/{price}")
//    public void updateprice(@PathVariable("price")int price)
//    {
//        service.update(price);
//    }

}
