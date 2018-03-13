package com.szht.service.impl;
import com.szht.model.custom.BcCustom;
import com.szht.model.BcExample;
import com.szht.model.custom.BcinfoCustom;
import com.szht.model.BcinfoExample;
import com.szht.model.custom.BctbhbCustom;
import com.szht.model.BctbhbExample;
import com.szht.model.custom.JcdmCustom;
import com.szht.model.JcdmExample;
import com.szht.model.custom.ProblemsCustom;
import com.szht.model.ProblemsExample;
import com.szht.model.custom.SiteCustom;
import com.szht.model.SiteExample;
import com.szht.model.custom.UserCustom;
import com.szht.model.UserExample;
import com.szht.model.custom.UserPermissionCustom;
import com.szht.model.UserPermissionExample;
import com.szht.model.custom.XzdmCustom;
import com.szht.model.XzdmExample;
import org.springframework.stereotype.Service;
import com.szht.service.Toexampleservice;
@Service
public class Toexampleserviceimpl implements Toexampleservice{
@Override
public BcExample bctoexample(BcCustom record) {
BcExample bcExample=new BcExample();
com.szht.model.BcExample.Criteria criteria=bcExample.createCriteria();
if(record.getBc()==null)
{if(record.getId()!=null)
criteria.andIdEqualTo(record.getId());
if(record.getDm()!=null&&!record.getDm().equals(""))
criteria.andDmEqualTo(record.getDm());
if(record.getYear()!=null)
criteria.andYearEqualTo(record.getYear());
if(record.getMonth()!=null)
criteria.andMonthEqualTo(record.getMonth());
if(record.getGmsy()!=null)
criteria.andGmsyEqualTo(record.getGmsy());
if(record.getAd()!=null)
criteria.andAdEqualTo(record.getAd());
if(record.getZl()!=null)
criteria.andZlEqualTo(record.getZl());
}
else {
if(record.getBc().getId()!=null&&record.getId()!=null)
criteria.andIdBetween(record.getId(), record.getBc().getId());
else if(record.getId()!=null)
criteria.andIdEqualTo(record.getId());
else if(record.getBc().getId()!=null)
criteria.andIdLessThanOrEqualTo(record.getBc().getId());
if(record.getBc().getDm()!=null&&record.getDm()!=null&&!record.getBc().getDm().equals("")&&!record.getDm().equals(""))
criteria.andDmBetween(record.getDm(), record.getBc().getDm());
else if(record.getDm()!=null&&!record.getDm().equals(""))
criteria.andDmEqualTo(record.getDm());
else if(record.getBc().getDm()!=null&&!record.getBc().getDm().equals(""))
criteria.andDmLike("%"+record.getBc().getDm()+"%");
if(record.getBc().getYear()!=null&&record.getYear()!=null)
criteria.andYearBetween(record.getYear(), record.getBc().getYear());
else if(record.getYear()!=null)
criteria.andYearEqualTo(record.getYear());
else if(record.getBc().getYear()!=null)
criteria.andYearLessThanOrEqualTo(record.getBc().getYear());
if(record.getBc().getMonth()!=null&&record.getMonth()!=null)
criteria.andMonthBetween(record.getMonth(), record.getBc().getMonth());
else if(record.getMonth()!=null)
criteria.andMonthEqualTo(record.getMonth());
else if(record.getBc().getMonth()!=null)
criteria.andMonthLessThanOrEqualTo(record.getBc().getMonth());
if(record.getBc().getGmsy()!=null&&record.getGmsy()!=null)
criteria.andGmsyBetween(record.getGmsy(), record.getBc().getGmsy());
else if(record.getGmsy()!=null)
criteria.andGmsyEqualTo(record.getGmsy());
else if(record.getBc().getGmsy()!=null)
criteria.andGmsyLessThanOrEqualTo(record.getBc().getGmsy());
if(record.getBc().getAd()!=null&&record.getAd()!=null)
criteria.andAdBetween(record.getAd(), record.getBc().getAd());
else if(record.getAd()!=null)
criteria.andAdEqualTo(record.getAd());
else if(record.getBc().getAd()!=null)
criteria.andAdLessThanOrEqualTo(record.getBc().getAd());
if(record.getBc().getZl()!=null&&record.getZl()!=null)
criteria.andZlBetween(record.getZl(), record.getBc().getZl());
else if(record.getZl()!=null)
criteria.andZlEqualTo(record.getZl());
else if(record.getBc().getZl()!=null)
criteria.andZlLessThanOrEqualTo(record.getBc().getZl());
}return bcExample;
}
@Override
public BcinfoExample bcinfotoexample(BcinfoCustom record) {
BcinfoExample bcinfoExample=new BcinfoExample();
com.szht.model.BcinfoExample.Criteria criteria=bcinfoExample.createCriteria();
if(record.getBcinfo()==null)
{if(record.getId()!=null)
criteria.andIdEqualTo(record.getId());
if(record.getDmmc()!=null&&!record.getDmmc().equals(""))
criteria.andDmmcEqualTo(record.getDmmc());
if(record.getMubiao()!=null)
criteria.andMubiaoEqualTo(record.getMubiao());
if(record.getHlmc()!=null&&!record.getHlmc().equals(""))
criteria.andHlmcEqualTo(record.getHlmc());
if(record.getDmlb()!=null&&!record.getDmlb().equals(""))
criteria.andDmlbEqualTo(record.getDmlb());
}
else {
if(record.getBcinfo().getId()!=null&&record.getId()!=null)
criteria.andIdBetween(record.getId(), record.getBcinfo().getId());
else if(record.getId()!=null)
criteria.andIdEqualTo(record.getId());
else if(record.getBcinfo().getId()!=null)
criteria.andIdLessThanOrEqualTo(record.getBcinfo().getId());
if(record.getBcinfo().getDmmc()!=null&&record.getDmmc()!=null&&!record.getBcinfo().getDmmc().equals("")&&!record.getDmmc().equals(""))
criteria.andDmmcBetween(record.getDmmc(), record.getBcinfo().getDmmc());
else if(record.getDmmc()!=null&&!record.getDmmc().equals(""))
criteria.andDmmcEqualTo(record.getDmmc());
else if(record.getBcinfo().getDmmc()!=null&&!record.getBcinfo().getDmmc().equals(""))
criteria.andDmmcLike("%"+record.getBcinfo().getDmmc()+"%");
if(record.getBcinfo().getMubiao()!=null&&record.getMubiao()!=null)
criteria.andMubiaoBetween(record.getMubiao(), record.getBcinfo().getMubiao());
else if(record.getMubiao()!=null)
criteria.andMubiaoEqualTo(record.getMubiao());
else if(record.getBcinfo().getMubiao()!=null)
criteria.andMubiaoLessThanOrEqualTo(record.getBcinfo().getMubiao());
if(record.getBcinfo().getHlmc()!=null&&record.getHlmc()!=null&&!record.getBcinfo().getHlmc().equals("")&&!record.getHlmc().equals(""))
criteria.andHlmcBetween(record.getHlmc(), record.getBcinfo().getHlmc());
else if(record.getHlmc()!=null&&!record.getHlmc().equals(""))
criteria.andHlmcEqualTo(record.getHlmc());
else if(record.getBcinfo().getHlmc()!=null&&!record.getBcinfo().getHlmc().equals(""))
criteria.andHlmcLike("%"+record.getBcinfo().getHlmc()+"%");
if(record.getBcinfo().getDmlb()!=null&&record.getDmlb()!=null&&!record.getBcinfo().getDmlb().equals("")&&!record.getDmlb().equals(""))
criteria.andDmlbBetween(record.getDmlb(), record.getBcinfo().getDmlb());
else if(record.getDmlb()!=null&&!record.getDmlb().equals(""))
criteria.andDmlbEqualTo(record.getDmlb());
else if(record.getBcinfo().getDmlb()!=null&&!record.getBcinfo().getDmlb().equals(""))
criteria.andDmlbLike("%"+record.getBcinfo().getDmlb()+"%");
}return bcinfoExample;
}
@Override
public BctbhbExample bctbhbtoexample(BctbhbCustom record) {
BctbhbExample bctbhbExample=new BctbhbExample();
com.szht.model.BctbhbExample.Criteria criteria=bctbhbExample.createCriteria();
if(record.getBctbhb()==null)
{if(record.getId()!=null)
criteria.andIdEqualTo(record.getId());
if(record.getDmmc()!=null&&!record.getDmmc().equals(""))
criteria.andDmmcEqualTo(record.getDmmc());
if(record.getYear()!=null)
criteria.andYearEqualTo(record.getYear());
if(record.getMonth()!=null)
criteria.andMonthEqualTo(record.getMonth());
if(record.getGmsytb()!=null)
criteria.andGmsytbEqualTo(record.getGmsytb());
if(record.getAdtb()!=null)
criteria.andAdtbEqualTo(record.getAdtb());
if(record.getZltb()!=null)
criteria.andZltbEqualTo(record.getZltb());
if(record.getGmsyhb()!=null)
criteria.andGmsyhbEqualTo(record.getGmsyhb());
if(record.getAdhb()!=null)
criteria.andAdhbEqualTo(record.getAdhb());
if(record.getZlhb()!=null)
criteria.andZlhbEqualTo(record.getZlhb());
}
else {
if(record.getBctbhb().getId()!=null&&record.getId()!=null)
criteria.andIdBetween(record.getId(), record.getBctbhb().getId());
else if(record.getId()!=null)
criteria.andIdEqualTo(record.getId());
else if(record.getBctbhb().getId()!=null)
criteria.andIdLessThanOrEqualTo(record.getBctbhb().getId());
if(record.getBctbhb().getDmmc()!=null&&record.getDmmc()!=null&&!record.getBctbhb().getDmmc().equals("")&&!record.getDmmc().equals(""))
criteria.andDmmcBetween(record.getDmmc(), record.getBctbhb().getDmmc());
else if(record.getDmmc()!=null&&!record.getDmmc().equals(""))
criteria.andDmmcEqualTo(record.getDmmc());
else if(record.getBctbhb().getDmmc()!=null&&!record.getBctbhb().getDmmc().equals(""))
criteria.andDmmcLike("%"+record.getBctbhb().getDmmc()+"%");
if(record.getBctbhb().getYear()!=null&&record.getYear()!=null)
criteria.andYearBetween(record.getYear(), record.getBctbhb().getYear());
else if(record.getYear()!=null)
criteria.andYearEqualTo(record.getYear());
else if(record.getBctbhb().getYear()!=null)
criteria.andYearLessThanOrEqualTo(record.getBctbhb().getYear());
if(record.getBctbhb().getMonth()!=null&&record.getMonth()!=null)
criteria.andMonthBetween(record.getMonth(), record.getBctbhb().getMonth());
else if(record.getMonth()!=null)
criteria.andMonthEqualTo(record.getMonth());
else if(record.getBctbhb().getMonth()!=null)
criteria.andMonthLessThanOrEqualTo(record.getBctbhb().getMonth());
if(record.getBctbhb().getGmsytb()!=null&&record.getGmsytb()!=null)
criteria.andGmsytbBetween(record.getGmsytb(), record.getBctbhb().getGmsytb());
else if(record.getGmsytb()!=null)
criteria.andGmsytbEqualTo(record.getGmsytb());
else if(record.getBctbhb().getGmsytb()!=null)
criteria.andGmsytbLessThanOrEqualTo(record.getBctbhb().getGmsytb());
if(record.getBctbhb().getAdtb()!=null&&record.getAdtb()!=null)
criteria.andAdtbBetween(record.getAdtb(), record.getBctbhb().getAdtb());
else if(record.getAdtb()!=null)
criteria.andAdtbEqualTo(record.getAdtb());
else if(record.getBctbhb().getAdtb()!=null)
criteria.andAdtbLessThanOrEqualTo(record.getBctbhb().getAdtb());
if(record.getBctbhb().getZltb()!=null&&record.getZltb()!=null)
criteria.andZltbBetween(record.getZltb(), record.getBctbhb().getZltb());
else if(record.getZltb()!=null)
criteria.andZltbEqualTo(record.getZltb());
else if(record.getBctbhb().getZltb()!=null)
criteria.andZltbLessThanOrEqualTo(record.getBctbhb().getZltb());
if(record.getBctbhb().getGmsyhb()!=null&&record.getGmsyhb()!=null)
criteria.andGmsyhbBetween(record.getGmsyhb(), record.getBctbhb().getGmsyhb());
else if(record.getGmsyhb()!=null)
criteria.andGmsyhbEqualTo(record.getGmsyhb());
else if(record.getBctbhb().getGmsyhb()!=null)
criteria.andGmsyhbLessThanOrEqualTo(record.getBctbhb().getGmsyhb());
if(record.getBctbhb().getAdhb()!=null&&record.getAdhb()!=null)
criteria.andAdhbBetween(record.getAdhb(), record.getBctbhb().getAdhb());
else if(record.getAdhb()!=null)
criteria.andAdhbEqualTo(record.getAdhb());
else if(record.getBctbhb().getAdhb()!=null)
criteria.andAdhbLessThanOrEqualTo(record.getBctbhb().getAdhb());
if(record.getBctbhb().getZlhb()!=null&&record.getZlhb()!=null)
criteria.andZlhbBetween(record.getZlhb(), record.getBctbhb().getZlhb());
else if(record.getZlhb()!=null)
criteria.andZlhbEqualTo(record.getZlhb());
else if(record.getBctbhb().getZlhb()!=null)
criteria.andZlhbLessThanOrEqualTo(record.getBctbhb().getZlhb());
}return bctbhbExample;
}
@Override
public JcdmExample jcdmtoexample(JcdmCustom record) {
JcdmExample jcdmExample=new JcdmExample();
com.szht.model.JcdmExample.Criteria criteria=jcdmExample.createCriteria();
if(record.getJcdm()==null)
{if(record.getId()!=null)
criteria.andIdEqualTo(record.getId());
if(record.getAndan()!=null&&!record.getAndan().equals(""))
criteria.andAndanEqualTo(record.getAndan());
if(record.getDate()!=null&&!record.getDate().equals(""))
criteria.andDateEqualTo(record.getDate());
if(record.getDiandaolv()!=null&&!record.getDiandaolv().equals(""))
criteria.andDiandaolvEqualTo(record.getDiandaolv());
if(record.getDmmc()!=null&&!record.getDmmc().equals(""))
criteria.andDmmcEqualTo(record.getDmmc());
if(record.getFlza()!=null&&!record.getFlza().equals(""))
criteria.andFlzaEqualTo(record.getFlza());
if(record.getFuhuawu()!=null&&!record.getFuhuawu().equals(""))
criteria.andFuhuawuEqualTo(record.getFuhuawu());
if(record.getGe()!=null&&!record.getGe().equals(""))
criteria.andGeEqualTo(record.getGe());
if(record.getGmsy()!=null&&!record.getGmsy().equals(""))
criteria.andGmsyEqualTo(record.getGmsy());
if(record.getGong()!=null&&!record.getGong().equals(""))
criteria.andGongEqualTo(record.getGong());
if(record.getHlmc()!=null&&!record.getHlmc().equals(""))
criteria.andHlmcEqualTo(record.getHlmc());
if(record.getHuifafen()!=null&&!record.getHuifafen().equals(""))
criteria.andHuifafenEqualTo(record.getHuifafen());
if(record.getHxxyl()!=null&&!record.getHxxyl().equals(""))
criteria.andHxxylEqualTo(record.getHxxyl());
if(record.getLiuhuawu()!=null&&!record.getLiuhuawu().equals(""))
criteria.andLiuhuawuEqualTo(record.getLiuhuawu());
if(record.getLiujiage()!=null&&!record.getLiujiage().equals(""))
criteria.andLiujiageEqualTo(record.getLiujiage());
if(record.getLiuliang()!=null&&!record.getLiuliang().equals(""))
criteria.andLiuliangEqualTo(record.getLiuliang());
if(record.getLiusuanyan()!=null&&!record.getLiusuanyan().equals(""))
criteria.andLiusuanyanEqualTo(record.getLiusuanyan());
if(record.getLvhuawu()!=null&&!record.getLvhuawu().equals(""))
criteria.andLvhuawuEqualTo(record.getLvhuawu());
if(record.getMonth()!=null)
criteria.andMonthEqualTo(record.getMonth());
if(record.getPh()!=null&&!record.getPh().equals(""))
criteria.andPhEqualTo(record.getPh());
if(record.getQian()!=null&&!record.getQian().equals(""))
criteria.andQianEqualTo(record.getQian());
if(record.getRongjieyanng()!=null&&!record.getRongjieyanng().equals(""))
criteria.andRongjieyanngEqualTo(record.getRongjieyanng());
if(record.getShen()!=null&&!record.getShen().equals(""))
criteria.andShenEqualTo(record.getShen());
if(record.getShiyoulei()!=null&&!record.getShiyoulei().equals(""))
criteria.andShiyouleiEqualTo(record.getShiyoulei());
if(record.getShuishen()!=null&&!record.getShuishen().equals(""))
criteria.andShuishenEqualTo(record.getShuishen());
if(record.getShuiweng()!=null&&!record.getShuiweng().equals(""))
criteria.andShuiwengEqualTo(record.getShuiweng());
if(record.getShxyl()!=null&&!record.getShxyl().equals(""))
criteria.andShxylEqualTo(record.getShxyl());
if(record.getSqdm()!=null&&!record.getSqdm().equals(""))
criteria.andSqdmEqualTo(record.getSqdm());
if(record.getXi()!=null&&!record.getXi().equals(""))
criteria.andXiEqualTo(record.getXi());
if(record.getXiaosuanyan()!=null&&!record.getXiaosuanyan().equals(""))
criteria.andXiaosuanyanEqualTo(record.getXiaosuanyan());
if(record.getXuanfuwu()!=null&&!record.getXuanfuwu().equals(""))
criteria.andXuanfuwuEqualTo(record.getXuanfuwu());
if(record.getYear()!=null)
criteria.andYearEqualTo(record.getYear());
if(record.getYxsy()!=null&&!record.getYxsy().equals(""))
criteria.andYxsyEqualTo(record.getYxsy());
if(record.getZjhw()!=null&&!record.getZjhw().equals(""))
criteria.andZjhwEqualTo(record.getZjhw());
if(record.getZongdan()!=null&&!record.getZongdan().equals(""))
criteria.andZongdanEqualTo(record.getZongdan());
if(record.getZongling()!=null&&!record.getZongling().equals(""))
criteria.andZonglingEqualTo(record.getZongling());
if(record.getZongyingdu()!=null&&!record.getZongyingdu().equals(""))
criteria.andZongyingduEqualTo(record.getZongyingdu());
}
else {
if(record.getJcdm().getId()!=null&&record.getId()!=null)
criteria.andIdBetween(record.getId(), record.getJcdm().getId());
else if(record.getId()!=null)
criteria.andIdEqualTo(record.getId());
else if(record.getJcdm().getId()!=null)
criteria.andIdLessThanOrEqualTo(record.getJcdm().getId());
if(record.getJcdm().getAndan()!=null&&record.getAndan()!=null&&!record.getJcdm().getAndan().equals("")&&!record.getAndan().equals(""))
criteria.andAndanBetween(record.getAndan(), record.getJcdm().getAndan());
else if(record.getAndan()!=null&&!record.getAndan().equals(""))
criteria.andAndanEqualTo(record.getAndan());
else if(record.getJcdm().getAndan()!=null&&!record.getJcdm().getAndan().equals(""))
criteria.andAndanLike("%"+record.getJcdm().getAndan()+"%");
if(record.getJcdm().getDate()!=null&&record.getDate()!=null&&!record.getJcdm().getDate().equals("")&&!record.getDate().equals(""))
criteria.andDateBetween(record.getDate(), record.getJcdm().getDate());
else if(record.getDate()!=null&&!record.getDate().equals(""))
criteria.andDateEqualTo(record.getDate());
else if(record.getJcdm().getDate()!=null&&!record.getJcdm().getDate().equals(""))
criteria.andDateLike("%"+record.getJcdm().getDate()+"%");
if(record.getJcdm().getDiandaolv()!=null&&record.getDiandaolv()!=null&&!record.getJcdm().getDiandaolv().equals("")&&!record.getDiandaolv().equals(""))
criteria.andDiandaolvBetween(record.getDiandaolv(), record.getJcdm().getDiandaolv());
else if(record.getDiandaolv()!=null&&!record.getDiandaolv().equals(""))
criteria.andDiandaolvEqualTo(record.getDiandaolv());
else if(record.getJcdm().getDiandaolv()!=null&&!record.getJcdm().getDiandaolv().equals(""))
criteria.andDiandaolvLike("%"+record.getJcdm().getDiandaolv()+"%");
if(record.getJcdm().getDmmc()!=null&&record.getDmmc()!=null&&!record.getJcdm().getDmmc().equals("")&&!record.getDmmc().equals(""))
criteria.andDmmcBetween(record.getDmmc(), record.getJcdm().getDmmc());
else if(record.getDmmc()!=null&&!record.getDmmc().equals(""))
criteria.andDmmcEqualTo(record.getDmmc());
else if(record.getJcdm().getDmmc()!=null&&!record.getJcdm().getDmmc().equals(""))
criteria.andDmmcLike("%"+record.getJcdm().getDmmc()+"%");
if(record.getJcdm().getFlza()!=null&&record.getFlza()!=null&&!record.getJcdm().getFlza().equals("")&&!record.getFlza().equals(""))
criteria.andFlzaBetween(record.getFlza(), record.getJcdm().getFlza());
else if(record.getFlza()!=null&&!record.getFlza().equals(""))
criteria.andFlzaEqualTo(record.getFlza());
else if(record.getJcdm().getFlza()!=null&&!record.getJcdm().getFlza().equals(""))
criteria.andFlzaLike("%"+record.getJcdm().getFlza()+"%");
if(record.getJcdm().getFuhuawu()!=null&&record.getFuhuawu()!=null&&!record.getJcdm().getFuhuawu().equals("")&&!record.getFuhuawu().equals(""))
criteria.andFuhuawuBetween(record.getFuhuawu(), record.getJcdm().getFuhuawu());
else if(record.getFuhuawu()!=null&&!record.getFuhuawu().equals(""))
criteria.andFuhuawuEqualTo(record.getFuhuawu());
else if(record.getJcdm().getFuhuawu()!=null&&!record.getJcdm().getFuhuawu().equals(""))
criteria.andFuhuawuLike("%"+record.getJcdm().getFuhuawu()+"%");
if(record.getJcdm().getGe()!=null&&record.getGe()!=null&&!record.getJcdm().getGe().equals("")&&!record.getGe().equals(""))
criteria.andGeBetween(record.getGe(), record.getJcdm().getGe());
else if(record.getGe()!=null&&!record.getGe().equals(""))
criteria.andGeEqualTo(record.getGe());
else if(record.getJcdm().getGe()!=null&&!record.getJcdm().getGe().equals(""))
criteria.andGeLike("%"+record.getJcdm().getGe()+"%");
if(record.getJcdm().getGmsy()!=null&&record.getGmsy()!=null&&!record.getJcdm().getGmsy().equals("")&&!record.getGmsy().equals(""))
criteria.andGmsyBetween(record.getGmsy(), record.getJcdm().getGmsy());
else if(record.getGmsy()!=null&&!record.getGmsy().equals(""))
criteria.andGmsyEqualTo(record.getGmsy());
else if(record.getJcdm().getGmsy()!=null&&!record.getJcdm().getGmsy().equals(""))
criteria.andGmsyLike("%"+record.getJcdm().getGmsy()+"%");
if(record.getJcdm().getGong()!=null&&record.getGong()!=null&&!record.getJcdm().getGong().equals("")&&!record.getGong().equals(""))
criteria.andGongBetween(record.getGong(), record.getJcdm().getGong());
else if(record.getGong()!=null&&!record.getGong().equals(""))
criteria.andGongEqualTo(record.getGong());
else if(record.getJcdm().getGong()!=null&&!record.getJcdm().getGong().equals(""))
criteria.andGongLike("%"+record.getJcdm().getGong()+"%");
if(record.getJcdm().getHlmc()!=null&&record.getHlmc()!=null&&!record.getJcdm().getHlmc().equals("")&&!record.getHlmc().equals(""))
criteria.andHlmcBetween(record.getHlmc(), record.getJcdm().getHlmc());
else if(record.getHlmc()!=null&&!record.getHlmc().equals(""))
criteria.andHlmcEqualTo(record.getHlmc());
else if(record.getJcdm().getHlmc()!=null&&!record.getJcdm().getHlmc().equals(""))
criteria.andHlmcLike("%"+record.getJcdm().getHlmc()+"%");
if(record.getJcdm().getHuifafen()!=null&&record.getHuifafen()!=null&&!record.getJcdm().getHuifafen().equals("")&&!record.getHuifafen().equals(""))
criteria.andHuifafenBetween(record.getHuifafen(), record.getJcdm().getHuifafen());
else if(record.getHuifafen()!=null&&!record.getHuifafen().equals(""))
criteria.andHuifafenEqualTo(record.getHuifafen());
else if(record.getJcdm().getHuifafen()!=null&&!record.getJcdm().getHuifafen().equals(""))
criteria.andHuifafenLike("%"+record.getJcdm().getHuifafen()+"%");
if(record.getJcdm().getHxxyl()!=null&&record.getHxxyl()!=null&&!record.getJcdm().getHxxyl().equals("")&&!record.getHxxyl().equals(""))
criteria.andHxxylBetween(record.getHxxyl(), record.getJcdm().getHxxyl());
else if(record.getHxxyl()!=null&&!record.getHxxyl().equals(""))
criteria.andHxxylEqualTo(record.getHxxyl());
else if(record.getJcdm().getHxxyl()!=null&&!record.getJcdm().getHxxyl().equals(""))
criteria.andHxxylLike("%"+record.getJcdm().getHxxyl()+"%");
if(record.getJcdm().getLiuhuawu()!=null&&record.getLiuhuawu()!=null&&!record.getJcdm().getLiuhuawu().equals("")&&!record.getLiuhuawu().equals(""))
criteria.andLiuhuawuBetween(record.getLiuhuawu(), record.getJcdm().getLiuhuawu());
else if(record.getLiuhuawu()!=null&&!record.getLiuhuawu().equals(""))
criteria.andLiuhuawuEqualTo(record.getLiuhuawu());
else if(record.getJcdm().getLiuhuawu()!=null&&!record.getJcdm().getLiuhuawu().equals(""))
criteria.andLiuhuawuLike("%"+record.getJcdm().getLiuhuawu()+"%");
if(record.getJcdm().getLiujiage()!=null&&record.getLiujiage()!=null&&!record.getJcdm().getLiujiage().equals("")&&!record.getLiujiage().equals(""))
criteria.andLiujiageBetween(record.getLiujiage(), record.getJcdm().getLiujiage());
else if(record.getLiujiage()!=null&&!record.getLiujiage().equals(""))
criteria.andLiujiageEqualTo(record.getLiujiage());
else if(record.getJcdm().getLiujiage()!=null&&!record.getJcdm().getLiujiage().equals(""))
criteria.andLiujiageLike("%"+record.getJcdm().getLiujiage()+"%");
if(record.getJcdm().getLiuliang()!=null&&record.getLiuliang()!=null&&!record.getJcdm().getLiuliang().equals("")&&!record.getLiuliang().equals(""))
criteria.andLiuliangBetween(record.getLiuliang(), record.getJcdm().getLiuliang());
else if(record.getLiuliang()!=null&&!record.getLiuliang().equals(""))
criteria.andLiuliangEqualTo(record.getLiuliang());
else if(record.getJcdm().getLiuliang()!=null&&!record.getJcdm().getLiuliang().equals(""))
criteria.andLiuliangLike("%"+record.getJcdm().getLiuliang()+"%");
if(record.getJcdm().getLiusuanyan()!=null&&record.getLiusuanyan()!=null&&!record.getJcdm().getLiusuanyan().equals("")&&!record.getLiusuanyan().equals(""))
criteria.andLiusuanyanBetween(record.getLiusuanyan(), record.getJcdm().getLiusuanyan());
else if(record.getLiusuanyan()!=null&&!record.getLiusuanyan().equals(""))
criteria.andLiusuanyanEqualTo(record.getLiusuanyan());
else if(record.getJcdm().getLiusuanyan()!=null&&!record.getJcdm().getLiusuanyan().equals(""))
criteria.andLiusuanyanLike("%"+record.getJcdm().getLiusuanyan()+"%");
if(record.getJcdm().getLvhuawu()!=null&&record.getLvhuawu()!=null&&!record.getJcdm().getLvhuawu().equals("")&&!record.getLvhuawu().equals(""))
criteria.andLvhuawuBetween(record.getLvhuawu(), record.getJcdm().getLvhuawu());
else if(record.getLvhuawu()!=null&&!record.getLvhuawu().equals(""))
criteria.andLvhuawuEqualTo(record.getLvhuawu());
else if(record.getJcdm().getLvhuawu()!=null&&!record.getJcdm().getLvhuawu().equals(""))
criteria.andLvhuawuLike("%"+record.getJcdm().getLvhuawu()+"%");
if(record.getJcdm().getMonth()!=null&&record.getMonth()!=null)
criteria.andMonthBetween(record.getMonth(), record.getJcdm().getMonth());
else if(record.getMonth()!=null)
criteria.andMonthEqualTo(record.getMonth());
else if(record.getJcdm().getMonth()!=null)
criteria.andMonthLessThanOrEqualTo(record.getJcdm().getMonth());
if(record.getJcdm().getPh()!=null&&record.getPh()!=null&&!record.getJcdm().getPh().equals("")&&!record.getPh().equals(""))
criteria.andPhBetween(record.getPh(), record.getJcdm().getPh());
else if(record.getPh()!=null&&!record.getPh().equals(""))
criteria.andPhEqualTo(record.getPh());
else if(record.getJcdm().getPh()!=null&&!record.getJcdm().getPh().equals(""))
criteria.andPhLike("%"+record.getJcdm().getPh()+"%");
if(record.getJcdm().getQian()!=null&&record.getQian()!=null&&!record.getJcdm().getQian().equals("")&&!record.getQian().equals(""))
criteria.andQianBetween(record.getQian(), record.getJcdm().getQian());
else if(record.getQian()!=null&&!record.getQian().equals(""))
criteria.andQianEqualTo(record.getQian());
else if(record.getJcdm().getQian()!=null&&!record.getJcdm().getQian().equals(""))
criteria.andQianLike("%"+record.getJcdm().getQian()+"%");
if(record.getJcdm().getRongjieyanng()!=null&&record.getRongjieyanng()!=null&&!record.getJcdm().getRongjieyanng().equals("")&&!record.getRongjieyanng().equals(""))
criteria.andRongjieyanngBetween(record.getRongjieyanng(), record.getJcdm().getRongjieyanng());
else if(record.getRongjieyanng()!=null&&!record.getRongjieyanng().equals(""))
criteria.andRongjieyanngEqualTo(record.getRongjieyanng());
else if(record.getJcdm().getRongjieyanng()!=null&&!record.getJcdm().getRongjieyanng().equals(""))
criteria.andRongjieyanngLike("%"+record.getJcdm().getRongjieyanng()+"%");
if(record.getJcdm().getShen()!=null&&record.getShen()!=null&&!record.getJcdm().getShen().equals("")&&!record.getShen().equals(""))
criteria.andShenBetween(record.getShen(), record.getJcdm().getShen());
else if(record.getShen()!=null&&!record.getShen().equals(""))
criteria.andShenEqualTo(record.getShen());
else if(record.getJcdm().getShen()!=null&&!record.getJcdm().getShen().equals(""))
criteria.andShenLike("%"+record.getJcdm().getShen()+"%");
if(record.getJcdm().getShiyoulei()!=null&&record.getShiyoulei()!=null&&!record.getJcdm().getShiyoulei().equals("")&&!record.getShiyoulei().equals(""))
criteria.andShiyouleiBetween(record.getShiyoulei(), record.getJcdm().getShiyoulei());
else if(record.getShiyoulei()!=null&&!record.getShiyoulei().equals(""))
criteria.andShiyouleiEqualTo(record.getShiyoulei());
else if(record.getJcdm().getShiyoulei()!=null&&!record.getJcdm().getShiyoulei().equals(""))
criteria.andShiyouleiLike("%"+record.getJcdm().getShiyoulei()+"%");
if(record.getJcdm().getShuishen()!=null&&record.getShuishen()!=null&&!record.getJcdm().getShuishen().equals("")&&!record.getShuishen().equals(""))
criteria.andShuishenBetween(record.getShuishen(), record.getJcdm().getShuishen());
else if(record.getShuishen()!=null&&!record.getShuishen().equals(""))
criteria.andShuishenEqualTo(record.getShuishen());
else if(record.getJcdm().getShuishen()!=null&&!record.getJcdm().getShuishen().equals(""))
criteria.andShuishenLike("%"+record.getJcdm().getShuishen()+"%");
if(record.getJcdm().getShuiweng()!=null&&record.getShuiweng()!=null&&!record.getJcdm().getShuiweng().equals("")&&!record.getShuiweng().equals(""))
criteria.andShuiwengBetween(record.getShuiweng(), record.getJcdm().getShuiweng());
else if(record.getShuiweng()!=null&&!record.getShuiweng().equals(""))
criteria.andShuiwengEqualTo(record.getShuiweng());
else if(record.getJcdm().getShuiweng()!=null&&!record.getJcdm().getShuiweng().equals(""))
criteria.andShuiwengLike("%"+record.getJcdm().getShuiweng()+"%");
if(record.getJcdm().getShxyl()!=null&&record.getShxyl()!=null&&!record.getJcdm().getShxyl().equals("")&&!record.getShxyl().equals(""))
criteria.andShxylBetween(record.getShxyl(), record.getJcdm().getShxyl());
else if(record.getShxyl()!=null&&!record.getShxyl().equals(""))
criteria.andShxylEqualTo(record.getShxyl());
else if(record.getJcdm().getShxyl()!=null&&!record.getJcdm().getShxyl().equals(""))
criteria.andShxylLike("%"+record.getJcdm().getShxyl()+"%");
if(record.getJcdm().getSqdm()!=null&&record.getSqdm()!=null&&!record.getJcdm().getSqdm().equals("")&&!record.getSqdm().equals(""))
criteria.andSqdmBetween(record.getSqdm(), record.getJcdm().getSqdm());
else if(record.getSqdm()!=null&&!record.getSqdm().equals(""))
criteria.andSqdmEqualTo(record.getSqdm());
else if(record.getJcdm().getSqdm()!=null&&!record.getJcdm().getSqdm().equals(""))
criteria.andSqdmLike("%"+record.getJcdm().getSqdm()+"%");
if(record.getJcdm().getXi()!=null&&record.getXi()!=null&&!record.getJcdm().getXi().equals("")&&!record.getXi().equals(""))
criteria.andXiBetween(record.getXi(), record.getJcdm().getXi());
else if(record.getXi()!=null&&!record.getXi().equals(""))
criteria.andXiEqualTo(record.getXi());
else if(record.getJcdm().getXi()!=null&&!record.getJcdm().getXi().equals(""))
criteria.andXiLike("%"+record.getJcdm().getXi()+"%");
if(record.getJcdm().getXiaosuanyan()!=null&&record.getXiaosuanyan()!=null&&!record.getJcdm().getXiaosuanyan().equals("")&&!record.getXiaosuanyan().equals(""))
criteria.andXiaosuanyanBetween(record.getXiaosuanyan(), record.getJcdm().getXiaosuanyan());
else if(record.getXiaosuanyan()!=null&&!record.getXiaosuanyan().equals(""))
criteria.andXiaosuanyanEqualTo(record.getXiaosuanyan());
else if(record.getJcdm().getXiaosuanyan()!=null&&!record.getJcdm().getXiaosuanyan().equals(""))
criteria.andXiaosuanyanLike("%"+record.getJcdm().getXiaosuanyan()+"%");
if(record.getJcdm().getXuanfuwu()!=null&&record.getXuanfuwu()!=null&&!record.getJcdm().getXuanfuwu().equals("")&&!record.getXuanfuwu().equals(""))
criteria.andXuanfuwuBetween(record.getXuanfuwu(), record.getJcdm().getXuanfuwu());
else if(record.getXuanfuwu()!=null&&!record.getXuanfuwu().equals(""))
criteria.andXuanfuwuEqualTo(record.getXuanfuwu());
else if(record.getJcdm().getXuanfuwu()!=null&&!record.getJcdm().getXuanfuwu().equals(""))
criteria.andXuanfuwuLike("%"+record.getJcdm().getXuanfuwu()+"%");
if(record.getJcdm().getYear()!=null&&record.getYear()!=null)
criteria.andYearBetween(record.getYear(), record.getJcdm().getYear());
else if(record.getYear()!=null)
criteria.andYearEqualTo(record.getYear());
else if(record.getJcdm().getYear()!=null)
criteria.andYearLessThanOrEqualTo(record.getJcdm().getYear());
if(record.getJcdm().getYxsy()!=null&&record.getYxsy()!=null&&!record.getJcdm().getYxsy().equals("")&&!record.getYxsy().equals(""))
criteria.andYxsyBetween(record.getYxsy(), record.getJcdm().getYxsy());
else if(record.getYxsy()!=null&&!record.getYxsy().equals(""))
criteria.andYxsyEqualTo(record.getYxsy());
else if(record.getJcdm().getYxsy()!=null&&!record.getJcdm().getYxsy().equals(""))
criteria.andYxsyLike("%"+record.getJcdm().getYxsy()+"%");
if(record.getJcdm().getZjhw()!=null&&record.getZjhw()!=null&&!record.getJcdm().getZjhw().equals("")&&!record.getZjhw().equals(""))
criteria.andZjhwBetween(record.getZjhw(), record.getJcdm().getZjhw());
else if(record.getZjhw()!=null&&!record.getZjhw().equals(""))
criteria.andZjhwEqualTo(record.getZjhw());
else if(record.getJcdm().getZjhw()!=null&&!record.getJcdm().getZjhw().equals(""))
criteria.andZjhwLike("%"+record.getJcdm().getZjhw()+"%");
if(record.getJcdm().getZongdan()!=null&&record.getZongdan()!=null&&!record.getJcdm().getZongdan().equals("")&&!record.getZongdan().equals(""))
criteria.andZongdanBetween(record.getZongdan(), record.getJcdm().getZongdan());
else if(record.getZongdan()!=null&&!record.getZongdan().equals(""))
criteria.andZongdanEqualTo(record.getZongdan());
else if(record.getJcdm().getZongdan()!=null&&!record.getJcdm().getZongdan().equals(""))
criteria.andZongdanLike("%"+record.getJcdm().getZongdan()+"%");
if(record.getJcdm().getZongling()!=null&&record.getZongling()!=null&&!record.getJcdm().getZongling().equals("")&&!record.getZongling().equals(""))
criteria.andZonglingBetween(record.getZongling(), record.getJcdm().getZongling());
else if(record.getZongling()!=null&&!record.getZongling().equals(""))
criteria.andZonglingEqualTo(record.getZongling());
else if(record.getJcdm().getZongling()!=null&&!record.getJcdm().getZongling().equals(""))
criteria.andZonglingLike("%"+record.getJcdm().getZongling()+"%");
if(record.getJcdm().getZongyingdu()!=null&&record.getZongyingdu()!=null&&!record.getJcdm().getZongyingdu().equals("")&&!record.getZongyingdu().equals(""))
criteria.andZongyingduBetween(record.getZongyingdu(), record.getJcdm().getZongyingdu());
else if(record.getZongyingdu()!=null&&!record.getZongyingdu().equals(""))
criteria.andZongyingduEqualTo(record.getZongyingdu());
else if(record.getJcdm().getZongyingdu()!=null&&!record.getJcdm().getZongyingdu().equals(""))
criteria.andZongyingduLike("%"+record.getJcdm().getZongyingdu()+"%");
}return jcdmExample;
}
@Override
public ProblemsExample problemstoexample(ProblemsCustom record) {
ProblemsExample problemsExample=new ProblemsExample();
com.szht.model.ProblemsExample.Criteria criteria=problemsExample.createCriteria();
if(record.getProblems()==null)
{if(record.getId()!=null)
criteria.andIdEqualTo(record.getId());
if(record.getLon()!=null)
criteria.andLonEqualTo(record.getLon());
if(record.getLat()!=null)
criteria.andLatEqualTo(record.getLat());
if(record.getDisc()!=null&&!record.getDisc().equals(""))
criteria.andDiscEqualTo(record.getDisc());
if(record.getTelephone()!=null&&!record.getTelephone().equals(""))
criteria.andTelephoneEqualTo(record.getTelephone());
if(record.getUsername()!=null&&!record.getUsername().equals(""))
criteria.andUsernameEqualTo(record.getUsername());
if(record.getSubmittime()!=null)
criteria.andSubmittimeEqualTo(record.getSubmittime());
if(record.getStatus()!=null&&!record.getStatus().equals(""))
criteria.andStatusEqualTo(record.getStatus());
if(record.getSlovetime()!=null)
criteria.andSlovetimeEqualTo(record.getSlovetime());
if(record.getSolver()!=null&&!record.getSolver().equals(""))
criteria.andSolverEqualTo(record.getSolver());
if(record.getSuggest()!=null&&!record.getSuggest().equals(""))
criteria.andSuggestEqualTo(record.getSuggest());
}
else {
if(record.getProblems().getId()!=null&&record.getId()!=null)
criteria.andIdBetween(record.getId(), record.getProblems().getId());
else if(record.getId()!=null)
criteria.andIdEqualTo(record.getId());
else if(record.getProblems().getId()!=null)
criteria.andIdLessThanOrEqualTo(record.getProblems().getId());
if(record.getProblems().getLon()!=null&&record.getLon()!=null)
criteria.andLonBetween(record.getLon(), record.getProblems().getLon());
else if(record.getLon()!=null)
criteria.andLonEqualTo(record.getLon());
else if(record.getProblems().getLon()!=null)
criteria.andLonLessThanOrEqualTo(record.getProblems().getLon());
if(record.getProblems().getLat()!=null&&record.getLat()!=null)
criteria.andLatBetween(record.getLat(), record.getProblems().getLat());
else if(record.getLat()!=null)
criteria.andLatEqualTo(record.getLat());
else if(record.getProblems().getLat()!=null)
criteria.andLatLessThanOrEqualTo(record.getProblems().getLat());
if(record.getProblems().getDisc()!=null&&record.getDisc()!=null&&!record.getProblems().getDisc().equals("")&&!record.getDisc().equals(""))
criteria.andDiscBetween(record.getDisc(), record.getProblems().getDisc());
else if(record.getDisc()!=null&&!record.getDisc().equals(""))
criteria.andDiscEqualTo(record.getDisc());
else if(record.getProblems().getDisc()!=null&&!record.getProblems().getDisc().equals(""))
criteria.andDiscLike("%"+record.getProblems().getDisc()+"%");
if(record.getProblems().getTelephone()!=null&&record.getTelephone()!=null&&!record.getProblems().getTelephone().equals("")&&!record.getTelephone().equals(""))
criteria.andTelephoneBetween(record.getTelephone(), record.getProblems().getTelephone());
else if(record.getTelephone()!=null&&!record.getTelephone().equals(""))
criteria.andTelephoneEqualTo(record.getTelephone());
else if(record.getProblems().getTelephone()!=null&&!record.getProblems().getTelephone().equals(""))
criteria.andTelephoneLike("%"+record.getProblems().getTelephone()+"%");
if(record.getProblems().getUsername()!=null&&record.getUsername()!=null&&!record.getProblems().getUsername().equals("")&&!record.getUsername().equals(""))
criteria.andUsernameBetween(record.getUsername(), record.getProblems().getUsername());
else if(record.getUsername()!=null&&!record.getUsername().equals(""))
criteria.andUsernameEqualTo(record.getUsername());
else if(record.getProblems().getUsername()!=null&&!record.getProblems().getUsername().equals(""))
criteria.andUsernameLike("%"+record.getProblems().getUsername()+"%");
if(record.getProblems().getSubmittime()!=null&&record.getSubmittime()!=null)
criteria.andSubmittimeBetween(record.getSubmittime(), record.getProblems().getSubmittime());
else if(record.getSubmittime()!=null)
criteria.andSubmittimeEqualTo(record.getSubmittime());
else if(record.getProblems().getSubmittime()!=null)
criteria.andSubmittimeLessThanOrEqualTo(record.getProblems().getSubmittime());
if(record.getProblems().getStatus()!=null&&record.getStatus()!=null&&!record.getProblems().getStatus().equals("")&&!record.getStatus().equals(""))
criteria.andStatusBetween(record.getStatus(), record.getProblems().getStatus());
else if(record.getStatus()!=null&&!record.getStatus().equals(""))
criteria.andStatusEqualTo(record.getStatus());
else if(record.getProblems().getStatus()!=null&&!record.getProblems().getStatus().equals(""))
criteria.andStatusLike("%"+record.getProblems().getStatus()+"%");
if(record.getProblems().getSlovetime()!=null&&record.getSlovetime()!=null)
criteria.andSlovetimeBetween(record.getSlovetime(), record.getProblems().getSlovetime());
else if(record.getSlovetime()!=null)
criteria.andSlovetimeEqualTo(record.getSlovetime());
else if(record.getProblems().getSlovetime()!=null)
criteria.andSlovetimeLessThanOrEqualTo(record.getProblems().getSlovetime());
if(record.getProblems().getSolver()!=null&&record.getSolver()!=null&&!record.getProblems().getSolver().equals("")&&!record.getSolver().equals(""))
criteria.andSolverBetween(record.getSolver(), record.getProblems().getSolver());
else if(record.getSolver()!=null&&!record.getSolver().equals(""))
criteria.andSolverEqualTo(record.getSolver());
else if(record.getProblems().getSolver()!=null&&!record.getProblems().getSolver().equals(""))
criteria.andSolverLike("%"+record.getProblems().getSolver()+"%");
if(record.getProblems().getSuggest()!=null&&record.getSuggest()!=null&&!record.getProblems().getSuggest().equals("")&&!record.getSuggest().equals(""))
criteria.andSuggestBetween(record.getSuggest(), record.getProblems().getSuggest());
else if(record.getSuggest()!=null&&!record.getSuggest().equals(""))
criteria.andSuggestEqualTo(record.getSuggest());
else if(record.getProblems().getSuggest()!=null&&!record.getProblems().getSuggest().equals(""))
criteria.andSuggestLike("%"+record.getProblems().getSuggest()+"%");
}return problemsExample;
}
@Override
public SiteExample sitetoexample(SiteCustom record) {
SiteExample siteExample=new SiteExample();
com.szht.model.SiteExample.Criteria criteria=siteExample.createCriteria();
if(record.getSite()==null)
{if(record.getId()!=null)
criteria.andIdEqualTo(record.getId());
if(record.getAqi()!=null&&!record.getAqi().equals(""))
criteria.andAqiEqualTo(record.getAqi());
if(record.getCo()!=null&&!record.getCo().equals(""))
criteria.andCoEqualTo(record.getCo());
if(record.getCt()!=null&&!record.getCt().equals(""))
criteria.andCtEqualTo(record.getCt());
if(record.getNo2()!=null&&!record.getNo2().equals(""))
criteria.andNo2EqualTo(record.getNo2());
if(record.getO3()!=null&&!record.getO3().equals(""))
criteria.andO3EqualTo(record.getO3());
if(record.getO38h()!=null&&!record.getO38h().equals(""))
criteria.andO38hEqualTo(record.getO38h());
if(record.getPm10()!=null&&!record.getPm10().equals(""))
criteria.andPm10EqualTo(record.getPm10());
if(record.getPm25()!=null&&!record.getPm25().equals(""))
criteria.andPm25EqualTo(record.getPm25());
if(record.getPrimaryPollutant()!=null&&!record.getPrimaryPollutant().equals(""))
criteria.andPrimaryPollutantEqualTo(record.getPrimaryPollutant());
if(record.getQuality()!=null&&!record.getQuality().equals(""))
criteria.andQualityEqualTo(record.getQuality());
if(record.getSiteName()!=null&&!record.getSiteName().equals(""))
criteria.andSiteNameEqualTo(record.getSiteName());
if(record.getSo2()!=null&&!record.getSo2().equals(""))
criteria.andSo2EqualTo(record.getSo2());
}
else {
if(record.getSite().getId()!=null&&record.getId()!=null)
criteria.andIdBetween(record.getId(), record.getSite().getId());
else if(record.getId()!=null)
criteria.andIdEqualTo(record.getId());
else if(record.getSite().getId()!=null)
criteria.andIdLessThanOrEqualTo(record.getSite().getId());
if(record.getSite().getAqi()!=null&&record.getAqi()!=null&&!record.getSite().getAqi().equals("")&&!record.getAqi().equals(""))
criteria.andAqiBetween(record.getAqi(), record.getSite().getAqi());
else if(record.getAqi()!=null&&!record.getAqi().equals(""))
criteria.andAqiEqualTo(record.getAqi());
else if(record.getSite().getAqi()!=null&&!record.getSite().getAqi().equals(""))
criteria.andAqiLike("%"+record.getSite().getAqi()+"%");
if(record.getSite().getCo()!=null&&record.getCo()!=null&&!record.getSite().getCo().equals("")&&!record.getCo().equals(""))
criteria.andCoBetween(record.getCo(), record.getSite().getCo());
else if(record.getCo()!=null&&!record.getCo().equals(""))
criteria.andCoEqualTo(record.getCo());
else if(record.getSite().getCo()!=null&&!record.getSite().getCo().equals(""))
criteria.andCoLike("%"+record.getSite().getCo()+"%");
if(record.getSite().getCt()!=null&&record.getCt()!=null&&!record.getSite().getCt().equals("")&&!record.getCt().equals(""))
criteria.andCtBetween(record.getCt(), record.getSite().getCt());
else if(record.getCt()!=null&&!record.getCt().equals(""))
criteria.andCtEqualTo(record.getCt());
else if(record.getSite().getCt()!=null&&!record.getSite().getCt().equals(""))
criteria.andCtLike("%"+record.getSite().getCt()+"%");
if(record.getSite().getNo2()!=null&&record.getNo2()!=null&&!record.getSite().getNo2().equals("")&&!record.getNo2().equals(""))
criteria.andNo2Between(record.getNo2(), record.getSite().getNo2());
else if(record.getNo2()!=null&&!record.getNo2().equals(""))
criteria.andNo2EqualTo(record.getNo2());
else if(record.getSite().getNo2()!=null&&!record.getSite().getNo2().equals(""))
criteria.andNo2Like("%"+record.getSite().getNo2()+"%");
if(record.getSite().getO3()!=null&&record.getO3()!=null&&!record.getSite().getO3().equals("")&&!record.getO3().equals(""))
criteria.andO3Between(record.getO3(), record.getSite().getO3());
else if(record.getO3()!=null&&!record.getO3().equals(""))
criteria.andO3EqualTo(record.getO3());
else if(record.getSite().getO3()!=null&&!record.getSite().getO3().equals(""))
criteria.andO3Like("%"+record.getSite().getO3()+"%");
if(record.getSite().getO38h()!=null&&record.getO38h()!=null&&!record.getSite().getO38h().equals("")&&!record.getO38h().equals(""))
criteria.andO38hBetween(record.getO38h(), record.getSite().getO38h());
else if(record.getO38h()!=null&&!record.getO38h().equals(""))
criteria.andO38hEqualTo(record.getO38h());
else if(record.getSite().getO38h()!=null&&!record.getSite().getO38h().equals(""))
criteria.andO38hLike("%"+record.getSite().getO38h()+"%");
if(record.getSite().getPm10()!=null&&record.getPm10()!=null&&!record.getSite().getPm10().equals("")&&!record.getPm10().equals(""))
criteria.andPm10Between(record.getPm10(), record.getSite().getPm10());
else if(record.getPm10()!=null&&!record.getPm10().equals(""))
criteria.andPm10EqualTo(record.getPm10());
else if(record.getSite().getPm10()!=null&&!record.getSite().getPm10().equals(""))
criteria.andPm10Like("%"+record.getSite().getPm10()+"%");
if(record.getSite().getPm25()!=null&&record.getPm25()!=null&&!record.getSite().getPm25().equals("")&&!record.getPm25().equals(""))
criteria.andPm25Between(record.getPm25(), record.getSite().getPm25());
else if(record.getPm25()!=null&&!record.getPm25().equals(""))
criteria.andPm25EqualTo(record.getPm25());
else if(record.getSite().getPm25()!=null&&!record.getSite().getPm25().equals(""))
criteria.andPm25Like("%"+record.getSite().getPm25()+"%");
if(record.getSite().getPrimaryPollutant()!=null&&record.getPrimaryPollutant()!=null&&!record.getSite().getPrimaryPollutant().equals("")&&!record.getPrimaryPollutant().equals(""))
criteria.andPrimaryPollutantBetween(record.getPrimaryPollutant(), record.getSite().getPrimaryPollutant());
else if(record.getPrimaryPollutant()!=null&&!record.getPrimaryPollutant().equals(""))
criteria.andPrimaryPollutantEqualTo(record.getPrimaryPollutant());
else if(record.getSite().getPrimaryPollutant()!=null&&!record.getSite().getPrimaryPollutant().equals(""))
criteria.andPrimaryPollutantLike("%"+record.getSite().getPrimaryPollutant()+"%");
if(record.getSite().getQuality()!=null&&record.getQuality()!=null&&!record.getSite().getQuality().equals("")&&!record.getQuality().equals(""))
criteria.andQualityBetween(record.getQuality(), record.getSite().getQuality());
else if(record.getQuality()!=null&&!record.getQuality().equals(""))
criteria.andQualityEqualTo(record.getQuality());
else if(record.getSite().getQuality()!=null&&!record.getSite().getQuality().equals(""))
criteria.andQualityLike("%"+record.getSite().getQuality()+"%");
if(record.getSite().getSiteName()!=null&&record.getSiteName()!=null&&!record.getSite().getSiteName().equals("")&&!record.getSiteName().equals(""))
criteria.andSiteNameBetween(record.getSiteName(), record.getSite().getSiteName());
else if(record.getSiteName()!=null&&!record.getSiteName().equals(""))
criteria.andSiteNameEqualTo(record.getSiteName());
else if(record.getSite().getSiteName()!=null&&!record.getSite().getSiteName().equals(""))
criteria.andSiteNameLike("%"+record.getSite().getSiteName()+"%");
if(record.getSite().getSo2()!=null&&record.getSo2()!=null&&!record.getSite().getSo2().equals("")&&!record.getSo2().equals(""))
criteria.andSo2Between(record.getSo2(), record.getSite().getSo2());
else if(record.getSo2()!=null&&!record.getSo2().equals(""))
criteria.andSo2EqualTo(record.getSo2());
else if(record.getSite().getSo2()!=null&&!record.getSite().getSo2().equals(""))
criteria.andSo2Like("%"+record.getSite().getSo2()+"%");
}return siteExample;
}
@Override
public UserExample usertoexample(UserCustom record) {
UserExample userExample=new UserExample();
com.szht.model.UserExample.Criteria criteria=userExample.createCriteria();
if(record.getUser()==null)
{if(record.getId()!=null)
criteria.andIdEqualTo(record.getId());
if(record.getUsercode()!=null&&!record.getUsercode().equals(""))
criteria.andUsercodeEqualTo(record.getUsercode());
if(record.getPassword()!=null&&!record.getPassword().equals(""))
criteria.andPasswordEqualTo(record.getPassword());
if(record.getUsername()!=null&&!record.getUsername().equals(""))
criteria.andUsernameEqualTo(record.getUsername());
if(record.getLogtimes()!=null)
criteria.andLogtimesEqualTo(record.getLogtimes());
if(record.getLasttime()!=null)
criteria.andLasttimeEqualTo(record.getLasttime());
if(record.getCreatetime()!=null)
criteria.andCreatetimeEqualTo(record.getCreatetime());
if(record.getPassword2()!=null&&!record.getPassword2().equals(""))
criteria.andPassword2EqualTo(record.getPassword2());
}
else {
if(record.getUser().getId()!=null&&record.getId()!=null)
criteria.andIdBetween(record.getId(), record.getUser().getId());
else if(record.getId()!=null)
criteria.andIdEqualTo(record.getId());
else if(record.getUser().getId()!=null)
criteria.andIdLessThanOrEqualTo(record.getUser().getId());
if(record.getUser().getUsercode()!=null&&record.getUsercode()!=null&&!record.getUser().getUsercode().equals("")&&!record.getUsercode().equals(""))
criteria.andUsercodeBetween(record.getUsercode(), record.getUser().getUsercode());
else if(record.getUsercode()!=null&&!record.getUsercode().equals(""))
criteria.andUsercodeEqualTo(record.getUsercode());
else if(record.getUser().getUsercode()!=null&&!record.getUser().getUsercode().equals(""))
criteria.andUsercodeLike("%"+record.getUser().getUsercode()+"%");
if(record.getUser().getPassword()!=null&&record.getPassword()!=null&&!record.getUser().getPassword().equals("")&&!record.getPassword().equals(""))
criteria.andPasswordBetween(record.getPassword(), record.getUser().getPassword());
else if(record.getPassword()!=null&&!record.getPassword().equals(""))
criteria.andPasswordEqualTo(record.getPassword());
else if(record.getUser().getPassword()!=null&&!record.getUser().getPassword().equals(""))
criteria.andPasswordLike("%"+record.getUser().getPassword()+"%");
if(record.getUser().getUsername()!=null&&record.getUsername()!=null&&!record.getUser().getUsername().equals("")&&!record.getUsername().equals(""))
criteria.andUsernameBetween(record.getUsername(), record.getUser().getUsername());
else if(record.getUsername()!=null&&!record.getUsername().equals(""))
criteria.andUsernameEqualTo(record.getUsername());
else if(record.getUser().getUsername()!=null&&!record.getUser().getUsername().equals(""))
criteria.andUsernameLike("%"+record.getUser().getUsername()+"%");
if(record.getUser().getLogtimes()!=null&&record.getLogtimes()!=null)
criteria.andLogtimesBetween(record.getLogtimes(), record.getUser().getLogtimes());
else if(record.getLogtimes()!=null)
criteria.andLogtimesEqualTo(record.getLogtimes());
else if(record.getUser().getLogtimes()!=null)
criteria.andLogtimesLessThanOrEqualTo(record.getUser().getLogtimes());
if(record.getUser().getLasttime()!=null&&record.getLasttime()!=null)
criteria.andLasttimeBetween(record.getLasttime(), record.getUser().getLasttime());
else if(record.getLasttime()!=null)
criteria.andLasttimeEqualTo(record.getLasttime());
else if(record.getUser().getLasttime()!=null)
criteria.andLasttimeLessThanOrEqualTo(record.getUser().getLasttime());
if(record.getUser().getCreatetime()!=null&&record.getCreatetime()!=null)
criteria.andCreatetimeBetween(record.getCreatetime(), record.getUser().getCreatetime());
else if(record.getCreatetime()!=null)
criteria.andCreatetimeEqualTo(record.getCreatetime());
else if(record.getUser().getCreatetime()!=null)
criteria.andCreatetimeLessThanOrEqualTo(record.getUser().getCreatetime());
if(record.getUser().getPassword2()!=null&&record.getPassword2()!=null&&!record.getUser().getPassword2().equals("")&&!record.getPassword2().equals(""))
criteria.andPassword2Between(record.getPassword2(), record.getUser().getPassword2());
else if(record.getPassword2()!=null&&!record.getPassword2().equals(""))
criteria.andPassword2EqualTo(record.getPassword2());
else if(record.getUser().getPassword2()!=null&&!record.getUser().getPassword2().equals(""))
criteria.andPassword2Like("%"+record.getUser().getPassword2()+"%");
}return userExample;
}
@Override
public UserPermissionExample userPermissiontoexample(UserPermissionCustom record) {
UserPermissionExample userPermissionExample=new UserPermissionExample();
com.szht.model.UserPermissionExample.Criteria criteria=userPermissionExample.createCriteria();
if(record.getUserPermission()==null)
{if(record.getId()!=null)
criteria.andIdEqualTo(record.getId());
if(record.getUsercode()!=null&&!record.getUsercode().equals(""))
criteria.andUsercodeEqualTo(record.getUsercode());
if(record.getPermission()!=null&&!record.getPermission().equals(""))
criteria.andPermissionEqualTo(record.getPermission());
}
else {
if(record.getUserPermission().getId()!=null&&record.getId()!=null)
criteria.andIdBetween(record.getId(), record.getUserPermission().getId());
else if(record.getId()!=null)
criteria.andIdEqualTo(record.getId());
else if(record.getUserPermission().getId()!=null)
criteria.andIdLessThanOrEqualTo(record.getUserPermission().getId());
if(record.getUserPermission().getUsercode()!=null&&record.getUsercode()!=null&&!record.getUserPermission().getUsercode().equals("")&&!record.getUsercode().equals(""))
criteria.andUsercodeBetween(record.getUsercode(), record.getUserPermission().getUsercode());
else if(record.getUsercode()!=null&&!record.getUsercode().equals(""))
criteria.andUsercodeEqualTo(record.getUsercode());
else if(record.getUserPermission().getUsercode()!=null&&!record.getUserPermission().getUsercode().equals(""))
criteria.andUsercodeLike("%"+record.getUserPermission().getUsercode()+"%");
if(record.getUserPermission().getPermission()!=null&&record.getPermission()!=null&&!record.getUserPermission().getPermission().equals("")&&!record.getPermission().equals(""))
criteria.andPermissionBetween(record.getPermission(), record.getUserPermission().getPermission());
else if(record.getPermission()!=null&&!record.getPermission().equals(""))
criteria.andPermissionEqualTo(record.getPermission());
else if(record.getUserPermission().getPermission()!=null&&!record.getUserPermission().getPermission().equals(""))
criteria.andPermissionLike("%"+record.getUserPermission().getPermission()+"%");
}return userPermissionExample;
}
@Override
public XzdmExample xzdmtoexample(XzdmCustom record) {
XzdmExample xzdmExample=new XzdmExample();
com.szht.model.XzdmExample.Criteria criteria=xzdmExample.createCriteria();
if(record.getXzdm()==null)
{if(record.getId()!=null)
criteria.andIdEqualTo(record.getId());
if(record.getDmmc()!=null&&!record.getDmmc().equals(""))
criteria.andDmmcEqualTo(record.getDmmc());
if(record.getHlmc()!=null&&!record.getHlmc().equals(""))
criteria.andHlmcEqualTo(record.getHlmc());
if(record.getYear()!=null)
criteria.andYearEqualTo(record.getYear());
if(record.getSeason()!=null)
criteria.andSeasonEqualTo(record.getSeason());
if(record.getZhenqu()!=null&&!record.getZhenqu().equals(""))
criteria.andZhenquEqualTo(record.getZhenqu());
if(record.getAd()!=null)
criteria.andAdEqualTo(record.getAd());
if(record.getZl()!=null)
criteria.andZlEqualTo(record.getZl());
if(record.getGmsy()!=null)
criteria.andGmsyEqualTo(record.getGmsy());
if(record.getRjy()!=null)
criteria.andRjyEqualTo(record.getRjy());
if(record.getDabiao()!=null&&!record.getDabiao().equals(""))
criteria.andDabiaoEqualTo(record.getDabiao());
}
else {
if(record.getXzdm().getId()!=null&&record.getId()!=null)
criteria.andIdBetween(record.getId(), record.getXzdm().getId());
else if(record.getId()!=null)
criteria.andIdEqualTo(record.getId());
else if(record.getXzdm().getId()!=null)
criteria.andIdLessThanOrEqualTo(record.getXzdm().getId());
if(record.getXzdm().getDmmc()!=null&&record.getDmmc()!=null&&!record.getXzdm().getDmmc().equals("")&&!record.getDmmc().equals(""))
criteria.andDmmcBetween(record.getDmmc(), record.getXzdm().getDmmc());
else if(record.getDmmc()!=null&&!record.getDmmc().equals(""))
criteria.andDmmcEqualTo(record.getDmmc());
else if(record.getXzdm().getDmmc()!=null&&!record.getXzdm().getDmmc().equals(""))
criteria.andDmmcLike("%"+record.getXzdm().getDmmc()+"%");
if(record.getXzdm().getHlmc()!=null&&record.getHlmc()!=null&&!record.getXzdm().getHlmc().equals("")&&!record.getHlmc().equals(""))
criteria.andHlmcBetween(record.getHlmc(), record.getXzdm().getHlmc());
else if(record.getHlmc()!=null&&!record.getHlmc().equals(""))
criteria.andHlmcEqualTo(record.getHlmc());
else if(record.getXzdm().getHlmc()!=null&&!record.getXzdm().getHlmc().equals(""))
criteria.andHlmcLike("%"+record.getXzdm().getHlmc()+"%");
if(record.getXzdm().getYear()!=null&&record.getYear()!=null)
criteria.andYearBetween(record.getYear(), record.getXzdm().getYear());
else if(record.getYear()!=null)
criteria.andYearEqualTo(record.getYear());
else if(record.getXzdm().getYear()!=null)
criteria.andYearLessThanOrEqualTo(record.getXzdm().getYear());
if(record.getXzdm().getSeason()!=null&&record.getSeason()!=null)
criteria.andSeasonBetween(record.getSeason(), record.getXzdm().getSeason());
else if(record.getSeason()!=null)
criteria.andSeasonEqualTo(record.getSeason());
else if(record.getXzdm().getSeason()!=null)
criteria.andSeasonLessThanOrEqualTo(record.getXzdm().getSeason());
if(record.getXzdm().getZhenqu()!=null&&record.getZhenqu()!=null&&!record.getXzdm().getZhenqu().equals("")&&!record.getZhenqu().equals(""))
criteria.andZhenquBetween(record.getZhenqu(), record.getXzdm().getZhenqu());
else if(record.getZhenqu()!=null&&!record.getZhenqu().equals(""))
criteria.andZhenquEqualTo(record.getZhenqu());
else if(record.getXzdm().getZhenqu()!=null&&!record.getXzdm().getZhenqu().equals(""))
criteria.andZhenquLike("%"+record.getXzdm().getZhenqu()+"%");
if(record.getXzdm().getAd()!=null&&record.getAd()!=null)
criteria.andAdBetween(record.getAd(), record.getXzdm().getAd());
else if(record.getAd()!=null)
criteria.andAdEqualTo(record.getAd());
else if(record.getXzdm().getAd()!=null)
criteria.andAdLessThanOrEqualTo(record.getXzdm().getAd());
if(record.getXzdm().getZl()!=null&&record.getZl()!=null)
criteria.andZlBetween(record.getZl(), record.getXzdm().getZl());
else if(record.getZl()!=null)
criteria.andZlEqualTo(record.getZl());
else if(record.getXzdm().getZl()!=null)
criteria.andZlLessThanOrEqualTo(record.getXzdm().getZl());
if(record.getXzdm().getGmsy()!=null&&record.getGmsy()!=null)
criteria.andGmsyBetween(record.getGmsy(), record.getXzdm().getGmsy());
else if(record.getGmsy()!=null)
criteria.andGmsyEqualTo(record.getGmsy());
else if(record.getXzdm().getGmsy()!=null)
criteria.andGmsyLessThanOrEqualTo(record.getXzdm().getGmsy());
if(record.getXzdm().getRjy()!=null&&record.getRjy()!=null)
criteria.andRjyBetween(record.getRjy(), record.getXzdm().getRjy());
else if(record.getRjy()!=null)
criteria.andRjyEqualTo(record.getRjy());
else if(record.getXzdm().getRjy()!=null)
criteria.andRjyLessThanOrEqualTo(record.getXzdm().getRjy());
if(record.getXzdm().getDabiao()!=null&&record.getDabiao()!=null&&!record.getXzdm().getDabiao().equals("")&&!record.getDabiao().equals(""))
criteria.andDabiaoBetween(record.getDabiao(), record.getXzdm().getDabiao());
else if(record.getDabiao()!=null&&!record.getDabiao().equals(""))
criteria.andDabiaoEqualTo(record.getDabiao());
else if(record.getXzdm().getDabiao()!=null&&!record.getXzdm().getDabiao().equals(""))
criteria.andDabiaoLike("%"+record.getXzdm().getDabiao()+"%");
}return xzdmExample;
}
}
