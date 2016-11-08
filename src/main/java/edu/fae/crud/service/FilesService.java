package edu.fae.crud.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * Serviço que gerencia arquivos da aplicação
 * 
 * @author robson
 *
 */
@Service
public class FilesService {
	@Value("${upload.dir}")
	private String path;
	
	public String saveFile(MultipartFile file) {
		try{
			FileOutputStream fout = new FileOutputStream(path + file.getOriginalFilename());
			IOUtils.copy(file.getInputStream(), fout);
			fout.close();
			return file.getOriginalFilename();
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public void showFile(String file, HttpServletRequest request, HttpServletResponse response) {
		try{ 
			String fullFile = path + file;
			response.setContentType(request.getSession().getServletContext().getMimeType(fullFile));
			FileInputStream fin = new FileInputStream(fullFile);
			IOUtils.copy(fin, response.getOutputStream());
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
