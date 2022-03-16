package kevins.fun.demo.dto;

import kevins.fun.demo.enums.CaseStyles;
import lombok.Data;

@Data
public class CaseStyleDTO {
    private String value;
    private String info;

    public CaseStyleDTO() {

    }

    public CaseStyleDTO(CaseStyles caseStyles) {
        this.value = caseStyles.getValue();
        this.info = caseStyles.getInfo();
    }
}
