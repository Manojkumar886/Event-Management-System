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

    public String deleteone(int eventnumber)
    {
       eventEntity temp=repo.findById(eventnumber).orElse(new eventEntity());
       repo.delete(temp);
        return  temp.getEventName()+" has been deleted";
    }

    public void deleteusingid(int id)
    {
        repo.deleteById(id);
    }

//    find any one eventname
    public List<eventEntity> findsameeventname(String eventname)
    {
       return repo.findByEventName(eventname);
    }

    public List<eventEntity> findbybetweenvalues(int startingvalue,int endingvalue)
    {
        return  repo.findAllByEventEntryprice(startingvalue,endingvalue);
    }

    public void update(int price)
    {
        repo.updateprice(price);
    }
}

