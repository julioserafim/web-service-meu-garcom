package com.projeto.ufc.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.ufc.domain.Cardapio;
import com.projeto.ufc.domain.Prato;
import com.projeto.ufc.domain.Usuario;
import com.projeto.ufc.service.GerenteService;
import com.projeto.ufc.service.UsuarioService;

@RestController
@RequestMapping("/gerente")
public class GerenteController {
	@Autowired
	private GerenteService gerenteService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/prato",method = RequestMethod.POST,consumes="application/json")
	public String adicionarPratoGerente(@RequestBody Prato prato){
		gerenteService.adicionarPrato(prato);
		return "Salvo com sucesso";
	}
	
	@RequestMapping(value = "/prato/{id}",method = RequestMethod.DELETE,consumes="application/json")
	public String removerPrato(@PathVariable("id")Long id){
		gerenteService.deletarPrato(id);
		return "Deletado com sucesso";
	}
	
	
	@RequestMapping(value = "/funcionario",method = RequestMethod.POST,consumes="application/json")
	public String adicionarFuncionario(@RequestBody Usuario usuario){
		usuarioService.adicionarUsuario(usuario);
		return "Salvo com sucesso";
	}
	
	
	@RequestMapping(value = "/funcionario/{id}",method = RequestMethod.DELETE,consumes="application/json")
	public String removerFuncionario(@PathVariable("id")Long id){
		usuarioService.removerUsuario(id);
		return "Salvo com sucesso";
	}
	
	@RequestMapping(value = "/funcionario",method = RequestMethod.GET,produces="application/json")
	public List<Usuario> listarUsuario(){
		return gerenteService.retornarTodosFuncionarios();
	} 
	
	
	@RequestMapping(value = "/cardapio",method = RequestMethod.GET,produces="application/json")
	public List<Prato> retornarCardarpio(){
		return gerenteService.retornarCardapio();
	}
	
	
	
}
