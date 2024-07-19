package enigma.user_profile.service.impl;

import com.cloudinary.Cloudinary;
import enigma.user_profile.service.CloudinaryService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class CloudinaryServiceImpl implements CloudinaryService {

    @Resource
    private Cloudinary cloudinary;

    @Override
    public String uploadFile(MultipartFile file, String folderName) {
        try {
            HashMap<String, String> options = new HashMap<>();
            options.put("folder", folderName);
            Map<?,?> uploadResult = cloudinary.uploader().upload(file.getBytes(), options);
            String publicId = (String) uploadResult.get("public_id");
            return cloudinary.url().secure(true).generate(publicId);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("Image invalid");
        }
    }
}
