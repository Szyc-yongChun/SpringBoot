package aa.mine.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import aa.mine.Entity.Message;


public interface MessageRepository extends JpaRepository<Message, Long> {


}
