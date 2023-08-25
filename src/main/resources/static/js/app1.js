document.addEventListener("DOMContentLoaded", function() {
	let filtroInput = document.getElementById("filtro");

	filtroInput.addEventListener("keyup", function() {
		let valorFiltro = filtroInput.value.trim();
		let tabla = document.querySelector(".table tbody");
		let filas = tabla.getElementsByTagName("tr");

		for (let i = 0; i < filas.length; i++) {
			let fila = filas[i];
			let columnaId = fila.getElementsByTagName("td")[0];
			let id = columnaId.textContent.trim();

			if (valorFiltro === "") {
				fila.style.display = "table-row";
			} else if (id === valorFiltro) {
				fila.style.display = "table-row"; 
			} else {
				fila.style.display = "none";
			}
		}
	});
});