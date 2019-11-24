package com.guoguo.ningxing.controller.company;

import com.guoguo.ningxing.entity.company.Company;
import com.guoguo.ningxing.service.company.CompanyService;
import com.guoguo.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminCompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/companyAboutUs")
    public String companyAboutUs(HttpServletRequest request) {
        Integer type = 2;
        String name = "关于我们";
        Company company = companyService.getCompany(type);
        request.setAttribute("company", company);
        request.setAttribute("type",type);
        request.setAttribute("name",name);
        return "admin/company/companyProfile";
    }

    @RequestMapping("/companyProfile")
    public String companyProfile(HttpServletRequest request) {
        Integer type = 1;
        String name = "公司简介";
        Company company = companyService.getCompany(type);
        request.setAttribute("company", company);
        request.setAttribute("type",type);
        request.setAttribute("name",name);
        return "admin/company/companyProfile";
    }

    @RequestMapping("/ajax/companyProfile")
    @ResponseBody
    public Json companyProfile(@RequestParam String content, @RequestParam String url, @RequestParam Integer type, Long id) {
        Company company = new Company();
        company.setId(id);
        company.setContent(content);
        company.setUrl(url);
        company.setType(type);
        if (id == null) {
            companyService.addCompany(company);
        } else {
            companyService.updateCompanyById(company);
        }
        return Json.jsonTrue();
    }
}
