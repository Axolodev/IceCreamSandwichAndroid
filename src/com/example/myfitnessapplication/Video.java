package com.example.myfitnessapplication;


public class Video {
	private int id;
	private String deporte;
	private String nombre;
	private String url;

	public Video(){
		
	}
	public Video(int id, String deporte, String nombre, String url){
		this.id=id;
		this.deporte=deporte;
		this.nombre=nombre;
		this.url=url;
	}
	public Video(String deporte, String nombre, String url){
		this.deporte=deporte;
		this.nombre=nombre;
		this.url=url;
	}
	public void setID(int id){
		this.id=id;
	}
	public int getID(){
		return this.id;
	}
	public void setDeporte(String deporte){
		this.deporte=deporte;
	}
	public String getDeporte(){
		return this.deporte;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public String getNombre(){
		return this.nombre;
	}
	public void setURL(String url){
		this.url=url;
	}
	public String getURL(){
		return this.url;
	}

	
	

}
