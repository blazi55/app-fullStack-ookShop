package com.ookshop.application.book;
import com.ookshop.application.tables.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookDto getBook(long bookId) {
      Book book =  bookRepository.findById(bookId).orElseThrow(IllegalArgumentException::new);
      return bookMapper.toDto(book);
    }

    public List<BookDto> getBooks() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        return bookMapper.toDtoList(books);
    }

    public BookDto createBook(BookDto bookDto) {
        final Book book = Book.builder()
                .id(bookDto.getId())
                .name(bookDto.getName())
                .price(bookDto.getPrice())
                .build();
        bookRepository.save(book);
        return bookMapper.toDto(book);
    }

}
