package com.zking.killprovider.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 环绕通知处理分页
 *
 * @author Administrator
 * @create 2019-11-0915:11
 */
@Component
@Aspect
public class PagingInterceptor {

    //@Around(value = "execution(* *..*Service.*Page(..))")
    @Around(value = "@annotation(com.zking.killprovider.annotation.Paging))")
    public Object paging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object[] args = proceedingJoinPoint.getArgs();

        PageBean pageBean = getPageBean(args);

        if (pageBean != null && pageBean.isPagination()) {
            PageHelper.startPage(pageBean.getPage(), pageBean.getRows());
        }

        Object rv = proceedingJoinPoint.proceed();

        if(pageBean != null && pageBean.isPagination() && rv != null) {
            PageInfo pageInfo = new PageInfo((List)rv);
            pageBean.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());
        }

        return rv;
    }

    //获取pagebean对象
    private PageBean getPageBean(Object[] args) {
        PageBean pageBean = null;
        for (Object arg : args) {
            if (arg instanceof PageBean) {
                pageBean = (PageBean) arg;
            }
        }
        return pageBean;
    }

}
