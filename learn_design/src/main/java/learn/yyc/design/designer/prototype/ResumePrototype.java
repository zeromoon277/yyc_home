package learn.yyc.design.designer.prototype;

import java.io.*;

public class ResumePrototype implements Serializable,Cloneable {
	private static final long serialVersionUID = -7631714310254522039L;

	private String name;
	private String sex;
	private Integer age;
	private WorkExperience work;
	public ResumePrototype(String name) {
		this.name = name;
		work = new WorkExperience();
	}

	public void setPersonalInfo(String sex, Integer age) {
		this.sex = sex;
		this.age = age;
	}

	public void setWorkExperience(String workDate, String company) {
		work.setWorkDate(workDate);
		work.setCompany(company);
	}

	//浅复制 
	public Object clone() {
		Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
	}

	//深复制
	public Object deepClone() throws IOException, ClassNotFoundException {
		//将对象写到流里
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(this);
        //从流里读出来
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();
	}

	public void print(){ 
        System.out.println(String.format("%s %s %s", name,sex,age));
        System.out.println(String.format("工作经历：%s %s", work.getWorkDate(), work.getCompany()));
    }
}
