package com.projeto.ufc.resource;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.ufc.criptografia.Criptografia;
import com.projeto.ufc.domain.Usuario;
import com.projeto.ufc.repository.UsuarioRepository;


@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UsuarioRepository usuarioDAO;
	
	
	@RequestMapping(method = RequestMethod.POST,consumes="application/json")
	public BodyBuilder realizarLogin(String login, String senha, String cargo, HttpSession session) throws NoSuchAlgorithmException{
		
		Usuario usuario = usuarioDAO.findByLoginLike(login);
		String senhaCriptografada = Criptografia.convertPasswordToMD5(senha);
	
		if(usuario.getSenha().equals(senhaCriptografada)){ 
			
			if(cargo == "gerente"){
				session.setAttribute("gerenteLogado",cargo);
				return ResponseEntity.status(HttpStatus.OK);
				
			}
			
			if(cargo == "garcom"){
				session.setAttribute("leitorLogado",cargo);
				return ResponseEntity.status(HttpStatus.OK);
			}
			
			else{ // É funcionario da cozinha
				session.setAttribute("cozinhaLogado",cargo);
				return ResponseEntity.status(HttpStatus.OK);
			}
			
		}
		
		return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY);

	}
}