package com.vulinh.qrgenerator.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.image.BufferedImage;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author LinhNV42
 */
public class QRUtils {

    private QRUtils() {
        throw new UnsupportedOperationException("Cannot instantiate utility class!");
    }

    private static final Map<EncodeHintType, Object> HINTS = new EnumMap<>(EncodeHintType.class);

    static {
        HINTS.put(EncodeHintType.CHARACTER_SET, "utf-8"); // So that I can write love letter in Vietnamese, albeit in around 2k characters
        HINTS.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L); // I heard this will widen or lengthen the distance between 'dots'
        HINTS.put(EncodeHintType.MARGIN, 2);
    }

    public static BitMatrix generateQRCode(String data, int size) throws WriterException {
        return new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, size, size, HINTS);
    }

    public static BufferedImage toBufferedImage(BitMatrix bitMatrix) {
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}
