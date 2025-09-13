package org.example.mcpserver.tools;


import jdk.jfr.Description;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public class StockTools {

    List<Company> companies = List.of(
            new Company("TechNova", "Software Development", 120, 5_000_000.00, "USA"),
            new Company("GreenAgro", "Agriculture", 85, 2_300_000.00, "Canada"),
            new Company("MediLife", "Healthcare", 240, 12_000_000.00, "Germany"),
            new Company("BuildPro", "Construction", 310, 9_500_000.00, "France"),
            new Company("FinScope", "Financial Services", 150, 7_800_000.00, "UK")
    );


    @Tool(
            description = "Retrieve a list of companies with their details including name, activity, number of employees, turnover, and country."
    )
    public List<Company> getCompanies() {
        return companies;
    }



    @Tool
    public Company getCompany(String name) {
        return companies.stream()
                .filter(company -> company.name().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Company not found: " + name));
    }


    @Tool
    public Stock getStockByCompanyName(String name) {
        return new Stock(name,LocalDate.now(),300+Math.random()*300);

    }


    record Company(String name, String activity, int employees, @Description("In dinar tunisien") double turnover, String country) {

    }

    record Stock(String CompanyName, LocalDate date, double Stack) {}
}
