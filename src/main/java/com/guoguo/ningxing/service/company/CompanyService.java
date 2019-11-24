package com.guoguo.ningxing.service.company;

import com.github.pagehelper.PageHelper;
import com.guoguo.ningxing.dao.company.CompanyDao;
import com.guoguo.ningxing.entity.company.Company;
import com.guoguo.util.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private RequestService requestService;

    public Company getCompanyById(Long id) {
        return companyDao.getCompanyById(id);
    }

    public void addCompany(Company company) {
        Date date = new Date();
        company.setAddTime(date);
        company.setUpdateTime(date);
        companyDao.addCompany(company);
    }

    public void updateCompanyById(Company company) {
        company.setUpdateTime(new Date());
        companyDao.updateCompanyById(company);
    }

    public void deleteCompanyById(Long id) {
        companyDao.deleteCompanyById(id);
    }

    public List<Company> getCompanyList(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        return companyDao.getCompanyList();
    }

    public Company getCompany(int type) {
        return companyDao.getCompany(type);
    }
}
