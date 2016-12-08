package com.projeto.ufc.resource;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
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
	public String realizarLogin(@RequestBody LoginForm loginForm) throws NoSuchAlgorithmException{
		
		System.out.println("LOGIN:" + loginForm.getLoginDigitado());
		Usuario usuario = usuarioDAO.findByLoginLike(loginForm.getLoginDigitado());
		String senhaCriptografada = Criptografia.convertPasswordToMD5(loginForm.getSenhaDigitada());
	
		if(usuario.getSenha().equals(senhaCriptografada)){ 
			
			if(loginForm.getCargo() == "gerente"){
				return "{\"msg\": \"OK\"}";
				
			}
			
			if(loginForm.getCargo() == "garcom"){
				return "{\"msg\": \"OK\"}";
			}
			
			else{ // É funcionario da cozinha
				return "{\"msg\": \"OK\"}";
			}
			
		}
		
		return "{\"msg\": \"ERROR\"}";

	}
}