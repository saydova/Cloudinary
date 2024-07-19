package enigma.user_profile.service.impl;

import enigma.user_profile.service.PdfService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PdfGenerateService {
    private final PdfService pdfService;

    public ByteArrayResource getPdfFromUserId(Long id) {
        try {
            byte[] pdfBytes = pdfService.createPdfImageById(id);
            ByteArrayResource resource = new ByteArrayResource(pdfBytes);
            return resource;
        } catch (Exception e) {
            return null;
        }
    }
}
