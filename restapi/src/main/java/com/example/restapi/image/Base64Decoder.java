package com.example.restapi.image;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class Base64Decoder implements MultipartFile {
	
    private final byte[] IMAGE;

    private final String HEADER;

    private Base64Decoder(byte[]image,String header){
        this.IMAGE = image;
        this.HEADER = header;
    }

    public static MultipartFile multipartFile(byte[]image,String header){
        return new Base64Decoder(image,header);
    }

	@Override
	public String getName() {
		return System.currentTimeMillis()+Math.random()+"."+HEADER.split("/")[1].split(";")[0];
	}

	@Override
	public String getOriginalFilename() {
		return System.currentTimeMillis()+(int)Math.random()*10000+"."+HEADER.split("/")[1].split(";")[0];
	}

	@Override
	public String getContentType() {
		return HEADER.split(":")[1];
	}

	@Override
	public boolean isEmpty() {
		return IMAGE == null || IMAGE.length == 0;
	}

	@Override
	public long getSize() {
		return IMAGE.length;
	}

	@Override
	public byte[] getBytes() throws IOException {
		return IMAGE;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return new ByteArrayInputStream(IMAGE);
	}

	@SuppressWarnings("resource")
	@Override
	public void transferTo(File file) throws IOException, IllegalStateException {
		new FileOutputStream(file).write(IMAGE);	
	}

}
