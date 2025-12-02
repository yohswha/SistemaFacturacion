package com.cliente;


	public class Cliente {

		private int codigo;
		private String nombre;
		private String apellido;
		private String direccion;
		private String provincia;
		private String genero;

		

		public Cliente(int codigo,String nombre,String apellido,String direccion, String provincia,String genero) {
			 this.codigo = codigo;
		        this.nombre = nombre;
		        this.apellido = apellido;
		        this.direccion = direccion;
		        this.provincia = provincia;
		        this.genero = genero;
		}
		 // Getters y Setters
	    public int getCodigo() { return codigo; }
	    public void setCodigo(int codigo) { this.codigo = codigo; }

	    public String getNombre() { return nombre; }
	    public void setNombre(String nombre) { this.nombre = nombre; }

	    public String getApellido() { return apellido; }
	    public void setApellido(String apellido) { this.apellido = apellido; }

	    public String getDireccion() { return direccion; }
	    public void setDireccion(String direccion) { this.direccion = direccion; }

	    public String getProvincia() { return provincia; }
	    public void setProvincia(String provincia) { this.provincia = provincia; }

	    public String getGenero() { return genero; }
	    public void setGenero(String genero) { this.genero = genero; }

	}


