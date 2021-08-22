package com.ctf.bookstore;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

	@PersistenceContext
	private EntityManager em; // ใช้เรียกเมธอดจัดการฐานข้อมูลที่สร้าง

	public List<Book> findAll() {
		Query q = em.createQuery("from Book"); // สรา้งค าสงั่ SELECT ข ้อมูลจากตาราง customer
		return q.getResultList();// ดึงรายการผลลัพธ์จากการ Query สง่ กลบ
	}

	public Book get(Integer codebook) {
		return em.find(Book.class, codebook); // ค้นหา Customer ตาม id
	}

	@Transactional
	public Book save(Book book) {
		em.persist(book);
//		em.createNativeQuery("INSERT INTO bookstore.book (codebook, bookname, writer, price, stork, image) VALUES (?,?,?,?,?,?)")
//				.setParameter(1, book.getCodebook()).setParameter(2, book.getBookname())
//				.setParameter(3, book.getWriter()).setParameter(4, book.getPrice()).setParameter(5, book.getStork())
//				.setParameter(6, book.getImage())
//				.executeUpdate();
		return book;
	}

	@Transactional
	public Book edit(Integer codebook, Book book) {
		em.createNativeQuery(
				"UPDATE `bookstore`.`book` SET `bookname` = '', `price` = '', `writer` = '', `stork` = '',  `image` = '', WHERE (`codebook` = 'codebook')")
				.executeUpdate();
		return book;
	}

	@Transactional
	public void delete(Integer codebook) {
		Book book = em.find(Book.class, codebook); // ค้นหาตาม idที่ต้องการลบ
		em.remove(book); // เริ่มลบจริง
	}
}