package com.mwq.manage.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mwq.manage.domain.entity.NewsEntity;
import com.mwq.manage.mapper.NewsMapper;
import com.mwq.manage.service.NewsService;
import org.springframework.stereotype.Service;

/**
 * 新闻资讯表(News)表服务实现类
 *
 * @author wq
 * @since 2021-09-16 14:47:30
 */
@Service("newsService")
public class NewsServiceImpl extends ServiceImpl<NewsMapper, NewsEntity> implements NewsService {

}