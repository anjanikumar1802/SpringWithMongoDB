package Mongo_Sample.prac;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDALImpl implements UserDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<User> getAllUsers() {
		return mongoTemplate.findAll(User.class);
	}

	public User getUserById(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		return mongoTemplate.findOne(query, User.class);
	}

	public User addNewUser(User user) {
		mongoTemplate.save(user);
		return user;
	}

	public Object getAllUserSettings(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		User user = mongoTemplate.findOne(query, User.class);
		return user != null ? user.getUserSettings() : "User not found.";
	}

	public String getUserSetting(String userId, String key) {
		Query query = new Query();
		query.fields().include("userSettings");
		query.addCriteria(
				Criteria.where("userId").is(userId).andOperator(Criteria.where("userSettings." + key).exists(true)));
		User user = mongoTemplate.findOne(query, User.class);
		return user != null ? user.getUserSettings().get(key) : "Not found.";
	}

	public String addUserSetting(String userId, String key, String value) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		User user = mongoTemplate.findOne(query, User.class);
		if (user != null) {
			user.getUserSettings().put(key, value);
			mongoTemplate.save(user);
			return "Key added.";
		} else {
			return "User not found.";
		}
	}

	public User updateUser(User user, String userId) {
//		User userDTO = mongoTemplate.findOne(Query.query(Criteria.where("userId").is(userId)), User.class);
//		if (userDTO != null) {
//			if (user.getCreationDate() != null) {
//				userDTO.setCreationDate(user.getCreationDate());
//			} else if (user.getName() != null) {
//				userDTO.setName(user.getName());
//			} else if (user.getUserSettings() != null) {
//				userDTO.setUserSettings(user.getUserSettings());
//			}
//		} else {
//			System.out.println("-------------= There is nothing to update =-----------------");
//		}
//
//		userDTO.setUserId(userId);
//		mongoTemplate.save(userDTO);
//		return userDTO;
//		

		User userDTO = mongoTemplate.findOne(Query.query(Criteria.where("userId").is(userId)), User.class);
		if (null != userDTO) {
			userDTO.setName(user.getName());
			userDTO.setCreationDate(user.getCreationDate());
			userDTO.setUserSettings(user.getUserSettings());
			userDTO.setUserId(userId);
		}
		mongoTemplate.save(userDTO);

		return userDTO;

	}

	public String deleteUser(User user) {
		mongoTemplate.remove(user);
		return "Successfully deleted";
	}
}
