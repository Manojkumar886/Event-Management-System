package EMS.Event.Management.System;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface eventRepository extends JpaRepository<eventEntity,Integer>
{

}
