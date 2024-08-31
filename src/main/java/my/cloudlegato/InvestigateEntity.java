package my.cloudlegato;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "t_investigate" )
public class InvestigateEntity extends PanacheEntityBase {

    @Id
    @Column( name = "uuid" )
    public String uuid;

}
