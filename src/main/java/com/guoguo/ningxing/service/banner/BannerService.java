package com.guoguo.ningxing.service.banner;

import com.github.pagehelper.PageHelper;
import com.guoguo.ningxing.dao.banner.BannerDao;
import com.guoguo.ningxing.entity.banner.Banner;
import com.guoguo.util.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BannerService {
    @Autowired
    private BannerDao bannerDao;
    @Autowired
    private RequestService requestService;
    
    public Banner getBannerById(Long id) {
        return bannerDao.getBannerById(id);
    }

    public void addBanner(Banner banner) {
        Date date = new Date();
        banner.setAddTime(date);
        banner.setUpdateTime(date);
        bannerDao.addBanner(banner);
    }

    public void updateBannerById(Banner banner) {
        banner.setUpdateTime(new Date());
        bannerDao.updateBannerById(banner);
    }

    public void deleteBannerById(Long id) {
        bannerDao.deleteBannerById(id);
    }

    public List<Banner> getBannerList(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        return bannerDao.getBannerList();
    }

    public Banner getBanner() {
        return bannerDao.getBanner();
    }
}
