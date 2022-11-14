package cs3220.midterm.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cs3220.midterm.model.Department;
import cs3220.midterm.model.Faculty;

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
    
    
    public List<Department> getDepartments() {
    	var depts = new ArrayList<Department>();
    	try {
    		Statement stmt = connection.createStatement();
    		ResultSet deptRs = stmt.executeQuery("select * from department");
    		while(deptRs.next()) {
    			var dept = new Department();
    			dept.setId(deptRs.getInt("id"));
    			dept.setName(deptRs.getString("name"));
    			dept.setFaculty(new ArrayList<>());
    			int deptId = deptRs.getInt("id");
    			String sql = "select * from faculty where dept_id = ?";
                PreparedStatement pstmt = connection.prepareStatement( sql );
                pstmt.setInt( 1, deptId );
                var facRs = pstmt.executeQuery();
                while(facRs.next()) {
                	var faculty = new Faculty();
                	faculty.setName(facRs.getString("name"));
                	faculty.setChair(facRs.getInt("is_chair")==1 ? true: false);
                	dept.getFaculty().add(faculty);
                }
                depts.add(dept);
                pstmt.close();
    		}
    		stmt.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	System.out.println(depts);
    	return depts;
    }
    
    
    public int addDepartment(String name) {
    	int id=0;
    	try {
    		String sql = "insert into department (name) values (?)";
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
    
    public int addFaculty(String name, int isChair, int departmentId) {
    	int id=0;
    	try {
    		String sql = "insert into faculty (name, is_chair, dept_id) values (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement( sql,
                Statement.RETURN_GENERATED_KEYS );
            pstmt.setString(1, name);
            pstmt.setInt(2, isChair);
            pstmt.setInt(3, departmentId);
            pstmt.executeUpdate();
            var rs = pstmt.getGeneratedKeys();
            if(rs.next()) id = rs.getInt(1);
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return id;
    }
    
    
}
