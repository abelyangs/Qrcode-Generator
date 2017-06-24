package com.cn.ys.qr.code;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class CreateQRCode {

	public static void main(String[] args) {
		
		int width = 300;
		int height = 300;
		String format = "png";
		String content = "https://www.github.com/yangshuai5";
		
		//�����ά�����
		HashMap hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);
		
		//���ɶ�ά��
		
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);
			
			Path QRPath = new File("C:/QRCode-1.png").toPath();
			
		    MatrixToImageWriter.writeToPath(bitMatrix, format, QRPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
