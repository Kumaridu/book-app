package books;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BookRestClientApplication implements CommandLineRunner {

//	@Autowired
//	private RestTemplate restTemplate;;

	public static void main(String[] args) {
		SpringApplication.run(BookRestClientApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		RestTemplate restTemplate = restTemplate();
		String serverUrl = "http://localhost:8080/books";
		System.out.println("Hello world");

		// add book "The Hobbit"
		restTemplate.postForLocation(serverUrl,
				new Book("9780345339683", "J.R.R. Tolkien", "The Hobbit", 11.99 ));

		// add book "Pride and Prejudice"
		restTemplate.postForLocation(serverUrl,
				new Book("9780141439518", "Jane Austen", "Pride and Prejudice",7.99));


		// get "The Hobbit"
		Book book = restTemplate.getForObject(serverUrl + "/{isbn}", Book.class, "9780345339683");
		System.out.println("-------------------- get The Hobbit ----------------");
		System.out.println(book);


		// get all books
		Books books = restTemplate.getForObject(serverUrl, Books.class);
		System.out.println("------------------- get all books -----------------");
		System.out.println(books);

		// update book
		book.setPrice(13.99);
		restTemplate.put(serverUrl + "/{isbn}", book, "9780345339683");

		// delete book "The Pride and PreJudice"
        restTemplate.delete(serverUrl + "/{isbn}", "9780141439518");

		// get all books
		books = restTemplate.getForObject(serverUrl, Books.class);
		System.out.println("------------------- get all books -----------------");
		System.out.println(books);
	}


}
