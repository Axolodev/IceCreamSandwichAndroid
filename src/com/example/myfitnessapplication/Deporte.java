package com.example.myfitnessapplication;

import java.sql.Date;

public class Deporte {
	private int id;
	private String deporte;
	private String fecha;
	private double calorias;
	private double tiempo;
	public Deporte(){
		
	}
	public Deporte(int id, String deporte, String fecha, double calorias, double tiempo){
		this.id=id;
		this.deporte=deporte;
		this.fecha=fecha;
		this.calorias=calorias;
		this.tiempo=tiempo;
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
	public void setFecha(String fecha){
		this.fecha=fecha;
	}
	public String getFecha(){
		return this.fecha;
	}
	public void setCalorias(double calorias){
		this.calorias=calorias;
	}
	public double getCalorias(){
		return this.calorias;
	}
	public void setTiempo(double tiempo){
		this.tiempo=tiempo;
	}
	public double getTiempo(){
		return this.tiempo;
	}
	
	

}
/*
 * 	private int id;
	private String name;
	private int ranking;
	
	public Pelicula(){
		
	}
	public Pelicula(int id, String name, int ranking){
		this.id=id;
		this.name=name;
		this.ranking=ranking;
	}
	public Pelicula(String name, int ranking){
		this.name=name;
		this.ranking=ranking;
	}
	public void setID(int id){
		this.id=id;
	}
	
	public int getID(){
		return this.id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public void setRanking(int ranking){
		this.ranking=ranking;
	}
	public int getRanking(){
		return this.ranking;
	}

 * 
 * 
 * 
 * */
