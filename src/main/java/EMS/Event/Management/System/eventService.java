package EMS.Event.Management.System;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class eventService
{
    @Autowired//object creation performance
    eventRepository repo;

//    public String makecreate(String eventname)
//    {
//        return name;
//    }

    public eventEntity makecreate(eventEntity myeventdetails)
    {
        return repo.save(myeventdetails);
    }
}
