package com.zlzkj.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zlzkj.app.mapper.PointMapper;
import com.zlzkj.app.model.Point;
import com.zlzkj.app.model.User;
import com.zlzkj.core.mybatis.SqlRunner;
import com.zlzkj.core.sql.Row;
import com.zlzkj.core.sql.SQLBuilder;

@Service
@Transactional
public class PointService {
	
	@Autowired
	private PointMapper mapper;
	
	@Autowired
	private SqlRunner sqlRunner;
	
	public long delete(int id){
		return mapper.deleteByPrimaryKey(id);
	}
	
	public Integer update(Point entity){
		return mapper.updateByPrimaryKey(entity);
	}
	
	public Integer updateSelective(Point entity){
		return mapper.updateByPrimaryKeySelective(entity);
	}
	
	public Integer save(Point entity) {
		mapper.insertSelective(entity);
		return entity.getId();
	}

	public Point findById(Integer id){
		return mapper.selectByPrimaryKey(id);
	}
	
	public List<Row> findUser(String account){
		
		String sql = "select * from x_point where account='"+account+"'";
		return sqlRunner.select(sql);
	}

	public List<Row> findtarget(String project) {
		String sql="SELECT * FROM x_target WHERE project ='"+project+"'";
		return sqlRunner.select(sql);
	}

	public Integer savepoint(String account, String project,String point) {
		String sql="UPDATE x_point SET point='"+point+"',status=1 WHERE account='"+account+"' AND project='"+project+"'";
 return sqlRunner.update(sql);
		
	}

	public boolean isExist(String account,String project) {
		SQLBuilder sqlBuilder = SQLBuilder.getSQLBuilder(Point.class);
		String sql = sqlBuilder.fields("*").where("account='"+account+"' and project='"+project+"'").selectSql();
		System.out.println(sql);
		List<Row> list = sqlRunner.select(sql);
		if(list.size()==0){
			return false;
		}else{
			return true;
		}
	}

	public List<Row> isFinish(String project) {
		SQLBuilder sqlBuilder = SQLBuilder.getSQLBuilder(Point.class);
		String sql = sqlBuilder.fields("*").where("status=0 and project='"+project+"'").selectSql();
		return sqlRunner.select(sql);
		
	}

	public List<Row> detail(String project) {
		String sql="SELECT * FROM x_point WHERE project ='"+project+"'";
		return sqlRunner.select(sql);
	}

	public int allpoint_total(String account) {
		int total=0;
		String sql = "select count(*) as total from x_point where account='"+account+"' and status!=2";
		total = sqlRunner.select(sql).get(0).getInt("total");
		return total;
	}

	public List<Row> selectAllpoint(int start, int pagesize, int user_status,String account) {
		String sql = "select * from x_point  where account='"+account+"' and status!=2"
				+ " ORDER BY id desc limit "+start+","+pagesize+"";
		List<Row> list = sqlRunner.select(sql);
		return list;
	}

	public void mydelete(String project) {
		String sql="update x_point set status=2 where project='"+project+"'";
		sqlRunner.update(sql);
	}

	public void myrestore(String project) {
		String sql="update x_point set status=0 where project='"+project+"'";
		sqlRunner.update(sql);
	}
	public void myrestore2(String project) {
		String sql="update x_point set status=1 where project='"+project+"'";
		sqlRunner.update(sql);
	}
	public List<Row> find(String project) {
		String sql="select *from x_point where project='"+project+"'";
		return sqlRunner.select(sql);
	}
	
}

//编写者：张佳旻