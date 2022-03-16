package kevins.fun.demo.rest;

import kevins.fun.demo.entity.Faq;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
public class FaqTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @Order(1)
    void shouldCreateNewFaq() {

        var newFaq = new Faq();

        newFaq.setProjectCode("JWY");
        newFaq.setQuestion("q");
        newFaq.setAnswer("a");

        this.webTestClient
                .post()
                .uri("/cms/faqs")
                .body(Mono.just(newFaq), Faq.class)
                .accept(MediaType.APPLICATION_JSON)
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .header(ACCEPT, APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .returnResult(Faq.class);
    }


    @Test
    @Order(2)
    void shouldReturnThreeDefaultUsers() {
        this.webTestClient
                .get()
                .uri("/cms/faqs")
                .header(ACCEPT, APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus().isOk()
//                .is2xxSuccessful()
                .expectHeader()
                .contentType(APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.content.length()").isEqualTo(1)
                .jsonPath("$.content[0].idFaqs").isEqualTo(1)
                .jsonPath("$.content[0].question").isEqualTo("q")
                .jsonPath("$.content[0].answer").isEqualTo("a")
                .jsonPath("$.content[0].projectCode").isEqualTo("JWY")
                .jsonPath("$.content[0].delMemberId").isEmpty()
                .consumeWith(System.out::println);


    }

//    @Test
//    void shouldNotSupportMediaTypeXML() {
//        this.webTestClient
//                .get()
//                .uri("/api/users")
//                .header(ACCEPT, APPLICATION_XML_VALUE)
//                .exchange()
//                .expectStatus()
//                .isEqualTo(NOT_ACCEPTABLE);
//    }
//

//
//    @Test
//    void shouldReturnNotFoundForUnknownUserId() {
//        this.webTestClient
//                .get()
//                .uri("/api/users/{id}", 42)
//                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
//                .exchange()
//                .expectStatus()
//                .isEqualTo(NOT_FOUND);
//    }
}

