package EMS.Event.Management.System;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface eventRepository extends JpaRepository<eventEntity,Integer>
{
//    HQL-Hibernate Query language
    public List<eventEntity> findByEventName(String eventname);

    @Query(value = "select * from event_entity " +
            "where event_entryprice between :startingprice and :endingprice ",nativeQuery = true)
    public List<eventEntity> findAllByEventEntryprice(int startingprice,int endingprice);

    @Modifying
    @Transactional
    @Query(" update event_entity e set e.event_entryprice=e.event_entryprice+200 where e.event_entryprice>=:price")
    public void updateprice(int price);

}
