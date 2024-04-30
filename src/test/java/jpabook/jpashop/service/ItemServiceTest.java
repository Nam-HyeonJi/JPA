package jpabook.jpashop.service;

import jakarta.transaction.Transactional;
import jpabook.jpashop.domain.item.Album;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Movie;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {

    @Autowired ItemService itemService;
    @Autowired ItemRepository itemRepository;

    @Test
    public void 상품등록() throws Exception {
        //given
        Book book = new Book();
        book.setAuthor("author");
        book.setIsbn("1234-1234");

        Album album = new Album();
        album.setArtist("artist");
        album.setEtc("etc...");

        Movie movie = new Movie();
        movie.setDirector("director");
        movie.setActor("actor");
        
        //when
        Long bookId = itemService.saveItem(book);
        Long movieId = itemService.saveItem(movie);
        Long albumId = itemService.saveItem(album);

        //then
        assertEquals(book, itemRepository.findOne(bookId));
        assertEquals(movie, itemRepository.findOne(movieId));
        assertEquals(album, itemRepository.findOne(albumId));
    }
}