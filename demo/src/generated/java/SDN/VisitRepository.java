
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.CrudRepository;
public interface VisitRepository extends GraphRepository<Visit> {
}
