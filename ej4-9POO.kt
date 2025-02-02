data class Tarea(val id: Int, val descripcion: String, var estado: Boolean = false, var fechaRealizada: String? = null) {
    fun completar() {
        estado = true
        fechaRealizada = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
    }
}

class ListaTareas {
    private val tareas = mutableListOf<Tarea>()
    
    fun agregarTarea(tarea: Tarea) = tareas.add(tarea)
    fun eliminarTarea(id: Int) = tareas.removeIf { it.id == id }
    fun cambiarEstado(id: Int) {
        tareas.find { it.id == id }?.completar()
    }
    fun mostrarTareas() = tareas.forEach { println(it) }
    fun mostrarPendientes() = tareas.filter { !it.estado }.forEach { println(it) }
    fun mostrarRealizadas() = tareas.filter { it.estado }.forEach { println(it) }
}
