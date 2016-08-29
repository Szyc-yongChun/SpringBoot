package aa.mine.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import aa.mine.Entity.Message;


public interface MessageRepository extends MongoRepository<Message, Long> {
	
	Message findMessageByid(long id);
}
