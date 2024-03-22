package EMS.Event.Management.System;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data //getter,setter and tostring
@NoArgsConstructor  //without parameter
@AllArgsConstructor  //with parameter
public class eventEntity
{
    @Id //primary key//auto_increment
    private int eventNumber;
    private String eventName;
    private String eventLocation;
    private Date eventDate;
    private float eventEntryprice;

}
