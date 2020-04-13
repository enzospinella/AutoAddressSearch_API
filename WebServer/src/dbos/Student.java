package dbos;

public class Student 
{
	// ATRIBUTOS
	protected int ra;
	protected String name;
	protected int courseNumber;
	protected String zipCode;
	protected String complement;
	protected int number;
	
	public Student (int ra, String name, int courseN, String zipCode, String complement, int number) throws Exception
	{
		this.setRa(ra);
		this.setName(name);
		this.setCourseNumber(courseN);
		this.setZipCode(zipCode);
		this.setComplement(complement);
		this.setNumber(number);
	}
	//GETTERS AND SETTERS
	public void setRa(int ra) throws Exception
	{
		if (ra < 0)
			throw new Exception ("Invalid RA!");
		
		this.ra = ra;
	}
	public int getRa()
	{
		return this.ra;
	}
	
	public void setName(String name) throws Exception
	{
		if (name.equals("") || name==null)
			throw new Exception ("Invalid Name!");
		
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	
	public void setCourseNumber(int courseNumber) throws Exception
	{
		if (courseNumber < 0)
			throw new Exception ("Invalid Course Number!");
		
		this.courseNumber = courseNumber;
	}
	public int getCourseNumber()
	{
		return this.courseNumber;
	}
	
	public void setZipCode(String zipCode) throws Exception
	{
		if (zipCode.equals("") || zipCode==null)
			throw new Exception ("Invalid Zip Code!");
		
		this.zipCode = zipCode;
	}
	public String getZipCode()
	{
		return this.zipCode;
	}
	
	public void setComplement(String complement) throws Exception
	{
		if (complement.equals("") || complement==null)
			throw new Exception ("Invalid Complement!");
		
		this.complement = complement;
	}
	public String getComplement()
	{
		return this.complement;
	}
	public void setNumber(int number) throws Exception
	{
		if (number < 0)
			throw new Exception ("Invalid Number!");
		
		this.number = number;
	}
	public int getNumber()
	{
		return this.number;
	}
	
	public String toString()
	{
		String ret = "";
		
		ret += "Aluno: \n";
		ret += "\tRA: "+this.ra+"\n";
		ret += "\tName: "+this.name+"\n";
		ret += "\tCourse Number: "+this.courseNumber+"\n";
		ret += "\tZip Code: "+this.zipCode+"\n";
		ret += "\tComplement: "+this.complement+"\n";
		ret += "\tNumber: "+this.number+"\n";
		
		return ret;
	}
	public boolean equals(Object obj)
	{
		if(obj==null)
			return false;
		if(obj==this)
			return true;
		if(this.getClass()!=obj.getClass())
			return false;
		
		Student aluno = (Student)obj;
		
		if(this.ra != aluno.ra)
			return false;
		return true;
	}
	public int hashCode()
	{
		int ret = 9;
		
		ret += ret*13 + new Integer(this.ra).hashCode();
		ret += ret*13 + this.name.hashCode();
		ret += ret*13 + new Integer(this.courseNumber).hashCode();
		ret += ret*13 + this.zipCode.hashCode();
		ret += ret*13 + this.complement.hashCode();
		ret += ret*13 + new Integer(this.number).hashCode();
		
		return ret;
	}
	
	public Student(Student model) throws Exception
	{
		if(model==null)
			throw new Exception ("Invalid Model!");
		
		this.ra = model.ra;
		this.name = model.name;
		this.courseNumber = model.courseNumber;
		this.zipCode = model.zipCode;
		this.complement = model.complement;
		this.number = model.number;
	}
	public Object clone()
	{
		Student student = null;
		
		try
		{
			student = new Student(this);
		}
		catch(Exception ignored) {}
		
		return student;
	}

}
