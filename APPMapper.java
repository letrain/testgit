package com.cp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cp.pojo.Article;
import com.cp.pojo.Cp_APPDownloads;
import com.cp.pojo.Cplatest;
import com.cp.pojo.Cptype;
import com.cp.pojo.HomepageCommon;
import com.cp.pojo.InfoColumn;
import com.cp.pojo.KillHistoryOfAPP;
import com.cp.pojo.LotteryHistory;
import com.cp.pojo.LotteryInfo;
import com.cp.pojo.TrackHistory;
import com.cp.pojo.TrackInfo;
import com.cp.pojo.TrackType;

public interface APPMapper {

	/*@Select("select *,user_name userName from tb_user where user_name=#{userName}")
	User selectUserByUserName(@Param("userName")String userName);*/
	/*@Select("select * from tb_user where user_name=#{phone}")
	User loginByCode(HttpServletRequest req, String phone, String code);*/
	
	@Select("select * from cptype where status=1")
	List<Cptype> getAllCPType();
	
	@Select("select * from cptype where id=#{id}")
	Cptype selectCPTypeById (String id);
	
	@Select("SELECT kill_type.`name`,kill_details.killDetails,kill_history.`status`,kill_history.`no` FROM kill_type INNER JOIN kill_history ON kill_type.id=kill_history.track_id INNER JOIN kill_details ON kill_history.id =kill_details.th_id WHERE kill_type.`status`=0 AND kill_type.pid=#{pid} ORDER  BY kill_history.`no`")
	List<KillHistoryOfAPP>selectKillHistory(String pid);
	
	@Select("SELECT * FROM cplatest WHERE typeid=#{typeid}")
	List<Cplatest>queryLatestCp(Integer typeid);
	
	@Select("SELECT * FROM homepage_common WHERE parentid=33")
	List<HomepageCommon>getCarousel();
	
	@Select("SELECT * FROM homepage_common WHERE parentid=34")
	List<HomepageCommon>getCarousel2();
	
	@Select("SELECT * FROM homepage_common WHERE parentid=35")
	List<HomepageCommon>getCarousel3();
	
	@Select("SELECT * FROM homepage_common WHERE parentid=36")
	List<HomepageCommon>getCarousel4();
	
	@Select("SELECT * FROM homepage_common WHERE id=37")
	List<HomepageCommon>getPhoneAd();
	
	
	
	
	
	
	@Select("select * from cp_history INNER JOIN cptype ON cp_history.typeid=cptype.id WHERE cp_history.id=#{id} and opendate &gt;= #{beginDate} and opendate &lt;= #{endDate} and cp_history.platform=#{platform} and cptype.shortpy=#{shortpy}")
	List<LotteryHistory> getLotteryHistoryByIdAndDate(String id, String beginDate,
			String endDate,String shortpy,String platform);
	
	@Select("select * from cp_history INNER JOIN cptype ON cp_history.typeid=cptype.id WHERE cp_history.typeid=#{typeid} and opendate >= CONVERT(CONCAT(#{checkDate},' 00:01:30'),datetime) and opendate < date_add(CONVERT(CONCAT(#{checkDate},' 00:01:30'),datetime),interval 1 day) order by opendate desc")
	List<LotteryHistory> getLotteryHistoryByTypeAndDate1(@Param("typeid")String typeid, @Param("checkDate")String checkDate);
	
	@Select("select * from cp_history INNER JOIN cptype ON cp_history.typeid=cptype.id WHERE cp_history.typeid=#{typeid} and opendate >= CONVERT(CONCAT(#{checkDate},' 02:10:00'),datetime) and opendate < date_add(CONVERT(CONCAT(#{checkDate},' 02:10:00'),datetime),interval 1 day) order by opendate desc")
	List<LotteryHistory> getLotteryHistoryByTypeAndDate2(@Param("typeid")String typeid, @Param("checkDate")String checkDate);
	
	@Select("select * from cp_history INNER JOIN cptype ON cp_history.typeid=cptype.id WHERE cp_history.typeid=#{typeid} order by cp_history.no desc limit 100")
	List<LotteryHistory> getLotteryHistoryByTypeAndDate3(@Param("typeid")String typeid);
	
	
	@Select("select * from track_type where pid=#{typeid} and status=0")
	List<TrackType> selectTrackTypeById(@Param("typeid")String typeid);
	
	@Select("select * from cptype where id=#{typeid}")
	Cptype selectCptypeById(@Param("typeid")String typeid);
		
	@Select("select distinct a.no,b.opendate from track_history a join (select * from cp_history where typeid=#{typeid}) b on a.no=b.no  order by a.no DESC LIMIT 60")
	List<TrackHistory> selectNoByTypeid(@Param("typeid")String typeid);
	
	@Select("select * from track_details where th_id=#{th_id}")
	List<TrackInfo> selectTrackDetailByTh_id(@Param("typeid")String th_id);
	
	List<TrackHistory> selectTrackHistoryByTypeid(@Param("shortpy")String shortpy,@Param("typeid")String typeid);
	
	List<TrackHistory> selectTrackHistory(@Param("trackid")String trackid,@Param("typeid")String typeid);
	@Select("")
	List<LotteryInfo> getLotteryLatestInfoByLocationid(String locationId);
	
	/*getLocationInfo();*/
	
	List<LotteryInfo> getHighFrequencyLatestInfo();
	
	List<InfoColumn> getAllColumn();
	
	List<Article> getArticleById(int Id);
	
	List<LotteryInfo> getCollection(int Id);
	
	int delCollection(int customer_id,String cptype_id);
	
	int insertCollection(int customer_id,String cptype_id);
	
	List<Article> getHotArticle();
	
	Cptype getCptype(Integer cptype_id);

//	@Select("select * from cp_appdownloads order by id desc limit 0,1")
	Cp_APPDownloads selectDownloads();

	@Insert("insert into cp_APPDownloads(downloads,androidDownloads,IOSDownloads,IP,city,createDate) value(#{downloads},#{androidDownloads},#{IOSDownloads},#{IP},#{city},#{createDate})")
	void insertDownloads(Cp_APPDownloads cds1);

	@Select("SELECT city ,COUNT(*) num FROM cp_APPDownloads GROUP BY city order by num DESC ")
	List<Cp_APPDownloads> queryPersonSort();
	

}


//mei有错收费暗示法举案说法案例