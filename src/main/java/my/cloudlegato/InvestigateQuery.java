package my.cloudlegato;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InvestigateQuery implements PanacheRepositoryBase< InvestigateEntity, String > {
}
