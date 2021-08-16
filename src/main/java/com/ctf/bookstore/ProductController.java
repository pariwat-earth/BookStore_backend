package com.ctf.bookstore;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin("*")
@RestController
public class ProductController {
	@Autowired
	BookRepository repo;

	@GetMapping("/book") //ดูทั้งหมด
	public List<Book> home() {
		List<Book> booklist = repo.findAll();
		return booklist;
	}

	@GetMapping("/book/{codebook}") //ดูที่ละตัว
	public Book get(@PathVariable("codebook") Integer codebook) {
		return repo.get(codebook);
	}


	@PostMapping("/book") //เพิ่ม
	public Book addbook(@RequestBody Book book) {
		return repo.save(book);
	}
	
	@PutMapping("/book/{codebook}") //แก้ไข
	public Book editbook(@PathVariable("codebook") Integer codebook , @RequestBody Book book) {
		Book editbook = repo.get(codebook);
		editbook.setCodebook(book.getCodebook());
		editbook.setBookname(book.getBookname());
		editbook.setWriter(book.getWriter());
		editbook.setPrice(book.getPrice());
		editbook.setStork(book.getStork());
		editbook.setImage(book.getImage());
		return repo.edit(codebook,book);
		
	}

	@DeleteMapping("/book/{codebook}") //ลบ
	public void deleteCustomer(@PathVariable("codebook") Integer codebook) {
		repo.delete(codebook);
	}
}
