package com.yilin.app.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * sqlserver 2008 连接工具类
 * 
 * @author zhubo
 * 
 */
public class SqlUtils {
	private static final SqlUtils sqlUtil = new SqlUtils();
	private static String driverClassName=null;
	private static String dbUrl=null;
	private static String username=null;
	private static String password=null;
	private static Properties prop = new Properties();
	static {
		InputStream in = SqlUtils.class
				.getResourceAsStream("/database2.properties");
		try {
			prop.load(in);
			driverClassName = prop.getProperty("jdbc.driver").trim();
			dbUrl = prop.getProperty("jdbc.url").trim();
			username = prop.getProperty("jdbc.username").trim();
			password = prop.getProperty("jdbc.password").trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private SqlUtils() {

	}

	public static SqlUtils getInstance() {
		return sqlUtil;
	}
	
	/**
	 * 获得连接
	 * @return
	 */
	public Connection getConnection() {
		try {
			Class.forName(driverClassName);
			Connection con = DriverManager.getConnection(dbUrl, username, password);
			System.out.println("Connection Successful! "); // 如果连接成功
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public int insert(String insertSql)
	{
		int result=0;
		PreparedStatement ps = null;
		Connection con = getConnection();
		try {
			ps = con.prepareStatement(insertSql);
			result= ps.executeUpdate();
			System.out.println("success！sql:"+insertSql);
		} catch (SQLException e) {
			System.out.println("failed！sql:"+insertSql);
			e.printStackTrace();
		} finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	/**
	 * 获得连接
	 * @return
	 */
	public Connection getConnection2(String dbType) {
		try {
			String tempDriverClassName = prop.getProperty("jdbc."+dbType+".driver").trim();
			String tempDbUrl = prop.getProperty("jdbc."+dbType+".url").trim();
			String tempUsername = prop.getProperty("jdbc."+dbType+".username").trim();
			String tempPassword = prop.getProperty("jdbc."+dbType+".password").trim();
			Class.forName(tempDriverClassName);
			Connection con = DriverManager.getConnection(tempDbUrl, tempUsername, tempPassword);
			System.out.println("Connection Successful! "); // 如果连接成功
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public int update(String sql){
		return update(sql,null);
	}
	public int update(String sql,List params){
		PreparedStatement ps=null;
		int result =0;
		Connection conn=null;
	    try {
	    	conn=getConnection();
	        ps = conn.prepareStatement(sql);
			setParams(params, ps);
			result = ps.executeUpdate();
	    } catch (SQLException e) {
	    	System.out.println("SQL异常："+sql);
	        e.printStackTrace();
	        return result ;
	    } finally{
			close(ps, null,conn);
		}
		return result ;
	}


	public int insert(String tableName,Map<String,Object> params)
	{
		int result=0;
		PreparedStatement ps = null;
		StringBuffer sql = new StringBuffer("insert into ");
		sql.append(tableName+"(");
		List<Object> valueList=new ArrayList<Object>();
		for(String key:params.keySet()){
			sql.append(key+",");
			valueList.add(params.get(key));
		}
		sql.deleteCharAt(sql.length()-1);
		sql.append(") values(");
		for(int i=0;i<params.size();i++){
			sql.append("?,");
		}
		sql.deleteCharAt(sql.length()-1);
		sql.append(")");
		Object param;
		Connection conn=null;
		try {
			conn=getConnection();
			ps = conn.prepareStatement(sql.toString());
			for(int i=0;i<valueList.size();i++){
				param=valueList.get(i);
				if (param instanceof Integer) {
					ps.setInt(i + 1, ((Integer) param).intValue());
				} else if (param instanceof String) {
					ps.setString(i + 1, (String) param);
				} else if (param instanceof Double) {
					ps.setDouble(i + 1, ((Double) param).doubleValue());
				} else if (param instanceof Float) {
					ps.setFloat(i + 1, ((Float) param).floatValue());
				} else if (param instanceof Long) {
					ps.setLong(i + 1,((Long) param).longValue());
				} else if (param instanceof Boolean) {
					ps.setBoolean(i + 1, ((Boolean) param).booleanValue());
				} else if (param instanceof Date) {
					ps.setDate(i + 1, (Date) param);
				} 
			}
			result= ps.executeUpdate();
			System.out.println("insert "+tableName+" success！");
		} catch (SQLException e) {
			System.out.println("insert "+tableName+" failed！");
			e.printStackTrace();
		} finally{
			close(ps, null,conn);
		}
		return result;
	}
	public int update(String tableName,Map<String,Object> modifyMap,Map<String,Object> conditionMap) throws SQLException {
	    int result=0;
		PreparedStatement ps = null;
		StringBuffer sql = new StringBuffer("update ");
		sql.append(tableName+" set ");
		List<Object> modifyValueList=new ArrayList<Object>();
		List<Object> conditionValueList=new ArrayList<Object>();
		for(String key:modifyMap.keySet()){
			sql.append(key+"=?,");
			modifyValueList.add(modifyMap.get(key));
		}
		sql.deleteCharAt(sql.length()-1);
		sql.append(" where ");
		for(String key:conditionMap.keySet()){
			sql.append(key+"=? and ");
			conditionValueList.add(conditionMap.get(key));
		}
		sql.delete(sql.length()-5,sql.length()-1);
		Object param;
		Connection conn=null;
		try {
			conn=getConnection();
			ps = conn.prepareStatement(sql.toString());
			for(int i=0;i<modifyValueList.size();i++){
				param=modifyValueList.get(i);
				if(param==null){
					ps.setObject(i + 1, param);
				}
				if (param instanceof Integer) {
					ps.setInt(i + 1, ((Integer) param).intValue());
				} else if (param instanceof String) {
					ps.setString(i + 1, (String) param);
				} else if (param instanceof Double) {
					ps.setDouble(i + 1, ((Double) param).doubleValue());
				} else if (param instanceof Float) {
					ps.setFloat(i + 1, ((Float) param).floatValue());
				} else if (param instanceof Long) {
					ps.setLong(i + 1,((Long) param).longValue());
				} else if (param instanceof Boolean) {
					ps.setBoolean(i + 1, ((Boolean) param).booleanValue());
				} else if (param instanceof Date) {
					ps.setDate(i + 1, (Date) param);
				} 
			}
			int modifyNum=modifyValueList.size();
			for(int i=0;i<conditionValueList.size();i++){
				param=conditionValueList.get(i);
				if (param instanceof Integer) {
					ps.setInt(modifyNum+i + 1, ((Integer) param).intValue());
				} else if (param instanceof String) {
					ps.setString(modifyNum+i + 1, (String) param);
				} else if (param instanceof Double) {
					ps.setDouble(modifyNum+i + 1, ((Double) param).doubleValue());
				} else if (param instanceof Float) {
					ps.setFloat(modifyNum+i + 1, ((Float) param).floatValue());
				} else if (param instanceof Long) {
					ps.setLong(modifyNum+i + 1,((Long) param).longValue());
				} else if (param instanceof Boolean) {
					ps.setBoolean(modifyNum+i + 1, ((Boolean) param).booleanValue());
				} else if (param instanceof Date) {
					ps.setDate(modifyNum+i + 1, (Date) param);
				} 
			}
			result=ps.executeUpdate();
			System.out.println("update "+tableName+" success！");
		} catch (SQLException e) {
			System.out.println("update "+tableName+" failed！");
			e.printStackTrace();
			throw e;
		}finally{
			close(ps, null,conn);
		}
		return result;
	}
	public JSONArray search(String sql) {
		return search(null,sql,null);
	}
	public JSONArray search(String dbType, String sql) {
		return search(dbType,sql,null);
	}
	public JSONArray search(String sql, List params) {
		return search(null,sql,params);
	}
	public JSONArray search(String dbType, String sql, List params) {
		 PreparedStatement ps=null;
		    ResultSet rs =null;
		    JSONArray result=new JSONArray();
		    JSONObject jsonObj;
		    Connection conn=null;
			try {
				if(dbType==null){
					conn=getConnection();
				}else{
					conn=getConnection2(dbType);
				}
		        ps = (PreparedStatement)conn.prepareStatement(sql);
				setParams(params, ps);
				rs = ps.executeQuery();
		        ResultSetMetaData   md   =   rs.getMetaData();   
		        List<String> columns=new ArrayList<String>();
		        for(int i=1;i<=md.getColumnCount();i++){    
		        	columns.add(md.getColumnName(i));    
		        } 
				while(rs.next()){
					jsonObj=new JSONObject();
					for (int i = 0; i < columns.size(); i++) {  
	                    jsonObj.put(columns.get(i),  rs.getObject(i+1));
					}
					result.add(jsonObj);
				}
		    } catch (SQLException e) {
		    	System.out.println("SQL异常："+sql);
		        e.printStackTrace();
		    } finally{
				close(ps, rs, conn);
			}
			return result;
	}

	private void setParams(List params, PreparedStatement ps) throws SQLException {
		if(params!=null){
            Object param=null;
            for(int i=0;i<params.size();i++){
                param=params.get(i);
                if (param instanceof Integer) {
                    ps.setInt(i + 1, ((Integer) param).intValue());
                } else if (param instanceof String) {
                    ps.setString(i + 1, (String) param);
                } else if (param instanceof Double) {
                    ps.setDouble(i + 1, ((Double) param).doubleValue());
                } else if (param instanceof Float) {
                    ps.setFloat(i + 1, ((Float) param).floatValue());
                } else if (param instanceof Long) {
                    ps.setLong(i + 1,((Long) param).longValue());
                } else if (param instanceof Boolean) {
                    ps.setBoolean(i + 1, ((Boolean) param).booleanValue());
                } else if (param instanceof Date) {
                    ps.setDate(i + 1, (Date) param);
                } else if (param instanceof BigDecimal) {
                    ps.setBigDecimal(i + 1, (BigDecimal) param);
                } else if (param instanceof Timestamp) {
                    ps.setTimestamp(i + 1, (Timestamp) param);
                }
            }
        }
	}

	public List search(String sql,List params, Class cls) {
		return search(null,sql,params,cls);
	}
	public List search(String dbType,String sql,List params, Class cls) {
	    PreparedStatement ps=null;
	    ResultSet rs =null;
	    List result=new ArrayList();
	    Connection conn=null;
		try {
			if(dbType==null){
				conn=getConnection();
			}else{
				conn=getConnection2(dbType);
			}
	        ps = (PreparedStatement)conn.prepareStatement(sql);
			setParams(params, ps);
			rs = ps.executeQuery();
        	try {
				result=resultSetToList(rs,cls);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    } catch (SQLException e) {
	    	System.out.println("SQL异常："+sql);
	        e.printStackTrace();
	    } finally{
			close(ps, rs, conn);
		}
		return result;
	}

	private void close(PreparedStatement ps, ResultSet rs, Connection conn) {
		try {
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            closeCon(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public String getSearchTableColumnsSql(String tableName){
		String sql="SELECT cast(a.name as varchar) AS columnName,cast(isnull(g.value,cast(a.name as varchar)) as varchar) AS columnTitle "+
				"	FROM sys.tables t "+
				"	LEFT JOIN sys.columns a on a.object_id=t.object_id "+
				"	left join sys.extended_properties g on (a.object_id = g.major_id AND g.minor_id = a.column_id) "+ 
				"WHERE t.name = '"+tableName+"'";
		return sql;
	}
	public static List resultSetToList(ResultSet rs, Class cls)throws Exception {  
        //取得Method   
        Method[] methods = cls.getDeclaredMethods();   
        List lst = new ArrayList();  
        // 用于获取列数、或者列类型  
        ResultSetMetaData meta = rs.getMetaData();  
        Object obj = null;  
        while (rs.next()) {  
            // 获取formbean实例对象  
            obj = cls.newInstance(); // 用Class.forName方法实例化对象和new创建实例化对象是有很大区别的，它要求JVM首先从类加载器中查找类，然后再实例化，并且能执行类中的静态方法。而new仅仅是新建一个对象实例  
            // 循环获取指定行的每一列的信息  
            for (int i = 1; i <= meta.getColumnCount(); i++) {  
                // 当前列名  
                String colName = meta.getColumnName(i);  
                // 设置方法名  
                String setMethodName = "set" + colName;  
                 //遍历Method   
                for (int j = 0; j < methods.length; j++) {   
                    if (methods[j].getName().equalsIgnoreCase(setMethodName)) {   
                        setMethodName = methods[j].getName();   
                        // 获取当前位置的值，返回Object类型  
                        Object value = rs.getObject(colName);   
                        if(value == null){  
                            continue;  
                        }  
                        //实行Set方法   
                        try {   
                            //// 利用反射获取对象  
                            //JavaBean内部属性和ResultSet中一致时候   
                            Method setMethod = obj.getClass().getMethod(   
                                    setMethodName, value.getClass());   
                            setMethod.invoke(obj, value);   
                        } catch (Exception e) {   
                            //JavaBean内部属性和ResultSet中不一致时候，使用String来输入值。   
                           e.printStackTrace();  
                        }   
                    }   
                }   
            }  
            lst.add(obj);  
        }  
        return lst;  
	} 
	public void closeCon(Connection con) throws SQLException{
		if(con!=null){
			con.close();
		}
	}
}
