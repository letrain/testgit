package com.website.tasks;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import com.website.dao.CpTypeDAO;
import com.website.dto.CpDto;
import com.website.entity.CpHistory;
import com.website.entity.Cplatest;
import com.website.entity.WebStats;
import com.website.enums.CodeEnums;
import com.website.exception.CpException;
import com.website.service.CpHisService;
import com.website.service.CpLatestService;
import com.website.service.WebStatsService;
import com.website.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by letrain on 2017/11/13.
 */
@EnableScheduling
@Component
@Slf4j
public class CpGetAndSave {
    @Autowired
    private CpHisService cpHisService;

    @Autowired
    private CpLatestService cpLatestService;

    @Autowired
    private CpTypeDAO cpTypeDAO;

    private String No;
    private Integer typeid;
    private static CpHistory  cpHistory = new CpHistory();
    private static Cplatest cplatest = new Cplatest();

    @Scheduled(fixedRate = 1000*5,initialDelay = 1000*5)
    @Transactional
    public void timerSave(){
        log.info("****定时获取数据并保存cp开奖结果信息***");
        List<CpDto> cpDtoList = GsonUtils.getResult();
        if(cpDtoList == null){
            log.error("【获取API开奖结果】异常");
            throw new CpException(CodeEnums.GET_CP_RESULT_ERROR);
        }
        cpHistory.setPlatform("API");
        for(CpDto cpDto : cpDtoList){
            No = cpDto.getExpect();
            typeid = cpTypeDAO.findByTypename(cpDto.getCode()).getTypeid();
            if(cpHisService.findOne(No,typeid) == null){
                //那就保存到数据库
                cpHistory.setNo(cpDto.getExpect());
                String[] split = cpDto.getOpencode().split("\\+");
                if(split.length>1){
                    cpHistory.setAfter_nums(split[0].replaceAll(",","-"));
                    cpHistory.setAfter_specialnums(split[1]);
                }else {
                    cpHistory.setAfter_nums(split[0].replaceAll(",","-"));
                }
                cpHistory.setOpendate(cpDto.getOpentime());
                cpHistory.setTypename(cpDto.getCode());
                cpHistory.setTypeid(typeid);
                cpHisService.insert(cpHistory);
                log.info("*********保存cphistory成功********");
            }

            //更新最新开奖结果
            if(cpLatestService.findOne(No,typeid) == null){
                //那就保存
                cplatest.setTypeid(typeid);
                cplatest.setNo(cpDto.getExpect());
                cplatest.setOpendate(cpDto.getOpentime());
                String[] split = cpDto.getOpencode().split("\\+");
                if(split.length>1){
                    cplatest.setNums(split[0].replaceAll(",","-"));
                    cplatest.setSpecialnums(split[1]);
                }else {
                    cplatest.setNums(cpDto.getOpencode().replaceAll(",","-"));
                }
                cpLatestService.insert(cplatest);
                log.info("******保存Cplast成功********");
            }
        }
    }

    public static void setVaule(CpDto cpDto){
        cpHistory.setNo(cpDto.getExpect());
        String[] split = cpDto.getOpencode().split("\\+");
        if(split.length>1){
            cpHistory.setAfter_nums(split[0].replaceAll(",","-"));
            cpHistory.setAfter_specialnums(split[1]);
        }else {
            cpHistory.setAfter_nums(split[0].replaceAll(",","-"));
        }
        cpHistory.setOpendate(cpDto.getOpentime());
        cpHistory.setTypename(cpDto.getCode());
    }

}
