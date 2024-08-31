package my.cloudlegato;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Path( "/investigate" )
public class InvestigateResource {

    @Inject
    InvestigateProcess investigateProcess;

    @Inject
    InvestigateQuery investigateQuery;

    @POST
    @Produces( MediaType.APPLICATION_JSON )
    public Uni< Response > create( ) {
        return Panache.withTransaction( ( ) -> {
            return investigateProcess.process( )
                    .map( rList -> {
                        return Response.ok( )
                                .entity( rList )
                                .build( );
                    } );
        } );
    }

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Uni< Response > listAll( ) {
        return investigateQuery.listAll( )
                .map( entityList -> {
                    return Response.ok( )
                            .entity( entityList )
                            .build( );
                } );
    }

}
