package com.guoguo.ningxing.dao.company;

import com.guoguo.ningxing.entity.company.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyDao {

    Company getCompanyById(@Param("id") Long id);

    void addCompany(Company company);

    void updateCompanyById(Company company);

    void deleteCompanyById(@Param("id") Long id);

    List<Company> getCompanyList();

    Company getCompany(int type);
}
