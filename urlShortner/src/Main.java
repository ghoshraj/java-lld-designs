import com.urlshortner.hash.RandomHashGenerator;
import com.urlshortner.repo.InMemoryURLRepository;
import com.urlshortner.service.URLShortenerService;

public class Main {
    public static void main(String[] args) {

        URLShortenerService urlShortenerService = new URLShortenerService(new InMemoryURLRepository(), new RandomHashGenerator());
        String shortUrl = urlShortenerService.generateShortUrl("https://www.google.com");
        System.out.println(shortUrl);
        String longUrl = urlShortenerService.getLongUrl(shortUrl);
        System.out.println(longUrl);
    }
}