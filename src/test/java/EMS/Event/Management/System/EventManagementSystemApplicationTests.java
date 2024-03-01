package EMS.Event.Management.System;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static  org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class EventManagementSystemApplicationTests
{
    @Autowired
    eventService service;

    @MockBean
    eventRepository repo;

    @Test
    public void testcase1()
    {
        Date date=new Date(2024,01,03);
        Date date1=new Date(2023,01,29);
        eventEntity object1=new eventEntity(1,"Facino_2023","Salem",date,450.0f);
        eventEntity object2=new eventEntity(2,"Access_2024","Trichengode", date1,600.0f);

        when(repo.findAll()).thenReturn(Stream.of(object1,object2).collect(Collectors.toList()));

//        assertSame,assertNotsame,assertNull,assertNotnull,assertFalse

//        assertNotNull(service.showall());

//        assertNull(service.showall());

        assertNotSame("Facino_2023",service.showall().get(0).getEventName());
    }

    @Test
    public void testcase2()
    {
        Date date=new Date(2024,01,03);
        Optional<eventEntity> object1=Optional.of(new eventEntity(1,"Facino_2023","Salem",date,450.0f));

        when(repo.findById(1)).thenReturn(object1);

        assertNotEquals(object1,service.readone(1));
    }
}
