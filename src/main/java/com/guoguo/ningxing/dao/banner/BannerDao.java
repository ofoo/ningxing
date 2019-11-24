package com.guoguo.ningxing.dao.banner;

import com.guoguo.ningxing.entity.banner.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDao {

    Banner getBannerById(@Param("id") Long id);

    void addBanner(Banner banner);

    void updateBannerById(Banner banner);

    void deleteBannerById(@Param("id") Long id);

    List<Banner> getBannerList();

    Banner getBanner();

}
