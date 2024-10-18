package qreol.project.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qreol.project.crm.model.Contact;
import qreol.project.crm.model.ContactType;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findAllByClientId(Long clientId);

    List<Contact> findAllByClientIdAndType(Long clientIid, ContactType type);

}
