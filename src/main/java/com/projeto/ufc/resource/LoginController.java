package com.projeto.ufc.resource;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.ufc.criptografia.Criptografia;
import com.projeto.ufc.domain.Usuario;
import com.projeto.ufc.repository.UsuarioRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UsuarioRepository usuarioDAO;
	
	
	@RequestMapping(method = RequestMethod.POST,consumes="application/json")
	public ResponseEntity<Void> realizarLogin(String login, String senha, String cargo) throws NoSuchAlgorithmException{
		
		System.out.println("LOGIN:" + login);
		Usuario usuario = usuarioDAO.findByLoginLike(login);
		String senhaCriptografada = Criptografia.convertPasswordToMD5(senha);
	
		if(usuario.getSenha().equals(senhaCriptografada)){ 
			
			if(cargo == "gerente"){
				return ResponseEntity.status(HttpStatus.OK).build();
				
			}
			
			if(cargo == "garcom"){
				return ResponseEntity.status(HttpStatus.OK).build();
			}
			
			else{ // É funcionario da cozinha
				return ResponseEntity.status(HttpStatus.OK).build();
			}
			
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

	}
}