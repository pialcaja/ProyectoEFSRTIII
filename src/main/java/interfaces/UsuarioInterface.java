package interfaces;

import java.util.List;

import model.Usuario;

public interface UsuarioInterface {
	
	public int registrar(Usuario u);
	
	public int actualizar(Usuario u);
	
	public Usuario validarAcceso(Usuario u);

	public int actualizarTipoUsuario1(Usuario u);
	
	public int actualizarTipoUsuario2(Usuario u);
	
	public Usuario obtenerTipo(int id);
	
	public List<Usuario> listado();
}
