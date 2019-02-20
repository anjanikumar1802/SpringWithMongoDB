package Mongo_Sample.prac;
import java.util.List;

public interface UserDAL {

	List<User> getAllUsers();

	User getUserById(String userId);

	User addNewUser(User user);

	Object getAllUserSettings(String userId);

	String getUserSetting(String userId, String key);

	String addUserSetting(String userId, String key, String value);
	
	User updateUser(User user, String userId);
	
	String deleteUser(User user);
}

