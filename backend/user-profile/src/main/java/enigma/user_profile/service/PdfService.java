package enigma.user_profile.service;

import com.itextpdf.text.DocumentException;

public interface PdfService {
    byte[] createPdfImageById(Long id) throws DocumentException;
}
