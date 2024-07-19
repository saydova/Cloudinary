package enigma.user_profile.utils;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    private MultipartFile profilePicture;
}
