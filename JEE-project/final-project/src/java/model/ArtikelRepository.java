package ehb.be.eindproject.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtikelRepository extends CrudRepository<Artikel,Integer> {
    public List<Artikel> findByCat(String cat);
}
