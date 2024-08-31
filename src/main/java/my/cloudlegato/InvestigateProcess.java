package my.cloudlegato;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.hibernate.reactive.mutiny.Mutiny;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class InvestigateProcess {

    @Inject
    Mutiny.Session em;

    public Uni< List< String > > process( ) {
        InvestigateEntity entity1 = new InvestigateEntity( );
        entity1.uuid = UUID.randomUUID( ).toString( );

        InvestigateEntity entity2 = new InvestigateEntity( );
        entity2.uuid = UUID.randomUUID( ).toString( );

        InvestigateEntity entity3 = new InvestigateEntity( );
        entity3.uuid = UUID.randomUUID( ).toString( );

        return em.persistAll(
                entity1,
                entity2,
                entity3
        ).map( r -> {
            return new ArrayList< String >( ) {{
                add( entity1.uuid );
                add( entity2.uuid );
                add( entity3.uuid );
            }};
        } );
    }

}
