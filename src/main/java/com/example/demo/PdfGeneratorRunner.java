package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.entity.Table;
import com.example.demo.service.PdfGenerateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PdfGeneratorRunner implements CommandLineRunner {

    @Autowired
    private PdfGenerateService pdfGenerateService;

    @Override
    public void run(String... args) throws Exception {
        Map<String, Object> data = new HashMap<>();
        User user = new User();
        user.setName("quangvu");
        user.setAddress("hn");
        user.setEmail("quangvu@gmail.com");
        user.setPhone("0848990151");
        data.put("user", user);

        List<Table> tables = new ArrayList<>();
        Table table1 = new Table();
        table1.setDescription("Test 1");
        table1.setQuantity(1);
        table1.setUnitPrice(100.0);
        table1.setTotal(100.0);
        tables.add(table1);

        Table table2 = new Table();
        table2.setDescription("Test 2");
        table2.setQuantity(4);
        table2.setUnitPrice(500.0);
        table2.setTotal(2000.0);
        tables.add(table2);

        Table table3 = new Table();
        table3.setDescription("Test 3");
        table3.setQuantity(2);
        table3.setUnitPrice(200.0);
        table3.setTotal(400.0);
        tables.add(table3);

        data.put("quoteItems", tables);

        pdfGenerateService.generatePdfFile("quotation", data, "quotation.pdf");
    }
}
