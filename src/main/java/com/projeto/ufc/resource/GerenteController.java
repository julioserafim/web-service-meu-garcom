package com.projeto.ufc.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.ufc.domain.Cardapio;
import com.projeto.ufc.domain.Prato;
import com.projeto.ufc.domain.Restaurante;
import com.projeto.ufc.domain.Usuario;
import com.projeto.ufc.service.GerenteService;
import com.projeto.ufc.service.RestauranteService;
import com.projeto.ufc.service.UsuarioService;

@RestController
@RequestMapping("/gerente")
public class GerenteController {
	@Autowired
	private GerenteService gerenteService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.POST,consumes="application/json")
	public String adicionarPratoGerente(@RequestBody Prato prato, Long restaurante){
		gerenteService.adicionarPrato(prato, restaurante);
		return "Salvo com sucesso";
	}
	
	@RequestMapping(method = RequestMethod.DELETE,consumes="application/json")
	public String removerPrato(Long id){
		gerenteService.deletarPrato(id);
		return "Salvo com sucesso";
	}
	
	
	@RequestMapping(value = "/funcionario/",method = RequestMethod.POST,consumes="application/json")
	public String adicionarFuncionario(@RequestBody Usuario usuario){
		usuarioService.adicionarUsuario(usuario);
		return "Salvo com sucesso";
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE,consumes="application/json")
	public String removerFuncionario(Long id){
		usuarioService.removerUsuario(id);
		return "Salvo com sucesso";
	}
	
	@RequestMapping(method = RequestMethod.GET,produces="application/json")
	public List<Usuario> listarUsuario(Long restaurante){
		return gerenteService.retornarTodosFuncionarios(restaurante);
	}; 
	
	
	@RequestMapping(method = RequestMethod.GET,produces="application/json")
	public Cardapio retornarCardarpioRestaurante(Long restaurante){
		return gerenteService.retornarCardapioRestaurante(restaurante);
	}; 
	
	
	

}
