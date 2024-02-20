package EMS.Event.Management.System;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<eventEntity> showall()
    {
        return (List<eventEntity>)  repo.findAll();
    }

    public Optional<eventEntity> readone(int myeventnumber)
    {
        return  repo.findById(myeventnumber);
    }
}
