package app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.Entity.Produto;
import app.Service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Produto produto){
			String message = this.produtoService.save(produto);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id){
			String message = this.produtoService.deleteById(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Produto> findById(@PathVariable long id){
			Produto produto = this.produtoService.findById(id);
			return new ResponseEntity<>(produto, HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Produto>> findAll(){
			List<Produto> list = this.produtoService.findAll();
			return new ResponseEntity<>(list,  HttpStatus.OK);
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Produto produto,@PathVariable long id){
			String message = this.produtoService.update(produto, id);
			return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
