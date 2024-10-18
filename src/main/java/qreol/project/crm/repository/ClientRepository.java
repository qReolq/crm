package qreol.project.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qreol.project.crm.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
