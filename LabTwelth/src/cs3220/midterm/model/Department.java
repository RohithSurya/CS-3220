package cs3220.midterm.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
	
	private Integer id;

    private String name;

    private List<Faculty> faculty;

    public Department()
    {
        faculty = new ArrayList<Faculty>();
    }

    public Department( String name )
    {
        this();
        this.name = name;
    }
    
    

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public List<Faculty> getFaculty()
    {
        return faculty;
    }

    public void setFaculty( List<Faculty> faculty )
    {
        this.faculty = faculty;
    }

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", faculty=" + faculty + "]";
	}

}
