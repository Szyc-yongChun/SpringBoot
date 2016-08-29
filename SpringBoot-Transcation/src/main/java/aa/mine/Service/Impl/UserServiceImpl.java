package aa.mine.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import aa.mine.Entity.UserEntity;
import aa.mine.Repository.UserRepository;
import aa.mine.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override

	public UserEntity saveUser(UserEntity user) throws Exception {
		userRepository.save(user);
		return user;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public int saveUserO(UserEntity user) throws Exception {
		// TODO Auto-generated method stub
		userRepository.save(user);
		UserEntity userO =user;
		userO.setName(user.getName()+"_2");
		saveUser(userO);
		int i = 0;
		if (9999 == user.getAge()) {			
			 i = 1 / 0;
		}
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		return i;
	}

}
