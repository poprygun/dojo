package io.pivotal.tg;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("bjj")
public class BjjDojoTests extends DojoApplicationTests{
    @Test
    public void verifyDisciplineTechniques() throws Exception {
        verifyDisciplineTechniques(2);
    }
}
