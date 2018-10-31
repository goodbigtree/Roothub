package cn.roothub.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.roothub.entity.Topic;
import cn.roothub.entity.User;
import cn.roothub.entity.Tag;

public interface TopicDao {

	/**
	 * 查询所有话题
	 * @return
	 */
	List<Topic> selectAll();
	
	/**
	 * 分页查询所有话题
	 * @param start
	 * @param limit
	 * @return
	 */
    List<Topic> selectAll(@Param("start") Integer start, @Param("limit") Integer limit,@Param("ptab") String ptab);
    
    /**
     * 根据昵称和板块查询话题
     * @param start
     * @param limit
     * @param ptab：板块
     * @param author：用户昵称
     * @return
     */
    List<Topic> selectAllByPtabAndAuthor(@Param("start") Integer start, @Param("limit") Integer limit,@Param("ptab") String ptab,@Param("author") String author);
    
    /**
	 * 模糊查询所有话题
	 * @param start
	 * @param limit
	 * @return
	 */
    List<Topic> selectByLike(@Param("like") String like, @Param("start") Integer start, @Param("limit") Integer limit);
    
    /**
	 * 分页查询所有最新话题
	 * @param start
	 * @param limit
	 * @return
	 */
    List<Topic> selectAllNewest(@Param("start") Integer start, @Param("limit") Integer limit,@Param("ptab") String ptab);

    /**
     * 根据板块查询话题
     * @param tab
     * @param start
     * @param limit
     * @return
     */
    List<Topic> selectByTab(@Param("tab") String tab, @Param("start") Integer start, @Param("limit") Integer limit);
    
    /**
     * 查询精华话题
     * @param start
     * @param limit
     * @return
     */
    List<Topic> selectAllGood(@Param("start") Integer start, @Param("limit") Integer limit,@Param("ptab") String ptab);

    /**
     * 查询等待评论的话题
     * @param start
     * @param limit
     * @return
     */
    List<Topic> selectAllNoReply(@Param("start") Integer start, @Param("limit") Integer limit,@Param("ptab") String ptab);
    
    /**
     * 侧边栏-今日热门话题
     * @param start
     * @param limit
     * @return
     */
    List<Topic> selectHot(@Param("start") Integer start, @Param("limit") Integer limit);
    
    /**
     * 侧边栏-今日等待回复的话题
     * @param start
     * @param limit
     * @return
     */
    List<Topic> selectTodayNoReply(@Param("start") Integer start, @Param("limit") Integer limit);
    
    /**
     * 首页-热门话题
     * @param start
     * @param limit
     * @return
     */
    List<Topic> selectIndexHot(@Param("start") Integer start, @Param("limit") Integer limit,@Param("tab")String tab);
    
    /**
     * 根据作者昵称分页查询所有话题
     * @param author
     * @param start
     * @param limit
     * @return
     */
    List<Topic> selectByAuthor(@Param("author") String author, @Param("start") Integer start, @Param("limit") Integer limit);

    /**
     * 根据话题ID查询话题
     * @param userId
     * @param start
     * @param limit
     * @return
     */
    Topic selectByTopicId(@Param("topicId") Integer topicId);

    /**
     * 根据话题名称查询话题
     * @param userId
     * @param start
     * @param limit
     * @return
     */
    Topic selectByTopicName(@Param("title") String title);
    
    /**
     * 根据话题名称、话题作者、话题标签、话题内容查询话题
     * @param userId
     * @param start
     * @param limit
     * @return
     */
    Topic selectByNameAndAuthorAndTagAndContent(@Param("title") String title,@Param("author") String author,@Param("tag") String tag,@Param("content") String content);
    
    /**
     * 发布话题
     * @param rootTopic
     * @return
     */
    int insert(Topic rootTopic);
    
    /**
     * 根据ID更新话题
     * @param topic
     * @return
     */
    int updateByTopicId(Topic topic);
    
    /**
     * 更新主题的头像
     * @param user
     * @return
     */
    int updateTopicAvatar(User user);
    
    /**
     * 根据ID删除话题
     * @param topicId
     * @return
     */
    int deleteById(@Param("topicId") Integer topicId);
    
    /**
     * 统计所有话题
     * @return
     */
    int countAllTopic(@Param("ptab") String ptab);

    /**
     * 统计所有精华话题
     * @return
     */
    int countAllTopicGood(@Param("ptab") String ptab);

    /**
     * 根据板块统计话题
     * @param tab
     * @return
     */
    int countTopicByTab(@Param("tab") String tab);

    /**
     * 统计无评论的话题
     * @return
     */
    int countAllTopicNoReply(@Param("ptab") String ptab);
    
    /**
     * 根据昵称统计所有话题
     * @return
     */
    int countAllByName(@Param("name") String name);
    
    /**
     * 根据昵称和板块统计话题
     * @return
     */
    int countAllByNameAndPtab(@Param("name") String name,@Param("ptab") String ptab);
    
    /**
     * 分组统计所有标签
     * @return
     */
    int countTag();
    
    /**
     * 统计所有模糊查询
     * @return
     */
    int countLike(@Param("like") String like);
    
    /**
     * 根据标签统计话题的数量
     * @param tag
     * @return
     */
    int countByTag(String tag);
    
    /**
     * 首页-热门话题
     * @return
     */
    int countIndexHot(@Param("tab")String tab);
    
    /**
	 * 分页查询所有标签
	 * @param start
	 * @param limit
	 * @return
	 */
    List<Tag> selectAllTag(@Param("start") Integer start, @Param("limit") Integer limit);
    
    /**
     * 根据标签查询话题
     * @param tab
     * @param start
     * @param limit
     * @return
     */
    List<Topic> selectByTag(@Param("tag") String tag, @Param("start") Integer start, @Param("limit") Integer limit);
    
    /**
     * 作者的其他话题
     * @param userName
     * @return
     */
    List<Topic> selectOther(@Param("userName")String userName,@Param("topicId") Integer topicId);

}
