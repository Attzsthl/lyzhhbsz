package com.szht.service;
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
public interface Toexampleservice{
public BcExample bctoexample(BcCustom record) ;
public BcinfoExample bcinfotoexample(BcinfoCustom record) ;
public BctbhbExample bctbhbtoexample(BctbhbCustom record) ;
public JcdmExample jcdmtoexample(JcdmCustom record) ;
public ProblemsExample problemstoexample(ProblemsCustom record) ;
public SiteExample sitetoexample(SiteCustom record) ;
public UserExample usertoexample(UserCustom record) ;
public UserPermissionExample userPermissiontoexample(UserPermissionCustom record) ;
public XzdmExample xzdmtoexample(XzdmCustom record) ;
}
