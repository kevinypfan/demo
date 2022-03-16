package kevins.fun.demo.controller;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.ReadContext;
import kevins.fun.demo.dto.CaseStyleDTO;
import kevins.fun.demo.enums.CaseStyles;
import kevins.fun.demo.utils.JsonParser;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController("DummyController")
@RequestMapping("/dummy")
public class DummyController {
    @GetMapping("")
    public List<CaseStyleDTO> getEnumSet() {
        List<CaseStyles> somethingList =
                new ArrayList<CaseStyles>(EnumSet.allOf(CaseStyles.class));
        List<CaseStyleDTO> caseStyleDTOS = somethingList.stream().map(CaseStyleDTO::new).collect(Collectors.toList());

        return caseStyleDTOS;
    }

    @GetMapping("/hello")
    public Map<String, String> getWorld() {
        Map<String, String> result = new HashMap<>();
        result.put("hello", "world");
        return result;
    }

    @PostMapping("/json")
    public String getJson(@RequestBody String data) {
        JsonParser jsonParser = new JsonParser(data);
        System.out.println(jsonParser.getPathList());
        System.out.println(jsonParser);

        DocumentContext parse = JsonPath.parse(data);

        try {
            Object read1 = parse.read("$.name");
            System.out.println(read1.toString());
        } catch (PathNotFoundException e) {
            System.out.println("PathNotFound");
        }

        jsonParser.getPathList().forEach(s -> {
            Object read = parse.read(s);
            System.out.println(read.toString());

            String lastKey = s.substring(s.lastIndexOf("."));
            if (lastKey.indexOf("number") > -1) {
                parse.set(s, "0912-123-123");
            }
        });

        System.out.println(parse.json().toString());

        return "Done";
    }
}
