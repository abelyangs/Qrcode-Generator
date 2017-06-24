package com.cn.ys.qr.code;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class ParseQRCode {

	public static void main(String[] args) {
		
		//½âÎö¶þÎ¬Âë
		try {
            MultiFormatReader formatReader = new MultiFormatReader();
			String filePath = "E:/qrcode-test/QRCode-1.png";
			File file = new File(filePath);
			BufferedImage image = ImageIO.read(file);;
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer  binarizer = new HybridBinarizer(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
			Map hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			Result result = formatReader.decode(binaryBitmap,hints);
			
            System.out.println("result = "+ result.toString());
			System.out.println("resultFormat = "+ result.getBarcodeFormat());
			System.out.println("resultText = "+ result.getText());
            
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
