package com.cairone.odataexample.edm.resources;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cairone.odataexample.EntityServiceRegistar;
import com.cairone.odataexample.entities.UsuarioEntity;
import com.cairone.odataexample.utils.FechaUtil;
import com.sdl.odata.api.edm.annotations.EdmEntity;
import com.sdl.odata.api.edm.annotations.EdmEntitySet;
import com.sdl.odata.api.edm.annotations.EdmNavigationProperty;
import com.sdl.odata.api.edm.annotations.EdmProperty;

@EdmEntity(name = "Usuario", key = { "tipoDocumentoId", "numeroDocumento" }, namespace = EntityServiceRegistar.NAME_SPACE, containerName = EntityServiceRegistar.CONTAINER_NAME)
@EdmEntitySet("Usuarios")
public class UsuarioEdm {

	@EdmProperty(name="tipoDocumentoId", nullable = false)
	private Integer tipoDocumentoId = null;
	
	@EdmProperty(name="numeroDocumento", nullable = false)
	private String numeroDocumento = null;
	
	@EdmProperty(name="nombreUsuario", nullable = false, maxLength=200)
	private String nombreUsuario = null;
	
	@EdmProperty(name="fechaAlta")
	private LocalDate fechaAlta = null;
	
	@EdmProperty(name="cuentaVencida", nullable = false)
	private Boolean cuentaVencida = null;

	@EdmProperty(name="claveVencida", nullable = false)
	private Boolean claveVencida = null;

	@EdmProperty(name="cuentaBloqueada", nullable = false)
	private Boolean cuentaBloqueada = null;

	@EdmProperty(name="usuarioHabilitado", nullable = false)
	private Boolean usuarioHabilitado = null;

	@EdmNavigationProperty(name="persona")
	private PersonaEdm persona = null;
	
	@EdmNavigationProperty(name="permisos")
	private List<PermisoEdm> permisos = null;

	public UsuarioEdm() {
		permisos = new ArrayList<PermisoEdm>();
	}

	public UsuarioEdm(Integer tipoDocumentoId, String numeroDocumento, String nombreUsuario, LocalDate fechaAlta, Boolean cuentaVencida, Boolean claveVencida, Boolean cuentaBloqueada, Boolean usuarioHabilitado, PersonaEdm persona) {
		super();
		this.tipoDocumentoId = tipoDocumentoId;
		this.numeroDocumento = numeroDocumento;
		this.nombreUsuario = nombreUsuario;
		this.fechaAlta = fechaAlta;
		this.cuentaVencida = cuentaVencida;
		this.claveVencida = claveVencida;
		this.cuentaBloqueada = cuentaBloqueada;
		this.usuarioHabilitado = usuarioHabilitado;
		this.persona = persona;
		this.permisos = new ArrayList<PermisoEdm>();
	}
	
	public UsuarioEdm(UsuarioEntity usuarioEntity) {
		this(
				usuarioEntity.getPersona().getTipoDocumento().getId(),
				usuarioEntity.getPersona().getNumeroDocumento(),
				usuarioEntity.getNombreUsuario(),
				FechaUtil.asLocalDate(usuarioEntity.getFechaAlta()),
				usuarioEntity.getCuentaVencida(),
				usuarioEntity.getClaveVencida(),
				usuarioEntity.getCuentaBloqueada(),
				usuarioEntity.getUsuarioHabilitado(),
				new PersonaEdm(usuarioEntity.getPersona()));
	}

	public Integer getTipoDocumentoId() {
		return tipoDocumentoId;
	}

	public void setTipoDocumentoId(Integer tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Boolean getCuentaVencida() {
		return cuentaVencida;
	}

	public void setCuentaVencida(Boolean cuentaVencida) {
		this.cuentaVencida = cuentaVencida;
	}

	public Boolean getClaveVencida() {
		return claveVencida;
	}

	public void setClaveVencida(Boolean claveVencida) {
		this.claveVencida = claveVencida;
	}

	public Boolean getCuentaBloqueada() {
		return cuentaBloqueada;
	}

	public void setCuentaBloqueada(Boolean cuentaBloqueada) {
		this.cuentaBloqueada = cuentaBloqueada;
	}

	public Boolean getUsuarioHabilitado() {
		return usuarioHabilitado;
	}

	public void setUsuarioHabilitado(Boolean usuarioHabilitado) {
		this.usuarioHabilitado = usuarioHabilitado;
	}

	public PersonaEdm getPersona() {
		return persona;
	}

	public void setPersona(PersonaEdm persona) {
		this.persona = persona;
	}

	public List<PermisoEdm> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<PermisoEdm> permisos) {
		this.permisos = permisos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEdm other = (UsuarioEdm) obj;
		if (persona == null) {
			if (other.persona != null)
				return false;
		} else if (!persona.equals(other.persona))
			return false;
		return true;
	}
}
