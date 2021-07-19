package com.jt;

import com.jt.pojo.Rights;
import com.jt.service.RightsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RightsTests {
    @Autowired
    private RightsService rightsService;

    @Test
    public void getRightsList(){
        List<Rights> list = rightsService.getRightsList();
        list.forEach(rights ->
                        System.err.println(rights)
                );
    }
}
