package strategy3.modularization;

import strategy3.interfaces.*;

public abstract class Person {
	private String id;
	private String name;
	private IJob job;
	private IGet get;

	public Person(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public void job() {
		job.job();
	}
	public void get() {
		get.get();
	}
	public void print() {
		System.out.print("ID : "+id+"\t¿Ã∏ß : "+name);
	}
	//
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public IJob getJob() {
		return job;
	}
	public void setJob(IJob job) {
		this.job = job;
	}
	public IGet getGet() {
		return get;
	}
	public void setGet(IGet get) {
		this.get = get;
	}
		
}
