package kevins.fun.demo.controller;

import kevins.fun.demo.entity.Faq;
import kevins.fun.demo.enums.CaseStyles;
import kevins.fun.demo.repository.FaqRepository;
import kevins.fun.demo.utils.PageSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@RestController("CmsFaqController")
@RequestMapping("/cms")
public class FaqController {

    @Autowired
    private FaqRepository faqRepository;


    @GetMapping("/faqs")
    public Page<Faq> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "idFaqs,desc") String sort,
            @RequestParam(required = false) String q
    ) {
        Pageable pagingSort = PageSort.of(size, page, sort, CaseStyles.CAMEL);
        Specification<Faq> spec = Specification.where(null);

        if (q != null) {
            spec = spec.and(Faq.searchQuery(q));
        }

        return faqRepository.findAll(spec, pagingSort);
    }

    @GetMapping("/faqs/{idFaqs}")
    public Faq findById(
            @PathVariable Long idFaqs
    ) {
        return faqRepository.findById(idFaqs).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        ));
    }

    @PostMapping("/faqs")
    public Faq create(
            @RequestBody Faq faq
    ) {
        return faqRepository.save(faq);
    }

    @DeleteMapping("/faqs/{idFaqs}")
    public void deleteById(
            @PathVariable Long idFaqs
    ) {
        faqRepository.deleteById(idFaqs);
    }
}
