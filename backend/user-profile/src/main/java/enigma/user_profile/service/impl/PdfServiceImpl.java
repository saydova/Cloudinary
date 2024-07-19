package enigma.user_profile.service.impl;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import enigma.user_profile.model.User;
import enigma.user_profile.service.PdfService;
import enigma.user_profile.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class PdfServiceImpl implements PdfService {
    private final UserService userService;

    @Override
    public byte[] createPdfImageById(Long id) throws DocumentException {

        User user = userService.getById(id);

        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, baos);
        document.open();

        try {
            Image img = Image.getInstance(user.getProfilePicture());
            img.scaleToFit(500, 500);
            document.add(img);
        } catch (Exception e) {
            log.error(e.getMessage());
            document.add(new Paragraph("Gambar tidak dapat dimuat: " + e.getMessage()));
        }
        document.close();
        return baos.toByteArray();
    }
}
