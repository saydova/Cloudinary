package enigma.user_profile.service;

import enigma.user_profile.model.User;
import enigma.user_profile.utils.UserDTO;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    User create(UserDTO req);
    List<User> getAll();
    String getImageUrl(Long id);
    User updateProfilePicture(MultipartFile file, Long id);
    User getById(Long id);
    User update(Long id, UserDTO req);
    void delete(Long id);
}
