package io.pivotal.tg;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("judo")
public class JudoDojoTests extends DojoApplicationTests{
    @Test
    public void verifyDisciplineTechniques() throws Exception {
        verifyDisciplineTechniques(1);
    }
}
