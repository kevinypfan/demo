package kevins.fun.demo.utils;

import kevins.fun.demo.enums.CaseStyles;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class PageSort {


    public static Pageable of(int size, int page, String sort, CaseStyles caseStyles) {
        List<Sort.Order> orders = new ArrayList<Sort.Order>();

        if (caseStyles == CaseStyles.SNAKE) {
            if (sort.contains(";")) {
                String[] sorts =  sort.split(";");
                for (String sortOrder : sorts) {
                    String[] _sort = sortOrder.split(",");
                    orders.add(new Sort.Order(_sort[1].equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, camelToSnake(_sort[0])));
                }
            } else {
                String[] _sort = sort.split(",");
                orders.add(new Sort.Order(_sort[1].equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, camelToSnake(_sort[0])));
            }
        } else {
            if (sort.contains(";")) {
                String[] sorts =  sort.split(";");
                for (String sortOrder : sorts) {
                    String[] _sort = sortOrder.split(",");
                    orders.add(new Sort.Order(_sort[1].equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, _sort[0]));
                }
            } else {
                String[] _sort = sort.split(",");
                orders.add(new Sort.Order(_sort[1].equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, _sort[0]));
            }
        }

        if (Integer.valueOf(size).equals(0)) {
            return PageRequest.of(0, Integer.MAX_VALUE, Sort.by(orders));
        } else {
            return PageRequest.of(page, size, Sort.by(orders));
        }
    }

    public static String camelToSnake(String str) {
        // Regular Expression
        String regex = "([a-z])([A-Z]+)";

        // Replacement string
        String replacement = "$1_$2";

        str = str.replaceAll(regex, replacement).toLowerCase();

        return str;
    }

    public static String kebabToSnake(String str) {
        str = str.replaceAll("-", "_").toLowerCase();
        return str;
    }
}
