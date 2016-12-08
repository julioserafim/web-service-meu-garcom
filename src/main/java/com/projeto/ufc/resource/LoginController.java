package com.projeto.ufc.resource;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.projeto.ufc.criptografia.Criptografia;
import com.projeto.ufc.domain.Usuario;
import com.projeto.ufc.form.LoginForm;
import com.projeto.ufc.repository.UsuarioRepository;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UsuarioRepository usuarioDAO;
	
	
	@RequestMapping(method = RequestMethod.POST,consumes="application/json")
	public ResponseEntity<Void> realizarLogin(LoginForm loginForm) throws NoSuchAlgorithmException{
		
		System.out.println("LOGIN:" + loginForm.getLoginDigitado());
		Usuario usuario = usuarioDAO.findByLoginLike(loginForm.getLoginDigitado());
		String senhaCriptografada = Criptografia.convertPasswordToMD5(loginForm.getSenhaDigitada());
	
		if(usuario.getSenha().equals(senhaCriptografada)){ 
			
			if(loginForm.getCargo() == "gerente"){
				return ResponseEntity.status(HttpStatus.OK).build();
				
			}
			
			if(loginForm.getCargo() == "garcom"){
				return ResponseEntity.status(HttpStatus.OK).build();
			}
			
			else{ // É funcionario da cozinha
				return ResponseEntity.status(HttpStatus.OK).build();
			}
			
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

	}
}