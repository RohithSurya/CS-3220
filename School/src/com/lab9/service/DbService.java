package com.lab9.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lab9.entities.Group;
import com.lab9.entities.Student;

public class DbService {
	private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu99";

    private String username = "cs3220stu99";

    private String password = "22muIUbaz7Kl";

    private Connection connection;
    
    
    public DbService()
    {
        try
        {
            connection = DriverManager.getConnection( url, username, password );
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    public void close()
    {
        if( connection != null )
        {
            try
            {
                connection.close();
            }
            catch( SQLException e )
            {
                e.printStackTrace();
            }
        }
    }
    
    
    public List<Group> getGroups() {
    	var groups = new ArrayList<Group>();
    	try {
    		Statement stmt = connection.createStatement();
    		ResultSet groupRs = stmt.executeQuery("SELECT id as group_id, name as group_name, max_size  FROM student_groups;");
    		while(groupRs.next()) {
    			var group = extractAndCreateGroup(groupRs);
    			String sql = "select id, name, birth_year as year, parent_email, parent_name from students where group_id=?;";
                PreparedStatement pstmt = connection.prepareStatement( sql );
                pstmt.setInt(1, group.getId());
                var stuRs = pstmt.executeQuery();
                group.setStudents(new ArrayList<Student>());
                while(stuRs.next()) {
                	var student = extractAndCreateStudent(stuRs);
                	group.getStudents().add(student);
                }
                groups.add(group);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
		}
    	return groups;
    }
    
    public List<Student> getStudents() {
    	var students = new ArrayList<Student>();
    	var groupMap = new HashMap<Integer, Group>();
    	try {
    		Statement stmt = connection.createStatement();
    		ResultSet studentRs = stmt.executeQuery("select s.id as id, s.name as `name`, s.birth_year as `year`, s.parent_name as `parent_name`, s.parent_email as `parent_email`, sg.id as `group_id`, sg.name as `group_name`  from students s left join student_groups sg on s.group_id = sg.id;");
    		while(studentRs.next()) {
    			var student = extractAndCreateStudent(studentRs);
    			var groupObj = studentRs.getObject("group_id");
    			if(groupObj!=null) {
    				var groupId = (Integer) groupObj;
    				if(groupMap.containsKey(groupId)) {
    					student.setGroup(groupMap.get(groupId));
    				} else {
    					var group = extractAndCreateGroup(studentRs);
        				groupMap.put(groupId, group);
        				student.setGroup(group);
    				}
    			}
    			students.add(student);
    		}
    		stmt.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return students;
    }
    
    Group extractAndCreateGroup(ResultSet rs) {
    	var group = new Group();
    	try {
        	var groupId = rs.getInt("group_id");
    		var groupName = rs.getString("group_name");
    		group.setId(groupId);
    		group.setName(groupName);
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return group;
    	
    }
    
    Student extractAndCreateStudent(ResultSet studentRs) {
    	var student = new Student();
    	try {
        	Integer id = studentRs.getInt("id");
    		var name = studentRs.getString("name");
    		var parentName = studentRs.getString("parent_name");
    		var parentEmail = studentRs.getString("parent_email");
    		var year = studentRs.getInt("year");
    		student.setId(id);
			student.setName(name);
			student.setParent(parentName);
			student.setEmail(parentEmail);
			student.setYear(year);
    	} catch(SQLException e) {e.printStackTrace();}
    	return student;
    }
    
    public int addStudent(String name, Integer birthYear, String parentName, String parentEmail, Integer groupId) {
    	int id=0;
    	try {
    		String sql = "insert into students (name, birth_year, parent_name, parent_email, group_id) values(?,?,?,?,?);";
            PreparedStatement pstmt = connection.prepareStatement( sql,
                Statement.RETURN_GENERATED_KEYS );
            pstmt.setString(1, name);
            pstmt.setInt(2, birthYear);
            pstmt.setString(3, parentName);
            pstmt.setString(4, parentEmail);
            pstmt.setObject(5, groupId);
            pstmt.executeUpdate();
            var rs = pstmt.getGeneratedKeys();
            if(rs.next()) id = rs.getInt(1);
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return id;
    	
    }
    
    public int addGroup(String name) {
    	int id=0;
    	try {
    		String sql = "insert into student_groups (name) values (?)";
            PreparedStatement pstmt = connection.prepareStatement( sql,
                Statement.RETURN_GENERATED_KEYS );
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            var rs = pstmt.getGeneratedKeys();
            if(rs.next()) id = rs.getInt(1);
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return id;
    }
    
    public void editGroup(Integer id, String name) {
    	try {
    		String sql = "update student_groups set name=? where id=?";
            PreparedStatement pstmt = connection.prepareStatement( sql,
                Statement.RETURN_GENERATED_KEYS );
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
//    public boolean insertStudent(Integer id) {
//    	try {
//        	String sql = "insert into student_groups (name) values (?)";
//            PreparedStatement pstmt = connection.prepareStatement( sql,
//                Statement.RETURN_GENERATED_KEYS );
//            pstmt.setInt(1, id);
//            ResultSet rs = pstmt.executeQuery(sql);
//            
//    	}
//    }
    
    
    public Student getStudent(Integer id) {
    	
    	var student = new Student();
    	try {
    		String sql = "select id, name, birth_year as year, parent_name, parent_email, group_id from students where id = ?";
    		PreparedStatement pstmt = connection.prepareStatement( sql,
                    Statement.RETURN_GENERATED_KEYS );
    		pstmt.setInt(1, id);
    		var stuRs = pstmt.executeQuery();
    		stuRs.next();
    		student = extractAndCreateStudent(stuRs);
    		var groupObj = stuRs.getObject("group_id");
    		if(groupObj!=null) {
    			int groupId = (Integer)groupObj;
    			sql = "select id as group_id, name as group_name from student_groups where id = ?";
        		PreparedStatement grpStmt = connection.prepareStatement( sql,
                        Statement.RETURN_GENERATED_KEYS );
        		grpStmt.setInt(1, groupId);
        		var grpRes = grpStmt.executeQuery();
        		grpRes.next();
        		var group = extractAndCreateGroup(grpRes);
        		student.setGroup(group);
        		grpStmt.close();
    		}
    		pstmt.close();
    		
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return student;
    }
    
    public void editStudent(Integer id, String name, Integer year, String parentName, String parentEmail, Integer groupId) {
    	try {
    		String sql = "update students set name=?, birth_year=?, parent_name=?, parent_email=?, group_id=? where id=?;";
    		PreparedStatement pstmt = connection.prepareStatement( sql,
                    Statement.RETURN_GENERATED_KEYS );
    		pstmt.setString(1, name);
            pstmt.setInt(2, year);
            pstmt.setString(3, parentName);
            pstmt.setString(4, parentEmail);
            pstmt.setObject(5, groupId);
            pstmt.setObject(6, id);
            pstmt.executeUpdate();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    
    public Group getGroup(Integer id) {
    	Group group = null;
    	try {
    		PreparedStatement stmt = connection.prepareStatement("SELECT id as group_id, name as group_name, max_size  FROM student_groups where id =?;");
    		stmt.setInt(1, id);
    		ResultSet groupRs = stmt.executeQuery();
    		while(groupRs.next()) {
    			group = extractAndCreateGroup(groupRs);
    			String sql = "select id, name, birth_year as year, parent_email, parent_name from students where group_id=?;";
                PreparedStatement pstmt = connection.prepareStatement( sql );
                pstmt.setInt(1, group.getId());
                var stuRs = pstmt.executeQuery();
                group.setStudents(new ArrayList<Student>());
                while(stuRs.next()) {
                	var student = extractAndCreateStudent(stuRs);
                	group.getStudents().add(student);
                }
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
		}
    	return group;
    }
    
    public void delelteStudentFromGroup(Integer id) {
    	try {
    		String sql = "update students set group_id=null where id=?;";
    		PreparedStatement pstmt = connection.prepareStatement( sql,
                    Statement.RETURN_GENERATED_KEYS );
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public List<Group> getGroupsForCreateStudent() {
    	var groups = new ArrayList<Group>();
    	try {
    		Statement stmt = connection.createStatement();
    		ResultSet groupRs = stmt.executeQuery("select a.group_id, a.name as group_name, a.max_size, a.count from (\r\n" + 
    				"select sg.name, sg.max_size, count(s.id) as count, sg.id as group_id  from student_groups sg\r\n" + 
    				"left join students s\r\n" + 
    				"on sg.id = s.group_id\r\n" + 
    				"group by sg.id) a\r\n" + 
    				"where a.count<a.max_size");
    		while(groupRs.next()) {
    			var group = extractAndCreateGroup(groupRs);
                groups.add(group);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
		}
    	return groups;
    }
    
    public List<Group> getGroupsForEditStudent(Integer groupId) {
    	var groups = new ArrayList<Group>();
    	try {
    		PreparedStatement stmt = connection.prepareStatement("select a.group_id, a.name as group_name, a.max_size, a.count from (\r\n" + 
    				"select sg.name, sg.max_size, count(s.id) as count, sg.id as group_id  from student_groups sg\r\n" + 
    				"left join students s\r\n" + 
    				"on sg.id = s.group_id\r\n" + 
    				"group by sg.id) a\r\n" + 
    				"where a.count<a.max_size or a.group_id=?;");
    		stmt.setObject(1, groupId);
    		ResultSet groupRs = stmt.executeQuery();
    		
    		while(groupRs.next()) {
    			var group = extractAndCreateGroup(groupRs);
                groups.add(group);
    		}
    		System.out.println(groups);
    	} catch (SQLException e) {
    		e.printStackTrace();
		}
    	return groups;
    }
    
    
}
